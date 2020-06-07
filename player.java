import java.util.Vector;

class player extends User {
    private Vector<team> teamPlayers=new Vector<team>();
    private Vector <Booking> bookings=new Vector<>();
    private Vector <String> invitations=new Vector<>();

    public player(){
        super();
        this.setID(Main.userID++);

    }


    public void bookPlayground (playground e, hour t){
        Booking b = new Booking();
        b.setPlaygroundBooked(e);
        b.setHourBooked(t);
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

    public void modifyTeam(int index){
        teamPlayers.remove(index);
    }

    public void getTeamPlayers(){
        int counter=0;
        for(team t : teamPlayers){
            counter++;
            System.out.println(counter+"-" +t);
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

    public boolean checkLogin(player o) {
        return this.getUserName().equals(o.getUserName())&&this.getPassword().equals(o.getPassword()) ;
    }


}