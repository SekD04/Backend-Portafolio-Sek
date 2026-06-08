package co.edu.usbcali.portafoliousbsek.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SkillRequestDTO {
    private Integer userId;
    private String name;
    private Integer level;
    private Boolean isTechnical;
}
