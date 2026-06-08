package co.edu.usbcali.portafoliousbsek.repository;

import co.edu.usbcali.portafoliousbsek.domain.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessagesRepository extends JpaRepository<Messages, Integer> {
}
