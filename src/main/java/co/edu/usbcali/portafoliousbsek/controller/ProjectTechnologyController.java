package co.edu.usbcali.portafoliousbsek.controller;

import co.edu.usbcali.portafoliousbsek.dto.ProjectTechnologyRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.ProjectTechnologyResponseDTO;
import co.edu.usbcali.portafoliousbsek.service.ProjectTechnologyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/projecttechnologies")
@RestController
@RequiredArgsConstructor
public class ProjectTechnologyController {
    private final ProjectTechnologyService projectTechnologyService;

    @GetMapping("/all")
    List<ProjectTechnologyResponseDTO> getAll() {
        return projectTechnologyService.findAll();
    }

    @GetMapping("/{id}")
    ProjectTechnologyResponseDTO getById(@PathVariable Integer id) {
        return projectTechnologyService.findProjectTechnologyById(id);
    }

    @PostMapping
    ResponseEntity<ProjectTechnologyResponseDTO> save(@RequestBody ProjectTechnologyRequestDTO dto) throws Exception {
        ProjectTechnologyResponseDTO response = projectTechnologyService.saveProjectTechnology(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/up/{id}")
    ResponseEntity<ProjectTechnologyResponseDTO> update(@PathVariable Integer id, @RequestBody ProjectTechnologyRequestDTO dto) throws Exception {
        ProjectTechnologyResponseDTO response = projectTechnologyService.updateProjectTechnology(id, dto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}



