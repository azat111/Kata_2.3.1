package web.dao;

import org.springframework.stereotype.Component;
import web.models.User;

import java.util.List;

@Component
public interface UserDAO {
    List<User> index();

    void save(User user);

    void delete(int id);

    User findById(int id);

    void update(User user);
}
