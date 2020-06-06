public class hour {
    int hour ;
    boolean available;

    public hour(){
        hour=0;
        available=true;
    }
    public void setHour(int h){
        hour=h;
    }


    public int getHour(){
        return  hour;
    }


    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String toString() {
        return String.format(
                "hours : " + hour );
    }
}
