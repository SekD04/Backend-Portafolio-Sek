package co.edu.usbcali.portafoliousbsek.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SkillResponseDTO {
    private Integer id;
    private String name;
    private Integer level;
    private Boolean isTechnical;
}
