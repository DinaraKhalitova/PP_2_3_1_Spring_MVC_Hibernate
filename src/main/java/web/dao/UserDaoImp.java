package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Component
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    @SuppressWarnings("unchecked")
    public List<User> findAll() {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        em.persist(user);

    }

    @Override
    public User getUser(long id) {
        return em.find(User.class, id);
    }

    @Override
    public void updateUser(long id, User user) {
        User updateUser = em.find(User.class, id);
        updateUser.setName(user.getName());
        updateUser.setSurname(user.getSurname());
        updateUser.setEmail(user.getEmail());
    }

    @Override
    public void deleteById(long id) {
        User removeUser = em.find(User.class, id);
        em.remove(removeUser);
    }
}
