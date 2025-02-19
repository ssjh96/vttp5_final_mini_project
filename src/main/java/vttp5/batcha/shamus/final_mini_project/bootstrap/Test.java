package vttp5.batcha.shamus.final_mini_project.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import vttp5.batcha.shamus.final_mini_project.repository.UserRepository;
import vttp5.batcha.shamus.final_mini_project.util.JwtUtil;

@Component
public class Test implements CommandLineRunner
{
    @Autowired
    private UserRepository userRepo;

    @Value("${jwt.secret.key}")
    private String secretKey;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public void run(String... args) throws Exception 
    {
        System.out.println(">>> TEST SECRET_KEY = " + secretKey);    

        System.out.println(">>> SECRET BYTE: " + jwtUtil.getSigningKey());

    }
    
}
