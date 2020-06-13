import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;


public class playgroundOwner extends User {
    private int EwalletBalance;
    private String address,phone;
    private Vector<playground> playgrounds = new Vector<playground>();

    public playgroundOwner(){
        super();
        setEwalletBalance(0);
        this.setID(Main.userID++);
    }



        public void addPlayground() throws IOException {

        playground e=new playground();
        System.out.println("Enter playground name : ");
        Main.input = Main.reader.readLine();
        e.setPlaygroundName(Main.input);
        System.out.println("Enter price per hour : ");
        double n = Double.parseDouble(Main.reader.readLine());
        e.setPricePerHour(n);
            hour h1 = new hour();
            System.out.println("Enter available hour(Hour must be in range 1pm-12pm) : ");
        int t = Integer.parseInt(Main.reader.readLine());
        if(t>12||t<1) System.out.println("!!--Hour must be in range 1pm-12pm");
        else{h1.setHour(t);
            e.addPlaygroundHours(h1);}
        while(true){
            hour h = new hour();
            System.out.println("add another hour? (y/n) : ");
            Main.input=Main.reader.readLine();
            if(Main.input.equalsIgnoreCase("y")) {
                System.out.println("Enter available hour(Hour must be in range 1pm-12pm) : ");
                t = Integer.parseInt(Main.reader.readLine());
                if(t>12||t<1) System.out.println("!!--Hour must be in range 1pm-12pm");
                else {h.setHour(t);
                    e.addPlaygroundHours(h);}
            }
            else if(Main.input.equalsIgnoreCase("n")) break;
            else System.out.println("!!--Wrong input.");
        }
        System.out.println("Enter cancellation period : ");
        n = Double.parseDouble(Main.reader.readLine());
        e.setCancellationPeriod(n);
        System.out.println("Enter playground size : ");
        n = Double.parseDouble(Main.reader.readLine());
        e.setPlaygroundSize(n);
        System.out.println("Enter playground area : ");
        Main.input = Main.reader.readLine();
        e.setPlaygroundArea(Main.input);

        e.setOwner(this);
        e.setOwnerID(this.getID());

        Main.admin.requestApproval(e); //asking admin to approve the playground
    }

    public void createProfile() throws IOException {
        System.out.println("Enter your Adress : ");
        Main.input = Main.reader.readLine();
        this.setAddress(Main.input);
        System.out.println("Enter your phone : ");
        Main.input = Main.reader.readLine();
        this.setPhone(Main.input);


    }

    public void  addApprovedPlayground(playground e){
        playgrounds.add(e);
    }

    public void updatePlayground(playground e) throws IOException {
        String op;
        while (true) {
            System.out.println("choose from menu\n1.change playground name.\n2.change playground price.\n3.add playground hours.");
            System.out.println("\n4.delete playground hour.\n5.change playground location.\n6.change playground size\n7.change playground cancellation period.\n8.back");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            op = reader.readLine();
            if (op.equals("1")) {
                System.out.println("Enter new name : ");
                String n = reader.readLine();
                e.setPlaygroundName(n);
                System.out.println("Great ! ,, playground name changed !");

            } else if (op.equals("2")) {
                System.out.println("Enter new price : ");
                double n = Double.parseDouble(reader.readLine());
                e.setPricePerHour(n);
                System.out.println("Great ! ,, playground price changed !");


            } else if (op.equals("3")) {
                hour t = new hour();
                int n;
                System.out.println("Enter new hours :\n");
                System.out.println("Enter hour : ");
                n = Integer.parseInt(reader.readLine());
                t.setHour(n);
<<<<<<< Updated upstream
                e.addPlaygroundHours(t);
=======
                //e.addPlaygroundHours(t);
>>>>>>> Stashed changes
                System.out.println("Great ! ,, playground hour added !");

            } else if (op == "4") {
                int n;
                System.out.println("playground hours are : " + e.getPlaygroundHours());
                System.out.println("enter number of hour you want to delete (1 for first one , 2 for second one...) : ");
                n = Integer.parseInt(reader.readLine());
                e.getPlaygroundHours().remove(n);
                System.out.println("Great ! ,, playground hour deleted !\n");
                System.out.println("playground hours now are : " + e.getPlaygroundHours());


            } else if (op == "5") {
                System.out.println("Enter new location : ");
                String n = reader.readLine();
                e.setPlaygroundArea(n);
                System.out.println("Great ! ,, playground location changed !");


            } else if (op == "6") {
                System.out.println("Enter new size : ");
                double n = Double.parseDouble(reader.readLine());
                e.setPlaygroundSize(n);
                System.out.println("Great ! ,, playground size changed !");
            } else if (op == "7") {
                System.out.println("Enter new cancellation period : ");
                double n = Double.parseDouble(reader.readLine());
                e.setCancellationPeriod(n);
                System.out.println("Great ! ,, playground cancellation period changed !");


            } else if (op == "8") break;
            else {
                System.out.println("\t\n!!-wrong input . try again .\n\n");
            }

        }
<<<<<<< Updated upstream
=======
    }

    public void getPlaygrounds(){
        int counter = 0;
        for (playground p : playgrounds) {
            counter++;
            System.out.println(counter + "-" + p);

        }
    }

    public void checkEwallet(){
        System.out.println("your balance = "+getEwalletBalance());
>>>>>>> Stashed changes
    }

    public void getpaid(double amount){
        EwalletBalance+=amount;
    }



    public int getEwalletBalance() {
        return EwalletBalance;
    }

    public void setEwalletBalance(int ewalletBalance) {
        EwalletBalance = ewalletBalance;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "playgroundOwner : \n" + "name : " + getName()
                +"username : "+ this.getUserName()+
                "email : "  +this.getEmail()
                +"phone : " +this.getPhone();
    }

    public boolean checkLogin(playgroundOwner o) {
        return this.getUserName().equals(o.getUserName())&&this.getPassword().equals(o.getPassword()) ;
    }

}
