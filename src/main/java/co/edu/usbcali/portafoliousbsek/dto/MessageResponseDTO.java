package co.edu.usbcali.portafoliousbsek.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
public class MessageResponseDTO {
    private Integer messageId;
    private String senderName;
    private String senderEmail;
    private String content;
    private Boolean isRead;
    private Date receivedAt;
}
