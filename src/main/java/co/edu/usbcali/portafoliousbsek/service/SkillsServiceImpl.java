package co.edu.usbcali.portafoliousbsek.service;

import co.edu.usbcali.portafoliousbsek.domain.Skills;
import co.edu.usbcali.portafoliousbsek.domain.User;
import co.edu.usbcali.portafoliousbsek.dto.SkillRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.SkillResponseDTO;
import co.edu.usbcali.portafoliousbsek.mapper.SkillMapper;
import co.edu.usbcali.portafoliousbsek.repository.SkillsRepository;
import co.edu.usbcali.portafoliousbsek.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SkillsServiceImpl implements SkillsService {
    private final SkillsRepository skillsRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<SkillResponseDTO> getSkills() {
        List<Skills> list = skillsRepository.findAll();
        return SkillMapper.domainListToResponseList(list);
    }

    @Override
    @Transactional(readOnly = true)
    public SkillResponseDTO findSkillById(Integer id) {
        Optional<Skills> optional = skillsRepository.findById(id);
        return optional.map(SkillMapper::domainToResponseDTO).orElse(null);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public SkillResponseDTO saveSkill(SkillRequestDTO dto) throws Exception {
        if(dto == null) throw new Exception("La skill no puede ser nula.");
        if(dto.getUserId() == null) throw new Exception("El userId es obligatorio");
        if(dto.getName() == null || dto.getName().trim().isEmpty()) throw new Exception("El nombre es obligatorio");

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new Exception("El usuario no existe por id "+dto.getUserId()));

        Skills e = SkillMapper.requestToDomain(dto);
        e.setUser(user);
        e = skillsRepository.save(e);
        return SkillMapper.domainToResponseDTO(e);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public SkillResponseDTO updateSkill(Integer id, SkillRequestDTO dto) throws Exception {
        if(dto == null) throw new Exception("La skill no puede ser nula.");
        Optional<Skills> optional = skillsRepository.findById(id);
        if(optional.isEmpty()) throw new Exception("La skill no existe por id "+id);

        Skills e = optional.get();
        if(dto.getName()!=null) e.setName(dto.getName());
        if(dto.getLevel()!=null) e.setLevel(dto.getLevel());
        if(dto.getIsTechnical()!=null) e.setIsTechnical(dto.getIsTechnical());

        e = skillsRepository.save(e);
        return SkillMapper.domainToResponseDTO(e);
    }

    @Override
    @Transactional
    public SkillResponseDTO setTechnicalFlag(Integer id, boolean isTechnical) throws Exception {
        Skills e = skillsRepository.findById(id)
                .orElseThrow(() -> new Exception("Skill no encontrada por id "+id));
        e.setIsTechnical(isTechnical);
        e = skillsRepository.save(e);
        return SkillMapper.domainToResponseDTO(e);
    }
}
