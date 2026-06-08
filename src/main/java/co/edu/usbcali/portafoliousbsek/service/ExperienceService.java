package co.edu.usbcali.portafoliousbsek.service;

import co.edu.usbcali.portafoliousbsek.dto.ExperienceRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.ExperienceResponseDTO;

import java.util.List;

public interface ExperienceService {
    List<ExperienceResponseDTO> getExperiences();
    ExperienceResponseDTO findExperienceById(Integer id);
    ExperienceResponseDTO saveExperience(ExperienceRequestDTO experience) throws Exception;
    ExperienceResponseDTO updateExperience(Integer id, ExperienceRequestDTO experience) throws Exception;
    ExperienceResponseDTO setCurrentlyWorkingFlag(Integer id, boolean currentlyWorking) throws Exception;
}
