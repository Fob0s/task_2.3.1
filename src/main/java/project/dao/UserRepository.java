package project.dao;

import jakarta.persistence.*;
import org.springframework.stereotype.Repository;
import project.entity.User;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from  User u", User.class).getResultList();
    }

    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    public void createUser(User newUser) {
        entityManager.persist(newUser);
    }

    public void updateUser(User user) {
        User updateUser = entityManager.find(User.class, user.getId());
        updateUser.setName(user.getName());
        updateUser.setAge(user.getAge());
        updateUser.setEmail(user.getEmail());
        entityManager.merge(updateUser);
    }

    public void deleteUser(User user) {

        User deleteUser = entityManager.find(User.class, user.getId());
        entityManager.remove(deleteUser);
    }
}
