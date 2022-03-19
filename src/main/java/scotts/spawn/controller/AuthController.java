package scotts.spawn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import scotts.spawn.config.jwt.JwtProvider;
import scotts.spawn.entitiy.UserEntity;
import scotts.spawn.service.UserService;

@CrossOrigin(maxAge = 3600)
@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider jwtProvider;

    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public String registerUser(@RequestBody @Validated RegistrationRequest registrationRequest) {
        UserEntity u = new UserEntity();
        u.setPassword(registrationRequest.getPassword());
        u.setLogin(registrationRequest.getLogin());
        userService.saveUser(u);
        return "OK";

    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) throws Exception {

        try {

//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getLogin(),request.getPassword()));


            UserEntity userEntity = userService.findByLoginAndPassword(request.getLogin(), request.getPassword());

            if (userEntity != null) {
                String token = jwtProvider.generateToken(userEntity.getLogin());
                return new AuthResponse(token);
            } else {

                throw new Exception("invalid credential");
            }

        } catch (Exception e) {
            throw new Exception("invalid credential", e);
        }


//            String token =jwtProvider.generateToken(request.getLogin());
//            return new AuthResponse(token);


    }


}
