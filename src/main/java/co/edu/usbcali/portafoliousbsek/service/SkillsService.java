package co.edu.usbcali.portafoliousbsek.service;

import co.edu.usbcali.portafoliousbsek.dto.SkillRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.SkillResponseDTO;

import java.util.List;

public interface SkillsService {
    List<SkillResponseDTO> getSkills();
    SkillResponseDTO findSkillById(Integer id);
    SkillResponseDTO saveSkill(SkillRequestDTO skill) throws Exception;
    SkillResponseDTO updateSkill(Integer id, SkillRequestDTO skill) throws Exception;
    SkillResponseDTO setTechnicalFlag(Integer id, boolean isTechnical) throws Exception;
}
