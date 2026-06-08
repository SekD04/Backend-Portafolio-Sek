package co.edu.usbcali.portafoliousbsek.mapper;

import co.edu.usbcali.portafoliousbsek.domain.ProjectImage;
import co.edu.usbcali.portafoliousbsek.dto.ProjectImageRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.ProjectImageResponseDTO;

import java.util.List;

public class ProjectImageMapper {
    public static ProjectImageResponseDTO domainToResponseDTO(ProjectImage domain){
        ProjectImageResponseDTO response = ProjectImageResponseDTO.builder()
                .imageId(domain.getImageId())
                .imageUrl(domain.getImageUrl())
                .caption(domain.getCaption())
                .build();
        return response;
    }

    public static List<ProjectImageResponseDTO> domainListToResponseList(List<ProjectImage> list){
        return list.stream().map(ProjectImageMapper::domainToResponseDTO).toList();
    }

    public static ProjectImage requestToDomain(ProjectImageRequestDTO dto){
        ProjectImage e = ProjectImage.builder()
                .imageUrl(dto.getImageUrl())
                .caption(dto.getCaption())
                .build();
        return e;
    }
}
