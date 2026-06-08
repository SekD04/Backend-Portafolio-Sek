package co.edu.usbcali.portafoliousbsek.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserResponseDTO {

    private Integer userId;
    private String name;
    private String email;
    private String profilePhoto;
    private String bio;
    private String location;
    private String profession;
    private String pitch;
    private String phone;
    private Integer visitCount;
    private String cvUrl;
}
