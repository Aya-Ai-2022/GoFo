public class Booking {

    private int id;
    private playground playgroundBooked;
    private hour hourBooked;


    public Booking(){

    }

    public int getId() {
        return this.id;
    }


    public playground getPlaygroundBooked() {
        return playgroundBooked;
    }

    public void setPlaygroundBooked(playground playgroundBooked) {
        this.playgroundBooked = playgroundBooked;
    }

    public void setHourBooked(hour hourBooked) {
        this.hourBooked = hourBooked;
    }

    public hour getHourBooked() {
        return hourBooked;
    }
}