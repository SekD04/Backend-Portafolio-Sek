package co.edu.usbcali.portafoliousbsek.service;

import co.edu.usbcali.portafoliousbsek.domain.Project;
import co.edu.usbcali.portafoliousbsek.domain.ProjectImage;
import co.edu.usbcali.portafoliousbsek.dto.ProjectImageRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.ProjectImageResponseDTO;
import co.edu.usbcali.portafoliousbsek.mapper.ProjectImageMapper;
import co.edu.usbcali.portafoliousbsek.repository.ProjectImageRepository;
import co.edu.usbcali.portafoliousbsek.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectImageServiceImpl implements ProjectImageService {
    private final ProjectImageRepository projectImageRepository;
    private final ProjectRepository projectRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ProjectImageResponseDTO> getProjectImages() {
        List<ProjectImage> list = projectImageRepository.findAll();
        return ProjectImageMapper.domainListToResponseList(list);
    }

    @Override
    @Transactional(readOnly = true)
    public ProjectImageResponseDTO findProjectImageById(Integer id) {
        Optional<ProjectImage> optional = projectImageRepository.findById(id);
        return optional.map(ProjectImageMapper::domainToResponseDTO).orElse(null);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public ProjectImageResponseDTO saveProjectImage(ProjectImageRequestDTO dto) throws Exception {
        if(dto == null) throw new Exception("La imagen del proyecto no puede ser nula.");
        if(dto.getProjectId() == null) throw new Exception("El projectId es obligatorio");
        if(dto.getImageUrl() == null || dto.getImageUrl().trim().isEmpty()) throw new Exception("La URL de la imagen es obligatoria");

        Project project = projectRepository.findById(dto.getProjectId())
                .orElseThrow(() -> new Exception("El proyecto no existe por id "+dto.getProjectId()));

        ProjectImage e = ProjectImageMapper.requestToDomain(dto);
        e.setProject(project);
        e = projectImageRepository.save(e);
        return ProjectImageMapper.domainToResponseDTO(e);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public ProjectImageResponseDTO updateProjectImage(Integer id, ProjectImageRequestDTO dto) throws Exception {
        if(dto == null) throw new Exception("La imagen del proyecto no puede ser nula.");
        Optional<ProjectImage> optional = projectImageRepository.findById(id);
        if(optional.isEmpty()) throw new Exception("La imagen del proyecto no existe por id "+id);

        ProjectImage e = optional.get();
        if(dto.getImageUrl()!=null) e.setImageUrl(dto.getImageUrl());
        if(dto.getCaption()!=null) e.setCaption(dto.getCaption());

        e = projectImageRepository.save(e);
        return ProjectImageMapper.domainToResponseDTO(e);
    }
}
