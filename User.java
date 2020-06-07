import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author
 *
 */


public class User {
    private String userRole;
    private String email;
    private String password;
    private String name;
    private String userName;
    private int ID; // unique id for each user
    private String errorLogIn;

    public User() {
    }

    public User( String email, String password, String name, String userName ,String userRole) {
        super();
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


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
    public void enterPassword() throws IOException {
        System.out.println("\nEnter your password : ");
        Main.input = Main.reader.readLine();
    }



    public void register(String rol) throws IOException {
        String n,e,u,pa;

        enterName();
        while (!Validate.name(Main.input))
        {
            System.out.println("\n\t!!--Wrong input.");
            enterName();
        }
        n=Main.input;

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
/*
        Timer timer = new Timer();
        TimerTask exitApp = new TimerTask() {
            public void run() {
                System.exit(0);
            }
        };

            timer.schedule(exitApp, new Date(System.currentTimeMillis()+30*1000));

*/
        int randomNum = ThreadLocalRandom.current().nextInt(1111, 9998 + 1);
        String message = ". we are happy to have you in our application!.\nhere's your code : "+randomNum;
        Main.sendEmail(e,n,"we are GOFO team" , message);
        System.out.println("\n\n\n\nEnter verification code to continue : ");
        Main.input = Main.reader.readLine();
        String code = Main.input;
        while(!code.equals(String.valueOf(randomNum))) {

             System.out.println("\n--Sorry code is wrong!");
            System.out.println("\nEnter verification code to continue : ");
            Main.input = Main.reader.readLine();
            code = Main.input;

        }



            if (rol.equals("player")) {
                player p = new player();
                p.setEmail(e);
                p.setName(n);
                p.setPassword(pa);
                p.setUserName(u);
                p.setUserRole("player");
                Main.admin.addPlayer(p);
                Main.admin.addUsers(p);
            } else {
                playgroundOwner o = new playgroundOwner();
                o.setEmail(e);
                o.setName(n);
                o.setPassword(pa);
                o.setUserName(u);
                o.setUserRole("owner");
                Main.admin.addPlaygroundOwner(o);
                Main.admin.addUsers(o);

            }
        }

    public int login(String n , String p) throws IOException {
        int id=0;


        player pl = new player();
        pl.setUserName(n);
        pl.setPassword(p);
        for (player i : Main.admin.getPlayers()) {
            if (i.checkLogin(pl)) {
                return i.getID();
            }
        }

        playgroundOwner o = new playgroundOwner();
        o.setUserName(n);
        o.setPassword(p);
        for (playgroundOwner i : Main.admin.getPlaygroundOwner()) {
            if (i.checkLogin(o)) {
                return i.getID();
            }

        }

        return id;
    }




}