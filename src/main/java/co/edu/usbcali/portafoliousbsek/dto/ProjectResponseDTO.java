package co.edu.usbcali.portafoliousbsek.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
public class ProjectResponseDTO {
    private Integer projectId;
    private String title;
    private String description;
    private String primaryImage;
    private String demoUrl;
    private String repoUrl;
    private Date dateCompleted;
    private String category;
    private Boolean visible;
}
