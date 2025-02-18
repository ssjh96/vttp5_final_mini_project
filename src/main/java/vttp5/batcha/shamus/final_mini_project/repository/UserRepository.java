package vttp5.batcha.shamus.final_mini_project.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import vttp5.batcha.shamus.final_mini_project.model.UserModel;

@Repository
public class UserRepository 
{
    @Autowired 
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public static final String SQL_REGISTER_USER = """
                                                    INSERT INTO users 
                                                        (username, password, email, role)
                                                    VALUES 
                                                        (?, ?, ?, ?)
                                                    """;

    public static final String SQL_FIND_BY_USERNAME = "SELECT * FROM users WHERE username = ?";
    public static final String SQL_FIND_BY_EMAIL = "SELECT * FROM users WHERE email = ?";

    // Register new user
    public Integer registerNewUser (UserModel user)
    {
        if(user.getRole() == null)
        {
            user.setRole("USER"); // assign default role to new user
        }

        Integer userRegister = jdbcTemplate.update(SQL_REGISTER_USER, 
                                                user.getUsername(), 
                                                passwordEncoder.encode(user.getPassword()),
                                                user.getEmail(),
                                                user.getRole()
                                                );

        return userRegister;

    }



    public Optional<UserModel> findByUsername(String username)
    {
        SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_FIND_BY_USERNAME, username);

        if(!rs.next())
        {
            return Optional.empty();
        }

        UserModel user = UserModel.toUser(rs);

        return Optional.of(user);
    }



    public Optional<UserModel> findByEmail(String email)
    {
        SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_FIND_BY_EMAIL, email);

        if(!rs.next())
        {
            return Optional.empty();
        }

        UserModel user = UserModel.toUser(rs);

        return Optional.of(user);
    }
}
