package co.edu.usbcali.portafoliousbsek.service;

import co.edu.usbcali.portafoliousbsek.dto.EducationRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.EducationResponseDTO;

import java.util.List;

public interface EducationService {
    List<EducationResponseDTO> getEducation();
    EducationResponseDTO findEducationById(Integer id);
    EducationResponseDTO saveEducation(EducationRequestDTO education) throws Exception;
    EducationResponseDTO updateEducation(Integer id, EducationRequestDTO education) throws Exception;
}
