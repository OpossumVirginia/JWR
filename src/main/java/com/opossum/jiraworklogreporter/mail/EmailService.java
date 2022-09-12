package com.opossum.jiraworklogreporter.mail;

import java.io.IOException;
import java.util.Map;

import jakarta.mail.MessagingException;

public interface EmailService {
    void sendSimpleMessage(String to, String subject, String text);
    void sendMessageWithAttachment( String subject, String text, String pathToAttachment);

    void sendMessageUsingThymeleafTemplate(String subject, Map<String, Object> templateModel)
            throws IOException,MessagingException;
    void sendMessageUsingThymeleafTemplateCustomRecipients(String subject, String to, String cc, Map<String, Object> templateModel)
            throws IOException,MessagingException;

    void sendTechnicalErrorMessage(String subject, String text);

    void sendSimpleMessageCC(String to, String cc, String subject, String text);
}
