public class time {
    int hour , minute ;
    boolean period;

    public void setHour(int h){
        hour=h;
    }

    public void setMinute(int m){
        minute=m;
    }

    public void setPeriod(boolean p){
        period=p;
    }

    public int getHour(){
        return  hour;
    }

    public int getMinute(){
        return minute;
    }

    public boolean getPeriod(){
        return period;
    }
}
