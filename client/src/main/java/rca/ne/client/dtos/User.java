package rca.ne.client.dtos;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rca.ne.client.enums.ERole;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;

    private ERole role;
    public User(CreateOrUpdateUserDTO dto){
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.username = dto.getUsername();
        this.email = dto.getEmail();
        this.role = dto.getRole();
    }
}
