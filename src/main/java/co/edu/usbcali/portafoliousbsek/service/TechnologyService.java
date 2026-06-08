package co.edu.usbcali.portafoliousbsek.service;

import co.edu.usbcali.portafoliousbsek.dto.TechnologyRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.TechnologyResponseDTO;

import java.util.List;

public interface TechnologyService {

    List<TechnologyResponseDTO> getTechnologies();

    String findNameTechnologyById(Integer id);

    TechnologyResponseDTO findTechnologyById(Integer id);

    TechnologyResponseDTO saveTechnology(TechnologyRequestDTO technology) throws Exception;

    TechnologyResponseDTO updateTechnology(Integer id, TechnologyRequestDTO technologyRequestDTO) throws Exception;
}
