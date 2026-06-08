package co.edu.usbcali.portafoliousbsek.service;

import co.edu.usbcali.portafoliousbsek.dto.MessageRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.MessageResponseDTO;

import java.util.List;

public interface MessagesService {
    List<MessageResponseDTO> getMessages();
    MessageResponseDTO findMessageById(Integer id);
    MessageResponseDTO saveMessage(MessageRequestDTO message) throws Exception;
    MessageResponseDTO updateMessage(Integer id, MessageRequestDTO message) throws Exception;
    MessageResponseDTO setReadFlag(Integer id, boolean isRead) throws Exception;
}
