package rca.ne.server.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rca.ne.server.dtos.CreateOrUpdateUserDTO;
import rca.ne.server.enums.ERole;

import javax.persistence.*;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String status;

    @Enumerated(EnumType.STRING)
    private ERole role;

    public User(CreateOrUpdateUserDTO user) {
        this.email = user.getEmail();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.status = user.getStatus();
        this.role = user.getRole();
        this.username = user.getUsername();

    }
}
