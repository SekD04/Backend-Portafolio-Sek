package co.edu.usbcali.portafoliousbsek.service;

import co.edu.usbcali.portafoliousbsek.domain.Technology;
import co.edu.usbcali.portafoliousbsek.dto.TechnologyRequestDTO;
import co.edu.usbcali.portafoliousbsek.dto.TechnologyResponseDTO;
import co.edu.usbcali.portafoliousbsek.mapper.TechnologyMapper;
import co.edu.usbcali.portafoliousbsek.repository.TechnologyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TechnologyServiceImpl implements TechnologyService {

    private final TechnologyRepository technologyRepository;

    @Override
    @Transactional(readOnly = true)
    public List<TechnologyResponseDTO> getTechnologies() {
        List<Technology> technologies = technologyRepository.findAll();
        List<TechnologyResponseDTO> responseDTOs = TechnologyMapper.domainListToTechnologyResponseDTOList(technologies);
        return responseDTOs;
    }

    @Override
    @Transactional(readOnly = true)
    public String findNameTechnologyById(Integer id) {
        Optional<Technology> technologyOptional = technologyRepository.findById(id);
        if(technologyOptional.isPresent()){
            return technologyOptional.get().getName();
        }
        return "Not found";
    }

    @Override
    @Transactional(readOnly = true)
    public TechnologyResponseDTO findTechnologyById(Integer id) {
        //Technology technology = technologyRepository.getReferenceById(id);
        Optional<Technology> technologyOptional = technologyRepository.findById(id);
        if(technologyOptional.isPresent()){
            TechnologyResponseDTO response = TechnologyMapper
                    .domainToTechnologyResponseDTO(technologyOptional.get());
            return response;
        }
        return null;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public TechnologyResponseDTO saveTechnology(TechnologyRequestDTO technologyRequestDTO) throws Exception {

        if (technologyRequestDTO == null) {
            throw new Exception("La technologia no puede ser nula.");
        }

        if (technologyRequestDTO.getName() == null ||
                technologyRequestDTO.getName().trim().isEmpty()){
            throw new Exception("El nombre de la tecnologia debe contener informacion");
        }

        //Validar los otros campos
        //Convertir hacia el objeto de dominio
        Technology technology = TechnologyMapper.technologyRequestDTOtoDomain(technologyRequestDTO);

        // Persistir en base datos y obtener la informacion del Technology con el ID desde DB
        technology =technologyRepository.save(technology);

        //Convertir a ResponseDTO
        TechnologyResponseDTO response = TechnologyMapper.domainToTechnologyResponseDTO(technology);

        return response;
    }

    @Override
    public TechnologyResponseDTO updateTechnology(Integer id, TechnologyRequestDTO technologyRequestDTO) throws Exception {
        if (id == null || id == 0) {
            throw new Exception("El id no puede ser nulo ni cero.");
        }

        if (technologyRequestDTO == null) {
            throw new Exception("La technologia no puede ser nulo.");
        }
        if (technologyRequestDTO.getName() == null ||
                technologyRequestDTO.getName().trim().isEmpty()){
            throw new Exception("El nombre de no puede ser nulo ni vacio.");
        }

        if(technologyRepository.existsById(id)){
            Technology technology = technologyRepository.findById(id).get();
            technology.setName(technologyRequestDTO.getName());
            technology.setLogoUrl(technologyRequestDTO.getUrl());
            technology = technologyRepository.save(technology);
            TechnologyResponseDTO responseDTO = TechnologyMapper.domainToTechnologyResponseDTO(technology);
            return responseDTO;
        } else{
            throw new Exception("No existe la tecnologia por id "+id);
        }
    }
}
