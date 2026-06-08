package co.edu.usbcali.portafoliousbsek.controller;

import co.edu.usbcali.portafoliousbsek.dto.ProjectRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.ProjectResponseDTO;
import co.edu.usbcali.portafoliousbsek.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/projects")
@RestController
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping("/all")
    List<ProjectResponseDTO> getAll() {
        return projectService.getProjects();
    }

    @GetMapping("/{id}")
    ProjectResponseDTO getById(@PathVariable Integer id) {
        return projectService.findProjectById(id);
    }

    @PostMapping
    ResponseEntity<ProjectResponseDTO> save(@RequestBody ProjectRequestDTO dto) throws Exception {
        ProjectResponseDTO response = projectService.saveProject(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/up/{id}")
    ResponseEntity<ProjectResponseDTO> update(@PathVariable Integer id, @RequestBody ProjectRequestDTO dto) throws Exception {
        ProjectResponseDTO responseDTO = projectService.updateProject(id, dto);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PatchMapping("/set-visible-flag")
    ResponseEntity<ProjectResponseDTO> setFlag(@RequestParam Integer id, @RequestParam boolean visible) throws Exception {
        ProjectResponseDTO responseDTO = projectService.setVisibleFlag(id, visible);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
