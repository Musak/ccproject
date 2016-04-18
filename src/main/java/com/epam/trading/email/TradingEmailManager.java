package com.epam.trading.email;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.internet.MimeMessage;
import java.util.Map;
import java.util.logging.Logger;


/**
 * Created by musak on 14/04/16.
 */
@Service
public class TradingEmailManager {

    private static final String ENCODING = "utf-8";
    private static final String TEXT_HTML = "text/html";
    private static Logger LOG = Logger.getLogger(TradingEmailManager.class.getSimpleName());

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SimpleMailMessage simpleMailMessage;

    @Autowired
    private VelocityEngine velocityEngine;

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

    public VelocityEngine getVelocityEngine() {
        return velocityEngine;
    }

    public void setVelocityEngine(VelocityEngine velocityEngine) {
        this.velocityEngine = velocityEngine;
    }

    public void sendMail(Map<String, Object> model, String template) {
        try {
            LOG.info("sendMail :: simpleMailMessage: " + simpleMailMessage);

            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(simpleMailMessage.getFrom());
            mimeMessageHelper.setTo(simpleMailMessage.getTo());
            mimeMessageHelper.setSubject(simpleMailMessage.getSubject());

            String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, template, ENCODING, model);
            mimeMessage.setContent(text, TEXT_HTML);

            mailSender.send(mimeMessage);

        } catch (Exception e) {
            throw new MailParseException(e);
        }

    }
}
