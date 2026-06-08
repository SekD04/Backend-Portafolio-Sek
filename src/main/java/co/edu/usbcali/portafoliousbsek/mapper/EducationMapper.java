package co.edu.usbcali.portafoliousbsek.mapper;

import co.edu.usbcali.portafoliousbsek.domain.Education;
import co.edu.usbcali.portafoliousbsek.dto.EducationRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.EducationResponseDTO;

import java.util.List;

public class EducationMapper {
    public static EducationResponseDTO domainToResponseDTO(Education domain){
        EducationResponseDTO response = EducationResponseDTO.builder()
                .educationId(domain.getEducationId())
                .degree(domain.getDegree())
                .institution(domain.getInstitution())
                .startDate(domain.getStartDate())
                .endDate(domain.getEndDate())
                .description(domain.getDescription())
                .build();
        return response;
    }

    public static List<EducationResponseDTO> domainListToResponseList(List<Education> educationList){
        return educationList.stream().map(EducationMapper::domainToResponseDTO).toList();
    }

    public static Education requestToDomain(EducationRequestDTO dto){
        Education education = Education.builder()
                .degree(dto.getDegree())
                .institution(dto.getInstitution())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .description(dto.getDescription())
                .build();
        return education;
    }
}
