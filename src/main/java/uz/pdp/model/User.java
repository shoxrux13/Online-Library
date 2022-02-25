package uz.pdp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class User {
    private Integer id;
    private String fullName;
    private String userName;
    private String password;

    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }
}
