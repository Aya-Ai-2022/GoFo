import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Date;
import java.util.Properties;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Main {
    public static Admin admin = new Admin();
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static String input;
    public static int userID = 1;
    public static int playgroundID = 0;
    public static int bookingID = 0;


    public static void main(String[] args) throws IOException {

        while (true) {
            System.out.println("\n-----HELLO !! , let's GO FOOTBALL!-----\n");
            System.out.println("\n1-LOGIN.\n2-Sign up.\n3-Exit\nYour Choice : ");
            input = reader.readLine();
            //login for existing account
            if (input.equals("1")) {
                User u = new User();
                int id=0;
                while (true) {
                    String name, pass;
                    System.out.println("\nEnter your Username ");
                    Main.input = Main.reader.readLine();
                    name = Main.input;
                    System.out.println("\nEnter your password ");
                    Main.input = Main.reader.readLine();
                    pass = Main.input;
                    id = u.login(name, pass);
                    if (id == 0) {
                        if (admin.verifyAdmin(name, pass)) {
                            break;
                        }
                    } else {
                        break;
                    }
                    System.out.println("\n!!--Wrong email or password.");

                }

                if(id!=0){
                    player p =new player();
                    playgroundOwner o =new playgroundOwner();
                    p=admin.findPlayer(id);
                    if(p==null){
                        o=admin.findOwner(id);
                        ownerMenu(o);
                    }
                    else{
                       playerMenu(p);
                    }

                }
                else adminMenu(admin);


            }


            //register a new user
            else if (input.equals("2")) {
                while(true) {
                    User u = new User();
                    System.out.println("\nChoose your role :\n1-Player\n2-Playground owner ");
                    Main.input = Main.reader.readLine();
                    if (input.equals("1")) {
                        u.register("player");
                    } else if (input.equals("2")) {
                        u.register("owner");
                    } else System.out.println("!!--Wrong input.");
                }
            }

            else if (input.equals("3")) break;
            else
                System.out.println("\n!!--Wrong input.");


        }



        }



    static void playerMenu(player p) throws IOException {
        while(true){
            System.out.println("Choose action :\n1-\n4-logout");
            input =reader.readLine();

            if(input.equals("4")) break;
        }

     }

    static void ownerMenu(playgroundOwner o){

    }

    static void adminMenu(Admin a){

    }


    static void sendEmail (String email ,String nameR , String nameS , String message){
                final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
                // Get a Properties object
                Properties props = System.getProperties();
                props.setProperty("mail.smtp.host", "smtp.gmail.com");
                props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
                props.setProperty("mail.smtp.socketFactory.fallback", "false");
                props.setProperty("mail.smtp.port", "465");
                props.setProperty("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.auth", "true");
                props.put("mail.debug", "true");
                props.put("mail.store.protocol", "pop3");
                props.put("mail.transport.protocol", "smtp");
                final String username = "xxx@gmail.com";//
                final String password = "xxxxx";
                try {
                    Session session = Session.getDefaultInstance(props,
                            new Authenticator() {
                                protected PasswordAuthentication getPasswordAuthentication() {
                                    return new PasswordAuthentication(username, password);
                                }
                            });

                    // -- Create a new message --
                    Message msg = new MimeMessage(session);

                    // -- Set the FROM and TO fields --
                    msg.setFrom(new InternetAddress("xxxx@gmail.com"));
                    msg.setRecipients(Message.RecipientType.TO,
                            InternetAddress.parse(email, false));
                    msg.setSubject("GOFO APP");
                    msg.setText("Hello"+nameR+",\n"+nameS+message);
                    msg.setSentDate(new Date());
                    Transport.send(msg);
                    Runtime.getRuntime().exec("cls");
                    System.out.println("Message sent.");
                } catch (MessagingException | IOException e) {
                    System.out.println("Error, cause: " + e);
                }
            }

}
