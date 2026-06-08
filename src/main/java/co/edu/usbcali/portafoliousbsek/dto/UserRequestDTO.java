package co.edu.usbcali.portafoliousbsek.dto;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserRequestDTO {

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
    private String password;
    private String cvUrl;
}
