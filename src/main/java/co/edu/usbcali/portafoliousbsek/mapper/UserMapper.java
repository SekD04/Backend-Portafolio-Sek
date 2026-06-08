package co.edu.usbcali.portafoliousbsek.mapper;

import co.edu.usbcali.portafoliousbsek.domain.User;
import co.edu.usbcali.portafoliousbsek.dto.UserRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.UserResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserResponseDTO domainToUserResponseDTO(User domain){
        UserResponseDTO response = UserResponseDTO.builder()
                .userId(domain.getUserId())
                .name(domain.getName())
                .email(domain.getEmail())
                .profilePhoto(domain.getProfilePhoto())
                .bio(domain.getBio())
                .location(domain.getLocation())
                .profession(domain.getProfession())
                .pitch(domain.getPitch())
                .phone(domain.getPhone())
                .visitCount(domain.getVisitCount())
                .cvUrl(domain.getCvUrl())
                .build();
        return response;
    }

    public static List<UserResponseDTO> domainListToUserResponseDTOList(List<User> users){
        return users.stream().map(UserMapper::domainToUserResponseDTO).toList();
    }

    public static User userRequestDTOToDomain(UserRequestDTO userRequestDTO){
        User user = User.builder()
                .name(userRequestDTO.getName())
                .email(userRequestDTO.getEmail())
                .profilePhoto(userRequestDTO.getProfilePhoto())
                .bio(userRequestDTO.getBio())
                .location(userRequestDTO.getLocation())
                .password(userRequestDTO.getPassword())
                .profession(userRequestDTO.getProfession())
                .pitch(userRequestDTO.getPitch())
                .phone(userRequestDTO.getPhone())
                .visitCount(userRequestDTO.getVisitCount())
                .cvUrl(userRequestDTO.getCvUrl())
                .build();

        return user;
    }
}
