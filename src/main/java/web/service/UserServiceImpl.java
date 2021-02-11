package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }
    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
    @Transactional
    public void removeUser(int id) {
        userDao.removeUser(id);
    }
    @Transactional
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }
    @Transactional
    public List<User> listUser() {
        return userDao.listUser();
    }
}
