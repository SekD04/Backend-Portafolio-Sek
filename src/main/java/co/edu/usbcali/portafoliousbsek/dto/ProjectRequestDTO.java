package co.edu.usbcali.portafoliousbsek.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class ProjectRequestDTO {
    private Integer userId;
    private String title;
    private String description;
    private String primaryImage;
    private String demoUrl;
    private String repoUrl;
    private Date dateCompleted;
    private String category;
    private Boolean visible;
}
