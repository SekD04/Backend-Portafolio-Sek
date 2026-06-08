package co.edu.usbcali.portafoliousbsek.controller;

import co.edu.usbcali.portafoliousbsek.dto.ExperienceResponseDTO;
import co.edu.usbcali.portafoliousbsek.dto.MessageRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.MessageResponseDTO;
import co.edu.usbcali.portafoliousbsek.service.MessagesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/messages")
@RestController
@RequiredArgsConstructor
public class MessagesController {
    private final MessagesService messagesService;

    @GetMapping("/all")
    List<MessageResponseDTO> getAll() {
        return messagesService.getMessages();
    }

    @GetMapping("/{id}")
    MessageResponseDTO getById(@PathVariable Integer id) {
        return messagesService.findMessageById(id);
    }

    @PostMapping
    ResponseEntity<MessageResponseDTO> save(@RequestBody MessageRequestDTO dto) throws Exception {
        MessageResponseDTO response = messagesService.saveMessage(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/up/{id}")
    ResponseEntity<MessageResponseDTO> update(@PathVariable Integer id, @RequestBody MessageRequestDTO dto) throws Exception {
        MessageResponseDTO responseDTO = messagesService.updateMessage(id, dto);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PatchMapping("/set-read-flag")
    public ResponseEntity<MessageResponseDTO> setFlag(
            @RequestParam Integer id,
            @RequestParam boolean isRead
    ) throws Exception {
        MessageResponseDTO responseDTO = messagesService.setReadFlag(id, isRead);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
