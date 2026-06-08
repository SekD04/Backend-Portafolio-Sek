package co.edu.usbcali.portafoliousbsek.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class ExperienceRequestDTO {
    private Integer userId;
    private String position;
    private String company;
    private Date startDate;
    private Date endDate;
    private String description;
    private Boolean currentlyWorking;
}
