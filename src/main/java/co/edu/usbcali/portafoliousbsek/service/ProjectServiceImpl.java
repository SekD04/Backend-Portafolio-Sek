package co.edu.usbcali.portafoliousbsek.service;

import co.edu.usbcali.portafoliousbsek.domain.Project;
import co.edu.usbcali.portafoliousbsek.domain.User;
import co.edu.usbcali.portafoliousbsek.dto.ProjectRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.ProjectResponseDTO;
import co.edu.usbcali.portafoliousbsek.mapper.ProjectMapper;
import co.edu.usbcali.portafoliousbsek.repository.ProjectRepository;
import co.edu.usbcali.portafoliousbsek.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ProjectResponseDTO> getProjects() {
        List<Project> list = projectRepository.findAll();
        return ProjectMapper.domainListToResponseList(list);
    }

    @Override
    @Transactional(readOnly = true)
    public ProjectResponseDTO findProjectById(Integer id) {
        Optional<Project> optional = projectRepository.findById(id);
        return optional.map(ProjectMapper::domainToResponseDTO).orElse(null);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public ProjectResponseDTO saveProject(ProjectRequestDTO dto) throws Exception {
        if(dto == null) throw new Exception("El proyecto no puede ser nulo.");
        if(dto.getUserId() == null) throw new Exception("El userId es obligatorio");
        if(dto.getTitle() == null || dto.getTitle().trim().isEmpty()) throw new Exception("El título es obligatorio");

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new Exception("El usuario no existe por id "+dto.getUserId()));

        Project p = ProjectMapper.requestToDomain(dto);
        p.setUser(user);
        p = projectRepository.save(p);
        return ProjectMapper.domainToResponseDTO(p);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public ProjectResponseDTO updateProject(Integer id, ProjectRequestDTO dto) throws Exception {
        if(dto == null) throw new Exception("El proyecto no puede ser nulo.");
        Optional<Project> optional = projectRepository.findById(id);
        if(optional.isEmpty()) throw new Exception("El proyecto no existe por id "+id);

        Project p = optional.get();
        if(dto.getTitle()!=null) p.setTitle(dto.getTitle());
        if(dto.getDescription()!=null) p.setDescription(dto.getDescription());
        if(dto.getPrimaryImage()!=null) p.setPrimaryImage(dto.getPrimaryImage());
        if(dto.getDemoUrl()!=null) p.setDemoUrl(dto.getDemoUrl());
        if(dto.getRepoUrl()!=null) p.setRepoUrl(dto.getRepoUrl());
        if(dto.getDateCompleted()!=null) p.setDateCompleted(dto.getDateCompleted());
        if(dto.getCategory()!=null) p.setCategory(dto.getCategory());
        if(dto.getVisible()!=null) p.setVisible(dto.getVisible());

        p = projectRepository.save(p);
        return ProjectMapper.domainToResponseDTO(p);
    }

    @Override
    @Transactional
    public ProjectResponseDTO setVisibleFlag(Integer id, boolean visible) throws Exception {
        Project p = projectRepository.findById(id)
                .orElseThrow(() -> new Exception("Proyecto no encontrado por id "+id));
        p.setVisible(visible);
        p = projectRepository.save(p);
        return ProjectMapper.domainToResponseDTO(p);
    }
}
