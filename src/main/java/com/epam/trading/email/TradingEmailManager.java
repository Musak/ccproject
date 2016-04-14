package com.epam.trading.email;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;


/**
 * Created by musak on 14/04/16.
 */
@Service
public class TradingEmailManager {

    private static final String ENCODING = "utf-8";
    private static Logger LOG = Logger.getLogger(TradingEmailManager.class.getSimpleName());

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SimpleMailMessage simpleMailMessage;

    @Autowired
    private VelocityEngine velocityEngine;

    @Value("${trading.email.template.location}")
    private String emailTemplateLocation;
    private String attachmentFilePath;


    public JavaMailSender getMailSender() {
        return mailSender;
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public SimpleMailMessage getSimpleMailMessage() {
        return simpleMailMessage;
    }

    public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
        this.simpleMailMessage = simpleMailMessage;
    }

    public String getAttachmentFilePath() {
        return attachmentFilePath;
    }

    public void setAttachmentFilePath(String attachmentFilePath) {
        this.attachmentFilePath = attachmentFilePath;
    }

    public String getEmailTemplateLocation() {
        return emailTemplateLocation;
    }

    public void setEmailTemplateLocation(String emailTemplateLocation) {
        this.emailTemplateLocation = emailTemplateLocation;
    }

    public VelocityEngine getVelocityEngine() {
        return velocityEngine;
    }

    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }

    public void sendMail() {
        try {
            LOG.info("sendMail :: simpleMailMessage: " + simpleMailMessage);

            Map<String, Object> model = new HashMap<>();
            model.put("name", "Name");

           // String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, getEmailTemplateLocation(), ENCODING, model);
           // simpleMailMessage.setText(text);
            simpleMailMessage.setText("aaaa");
            mailSender.send(simpleMailMessage);

        } catch (Exception e) {
            throw new MailParseException(e);
        }

    }
}
