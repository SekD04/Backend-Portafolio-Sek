package co.edu.usbcali.portafoliousbsek.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class TechnologyResponseDTO {

    private Integer id;
    private String name;
    private String url;
}
