package co.edu.usbcali.portafoliousbsek.service;

import co.edu.usbcali.portafoliousbsek.dto.ProjectTechnologyRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.ProjectTechnologyResponseDTO;

import java.util.List;

public interface ProjectTechnologyService {
    List<ProjectTechnologyResponseDTO> findAll();
    ProjectTechnologyResponseDTO findProjectTechnologyById(Integer id);
    ProjectTechnologyResponseDTO saveProjectTechnology(ProjectTechnologyRequestDTO projectTechnology) throws Exception;
    ProjectTechnologyResponseDTO updateProjectTechnology(Integer id, ProjectTechnologyRequestDTO projectTechnology) throws Exception;
}
