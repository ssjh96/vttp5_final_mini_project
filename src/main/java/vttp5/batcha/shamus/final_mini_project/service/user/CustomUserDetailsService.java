package vttp5.batcha.shamus.final_mini_project.service.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import vttp5.batcha.shamus.final_mini_project.model.UserModel;
import vttp5.batcha.shamus.final_mini_project.model.UserModel;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
    {
        Optional<UserModel> userOpt = userService.findByUsername(username);

        if (userOpt.isEmpty())
        {
            throw new UsernameNotFoundException("username not found: " + username);
        }

        UserModel currentUser = userOpt.get();

        return User.builder()
                    .username(currentUser.getUsername())
                    .password(currentUser.getPassword())
                    .roles(currentUser.getRole())
                    .build();
    }   

}
