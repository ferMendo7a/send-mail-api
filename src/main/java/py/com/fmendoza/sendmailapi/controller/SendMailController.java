package py.com.fmendoza.sendmailapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendMailController {
    @GetMapping("/health")
    public String healthCheck() {
        return "Send Mail API OK!";
    }
}
