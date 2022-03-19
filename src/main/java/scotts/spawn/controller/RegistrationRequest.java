package scotts.spawn.controller;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class RegistrationRequest {

    @NotNull
    private String login;

    @NotNull
    private String password;

}
