package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {

    public List<User> findAll();
    public void saveUser(User user);
    User getUser(long id);
    public User updateUser(User user);
    public void deleteById(int id);

}
