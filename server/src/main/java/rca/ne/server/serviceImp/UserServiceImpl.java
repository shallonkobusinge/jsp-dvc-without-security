package rca.ne.server.serviceImp;

import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import rca.ne.server.dtos.CreateOrUpdateUserDTO;
import rca.ne.server.models.User;
import rca.ne.server.repository.IUserRepository;
import rca.ne.server.services.IUserService;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceAccessException("User with id " + id.toString() + " not found"));
    }

    @Override
    public User save(CreateOrUpdateUserDTO user) {
        return userRepository.save(new User(user));
    }

    @Override
    public User update(CreateOrUpdateUserDTO user, Long id) {
        User existingUser = findById(id);
        existingUser.setUsername(user.getUsername());
        existingUser.setEmail(user.getEmail());
        existingUser.setLastName(user.getLastName());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setRole(user.getRole());
        existingUser.setStatus(user.getStatus());
        return userRepository.save(existingUser);
    }


    @Override
    public User remove(Long id) {
        User existingUser = findById(id);
        userRepository.delete(existingUser);
        return existingUser;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }


}
