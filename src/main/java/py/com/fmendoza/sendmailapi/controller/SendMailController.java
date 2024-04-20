package py.com.fmendoza.sendmailapi.controller;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import py.com.fmendoza.sendmailapi.model.SendMailRequestBody;
import py.com.fmendoza.sendmailapi.service.SendMailService;

import java.io.UnsupportedEncodingException;

@RestController
public class SendMailController {
    private final SendMailService sendMailService;

    @Autowired
    public SendMailController(SendMailService sendMailService) {
        this.sendMailService = sendMailService;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "Send Mail API OK!";
    }

    @PostMapping("/send")
    public boolean sendMail(@RequestBody SendMailRequestBody body) throws MessagingException, UnsupportedEncodingException {
        return sendMailService.sendMail(body);
    }

}
