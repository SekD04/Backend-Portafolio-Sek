package co.edu.usbcali.portafoliousbsek.service;

import co.edu.usbcali.portafoliousbsek.domain.User;
import co.edu.usbcali.portafoliousbsek.dto.UserRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.UserResponseDTO;
import co.edu.usbcali.portafoliousbsek.mapper.UserMapper;
import co.edu.usbcali.portafoliousbsek.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<UserResponseDTO> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponseDTO> responseDTOs = UserMapper.domainListToUserResponseDTOList(users);
        return responseDTOs;
    }

    @Override
    @Transactional(readOnly = true)
    public String findNameUserById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            return userOptional.get().getName();
        }
        return "Not found";
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponseDTO finUserById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            UserResponseDTO response = UserMapper
                    .domainToUserResponseDTO(userOptional.get());
            return response;
        }
        return null;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public UserResponseDTO saveUser(UserRequestDTO userRequestDTO) throws Exception {

        if(userRequestDTO == null){
            throw new Exception("El usuario no puede ser nulo.");
        }

        if(userRequestDTO.getName() == null || userRequestDTO.getName().trim().isEmpty()){
            throw new Exception("El nombre de usuario no puede ser nulo.");
        }

        if(userRequestDTO.getEmail() == null || userRequestDTO.getEmail().trim().isEmpty()){
            throw new Exception("El email del usuario no puede ser nulo.");
        }

        if(userRequestDTO.getPassword() == null || userRequestDTO.getPassword().trim().isEmpty()){
            throw new Exception("La contraseña del usuario no puede ser nulo.");
        }

        User user = UserMapper.userRequestDTOToDomain(userRequestDTO);

        user = userRepository.save(user);
        UserResponseDTO response = UserMapper.domainToUserResponseDTO(user);

        return response;
    }

    @Override
    public UserResponseDTO updateUser(Integer id, UserRequestDTO userRequestDTO) throws Exception {
        if (id == null || id == 0) {
            throw new Exception("El id del usuario no puede ser nulo.");
        }
        if (userRequestDTO == null) {
            throw new Exception("El usuario no puede ser nulo.");
        }
        if(userRequestDTO.getName() == null || userRequestDTO.getName().trim().isEmpty()){
            throw new Exception("El nombre de usuario no puede ser nulo.");
        }
        if(userRequestDTO.getEmail() == null || userRequestDTO.getEmail().trim().isEmpty()){
            throw new Exception("El email del usuario no puede ser nulo.");
        }
        if(userRequestDTO.getPassword() == null || userRequestDTO.getPassword().trim().isEmpty()){
            throw new Exception("La contraseña del usuario no puede ser nulo.");
        }

        if(userRepository.existsById(id)){
            User user = userRepository.findById(id).get();
            user.setName(userRequestDTO.getName());
            user.setEmail(userRequestDTO.getEmail());
            user.setProfilePhoto(userRequestDTO.getProfilePhoto());
            user.setBio(userRequestDTO.getBio());
            user.setLocation(userRequestDTO.getLocation());
            user.setProfession(userRequestDTO.getProfession());
            user.setPitch(userRequestDTO.getPitch());
            user.setPhone(userRequestDTO.getPhone());
            user.setVisitCount(userRequestDTO.getVisitCount());
            user.setPassword(userRequestDTO.getPassword());
            user.setCvUrl(userRequestDTO.getCvUrl());
            user = userRepository.save(user);
            UserResponseDTO responseDTO = UserMapper.domainToUserResponseDTO(user);
            return responseDTO;
        } else{
            throw new Exception("El usuario no existe por id "+id);
        }
    }
}
