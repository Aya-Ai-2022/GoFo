import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
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
                        break;
                    } else if (input.equals("2")) {
                        u.register("owner");
                        break;
                    } else System.out.println("!!--Wrong input.");
                }
            }

            else if (input.equals("3")) break;
            else
                System.out.println("\n!!--Wrong input.");


        }



        }



    static void playerMenu(player p) throws IOException {
        while (true) {
            System.out.println("Choose action :\n1-Show available playgrounds.\n2-add teammate to your team.\n3-remove member from your team.\n4-logout\nenter : ");
            input = reader.readLine();
            Vector<playground> valid = new Vector<playground>();
            if (input.equals("1")) {
                System.out.println("1-show all.\n2- filter by.\nenter : ");
                input = reader.readLine();
                if (input.equals("1")) {
                    valid = admin.getAll();
                } else if (input.equals("2")) {
                    while (true) {
                        System.out.println("filter by :\n1-location.\n2-price range.\n3-Time range.\n4-available hours.\nenter : ");
                        input = reader.readLine();
                        if (input.equals("1")) {
                            System.out.println("enter location : ");
                            input = reader.readLine();
                            valid = admin.filterArea(input);
                            break;

                        } else if (input.equals("2")) {
                            System.out.println("enter min price : ");
                            int min = Integer.parseInt(reader.readLine());
                            System.out.println("enter max price : ");
                            int max = Integer.parseInt(reader.readLine());
                            valid = admin.filterPrice(min, max);
                            break;


                        } else if (input.equals("3")) {
                            System.out.println("Search hour from : ");
                            int min = Integer.parseInt(reader.readLine());
                            System.out.println("to : ");
                            int max = Integer.parseInt(reader.readLine());
                            valid = admin.filterTime(min, max);
                            break;
                        } else if (input.equals("4")) {
                            valid = admin.filterAvail();
                            break;
                        } else {
                            System.out.println("invalid input.");
                            continue;
                        }
                    }



                }




                if (!valid.isEmpty()) {
                    int counter = 0;
                    //displaying all pgs
                    for (playground pg : valid) {
                        counter++;
                        System.out.println(counter + "-" + pg);
                    }

                    //choosing one
                    System.out.println("choose playground  : ");
                    int indexP = Integer.parseInt(reader.readLine()) - 1;
                    while (indexP > valid.size()||indexP<0) {
                        System.out.println("Wrong input..Choose again.");
                        indexP = Integer.parseInt(reader.readLine()) - 1;
                    }

                    valid.get(indexP).getHour();
                    System.out.println("choose hour  : ");
                    int indexH = Integer.parseInt(reader.readLine()) - 1;

                    while (indexH > valid.get(indexP).getPlaygroundHours().size()) {
                        System.out.println("Wrong input..Choose again.");
                        indexH = Integer.parseInt(reader.readLine()) - 1;
                    }

                    while (!valid.get(indexP).getPlaygroundHours().get(indexH).isAvailable()) {
                        System.out.println("This hour is already booked.\nchoose again : ");
                        indexH = Integer.parseInt(reader.readLine()) - 1;
                    }


                    valid.get(indexP).book(indexH);
                    p.bookPlayground(valid.get(indexP), valid.get(indexP).getPlaygroundHours().get(indexH));

                    for(playgroundOwner o : admin.getPlaygroundOwner()){
                        if(valid.get(indexP).getOwnerID()==o.getID())
                            o.getpaid(valid.get(indexP).getPricePerHour());

                    }

                    System.out.println("Playground booked successfully.");
                } else {
                    System.out.println("There's no playgrounds !");
                }

            }




                else if (input.equals("2")) {
                    String n, e;
                    while (true) {
                        System.out.println("Enter your teammate Email : ");
                        e = reader.readLine();
                        System.out.println("Enter your teammate name : ");
                        n = reader.readLine();
                        p.addmember(e, n);
                        System.out.println("\nGREAT!! .. we sent him an Invitation!");
                        System.out.println("\nDo you want to add another member?(y/n) : ");
                        input = reader.readLine();
                        if (input.equalsIgnoreCase("y")) continue;
                        else if (input.equalsIgnoreCase("n")) break;
                        else System.out.println("!!--Wrong input.");

                    }
                } else if (input.equals("3")) {
                    p.getTeamPlayers();
                    System.out.println("\nEnter team member number to remove :");
                    input = reader.readLine();
                    int index = Integer.parseInt(input) - 1;
                    p.modifyTeam(index);
                    System.out.println("\nRemoved successfully!!");
                } else if (input.equals("4")) break;
                else System.out.println("!!--Wrong input.");
            }

        }


    static void ownerMenu(playgroundOwner o) throws IOException {
        while (true) {
            System.out.println("Choose action :\n1-Add playground\n2-Create profile\n3-logout");
            input = reader.readLine();
            if(input.equals("1")){
                o.addPlayground();
                System.out.println("\nGREAT!! .. Playground added successfully.");
            }
            else if(input.equals("2")){
                o.createProfile();
                System.out.println("\nGREAT!! .. profile created successfully.");

            }
            else if(input.equals("3")) break;
           else System.out.println("!!--Wrong input.");


        }
    }

    static void adminMenu(Admin a) throws IOException {
        while(true){
            System.out.println("Choose action :\n1-show playgrounds to be approved\n2-logout");
            input =reader.readLine();

            if(input.equals("1")){
                System.out.println("\nEnter playground number to approve it :");
                admin.getToApprove();
                input=reader.readLine();
                int index = Integer.parseInt(input)-1;
                admin.approvePlayground(index);
                System.out.println("\nRemoved successfully!!");

            }
            else if(input.equals("2")) break;
            else System.out.println("!!--Wrong input.");


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
                props.put("mail.store.protocol", "pop3");
                props.put("mail.transport.protocol", "smtp");
                final String username = "xxxxx@gmail.com";
                final String password = "xxxxxx";
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
                    msg.setFrom(new InternetAddress("xxxxx@gmail.com"));
                    msg.setRecipients(Message.RecipientType.TO,
                            InternetAddress.parse(email, false));
                    msg.setSubject("GOFO APP");
                    msg.setText("Hello "+nameR+",\n"+nameS+message);
                    msg.setSentDate(new Date());
                    Transport.send(msg);
                } catch (MessagingException  e) {
                    System.out.println("Error, cause: " + e);
                }
            }






}
