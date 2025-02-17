package vttp5.batcha.shamus.final_mini_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import vttp5.batcha.shamus.final_mini_project.service.user.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig 
{
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        // Customisation
        // For each request, if the requests is "/" or any url after /users/, or any url after /images/, leave unauthenticated by permitall()
        http.authorizeHttpRequests(request -> request.requestMatchers("/", "/users/**", "/images/**").permitAll()

        // For any other request, authenticate to ensures all other endpoints are secured.
        .anyRequest().authenticated())

        // specified login page url. All users need to be able to acess login page, permitAll()
        .formLogin(form -> form.loginPage("/users/login")
        .defaultSuccessUrl("/app/home") // change app name to app name
        .failureUrl("/users/login?error=true")
        .permitAll())

        // specified logout page url, successful logout url, invalidate http session upon logout, permitAll() users to logout
        .logout(logout -> logout.logoutUrl("/users/logout")
        .logoutSuccessUrl("/")
        .invalidateHttpSession(true)
        .deleteCookies("JSESSIONID")
        .permitAll());

        return http.build();        
    }    

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService()
    {
        return new CustomUserDetailsService();
    }

    @Bean
    public AuthenticationManager authenticationManager()
    {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return new ProviderManager(authenticationProvider);
    }
}
