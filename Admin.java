

import java.io.IOException;
import java.util.Vector;


public class Admin {
    private Vector<player> players = new Vector<player>();
    private Vector<playgroundOwner> playgroundOwner = new Vector<playgroundOwner>();
    private Vector<User> users = new Vector<>();
    private Vector<playground> toApprove = new Vector<>();
    private Vector<playground> playgrounds = new Vector<playground>();
    private String adminName;
    private String adminPass;


    public Admin() {
        adminName = "adminGofo";
        adminPass = "@dminGoFO##";
    }

    public String getAdminName() {
        return adminName;
    }

    public String getAdminPass() {
        return adminPass;
    }

    public boolean verifyAdmin(String n, String p) throws IOException {
        if (n.equals(adminName) && p.equals(adminPass)) return true;
        else return false;
    }

    public void requestApproval(playground e ) {
        toApprove.add(e);
    }

    public void approvePlayground(int index) {
        playgrounds.add(toApprove.get(index));
        toApprove.get(index).getOwner().addApprovedPlayground(toApprove.get(index));
        toApprove.remove(index);
    }

    public void getToApprove() {
        int counter = 0;
        for (playground p : toApprove) {
            counter++;
            System.out.println(counter + "-" + p);

        }
    }

    public void suspendplayground(playground e) {
        e.setStatus(false);
    }

    public void deletplayground() {
        // TODO - implement admin.deletplayground
        throw new UnsupportedOperationException();
    }

    public void activateplayground(playground e) {
        e.setStatus(true);
    }


    public void addPlayer(player p) {
        players.add(p);
    }

    public void addPlaygroundOwner(playgroundOwner o) {
        playgroundOwner.add(o);

    }

    public Vector<player> getPlayers() {
        return players;
    }

    public Vector<playgroundOwner> getPlaygroundOwner() {
        return playgroundOwner;
    }

    public void getPlaygrounds() {
        int counter = 0;
        for (playground p : playgrounds) {
            counter++;
            System.out.println(counter + "-" + p);

        }
    }

    public Vector<playground> getAllPlayground(){
        return playgrounds;
    }

    public void addPlayground(playground g) {
        playgrounds.add(g);
    }

    public Vector<User> getUsers() {
        return users;
    }

    public void addUsers(User u) {
        users.add(u);
    }

    public player findPlayer(int id) {
        for (player p : players) {
            if (p.getID() == id) return p;
        }
        return null;

    }

    public playgroundOwner findOwner(int id) {
        for (playgroundOwner o : playgroundOwner) {
            if (o.getID() == id) return o;
        }
        return null;
    }


    public Vector<playground> filterArea(String x) {
        Vector<playground> valid = new Vector<>();
        for (playground o : playgrounds) {
                if (o.getPlaygroundArea().equals(x))
                    valid.add(o);
        }
        return valid;

    }

    public Vector<playground> filterTime(int min ,int max) {
        Vector<playground> valid = new Vector<>();
        for (playground o : playgrounds) {
            for(hour h : o.getPlaygroundHours()) {
<<<<<<< Updated upstream
                if (h.getHour() >= min || h.getHour() <= max)
=======
                if (h.getHour() >= min && h.getHour() <= max)
>>>>>>> Stashed changes
                    valid.add(o);
            }
        }
        return valid;

    }


    public Vector<playground> filterPrice(double min,double max) {
        Vector<playground> valid = new Vector<>();
        for (playground o : playgrounds) {

<<<<<<< Updated upstream
                if (o.getPricePerHour()>=min||o.getPricePerHour()<=max)
=======
                if (o.getPricePerHour()>=min&&o.getPricePerHour()<=max)
>>>>>>> Stashed changes
                    valid.add(o);
        }
        return valid;

    }




    public Vector<playground> filterAvail() {
        Vector<playground> valid = new Vector<>();
        for (playground o : playgrounds) {

            if (o.isAvailable())
                valid.add(o);
        }
        return valid;

    }


}