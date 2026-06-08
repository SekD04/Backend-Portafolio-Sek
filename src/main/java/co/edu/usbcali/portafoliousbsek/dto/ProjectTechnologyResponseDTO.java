package co.edu.usbcali.portafoliousbsek.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProjectTechnologyResponseDTO {

    private Integer id;
    private String projectName;
    private String technologyName;
}
