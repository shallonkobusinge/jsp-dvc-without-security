package rca.ne.client.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rca.ne.client.enums.ERole;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Getter
@Setter
public class CreateOrUpdateUserDTO {


    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String email;
    @NotEmpty
    private String status;

    @NotEmpty
    private String username;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ERole role;
    public CreateOrUpdateUserDTO(String firstName, String lastName, String email,  String username,ERole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.role = role;
    }
}
