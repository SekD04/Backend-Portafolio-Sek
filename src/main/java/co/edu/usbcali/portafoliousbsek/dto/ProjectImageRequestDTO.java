package co.edu.usbcali.portafoliousbsek.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProjectImageRequestDTO {
    private Integer projectId;
    private String imageUrl;
    private String caption;
}
