public class Booking {

    private int id;
    private playground playgroundBooked;


    public Booking() {
        id=Main.bookingID++;
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
}