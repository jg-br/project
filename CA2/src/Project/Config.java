package Project;
import java.util.prefs.Preferences;

public class Config 
{
	private String username;
    private  String password;

    Preferences preferences = 
    Preferences.userNodeForPackage(Login.class);
    public Config()
    {
        
    }
    public Config(String username, String password)
    {
        setUsername(username);
        setPassword(password);
    }
    

   
    public void setUsername(String username)
    {
         this.username = username;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public void setCredentials() 
    {        
         
        preferences.put("books_username",this.username);
        preferences.put("books_password", this.password);
    }

    public String getUsername() 
    {
        return preferences.get("books_username", null);
    }

    public String getPassword() 
    {
        return preferences.get("books_password", null);
    }
     
 

}
