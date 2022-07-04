package com.opossum.jiraworklogreporter.mail;

import java.io.File;
import java.util.Map;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void sendMessageUsingThymeleafTemplate(String subject, Map<String, Object> templateModel)
            throws MessagingException {

        Context thymeleafContext = new Context();
        thymeleafContext.setVariables(templateModel);

        String htmlBody = thymeleafTemplateEngine.process("mail.html", thymeleafContext);

        sendHtmlMessage(subject, htmlBody);
    }
    private void sendHtmlMessage(String subject, String htmlBody) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        helper.setFrom(emailFrom);
        helper.setTo(emailTo);
        helper.setCc(emailCC);
        helper.setSubject(subject);
        helper.setText(htmlBody, true);
       // helper.addInline("attachment.png", resourceFile);
        emailSender.send(message);
    }

}
