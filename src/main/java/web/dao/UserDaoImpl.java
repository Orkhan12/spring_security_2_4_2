package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    EntityManager em;

    public void addUser(User user) {
        em.persist(user);
    }

    public void updateUser(User user) {
        em.merge(user);
    }

    public void removeUser(int id) {
        User user = em.find(User.class, new Long(id));
        em.remove(user);
    }

    public User getUserById(int id) {
        User user = em.find(User.class, new Long(id));
        em.detach(user);
        return user;
    }

    public List<User> listUser() {
        List<User> user = em.createQuery("from User")
                .getResultList();
        return user;
    }

    @Override
    public List<Role> listRole() {
        List<Role> roles = em.createQuery("from Role").getResultList();
        return roles;
    }

    @Override
    public User getUserByUsername(String UserName) {
        User user = em.createQuery(
                "SELECT u from User u WHERE u.name = :username", User.class).
                setParameter("username", UserName).getSingleResult();
        return user;
    }

    @Override
    public Role getRoleById(Long id) {
        Role role = em.find(Role.class, new Long(id));
        em.detach(role);
        return role;
    }
}
