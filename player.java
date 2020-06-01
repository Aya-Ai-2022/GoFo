import java.util.Vector;

class player extends User {
    private team teamPlayers ;
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
        teamPlayers.addPlayer(email,name);
    }

}
