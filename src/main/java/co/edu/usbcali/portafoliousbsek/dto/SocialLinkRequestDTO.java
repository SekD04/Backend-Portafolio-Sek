package co.edu.usbcali.portafoliousbsek.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SocialLinkRequestDTO {
    private Integer userId;
    private String name;
    private String url;
    private String iconClass;
}
