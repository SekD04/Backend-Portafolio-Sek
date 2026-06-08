package co.edu.usbcali.portafoliousbsek.controller;

import co.edu.usbcali.portafoliousbsek.dto.ExperienceRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.ExperienceResponseDTO;
import co.edu.usbcali.portafoliousbsek.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/experiences")
@RestController
@RequiredArgsConstructor
public class ExperienceController {
    private final ExperienceService experienceService;

    @GetMapping("/all")
    List<ExperienceResponseDTO> getAll() {
        return experienceService.getExperiences();
    }

    @GetMapping("/{id}")
    ExperienceResponseDTO getById(@PathVariable Integer id) {
        return experienceService.findExperienceById(id);
    }

    @PostMapping
    ResponseEntity<ExperienceResponseDTO> save(@RequestBody ExperienceRequestDTO dto) throws Exception {
        ExperienceResponseDTO response = experienceService.saveExperience(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/up/{id}")
    ResponseEntity<ExperienceResponseDTO> update(@PathVariable Integer id, @RequestBody ExperienceRequestDTO dto) throws Exception {
        ExperienceResponseDTO responseDTO = experienceService.updateExperience(id, dto);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PatchMapping("/set-currently-working-flag")
    public ResponseEntity<ExperienceResponseDTO> setFlag(
            @RequestParam Integer id,
            @RequestParam boolean currentlyWorking
    ) throws Exception {
        ExperienceResponseDTO responseDTO = experienceService.setCurrentlyWorkingFlag(id, currentlyWorking);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
