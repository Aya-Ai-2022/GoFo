import java.util.Vector;

public class playground {
    String playgroundName , playgroundLocation ,playgroundID ;
    double playgroundSize , pricePerHour , cancellationPeriod;
    boolean status;
    Vector<time> playgroundHours = new Vector<time>();

    public playground(){
        playgroundName="";
        playgroundLocation="";
        playgroundID="";
        status=true;
        playgroundSize=1;
        pricePerHour=0;
        cancellationPeriod=0;
    }
    public double getCancellationPeriod() {
        return cancellationPeriod;
    }

    public double getPlaygroundSize() {
        return playgroundSize;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public String getPlaygroundID() {
        return playgroundID;
    }

    public String getPlaygroundLocation() {
        return playgroundLocation;
    }

    public String getPlaygroundName() {
        return playgroundName;
    }

    public Vector<time> getPlaygroundHours() {
        return playgroundHours;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setCancellationPeriod(double cancellationPeriod) {
        this.cancellationPeriod = cancellationPeriod;
    }

    public void setPlaygroubdSize(double playgroubdSize) {
        this.playgroundSize = playgroubdSize;
    }


    public void setPlaygroundID(String playgroundID) {
        this.playgroundID = playgroundID;
    }

    public void setPlaygroundLocation(String playgroundLocation) {
        this.playgroundLocation = playgroundLocation;
    }

    public void setPlaygroundName(String playgroundName) {
        this.playgroundName = playgroundName;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public void addPlaygroundHours(time e) {
        playgroundHours.add(e);
    }
}
