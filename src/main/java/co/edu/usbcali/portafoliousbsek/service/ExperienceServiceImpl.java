package co.edu.usbcali.portafoliousbsek.service;

import co.edu.usbcali.portafoliousbsek.domain.Experience;
import co.edu.usbcali.portafoliousbsek.domain.User;
import co.edu.usbcali.portafoliousbsek.dto.ExperienceRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.ExperienceResponseDTO;
import co.edu.usbcali.portafoliousbsek.mapper.ExperienceMapper;
import co.edu.usbcali.portafoliousbsek.repository.ExperienceRepository;
import co.edu.usbcali.portafoliousbsek.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {
    private final ExperienceRepository experienceRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ExperienceResponseDTO> getExperiences() {
        List<Experience> list = experienceRepository.findAll();
        return ExperienceMapper.domainListToResponseList(list);
    }

    @Override
    @Transactional(readOnly = true)
    public ExperienceResponseDTO findExperienceById(Integer id) {
        Optional<Experience> optional = experienceRepository.findById(id);
        return optional.map(ExperienceMapper::domainToResponseDTO).orElse(null);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public ExperienceResponseDTO saveExperience(ExperienceRequestDTO dto) throws Exception {
        if(dto == null) throw new Exception("La experiencia no puede ser nula.");
        if(dto.getUserId() == null) throw new Exception("El userId es obligatorio");
        if(dto.getPosition() == null || dto.getPosition().trim().isEmpty()) throw new Exception("La posición es obligatoria");
        if(dto.getCompany() == null || dto.getCompany().trim().isEmpty()) throw new Exception("La compañia es obligatoria");

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new Exception("El usuario no existe por id "+dto.getUserId()));

        Experience e = ExperienceMapper.requestToDomain(dto);
        e.setUser(user);
        e = experienceRepository.save(e);
        return ExperienceMapper.domainToResponseDTO(e);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public ExperienceResponseDTO updateExperience(Integer id, ExperienceRequestDTO dto) throws Exception {
        if(dto == null) throw new Exception("La experiencia no puede ser nula.");
        Optional<Experience> optional = experienceRepository.findById(id);
        if(optional.isEmpty()) throw new Exception("La experiencia no existe por id "+id);

        Experience e = optional.get();
        if(dto.getPosition()!=null) e.setPosition(dto.getPosition());
        if(dto.getCompany()!=null) e.setCompany(dto.getCompany());
        if(dto.getStartDate()!=null) e.setStartDate(dto.getStartDate());
        if(dto.getEndDate()!=null) e.setEndDate(dto.getEndDate());
        if(dto.getDescription()!=null) e.setDescription(dto.getDescription());
        if(dto.getCurrentlyWorking()!=null) e.setCurrentlyWorking(dto.getCurrentlyWorking());

        e = experienceRepository.save(e);
        return ExperienceMapper.domainToResponseDTO(e);
    }

    @Override
    @Transactional
    public ExperienceResponseDTO setCurrentlyWorkingFlag(Integer id, boolean currentlyWorking) throws Exception {
        Experience e = experienceRepository.findById(id)
                .orElseThrow(() -> new Exception("Experiencia no encontrada por id "+id));
        e.setCurrentlyWorking(currentlyWorking);
        e = experienceRepository.save(e);
        return ExperienceMapper.domainToResponseDTO(e);
    }
}
