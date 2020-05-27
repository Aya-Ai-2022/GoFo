import java.util.Vector;

public class playground {
    String playgroundName , playgroundLocation ,playgroundID , status;
    double playgroubdSize , pricePerHour , cancellationPeriod;
    Vector<time> playgroundHours = new Vector<time>();



    public double getCancellationPeriod() {
        return cancellationPeriod;
    }

    public double getPlaygroubdSize() {
        return playgroubdSize;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCancellationPeriod(double cancellationPeriod) {
        this.cancellationPeriod = cancellationPeriod;
    }

    public void setPlaygroubdSize(double playgroubdSize) {
        this.playgroubdSize = playgroubdSize;
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
