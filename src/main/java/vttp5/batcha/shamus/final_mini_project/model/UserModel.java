package vttp5.batcha.shamus.final_mini_project.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserModel 
{
    private Integer id;

    @NotBlank(message = "Username must not be blank.")
    @Size(min = 6, max = 32, message = "Username must be 6-32 characters long.")
    private String username;

    @NotBlank(message = "Password must not be blank.")
    // @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*]).{8,20}$", message = "Password must be 8-20 characters containing uppercase(s), lowercase(s), number(s), and special character(s).")
    @Size(min = 8, message = "Password must be at least 8 characters long.")
    private String password;    

    @NotBlank(message = "Email field must not be blank.")
    @Email(message = "Please enter a valid email.")
    private String email;

    private String role;
    private Date created_at;
    
    public UserModel() {
    }

    public UserModel(Integer id, String username, String password, String email, String role, Date created_at) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.created_at = created_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }



    public static UserModel toUser(SqlRowSet rs)
    {
        
        UserModel user = new UserModel();

        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setEmail(rs.getString("email"));
        user.setRole(rs.getString("role"));
        // user.setCreated_at(rs.getDate("null") // timestamp format YYYY-MM-DD HH:MM:SS
        user.setCreated_at(rs.getTimestamp("created_at"));

        return user;
    }


    
    public String getFormattedCreatedAt() 
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(created_at);
    }
    
}
