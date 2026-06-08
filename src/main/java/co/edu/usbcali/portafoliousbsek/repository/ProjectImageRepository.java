package co.edu.usbcali.portafoliousbsek.repository;

import co.edu.usbcali.portafoliousbsek.domain.ProjectImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectImageRepository extends JpaRepository<ProjectImage, Integer> {
}
