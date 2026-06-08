package co.edu.usbcali.portafoliousbsek.mapper;

import co.edu.usbcali.portafoliousbsek.domain.Skills;
import co.edu.usbcali.portafoliousbsek.dto.SkillRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.SkillResponseDTO;

import java.util.List;

public class SkillMapper {
    public static SkillResponseDTO domainToResponseDTO(Skills domain){
        SkillResponseDTO response = SkillResponseDTO.builder()
                .id(domain.getSkillId())
                .name(domain.getName())
                .level(domain.getLevel())
                .isTechnical(domain.getIsTechnical())
                .build();
        return response;
    }

    public static List<SkillResponseDTO> domainListToResponseList(List<Skills> list){
        return list.stream().map(SkillMapper::domainToResponseDTO).toList();
    }

    public static Skills requestToDomain(SkillRequestDTO dto){
        Skills s = Skills.builder()
                .name(dto.getName())
                .level(dto.getLevel())
                .isTechnical(dto.getIsTechnical())
                .build();
        return s;
    }
}
