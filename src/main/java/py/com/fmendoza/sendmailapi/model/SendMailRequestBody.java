package py.com.fmendoza.sendmailapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendMailRequestBody {
    private String message;
    private String to;
    private String subject;
}
