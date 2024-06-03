package web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);

    }

    @Override
    @Transactional
    public Object getUser(long id) {
        return userDao.getUser(id);
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        userDao.deleteById(id);
    }
}
