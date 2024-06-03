package web.Service;

import web.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void saveUser(User user);

    User getUser(long id);

    void updateUser(long id,User user);

    void deleteById(long id);

}
