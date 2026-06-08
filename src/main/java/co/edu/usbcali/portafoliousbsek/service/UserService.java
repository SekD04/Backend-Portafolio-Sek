package co.edu.usbcali.portafoliousbsek.service;

import co.edu.usbcali.portafoliousbsek.dto.UserRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.UserResponseDTO;

import java.util.List;

public interface UserService {

    List<UserResponseDTO> getUsers();

    String findNameUserById(Integer id);

    UserResponseDTO finUserById(Integer id);

    UserResponseDTO saveUser(UserRequestDTO user) throws Exception;

    UserResponseDTO updateUser(Integer id, UserRequestDTO userRequestDTO) throws Exception;
}
