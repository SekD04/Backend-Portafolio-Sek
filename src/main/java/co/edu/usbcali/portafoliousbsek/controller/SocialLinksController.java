package co.edu.usbcali.portafoliousbsek.controller;

import co.edu.usbcali.portafoliousbsek.dto.SocialLinkRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.SocialLinkResponseDTO;
import co.edu.usbcali.portafoliousbsek.service.SocialLinksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/sociallinks")
@RestController
@RequiredArgsConstructor
public class SocialLinksController {
    private final SocialLinksService socialLinksService;

    @GetMapping("/all")
    List<SocialLinkResponseDTO> getAll() {
        return socialLinksService.getSocialLinks();
    }

    @GetMapping("/{id}")
    SocialLinkResponseDTO getById(@PathVariable Integer id) {
        return socialLinksService.findSocialLinkById(id);
    }

    @PostMapping
    ResponseEntity<SocialLinkResponseDTO> save(@RequestBody SocialLinkRequestDTO dto) throws Exception {
        SocialLinkResponseDTO response = socialLinksService.saveSocialLink(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/up/{id}")
    ResponseEntity<SocialLinkResponseDTO> update(@PathVariable Integer id, @RequestBody SocialLinkRequestDTO dto) throws Exception {
        SocialLinkResponseDTO responseDTO = socialLinksService.updateSocialLink(id, dto);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
