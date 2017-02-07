package accounts;

/**
 * Created by moonserk on 15.12.16.
 */
public class UserProfile {

    private String login;
    private String password;
    private String email;

    public UserProfile(String login, String password, String email){
        this.login = login;
        this.password = password;
        this.email = email;
    }

     public UserProfile(String login, String password){
        this.login = login;
        this.password = password;
        this.email = login;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
