///Shelby Boswell
/// CS231-001
///Oct 15 2023

package WeekOfOct9.PasswordManager;

//User Class
class User {
    
    String username;

    StringBuilder password; //Using as StringBuilder so it can be changed!

    public User(String username, String password){

        this.username = username;

        this.password = new StringBuilder(password);

    }
}





