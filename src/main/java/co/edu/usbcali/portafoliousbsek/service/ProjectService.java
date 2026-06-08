package co.edu.usbcali.portafoliousbsek.service;

import co.edu.usbcali.portafoliousbsek.dto.ProjectRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.ProjectResponseDTO;

import java.util.List;

public interface ProjectService {
    List<ProjectResponseDTO> getProjects();
    ProjectResponseDTO findProjectById(Integer id);
    ProjectResponseDTO saveProject(ProjectRequestDTO project) throws Exception;
    ProjectResponseDTO updateProject(Integer id, ProjectRequestDTO project) throws Exception;
    ProjectResponseDTO setVisibleFlag(Integer id, boolean visible) throws Exception;
}
