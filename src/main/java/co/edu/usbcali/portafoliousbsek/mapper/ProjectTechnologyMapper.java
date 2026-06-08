package co.edu.usbcali.portafoliousbsek.mapper;

import co.edu.usbcali.portafoliousbsek.domain.ProjectTechnology;
import co.edu.usbcali.portafoliousbsek.dto.ProjectTechnologyResponseDTO;
import co.edu.usbcali.portafoliousbsek.dto.TechnologyResponseDTO;

import java.util.List;

public class ProjectTechnologyMapper {

    public static ProjectTechnologyResponseDTO domainToResponseDTO(ProjectTechnology projectTechnology) {
        ProjectTechnologyResponseDTO responseDTO = ProjectTechnologyResponseDTO.builder()
                .id(projectTechnology.getProjectTechnologyId())
                .technologyName(projectTechnology.getTechnology() == null ? null
                        : projectTechnology.getTechnology().getName())
                .build();

        return responseDTO;
    }

    public static List<ProjectTechnologyResponseDTO> domainToResponseDTO(List<ProjectTechnology> projectTechnologies){
        return projectTechnologies.stream().map(ProjectTechnologyMapper::domainToResponseDTO).toList();
    }
}
