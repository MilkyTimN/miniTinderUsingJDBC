package kg.megaco.miniTinder.services;

import kg.megaco.miniTinder.models.Users;

import java.util.List;

public interface UserService {

    void save(Users users);
    void update(Users users);
    List<Users> findAll();
    Users findById(Long id);
    void delete(Long id);
}
