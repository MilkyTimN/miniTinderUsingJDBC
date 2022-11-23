package kg.megaco.miniTinder.models;

import kg.megaco.miniTinder.models.enums.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Users {
    private Long id;
    private String name;
    private String login;
    private String password;
    private Integer age;
    private String info;
    private Gender gender;

    public Users(String name, String login, String password, Integer age, String info, Gender gender) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.age = age;
        this.info = info;
        this.gender = gender;
    }
}
