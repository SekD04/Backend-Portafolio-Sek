package co.edu.usbcali.portafoliousbsek.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProjectTechnologyRequestDTO {
    private Integer projectId;
    private Integer technologyId;
}
