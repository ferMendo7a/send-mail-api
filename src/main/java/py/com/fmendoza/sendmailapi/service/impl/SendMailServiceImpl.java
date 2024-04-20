package py.com.fmendoza.sendmailapi.service.impl;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import py.com.fmendoza.sendmailapi.model.SendMailRequestBody;
import py.com.fmendoza.sendmailapi.service.SendMailService;

import java.io.UnsupportedEncodingException;

@Service
public class SendMailServiceImpl implements SendMailService {
    private static String MAIL_USERNAME;
    private static String MAIL_TITLE;
    private JavaMailSender emailSender;

    @Autowired
    public SendMailServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Value("${spring.mail.username}")
    public void setMailUsername(String mailUsername) {
        MAIL_USERNAME = mailUsername;
    }

    @Value("${api.mail.title}")
    public void setMailTitle(String mailTitle) {
        MAIL_TITLE = mailTitle;
    }

    @Override
    public boolean sendMail(SendMailRequestBody body) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper;
        helper = new MimeMessageHelper(message, false);
        helper.setFrom(MAIL_USERNAME, MAIL_TITLE);
        String[] to= {body.getTo()};
        helper.setTo(to);
        helper.setSubject(body.getSubject());
        helper.setText(body.getMessage(),false);
        emailSender.send(message);
        return true;
    }
}
