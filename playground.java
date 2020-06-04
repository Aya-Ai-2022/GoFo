import java.util.Vector;

public class playground {
    String playgroundName , playgroundArea ,Owner ;
    double playgroundSize , pricePerHour , cancellationPeriod;
    boolean status;
    int playgroundID;
    Vector<hour> playgroundHours = new Vector<hour>();
   // Vector<time> playgroundDate = new Vector<time>();


    public playground(){
        playgroundName="";
        playgroundArea ="";
        status=true;
        playgroundSize=1;
        pricePerHour=0;
        cancellationPeriod=0;
        playgroundID=Main.playgroundID++;
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

    public String getPlaygroundOwner() {
        return Owner;
    }

    public String getPlaygroundArea() {
        return playgroundArea;
    }

    public String getPlaygroundName() {
        return playgroundName;
    }

    public Vector<hour> getPlaygroundHours() {
        return playgroundHours;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setPlaygroundOwner(String playgroundOwner) {
        this.Owner = playgroundOwner;
    }

    public void setCancellationPeriod(double cancellationPeriod) {
        this.cancellationPeriod = cancellationPeriod;
    }

    public void setPlaygroubdSize(double playgroubdSize) {
        this.playgroundSize = playgroubdSize;
    }

    public void setPlaygroundArea(String playgroundArea) {
        this.playgroundArea = playgroundArea;
    }

    public void setPlaygroundName(String playgroundName) {
        this.playgroundName = playgroundName;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public void addPlaygroundHours(hour e) {
        playgroundHours.add(e);
    }
}
