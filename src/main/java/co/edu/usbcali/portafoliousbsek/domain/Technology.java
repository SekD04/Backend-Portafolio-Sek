package co.edu.usbcali.portafoliousbsek.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "technologies")
@Data
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tech_id")
    private Integer techId;

    @Column(nullable = false, unique = true, name = "name")
    private String name;

    @Column(name = "logo_url")
    private String logoUrl;

}
