package co.edu.usbcali.portafoliousbsek.controller;

import co.edu.usbcali.portafoliousbsek.dto.ProjectImageRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.ProjectImageResponseDTO;
import co.edu.usbcali.portafoliousbsek.service.ProjectImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/projectimages")
@RestController
@RequiredArgsConstructor
public class ProjectImageController {
    private final ProjectImageService projectImageService;

    @GetMapping("/all")
    List<ProjectImageResponseDTO> getAll() {
        return projectImageService.getProjectImages();
    }

    @GetMapping("/{id}")
    ProjectImageResponseDTO getById(@PathVariable Integer id) {
        return projectImageService.findProjectImageById(id);
    }

    @PostMapping
    ResponseEntity<ProjectImageResponseDTO> save(@RequestBody ProjectImageRequestDTO dto) throws Exception {
        ProjectImageResponseDTO response = projectImageService.saveProjectImage(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/up/{id}")
    ResponseEntity<ProjectImageResponseDTO> update(@PathVariable Integer id, @RequestBody ProjectImageRequestDTO dto) throws Exception {
        ProjectImageResponseDTO responseDTO = projectImageService.updateProjectImage(id, dto);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
