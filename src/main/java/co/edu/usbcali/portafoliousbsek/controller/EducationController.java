package co.edu.usbcali.portafoliousbsek.controller;

import co.edu.usbcali.portafoliousbsek.dto.EducationRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.EducationResponseDTO;
import co.edu.usbcali.portafoliousbsek.service.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/education")
@RestController
@RequiredArgsConstructor
public class EducationController {
    private final EducationService educationService;

    @GetMapping("/all")
    List<EducationResponseDTO> getAll() {
        return educationService.getEducation();
    }

    @GetMapping("/{id}")
    EducationResponseDTO getById(@PathVariable Integer id) {
        return educationService.findEducationById(id);
    }

    @PostMapping
    ResponseEntity<EducationResponseDTO> save(@RequestBody EducationRequestDTO dto) throws Exception {
        EducationResponseDTO response = educationService.saveEducation(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/up/{id}")
    ResponseEntity<EducationResponseDTO> update(@PathVariable Integer id, @RequestBody EducationRequestDTO dto) throws Exception {
        EducationResponseDTO responseDTO = educationService.updateEducation(id, dto);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
