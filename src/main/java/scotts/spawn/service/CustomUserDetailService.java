package scotts.spawn.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import scotts.spawn.config.CustomUserDetails;
import scotts.spawn.entitiy.UserEntity;

@Component
public class CustomUserDetailService implements UserDetailsService {

    private final UserService userService;

    public CustomUserDetailService(UserService userService) {
        this.userService = userService;
    }


    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userService.findByLogin(username);

        if (userEntity != null) {
            return CustomUserDetails.fromUserEntityToCustomUserDetails(userEntity);
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
//        return null;
    }
}
