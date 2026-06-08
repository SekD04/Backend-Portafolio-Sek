package co.edu.usbcali.portafoliousbsek.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TechnologyRequestDTO {
    private String name;
    private String url;
}
