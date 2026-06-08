package co.edu.usbcali.portafoliousbsek.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
public class EducationResponseDTO {
    private Integer educationId;
    private String degree;
    private String institution;
    private Date startDate;
    private Date endDate;
    private String description;
}
