import java.util.Vector;

public class playground {
    String playgroundName , playgroundArea ,Owner ;
    double playgroundSize , pricePerHour , cancellationPeriod;
    boolean status;
    int playgroundID ,ownerID;
    Vector<hour> playgroundHours = new Vector<hour>();
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

    public void getHour() {
        int counter=1;
        for (hour h : playgroundHours) {
           if (h.isAvailable())
               System.out.println(counter + "-" + h);
           else{
               System.out.println(counter + "-" + h+"\tNOT AVAILABLE");
           }
           counter++;
        }
    }

    public  void book(int index){
        playgroundHours.get(index).setAvailable(false);
    }


    public boolean isAvailable(){
        for(hour h : playgroundHours){
            if(h.isAvailable()) return true;
        }
        return false;
    }

    public void addHour(hour h){
        playgroundHours.add(h);
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
