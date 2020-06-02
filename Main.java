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
    public static Admin admin= new Admin();
    public static Validate v1 = new Validate();
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static String input;
    public static int userID = 0;
    public static int playgroundID = 0;
    public static int bookingID = 0;




    public static void main(String[] args) throws IOException {

        while (true) {
            System.out.println("\n-----HELLO !! , let's GO FOOTBALL!-----\n");
            System.out.println("Choose your role :\n1-Player.\n2-Playground Owner.\n3-Admin\n4-exit\nYour Choice : ");
            input = reader.readLine();
            int role = Integer.parseInt(input);
            if (input.equals("1") || input.equals("2")) {
                while (true) {
                    System.out.println("\n1-LOGIN.\n2-New user.\n3-back\nYour Choice : ");
                    input = reader.readLine();
                    //login for existing account
                    if (input.equals("1")) {
                        User u = new User();
                        if (role == 1) {
                            while (!u.login("player")){
                                System.out.println("\n--Wrong username or password.");
                            }
                            System.out.println("we're here;");

                        } else if (role == 2) {
                            u.login("owner");
                        }

                    }
                    //register a new user
                    else if (input.equals("2")) {
                        User u = new User();
                        if (role == 1) {
                            u.register("player");
                        } else if (role == 2) {
                            u.register("owner");
                        }

                    }
                    else if(input.equals("3")) break;
                    else
                        System.out.println("!!--Wrong input.");

                }
            }
                else if (input.equals("3")) {
                while (!admin.verifyAdmin()){
                    System.out.println("\n--Wrong username or password.");
                }
                System.out.println("here");
            }
            else if (input.equals("4")) {
                break;
            }
                else {
                    System.out.println("!!--Wrong input.");
                }

            }


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
