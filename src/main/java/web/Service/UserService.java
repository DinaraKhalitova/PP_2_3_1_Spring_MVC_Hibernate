package web.Service;

import web.model.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();
    public void saveUser(User user);
    Object getUser(long id);
    public User updateUser(User user);
    public void deleteById(int id);

}
