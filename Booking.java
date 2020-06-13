/**
 * This class is responsible for the booking process only
 * and makes the player see all the bookings that he is booking or have already booked before.
 */

public class Booking {

    private int id;
    private playground playgroundBooked;
    private hour hourBooked;


    public Booking(){

    }

    /**
     * get id of the booking
     * @return id
     */
    public int getId() {
        return this.id;
    }

    /**
     * to get which playground associated with this booking
     * @return playground
     */

    public playground getPlaygroundBooked() {
        return playgroundBooked;
    }

    /**
     * set playground of the booking
     * @param playgroundBooked playground of this booking
     */
    public void setPlaygroundBooked(playground playgroundBooked) {
        this.playgroundBooked = playgroundBooked;
    }

    /**
     * set booked hour of the playground
     * @param hourBooked hour booked in the playgorund
     */

    public void setHourBooked(hour hourBooked) {
        this.hourBooked = hourBooked;
    }

    /**
     * get booked hour
     * @return hour booked in the playgorund
     */

    public hour getHourBooked() {
        return hourBooked;
    }
}