package co.edu.usbcali.portafoliousbsek.mapper;

import co.edu.usbcali.portafoliousbsek.domain.Project;
import co.edu.usbcali.portafoliousbsek.dto.ProjectRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.ProjectResponseDTO;

import java.util.List;

public class ProjectMapper {
    public static ProjectResponseDTO domainToResponseDTO(Project domain){
        ProjectResponseDTO response = ProjectResponseDTO.builder()
                .projectId(domain.getProjectId())
                .title(domain.getTitle())
                .description(domain.getDescription())
                .primaryImage(domain.getPrimaryImage())
                .demoUrl(domain.getDemoUrl())
                .repoUrl(domain.getRepoUrl())
                .dateCompleted(domain.getDateCompleted())
                .category(domain.getCategory())
                .visible(domain.getVisible())
                .build();
        return response;
    }

    public static List<ProjectResponseDTO> domainListToResponseList(List<Project> list){
        return list.stream().map(ProjectMapper::domainToResponseDTO).toList();
    }

    public static Project requestToDomain(ProjectRequestDTO dto){
        Project p = Project.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .primaryImage(dto.getPrimaryImage())
                .demoUrl(dto.getDemoUrl())
                .repoUrl(dto.getRepoUrl())
                .dateCompleted(dto.getDateCompleted())
                .category(dto.getCategory())
                .visible(dto.getVisible())
                .build();
        return p;
    }
}
