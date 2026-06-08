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
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, unique = true, name = "email")
    private String email;

    @Column(name = "profile_photo")
    private String profilePhoto;

    @Column(name = "bio")
    private String bio;

    @Column(name = "location")
    private String location;

    @Column(name = "profession")
    private String profession;

    @Column(name = "pitch")
    private String pitch;

    @Column(name = "phone")
    private String phone;

    @Column(name = "visit_count")
    private Integer visitCount;

    @Column(name = "cv_url")
    private String cvUrl;

    @Column(length= 20, nullable = false, unique = true, name = "password")
    private String password;

}
