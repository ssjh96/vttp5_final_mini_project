package vttp5.batcha.shamus.final_mini_project.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService 
{
    @Autowired
    private JdbcTemplate jdbcTemplate;
}
