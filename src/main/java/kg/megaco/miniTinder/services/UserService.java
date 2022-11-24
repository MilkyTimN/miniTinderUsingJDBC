package kg.megaco.miniTinder.services;

import kg.megaco.miniTinder.models.Users;

import java.util.List;

public interface UserService {

    void save(Users users);
    void update(Users users);
    List<Users> findAll();
    List<Users> findAllFemaleUsers();
    List<Users> findAllMaleUsers();
    List<Users> findAllOtherUsers();
    Users findById(Long id);
    Boolean findByLoginToCheckPresent(String login);
    Boolean findByLoginToSignIn(String login, String password);
}
