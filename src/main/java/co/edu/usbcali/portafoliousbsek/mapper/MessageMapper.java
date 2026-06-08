package co.edu.usbcali.portafoliousbsek.mapper;

import co.edu.usbcali.portafoliousbsek.domain.Messages;
import co.edu.usbcali.portafoliousbsek.dto.MessageRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.MessageResponseDTO;

import java.util.List;

public class MessageMapper {
    public static MessageResponseDTO domainToResponseDTO(Messages domain){
        MessageResponseDTO response = MessageResponseDTO.builder()
                .messageId(domain.getMessageId())
                .senderName(domain.getSenderName())
                .senderEmail(domain.getSenderEmail())
                .content(domain.getContent())
                .isRead(domain.getIsRead())
                .receivedAt(domain.getReceivedAt())
                .build();
        return response;
    }

    public static List<MessageResponseDTO> domainListToResponseList(List<Messages> list){
        return list.stream().map(MessageMapper::domainToResponseDTO).toList();
    }

    public static Messages requestToDomain(MessageRequestDTO dto){
        Messages m = Messages.builder()
                .senderName(dto.getSenderName())
                .senderEmail(dto.getSenderEmail())
                .content(dto.getContent())
                .isRead(dto.getIsRead())
                .receivedAt(dto.getReceivedAt())
                .build();
        return m;
    }
}
