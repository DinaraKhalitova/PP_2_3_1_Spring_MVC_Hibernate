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
        user.setId(id);
        em.merge(user);
    }

    @Override
    public void deleteById(long id) {
        em.remove(em.getReference(User.class, id));

    }

//    @Override
//    public List<User> findAll() {
//
//        return em.createQuery("from User", User.class).getResultList();
//    }
//
//    @Override
//    public void saveUser(User user) {
//        em.persist(user);
//    }
//
//    @Override
//    public User getUser(long id) {
//        return em.find(User.class,id);
//    }
//
//    @Override
//    public User updateUser(User user) {
//        return em.merge(user);
//    }
//
//    @Override
//    public void deleteById(int id) {
//        em.remove(em.getReference(User.class, id));
//    }
}
