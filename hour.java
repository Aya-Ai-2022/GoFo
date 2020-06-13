/**
 * This class contains all the hours whether it is valid or not
 * and contains a function that prints these hours during the user interface with the system.
 */
public class hour {
    private int hour ;
    private boolean available;

    /**
     * constructor to assign variables
     */
    public hour(){
        hour=0;
        available=true;
    }

    /**
     * set hour of this object
     * @param h hour to set
     */
    public void setHour(int h){
        hour=h;
    }

    /**
     * get hour
     * @return hour of this object
     */
    public int getHour(){
        return  hour;
    }

    /**
     * check availability of the hour
     * @return true if it's available
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * set availability of the hour
     * @param available true if it's avaiable
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String toString() {
        return String.format(
                "hour : " + hour );
    }
}
