package co.edu.usbcali.portafoliousbsek.controller;

import co.edu.usbcali.portafoliousbsek.dto.UserRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.UserResponseDTO;
import co.edu.usbcali.portafoliousbsek.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/users")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //Metodo para obtener todos los usuarios
    @GetMapping("/all")
    List<UserResponseDTO> getAll(){
        return userService.getUsers();
    }

    //Método para obtener el nombre del usuario por Id
    @GetMapping("/byId/{id}")
    String findNameUserById(@PathVariable Integer id){
        return userService.findNameUserById(id);
    }

    //Método para obtener el usuario por Id
    @GetMapping("/id/{id}")
    ResponseEntity<UserResponseDTO> findById(@PathVariable Integer id){
        UserResponseDTO response = userService.finUserById(id);
        if(response == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping
    ResponseEntity<UserResponseDTO> saveUser(@RequestBody UserRequestDTO userRequestDTO) throws Exception {
        UserResponseDTO response = userService.saveUser(userRequestDTO);
        return new ResponseEntity<UserResponseDTO>(response, HttpStatus.CREATED);
    }

    @PutMapping("/up/{id}")
    ResponseEntity<UserResponseDTO> update(@PathVariable Integer id, @RequestBody UserRequestDTO userRequestDTO) throws Exception {
        UserResponseDTO responseDTO = userService.updateUser(id, userRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
