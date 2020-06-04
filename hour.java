public class hour {
    int hour ;
    boolean period;
    boolean available;

    public hour(){
        hour=0;
        period=false;
        available=true;
    }
    public void setHour(int h){
        hour=h;
    }

    public void setPeriod(boolean p){
        period=p;
    }

    public int getHour(){
        return  hour;
    }


    public boolean getPeriod(){
        return period;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}
