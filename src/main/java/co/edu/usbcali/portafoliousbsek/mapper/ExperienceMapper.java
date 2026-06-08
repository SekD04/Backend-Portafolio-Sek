package co.edu.usbcali.portafoliousbsek.mapper;

import co.edu.usbcali.portafoliousbsek.domain.Experience;
import co.edu.usbcali.portafoliousbsek.dto.ExperienceRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.ExperienceResponseDTO;

import java.util.List;

public class ExperienceMapper {
    public static ExperienceResponseDTO domainToResponseDTO(Experience domain){
        ExperienceResponseDTO response = ExperienceResponseDTO.builder()
                .experienceId(domain.getExperienceId())
                .position(domain.getPosition())
                .company(domain.getCompany())
                .startDate(domain.getStartDate())
                .endDate(domain.getEndDate())
                .description(domain.getDescription())
                .currentlyWorking(domain.getCurrentlyWorking())
                .build();
        return response;
    }

    public static List<ExperienceResponseDTO> domainListToResponseList(List<Experience> list){
        return list.stream().map(ExperienceMapper::domainToResponseDTO).toList();
    }

    public static Experience requestToDomain(ExperienceRequestDTO dto){
        Experience e = Experience.builder()
                .position(dto.getPosition())
                .company(dto.getCompany())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .description(dto.getDescription())
                .currentlyWorking(dto.getCurrentlyWorking())
                .build();
        return e;
    }
}
