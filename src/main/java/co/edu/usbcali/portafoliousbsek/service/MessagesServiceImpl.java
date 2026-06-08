package co.edu.usbcali.portafoliousbsek.service;

import co.edu.usbcali.portafoliousbsek.domain.Messages;
import co.edu.usbcali.portafoliousbsek.domain.User;
import co.edu.usbcali.portafoliousbsek.dto.MessageRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.MessageResponseDTO;
import co.edu.usbcali.portafoliousbsek.mapper.MessageMapper;
import co.edu.usbcali.portafoliousbsek.repository.MessagesRepository;
import co.edu.usbcali.portafoliousbsek.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MessagesServiceImpl implements MessagesService {
    private final MessagesRepository messagesRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<MessageResponseDTO> getMessages() {
        List<Messages> list = messagesRepository.findAll();
        return MessageMapper.domainListToResponseList(list);
    }

    @Override
    @Transactional(readOnly = true)
    public MessageResponseDTO findMessageById(Integer id) {
        Optional<Messages> optional = messagesRepository.findById(id);
        return optional.map(MessageMapper::domainToResponseDTO).orElse(null);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public MessageResponseDTO saveMessage(MessageRequestDTO dto) throws Exception {
        if(dto == null) throw new Exception("El mensaje no puede ser nulo.");
        if(dto.getSenderName() == null || dto.getSenderName().trim().isEmpty()) throw new Exception("El nombre del remitente es obligatorio");
        if(dto.getSenderEmail() == null || dto.getSenderEmail().trim().isEmpty()) throw new Exception("El email del remitente es obligatorio");
        if(dto.getContent() == null || dto.getContent().trim().isEmpty()) throw new Exception("El contenido es obligatorio");

        Messages m = MessageMapper.requestToDomain(dto);
        if(dto.getUserId()!=null){
            User user = userRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new Exception("El usuario no existe por id "+dto.getUserId()));
            m.setUser(user);
        }
        m = messagesRepository.save(m);
        return MessageMapper.domainToResponseDTO(m);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public MessageResponseDTO updateMessage(Integer id, MessageRequestDTO dto) throws Exception {
        if(dto == null) throw new Exception("El mensaje no puede ser nulo.");
        Optional<Messages> optional = messagesRepository.findById(id);
        if(optional.isEmpty()) throw new Exception("El mensaje no existe por id "+id);

        Messages m = optional.get();
        if(dto.getSenderName()!=null) m.setSenderName(dto.getSenderName());
        if(dto.getSenderEmail()!=null) m.setSenderEmail(dto.getSenderEmail());
        if(dto.getContent()!=null) m.setContent(dto.getContent());
        if(dto.getIsRead()!=null) m.setIsRead(dto.getIsRead());
        if(dto.getReceivedAt()!=null) m.setReceivedAt(dto.getReceivedAt());

        m = messagesRepository.save(m);
        return MessageMapper.domainToResponseDTO(m);
    }

    @Override
    @Transactional
    public MessageResponseDTO setReadFlag(Integer id, boolean isRead) throws Exception {
        Messages m = messagesRepository.findById(id)
                .orElseThrow(() -> new Exception("Mensaje no encontrado por id "+id));
        m.setIsRead(isRead);
        m = messagesRepository.save(m);
        return MessageMapper.domainToResponseDTO(m);
    }
}
