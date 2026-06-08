package co.edu.usbcali.portafoliousbsek.service;

import co.edu.usbcali.portafoliousbsek.dto.ProjectImageRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.ProjectImageResponseDTO;

import java.util.List;

public interface ProjectImageService {
    List<ProjectImageResponseDTO> getProjectImages();
    ProjectImageResponseDTO findProjectImageById(Integer id);
    ProjectImageResponseDTO saveProjectImage(ProjectImageRequestDTO requestDTO) throws Exception;
    ProjectImageResponseDTO updateProjectImage(Integer id, ProjectImageRequestDTO requestDTO) throws Exception;
}
