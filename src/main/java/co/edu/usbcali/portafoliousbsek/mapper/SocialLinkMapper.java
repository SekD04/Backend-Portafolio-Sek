package co.edu.usbcali.portafoliousbsek.mapper;

import co.edu.usbcali.portafoliousbsek.domain.SocialLinks;
import co.edu.usbcali.portafoliousbsek.dto.SocialLinkRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.SocialLinkResponseDTO;

import java.util.List;

public class SocialLinkMapper {
    public static SocialLinkResponseDTO domainToResponseDTO(SocialLinks domain){
        SocialLinkResponseDTO response = SocialLinkResponseDTO.builder()
                .linkId(domain.getLinkId())
                .name(domain.getName())
                .url(domain.getUrl())
                .iconClass(domain.getIconClass())
                .build();
        return response;
    }

    public static List<SocialLinkResponseDTO> domainListToResponseList(List<SocialLinks> list){
        return list.stream().map(SocialLinkMapper::domainToResponseDTO).toList();
    }

    public static SocialLinks requestToDomain(SocialLinkRequestDTO dto){
        SocialLinks e = SocialLinks.builder()
                .name(dto.getName())
                .url(dto.getUrl())
                .iconClass(dto.getIconClass())
                .build();
        return e;
    }
}
