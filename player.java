import java.util.Vector;

class player extends User {
    private Vector<team> teamPlayers=new Vector<team>();
    private Vector <Booking> bookings;
    private Vector <String> invitations;

    public player(){
        super();
    }


    public void bookPlayground (playground e, time t){
        Booking b = new Booking();
        b.setPlaygroundBooked(e);
        bookings.add(b);
    }

    public void cancelBooking (int n){
        bookings.remove(n);
    }

    public void addmember(String email,String name){
        team m =new team(email,name);
        teamPlayers.add(m);
        Main.sendEmail(email,name,this.getName()," invites you to join the team!");
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

    public boolean checkLogin(player o) {
        return this.getUserName().equals(o.getUserName())&&this.getPassword().equals(o.getPassword()) ;
    }


}