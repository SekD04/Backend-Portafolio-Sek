package co.edu.usbcali.portafoliousbsek.repository;

import co.edu.usbcali.portafoliousbsek.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
