package com.opossum.jiraworklogreporter.mail;

import java.io.File;
import java.io.IOException;
import java.util.*;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import lombok.NonNull;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;


@Service("EmailService")
public class EmailServiceImpl implements EmailService {

    private final String emailFrom;
    private final String [] emailTo;
    private final String [] emailCC;
    private final String emailTechnicalTo;
    //@Autowired
    private final JavaMailSender emailSender;
    //@Autowired
    private final SpringTemplateEngine thymeleafTemplateEngine;
  //@Value("classpath:/mail-logo.png")
  //private Resource resourceFile;
    private static final Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);

    public EmailServiceImpl(SpringTemplateEngine thymeleafTemplateEngine, JavaMailSender emailSender,
                            @Value("${jwr.email.from}") String emailFrom,
                            @Value("${jwr.email.to}") String emailTo,
                            @Value("${jwr.email.cc}") String emailCC,
                            @Value("${jwr.email.technical.to}") String emailTechnicalTo){
        this.emailFrom = emailFrom;
        this.emailTo = emailTo.split(",");
        this.emailCC = emailCC.split(",");
        this.emailTechnicalTo = emailTechnicalTo;
        this.emailSender = emailSender;
        this.thymeleafTemplateEngine = thymeleafTemplateEngine;
    }
    public void sendSimpleMessage(String to, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailFrom);
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);

            emailSender.send(message);
        } catch (MailException exception) {
            log.error(exception.getMessage());
        }
    }

    public void sendTechnicalErrorMessage(String subject, String text){
        sendSimpleMessage(emailTechnicalTo,subject,text);
    }

    public void sendSimpleMessageCC(String to, String cc, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailFrom);
            message.setTo(to);
            message.setCc(cc);
            message.setSubject(subject);
            message.setText(text);

            emailSender.send(message);
        } catch (MailException exception) {
            log.error(exception.getMessage());
        }
    }

    @Override
    public void sendMessageWithAttachment(String subject, String text, String pathToAttachment) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            // pass 'true' to the constructor to create a multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setFrom(emailFrom);
            helper.setTo(emailTo);
            helper.setCc(emailCC);
            helper.setSubject(subject);
            helper.setText(text);

            FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
            helper.addAttachment("Invoice", file);

            emailSender.send(message);
        } catch (MessagingException exception) {
            log.error(exception.getMessage());
        }
    }


    @Override
    public void sendMessageUsingThymeleafTemplate(@NonNull String subject, @NonNull Map<String, Object> templateModel)
            throws MessagingException {

        Context thymeleafContext = new Context();
        thymeleafContext.setVariables(templateModel);

        String htmlBody = thymeleafTemplateEngine.process("mail.html", thymeleafContext);

        sendHtmlMessage(subject,emailFrom, emailTo, emailCC, htmlBody);
    }

    @Override
    public void sendMessageUsingThymeleafTemplateCustomRecipients(@NonNull String subject, String to, String cc,@NonNull Map<String, Object> templateModel) throws IOException, MessagingException {
        Context thymeleafContext = new Context();
        thymeleafContext.setVariables(templateModel);

        String htmlBody = thymeleafTemplateEngine.process("mail.html", thymeleafContext);

        List<String> allto = new ArrayList<String>();
        Collections.addAll(allto, to.split(","));
        Collections.addAll(allto, emailTo);


        List<String> allcc = new ArrayList<String>();
        Collections.addAll(allcc, cc.split(","));
        Collections.addAll(allcc, emailCC);

        String[] simpleArrayTo = new String[ allto.size() ];
        allto.toArray( simpleArrayTo );

        String[] simpleArrayCC = new String[ allcc.size() ];
        allcc.toArray( simpleArrayCC );

        sendHtmlMessage(subject,emailFrom, simpleArrayTo, simpleArrayCC, htmlBody);
    }

    private void sendHtmlMessage(@NonNull String subject, @NonNull String from, String [] to, String [] cc,@NonNull String htmlBody) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom(from);
        helper.setTo(cleanAddresses(to));
        helper.setCc(cleanAddresses(cc));
        helper.setSubject(subject);
        helper.setText(htmlBody, true);
        emailSender.send(message);
    }
    
    private String [] cleanAddresses(String [] input){
        return Arrays.stream(input).filter(x -> !StringUtils.isBlank(x)).toArray(String[]::new);
    }

}
