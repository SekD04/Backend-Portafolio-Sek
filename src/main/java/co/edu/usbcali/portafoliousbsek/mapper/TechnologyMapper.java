package co.edu.usbcali.portafoliousbsek.mapper;

import co.edu.usbcali.portafoliousbsek.domain.Technology;
import co.edu.usbcali.portafoliousbsek.dto.TechnologyRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.TechnologyResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class TechnologyMapper {

    public static TechnologyResponseDTO domainToTechnologyResponseDTO(Technology domain){
        TechnologyResponseDTO response = TechnologyResponseDTO.builder()
                .id(domain.getTechId())
                .name(domain.getName())
                .url(domain.getLogoUrl())
                .build();
        return response;
    }

    public static List<TechnologyResponseDTO> domainListToTechnologyResponseDTOList(List<Technology> technologies){
        return technologies.stream().map(TechnologyMapper::domainToTechnologyResponseDTO).toList();
    }

    public static Technology technologyRequestDTOtoDomain(TechnologyRequestDTO technologyRequestDTO){
        Technology technology = Technology.builder()
                .name(technologyRequestDTO.getName())
                .logoUrl(technologyRequestDTO.getUrl())
                .build();

        return technology;
    }
}
