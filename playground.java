import java.util.Vector;

public class playground {
    String playgroundName , playgroundArea ,Owner ;
    double playgroundSize , pricePerHour , cancellationPeriod;
    boolean status;
    int playgroundID ,ownerID;
    Vector<Integer> playgroundHours = new Vector<Integer>();
   // Vector<time> playgroundDate = new Vector<time>();


    public playground(){
        playgroundName="";
        playgroundArea ="";
        status=false;
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

    public Vector<Integer> getPlaygroundHours() {
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

    public void setPlaygroundArea(String playgroundArea) {
        this.playgroundArea = playgroundArea;
    }

    public void setPlaygroundName(String playgroundName) {
        this.playgroundName = playgroundName;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public void addPlaygroundHours(int e) {
        playgroundHours.add(e);
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setPlaygroundSize(double playgroundSize) {
        this.playgroundSize = playgroundSize;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    public int getPlaygroundID() {
        return playgroundID;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    @Override
    public String toString() {
        return String.format(
                "playground Name='" + playgroundName + '\'' +
                ", playground Area='" + playgroundArea + '\'' +
                ", Owner='" + Owner + '\'' +
                ", playground Size=" + playgroundSize +
                ", pricePerHour=" + pricePerHour +
                ", cancellation Period=" + cancellationPeriod +
                ", status=" + status +
                ", playground ID=" + playgroundID +
                ", owner ID=" + ownerID +
                '}');
    }
}
