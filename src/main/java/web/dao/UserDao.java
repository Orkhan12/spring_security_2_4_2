package web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import web.model.Role;
import web.model.User;

import java.util.List;

public interface UserDao  {
    void addUser(User user);

    void updateUser(User user);

    void removeUser(int id);

    User getUserById(int id);

    List<User> listUser();

    List<Role> listRole();

    Role getRoleById(Long id);

    User getUserByUsername(String UserName);
}