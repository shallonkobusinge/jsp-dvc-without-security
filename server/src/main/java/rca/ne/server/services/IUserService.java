package rca.ne.server.services;

import rca.ne.server.dtos.CreateOrUpdateUserDTO;
import rca.ne.server.models.User;

import java.util.List;

public interface IUserService {
    User findById(Long id);
    User save(CreateOrUpdateUserDTO user);
    User update(CreateOrUpdateUserDTO user, Long id);
    User remove(Long id);
    List<User> findAll();

}
