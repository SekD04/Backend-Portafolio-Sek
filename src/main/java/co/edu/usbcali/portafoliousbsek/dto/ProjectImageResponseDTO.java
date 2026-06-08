package co.edu.usbcali.portafoliousbsek.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProjectImageResponseDTO {
    private Integer imageId;
    private String imageUrl;
    private String caption;
}
