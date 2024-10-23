package project.dao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.entity.User;
import java.util.List;
@Transactional
@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userDao) {
        this.userRepository = userDao;
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public User getUser(int id) {
        return userRepository.getUser(id);
    }

    public void createUser(User user) {
        userRepository.createUser(user);
    }

    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    public void deleteUser(User user) {
        userRepository.deleteUser(user);
    }
}
