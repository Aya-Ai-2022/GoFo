import java.util.Vector;

/**
 * This class enables the owner to add a new valid hour or change the statue of this hour so it could be booked later.
 */
public class playground {
    private String playgroundName , playgroundArea;
    private playgroundOwner owner;
    private double playgroundSize , pricePerHour , cancellationPeriod;
    private boolean status;
    private int playgroundID ,ownerID;
    private Vector<hour> playgroundHours = new Vector<hour>();


    /**
     * playground constructor
     */
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

    /**
     * add hour to the playground
     * @param e hour to add
     */
    public void addPlaygroundHours(hour e) {
        playgroundHours.add(e);
    }

    public void setPlaygroundHours(Vector<hour> playgroundHours) {
        this.playgroundHours = playgroundHours;
    }

    public int getOwnerID() {
        return ownerID;
    }

    /**
     * set playground size
     * @param playgroundSize size
     */

    public void setPlaygroundSize(double playgroundSize) {
        this.playgroundSize = playgroundSize;
    }

    /**
     * set owner id
     * @param ownerID owner id
     */

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }

    /**
     * get id of the playground
     * @return id
     */

    public int getPlaygroundID() {
        return playgroundID;
    }

    /**
     * get hours of the playground
     */
    public void getHour() {
        int counter=1;
        for (hour h : playgroundHours) {
           if (h.isAvailable())
               System.out.println(counter + "--" + h);
           else{
               System.out.println(counter + "-" + h+"\tNOT AVAILABLE");
           }
           counter++;
        }
    }

    /**
     * book an hour in the playground
     * @param index index of the hour to book
     */
    public  void book(int index){
        playgroundHours.get(index).setAvailable(false);
    }

    /**
     * check if there's available hours in the playground
     * @return
     */

    public boolean isAvailable(){
        for(hour h : playgroundHours){
            if(h.isAvailable()) return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return String.format(
                "playground Name='" + playgroundName + '\'' +
                ", playground Area='" + playgroundArea + '\'' +
                ", Owner='" + owner + '\'' +
                ", playground Size=" + playgroundSize +
                ", pricePerHour=" + pricePerHour +
                ", cancellation Period=" + cancellationPeriod +
                ", status=" + status +
                ", playground ID=" + playgroundID +
                ", owner ID=" + ownerID +
                '}');
    }

    /**
     * set owner of the playground
     * @param owner owner
     */

    public void setOwner(playgroundOwner owner) {
        this.owner = owner;
    }

    /**
     * get owner of the playground
     * @return
     */

    public playgroundOwner getOwner() {
        return owner;
    }
}
