public class time {
    int hour , minute ;
    boolean period;
    
    public time(){
        hour=0;
        minute=0;
        period=false;
    }
    
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
