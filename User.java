import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author
 *
 */


public class User {
    private String userRole;
    private String phone;
    private String email;
    private String password;
    private String name;
    private String userName;
    public int id; // unique id for each user
    private String errorLogIn;

    public User() {
    }

    public User(String phone, String email, String password, String name, String userName ,String userRole) {
        super();
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.name = name;
        this.userName = userName;
        this.userRole =userRole;
    }


    public String getErrorLogIn() {
        return errorLogIn;
    }

    public void setErrorLogIn(String errorLogIn) {
        this.errorLogIn = errorLogIn;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserRole() {
        return userRole;
    }

    public void enterName() throws IOException {
        System.out.println("\nEnter your name : ");
        Main.input = Main.reader.readLine();
    }
    public void enterUsername() throws IOException {
        System.out.println("\nEnter your username : ");
        Main.input = Main.reader.readLine();
    }
    public void enterEmail() throws IOException {
        System.out.println("\nEnter your email : ");
        Main.input = Main.reader.readLine();
    }
    public void enterPhone() throws IOException {
        System.out.println("\nEnter your phone : ");
        Main.input = Main.reader.readLine();
    }
    public void enterPassword() throws IOException {
        System.out.println("\nEnter your password : ");
        Main.input = Main.reader.readLine();
    }



    public void register(String rol) throws IOException {
        String n,e,u,pa,ph;

        enterName();
        while (!Validate.name(Main.input))
        {
            System.out.println("\n\t!!--Wrong input.");
            enterName();
        }
        n=Main.input;

        enterPhone();
        while (!Validate.phone(Main.input))
        {
            System.out.println("\n\t!!--Wrong input.");
            enterPhone();
        }
        ph=Main.input;
        enterUsername();
        while (!Validate.username(Main.input))
        {
            System.out.println("\n\t!!--Wrong input.");
            enterUsername();
        }
        u=Main.input;

        enterEmail();
        while (!Validate.email(Main.input)) {
            System.out.println("\n\t!!--Wrong input.");
            enterEmail();
        }
        e=Main.input;

        enterPassword();
        while (!Validate.password(Main.input))
        {
            System.out.println("\n\t!!--Wrong input.");
            enterPassword();
        }
        pa=Main.input;

        if(rol.equals("player")){
            player p =new player();
            p.setEmail(e);
            p.setName(n);
            p.setPassword(pa);
            p.setPhone(ph);
            p.setUserName(u);
            p.setUserRole("player");
            Main.admin.addPlayer(p);
        }
        else{
            playgroundOwner o = new playgroundOwner();
            o.setEmail(e);
            o.setName(n);
            o.setPassword(pa);
            o.setPhone(ph);
            o.setUserName(u);
            o.setUserRole("owner");
            Main.admin.addPlaygroundOwner(o);

        }

    }

    public void login() {
        /*
         * User userlog=new User();
         * if(nam.equals(players.equals(userlog.userName))&&(pass.equals(players.equals(
         * userlog.password)))) players.showPlayerList(); else
         * if(nam.equals(playgroundowners.equals(userlog.userName))&&(pass.equals(
         * playgroundowners.equals(userlog.password))))
         * playgroundowners.showOwnerList(); else
         * userlog.setErrorLogIn("Error in log in Try again");
         */

    }


}
