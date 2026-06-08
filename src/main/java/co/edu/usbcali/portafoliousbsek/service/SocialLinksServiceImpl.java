package co.edu.usbcali.portafoliousbsek.service;

import co.edu.usbcali.portafoliousbsek.domain.SocialLinks;
import co.edu.usbcali.portafoliousbsek.domain.User;
import co.edu.usbcali.portafoliousbsek.dto.SocialLinkRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.SocialLinkResponseDTO;
import co.edu.usbcali.portafoliousbsek.mapper.SocialLinkMapper;
import co.edu.usbcali.portafoliousbsek.repository.SocialLinksRepository;
import co.edu.usbcali.portafoliousbsek.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SocialLinksServiceImpl implements SocialLinksService {
    private final SocialLinksRepository socialLinksRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<SocialLinkResponseDTO> getSocialLinks() {
        List<SocialLinks> list = socialLinksRepository.findAll();
        return SocialLinkMapper.domainListToResponseList(list);
    }

    @Override
    @Transactional(readOnly = true)
    public SocialLinkResponseDTO findSocialLinkById(Integer id) {
        Optional<SocialLinks> optional = socialLinksRepository.findById(id);
        return optional.map(SocialLinkMapper::domainToResponseDTO).orElse(null);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public SocialLinkResponseDTO saveSocialLink(SocialLinkRequestDTO dto) throws Exception {
        if(dto == null) throw new Exception("El social link no puede ser nulo.");
        if(dto.getUserId() == null) throw new Exception("El userId es obligatorio");
        if(dto.getUrl() == null || dto.getUrl().trim().isEmpty()) throw new Exception("La URL es obligatoria");

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new Exception("El usuario no existe por id "+dto.getUserId()));

        SocialLinks e = SocialLinkMapper.requestToDomain(dto);
        e.setUser(user);
        e = socialLinksRepository.save(e);
        return SocialLinkMapper.domainToResponseDTO(e);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public SocialLinkResponseDTO updateSocialLink(Integer id, SocialLinkRequestDTO dto) throws Exception {
        if(dto == null) throw new Exception("El social link no puede ser nulo.");
        Optional<SocialLinks> optional = socialLinksRepository.findById(id);
        if(optional.isEmpty()) throw new Exception("El social link no existe por id "+id);

        SocialLinks e = optional.get();
        if(dto.getName()!=null) e.setName(dto.getName());
        if(dto.getUrl()!=null) e.setUrl(dto.getUrl());
        if(dto.getIconClass()!=null) e.setIconClass(dto.getIconClass());

        e = socialLinksRepository.save(e);
        return SocialLinkMapper.domainToResponseDTO(e);
    }
}
