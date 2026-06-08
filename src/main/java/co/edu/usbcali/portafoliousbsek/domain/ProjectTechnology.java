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
@Table(name = "project_technologies")
@Data
public class ProjectTechnology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_tech_id")
    private Integer projectTechnologyId;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false, referencedColumnName = "project_id")
    private Project project;


    @ManyToOne
    @JoinColumn(name = "tech_id", nullable = false, referencedColumnName = "tech_id")
    private Technology technology;


}
