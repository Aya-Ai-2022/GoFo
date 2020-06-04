import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;


public class playgroundOwner extends User {
    int EwalletBalance;
    Vector<playground> playgroundVector = new Vector<playground>();

    public playgroundOwner(){
        super();
        setEwalletBalance(0);
        this.setID(Main.userID++);
    }

    public void addPlayground(playground e){
        Main.admin.approveplayground(e); //asking admin to approve the playground
        playgroundVector.add(e);

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
                time t = new time();
                int n;
                System.out.println("Enter new hours :\n");
                System.out.println("Enter hour : ");
                n = Integer.parseInt(reader.readLine());
                t.setHour(n);
                System.out.println("Enter minutes : ");
                n = Integer.parseInt(reader.readLine());
                t.setMinute(n);
                while (true) {
                    System.out.println("Enter period (am/pm) : ");
                    String s = reader.readLine();
                    if (s.equals("am")) {
                        t.setPeriod(false);
                        break;
                    } else if (s.equals("pm")) {
                        t.setPeriod(true);
                        break;
                    } else System.out.println("\t\n!!-wrong input . try again .\n\n");
                }

                e.addPlaygroundHours(t);
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
                e.setPlaygroubdSize(n);
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
    }

    public void getpaid(int amount){
        EwalletBalance+=amount;
    }


    public Vector<playground> getPlaygroundVector() {
        return playgroundVector;
    }

    public int getEwalletBalance() {
        return EwalletBalance;
    }

    public void setEwalletBalance(int ewalletBalance) {
        EwalletBalance = ewalletBalance;
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
