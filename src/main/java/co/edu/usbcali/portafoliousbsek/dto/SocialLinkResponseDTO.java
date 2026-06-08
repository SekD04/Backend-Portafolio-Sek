package co.edu.usbcali.portafoliousbsek.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SocialLinkResponseDTO {
    private Integer linkId;
    private String name;
    private String url;
    private String iconClass;
}
