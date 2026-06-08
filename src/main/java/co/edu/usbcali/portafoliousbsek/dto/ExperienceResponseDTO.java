package co.edu.usbcali.portafoliousbsek.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
public class ExperienceResponseDTO {
    private Integer experienceId;
    private String position;
    private String company;
    private Date startDate;
    private Date endDate;
    private String description;
    private Boolean currentlyWorking;
}
