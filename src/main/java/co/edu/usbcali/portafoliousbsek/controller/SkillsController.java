package co.edu.usbcali.portafoliousbsek.controller;

import co.edu.usbcali.portafoliousbsek.dto.SkillRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.SkillResponseDTO;
import co.edu.usbcali.portafoliousbsek.service.SkillsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/skills")
@RestController
@RequiredArgsConstructor
public class SkillsController {
    private final SkillsService skillsService;

    @GetMapping("/all")
    List<SkillResponseDTO> getAll() {
        return skillsService.getSkills();
    }

    @GetMapping("/{id}")
    SkillResponseDTO getById(@PathVariable Integer id) {
        return skillsService.findSkillById(id);
    }

    @PostMapping
    ResponseEntity<SkillResponseDTO> save(@RequestBody SkillRequestDTO dto) throws Exception {
        SkillResponseDTO response = skillsService.saveSkill(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/up/{id}")
    ResponseEntity<SkillResponseDTO> update(@PathVariable Integer id, @RequestBody SkillRequestDTO dto) throws Exception {
        SkillResponseDTO responseDTO = skillsService.updateSkill(id, dto);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PatchMapping("/set-technical-flag")
    ResponseEntity<SkillResponseDTO> setFlag(@RequestParam Integer id, @RequestParam boolean isTechnical) throws Exception {
        SkillResponseDTO responseDTO = skillsService.setTechnicalFlag(id, isTechnical);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
