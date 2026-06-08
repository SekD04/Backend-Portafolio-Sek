package co.edu.usbcali.portafoliousbsek.repository;

import co.edu.usbcali.portafoliousbsek.domain.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Integer> {
}
