package py.com.fmendoza.sendmailapi.service;

import jakarta.mail.MessagingException;
import py.com.fmendoza.sendmailapi.model.SendMailRequestBody;

import java.io.UnsupportedEncodingException;

public interface SendMailService {
    boolean sendMail(SendMailRequestBody body) throws MessagingException, UnsupportedEncodingException;
}
