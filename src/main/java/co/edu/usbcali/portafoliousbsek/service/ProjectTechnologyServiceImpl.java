package co.edu.usbcali.portafoliousbsek.service;

import co.edu.usbcali.portafoliousbsek.domain.Project;
import co.edu.usbcali.portafoliousbsek.domain.ProjectTechnology;
import co.edu.usbcali.portafoliousbsek.domain.Technology;
import co.edu.usbcali.portafoliousbsek.dto.ProjectTechnologyRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.ProjectTechnologyResponseDTO;
import co.edu.usbcali.portafoliousbsek.mapper.ProjectTechnologyMapper;
import co.edu.usbcali.portafoliousbsek.repository.ProjectRepository;
import co.edu.usbcali.portafoliousbsek.repository.ProjectTechnologyRepository;
import co.edu.usbcali.portafoliousbsek.repository.TechnologyRepository;
import co.edu.usbcali.portafoliousbsek.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectTechnologyServiceImpl implements ProjectTechnologyService {
    private final ProjectTechnologyRepository projectTechnologyRepository;
    private final ProjectRepository projectRepository;
    private final TechnologyRepository technologyRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ProjectTechnologyResponseDTO> findAll() {
        List<ProjectTechnology> projectTechnologies = projectTechnologyRepository.findAll();
        return ProjectTechnologyMapper.domainToResponseDTO(projectTechnologies);
    }

    @Override
    @Transactional(readOnly = true)
    public ProjectTechnologyResponseDTO findProjectTechnologyById(Integer id) {
        Optional<ProjectTechnology> optional = projectTechnologyRepository.findById(id);
        return optional.map(ProjectTechnologyMapper::domainToResponseDTO).orElse(null);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public ProjectTechnologyResponseDTO saveProjectTechnology(ProjectTechnologyRequestDTO projectTechnology) throws Exception {
        if (projectTechnology == null) {
            throw new Exception("La tecnologia del proyecto no puede ser nula");
        }
        if (projectTechnology.getProjectId() == null) {
            throw new Exception("El projectId es obligatorio");
        }
        if (projectTechnology.getTechnologyId() == null) {
            throw new Exception("El technologyId es obligatorio");
        }

        Project project = projectRepository.findById(projectTechnology.getProjectId())
                .orElseThrow(() -> new Exception("No existe el Proyecto por id " + projectTechnology.getProjectId()));
        Technology technology = technologyRepository.findById(projectTechnology.getTechnologyId())
                .orElseThrow(() -> new Exception("No existe la Tecnologia por id " + projectTechnology.getTechnologyId()));

        ProjectTechnology entity = ProjectTechnology.builder()
                .project(project)
                .technology(technology)
                .build();

        entity = projectTechnologyRepository.save(entity);
        return ProjectTechnologyMapper.domainToResponseDTO(entity);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public ProjectTechnologyResponseDTO updateProjectTechnology(Integer id, ProjectTechnologyRequestDTO dto) throws Exception {
        if (dto == null) throw new Exception("La tecnologia del proyecto no puede ser nula");
        Optional<ProjectTechnology> optional = projectTechnologyRepository.findById(id);
        if (optional.isEmpty()) throw new Exception("La tecnologia del proyecto no existe por id " + id);

        ProjectTechnology entity = optional.get();

        if (dto.getProjectId() != null) {
            Project project = projectRepository.findById(dto.getProjectId())
                    .orElseThrow(() -> new Exception("No existe el Proyecto por id " + dto.getProjectId()));
            entity.setProject(project);
        }
        if (dto.getTechnologyId() != null) {
            Technology technology = technologyRepository.findById(dto.getTechnologyId())
                    .orElseThrow(() -> new Exception("No existe la Tecnologia por id " + dto.getTechnologyId()));
            entity.setTechnology(technology);
        }

        entity = projectTechnologyRepository.save(entity);
        return ProjectTechnologyMapper.domainToResponseDTO(entity);
    }

}
