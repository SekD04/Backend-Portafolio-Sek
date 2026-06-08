package co.edu.usbcali.portafoliousbsek.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class EducationRequestDTO {
    private Integer userId;
    private String degree;
    private String institution;
    private Date startDate;
    private Date endDate;
    private String description;
}
