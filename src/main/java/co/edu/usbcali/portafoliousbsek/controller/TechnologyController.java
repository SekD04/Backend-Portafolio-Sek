package co.edu.usbcali.portafoliousbsek.controller;

import co.edu.usbcali.portafoliousbsek.dto.TechnologyRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.TechnologyResponseDTO;
import co.edu.usbcali.portafoliousbsek.service.TechnologyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/technologies")
@RestController
@RequiredArgsConstructor
public class TechnologyController {

    private final TechnologyService technologyService;

    @GetMapping("/ping")
    String ping() {
        return "pong";
    }

    //Método para obtener todas las tecnologias
    @GetMapping("/all")
    List<TechnologyResponseDTO> getAll() {
        return technologyService.getTechnologies();
    }

    //Método para obtener el nombre de la tecnología por Id
    @GetMapping("/byId/{id}")
    String findNameTechnologyById(@PathVariable Integer id) {
        return technologyService.findNameTechnologyById(id);
    }

    //Método para obtener la tecnología por Id
    @GetMapping("/id/{id}")
    ResponseEntity<TechnologyResponseDTO> findById(@PathVariable Integer id) {
        TechnologyResponseDTO response = technologyService.findTechnologyById(id);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping
    ResponseEntity<TechnologyResponseDTO> save(@RequestBody TechnologyRequestDTO technologyRequestDTO) throws Exception {
        TechnologyResponseDTO response = technologyService.saveTechnology(technologyRequestDTO);
        return new ResponseEntity<TechnologyResponseDTO>(response, HttpStatus.CREATED);
    }

    @PutMapping("/up/{id}")
    ResponseEntity<TechnologyResponseDTO> update(@PathVariable Integer id, @RequestBody TechnologyRequestDTO technologyRequestDTO) throws Exception {
        TechnologyResponseDTO responseDTO = technologyService.updateTechnology(id, technologyRequestDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
