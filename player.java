import java.awt.print.Book;
import java.util.Vector;

/**
 * This class makes the player able to add or invite a new member to the system
 * so they could invite each other for an hour and enable him to check for invitations from other players
 * and help him communicate with all his friends within the system and even cancel an already booked hour if possible.
 */
class player extends User {
    private Vector<team> teamPlayers=new Vector<team>();
    private Vector <Booking> bookings=new Vector<>();
    private Vector <String> invitations=new Vector<>();

    /**
     * constructor
     */
    public player(){
        super();
        this.setID(Main.userID++);

    }

    /**
     * book a playground and store its info
     * @param e playground booked
     * @param t hour booked
     */
    public void bookPlayground (playground e, hour t){
        Booking b = new Booking();
        b.setPlaygroundBooked(e);
        b.setHourBooked(t);
        bookings.add(b);
    }

    /**
     * cancel booking
     * @param n index of booking
     */

    public void cancelBooking (int n){
        bookings.remove(n);
    }

    /**
     * add member to the team
     * @param email email of teammate
     * @param name name of teammate
     */

    public void addmember(String email,String name){
        team m =new team(email,name);
        teamPlayers.add(m);
        Main.sendEmail(email,name,this.getName()," invites you to join the team!");
    }

    /**
     * remove player from the team
     * @param index index of the player to remove
     */

    public void modifyTeam(int index){
        teamPlayers.remove(index);
    }

    /**
     * get teammates
     */
    public void getTeamPlayers(){
        int counter=0;
        for(team t : teamPlayers){
            counter++;
            System.out.println(counter+"-" +t);
        }
    }

    /**
     * view booked hours
     */
    public void viewPlayingHours(){
        int counter=1;
        for(int i =0 ; i<bookings.size();i++){
            System.out.println(counter+"-" +bookings.get(i).getHourBooked());
            counter++;
        }
    }

    @Override
    public String toString() {
        return "player{" +
                "us = " + getUserName()+
                "pass = "+getPassword()+
                "teamPlayers=" + teamPlayers +
                ", bookings=" + bookings +
                ", invitations=" + invitations +
                '}';
    }

    /**
     * check the credentials
     * @param o player to check
     * @return
     */

    public boolean checkLogin(player o) {
        return this.getUserName().equals(o.getUserName())&&this.getPassword().equals(o.getPassword()) ;
    }


}