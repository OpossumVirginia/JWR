package com.opossum.jiraworklogreporter.configuration;


import java.util.Properties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
@ComponentScan(basePackages = { "opossum.jiraworklogreporter.mail" })
@PropertySource(value={"classpath:application.properties"})
public class EmailConfiguration {
    private String mailServerHost;
    private Integer mailServerPort;
    private String mailServerUsername;
    private String mailServerPassword;
    private String mailServerAuth;
    private String mailServerStartTls;

    public EmailConfiguration(@Value("${spring.mail.host}") String mailServerHost,
                              @Value("${spring.mail.port}") Integer mailServerPort,
                              @Value("${spring.mail.username}") String mailServerUsername,
                              @Value("${spring.mail.password}") String mailServerPassword,
                              @Value("${spring.mail.properties.mail.smtp.auth}") String mailServerAuth,
                              @Value("${spring.mail.properties.mail.smtp.starttls.enable}") String mailServerStartTls){

        this.mailServerHost = mailServerHost;
        this.mailServerPort = mailServerPort;
        this.mailServerUsername = mailServerUsername;
        this.mailServerPassword = mailServerPassword;
        this.mailServerAuth = mailServerAuth;
        this.mailServerStartTls = mailServerStartTls;
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(mailServerHost);
        mailSender.setPort(mailServerPort);

        mailSender.setUsername(mailServerUsername);
        mailSender.setPassword(mailServerPassword);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", mailServerAuth);
        props.put("mail.smtp.starttls.enable", mailServerStartTls);
        props.put("mail.debug", "true");

        return mailSender;
    }

    @Bean
    public SimpleMailMessage templateSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText("This is the test email template for your email:\n%s\n");
        return message;
    }

    @Bean
    public SpringTemplateEngine thymeleafTemplateEngine(ITemplateResolver templateResolver) {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        templateEngine.setTemplateEngineMessageSource(emailMessageSource());
        return templateEngine;
    }

    @Bean
    public ITemplateResolver thymeleafClassLoaderTemplateResolver() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix("mail-templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML");
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }

    @Bean
    public ResourceBundleMessageSource emailMessageSource() {
        final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("mailMessages");
        return messageSource;
    }

}