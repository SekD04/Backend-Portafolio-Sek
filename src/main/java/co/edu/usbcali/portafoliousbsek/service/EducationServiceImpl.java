package co.edu.usbcali.portafoliousbsek.service;

import co.edu.usbcali.portafoliousbsek.domain.Education;
import co.edu.usbcali.portafoliousbsek.domain.User;
import co.edu.usbcali.portafoliousbsek.dto.EducationRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.EducationResponseDTO;
import co.edu.usbcali.portafoliousbsek.mapper.EducationMapper;
import co.edu.usbcali.portafoliousbsek.repository.EducationRepository;
import co.edu.usbcali.portafoliousbsek.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements EducationService {
    private final EducationRepository educationRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<EducationResponseDTO> getEducation() {
        List<Education> list = educationRepository.findAll();
        return EducationMapper.domainListToResponseList(list);
    }

    @Override
    @Transactional(readOnly = true)
    public EducationResponseDTO findEducationById(Integer id) {
        Optional<Education> optional = educationRepository.findById(id);
        return optional.map(EducationMapper::domainToResponseDTO).orElse(null);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public EducationResponseDTO saveEducation(EducationRequestDTO dto) throws Exception {
        if(dto == null) throw new Exception("La education no puede ser nula.");
        if(dto.getUserId() == null) throw new Exception("El userId es obligatorio");

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new Exception("El usuario no existe por id "+dto.getUserId()));

        Education e = EducationMapper.requestToDomain(dto);
        e.setUser(user);
        e = educationRepository.save(e);
        return EducationMapper.domainToResponseDTO(e);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public EducationResponseDTO updateEducation(Integer id, EducationRequestDTO dto) throws Exception {
        if(dto == null) throw new Exception("La education no puede ser nula.");
        Optional<Education> optional = educationRepository.findById(id);
        if(optional.isEmpty()) throw new Exception("La education no existe por id "+id);

        Education e = optional.get();
        if(dto.getDegree()!=null) e.setDegree(dto.getDegree());
        if(dto.getInstitution()!=null) e.setInstitution(dto.getInstitution());
        if(dto.getStartDate()!=null) e.setStartDate(dto.getStartDate());
        if(dto.getEndDate()!=null) e.setEndDate(dto.getEndDate());
        if(dto.getDescription()!=null) e.setDescription(dto.getDescription());

        e = educationRepository.save(e);
        return EducationMapper.domainToResponseDTO(e);
    }
}
