package co.edu.usbcali.portafoliousbsek.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class MessageRequestDTO {
    private Integer userId;
    private String senderName;
    private String senderEmail;
    private String content;
    private Boolean isRead;
    private Date receivedAt;
}
