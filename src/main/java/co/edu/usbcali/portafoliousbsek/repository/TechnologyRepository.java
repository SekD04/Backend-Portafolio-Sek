package co.edu.usbcali.portafoliousbsek.repository;

import co.edu.usbcali.portafoliousbsek.domain.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology, Integer> {
}
