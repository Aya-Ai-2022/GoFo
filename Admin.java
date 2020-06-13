

import java.io.IOException;
import java.util.Vector;

/**
 * We can consider this class as the database of the GOFO project
 * since all the data is stored within it like players and owners with their date
 * and even the playgrounds with its valid hours and it enables the admin to suspend
 * or delete a certain playground and even activate it if it is already suspended.
 */
public class Admin {
    private Vector<player> players = new Vector<player>();
    private Vector<playgroundOwner> playgroundOwner = new Vector<playgroundOwner>();
    private Vector<User> users = new Vector<>();
    private Vector<playground> toApprove = new Vector<>();
    private Vector<playground> playgrounds = new Vector<playground>();
    private String adminName;
    private String adminPass;

    /**
     * constructor for admin class to assign its username and password
     */
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

    /**
     * to check login credentials for admin
     * @param n username for admin
     * @param p password for admin
     * @return true if credentials are right and false if it's not right
     * @throws IOException
     */
    public boolean verifyAdmin(String n, String p) throws IOException {
        if (n.equals(adminName) && p.equals(adminPass)) return true;
        else return false;
    }

    /**
     * request approval for a adding a playground
     * @param e playground to approve
     */
    public void requestApproval(playground e ) {
        toApprove.add(e);
    }

    /**
     * approving a playground after ensure its information are right
     * @param index index of playground to approve
     */

    public void approvePlayground(int index) {
        playgrounds.add(toApprove.get(index));
        toApprove.get(index).getOwner().addApprovedPlayground(toApprove.get(index));
        toApprove.remove(index);
    }

    /**
     * get playgrounds which are pending to get approved
     */

    public void getToApprove() {
        int counter = 0;
        for (playground p : toApprove) {
            counter++;
            System.out.println(counter + "-" + p);

        }
    }

    /**
     * suspend a playground by making its status false"suspended"
     * @param e playground to suspend
     */
    public void suspendplayground(playground e) {
        e.setStatus(false);
    }

    /**
     * deleting playground
     */
    public void deletplayground() {
        // TODO - implement admin.deletplayground
        throw new UnsupportedOperationException();
    }

    /**
     * activating playground
     * @param e playground to activate
     */
    public void activateplayground(playground e) {
        e.setStatus(true);
    }

    /**
     * add player to the system
     * @param p player to be added
     */
    public void addPlayer(player p) {
        players.add(p);
    }

    /**
     * add playground owner to the system
     * @param o owner to be added
     */
    public void addPlaygroundOwner(playgroundOwner o) {
        playgroundOwner.add(o);

    }

    /**
     * get players
     * @return vector of players
     */
    public Vector<player> getPlayers() {
        return players;
    }

    /**
     * get playground owners
     * @return owners
     */
    public Vector<playgroundOwner> getPlaygroundOwner() {
        return playgroundOwner;
    }

    /**
     * get playgrounds listed
     */

    public void getPlaygrounds() {
        int counter = 0;
        for (playground p : playgrounds) {
            counter++;
            System.out.println(counter + "-" + p);

        }
    }

    /**
     * get all playgrounds in the system
     * @return playgrounds
     */

    public Vector<playground> getAllPlayground(){
        return playgrounds;
    }

    /**
     * add playground to the system
     * @param g playground to add
     */

    public void addPlayground(playground g) {
        playgrounds.add(g);
    }

    /**
     * get users in the system
     * @return vector of users
     */
    public Vector<User> getUsers() {
        return users;
    }

    /**
     * add user to the system "owner or player
     * @param u user to add
     */

    public void addUsers(User u) {
        users.add(u);
    }


    /**
     * find player in the system by id
     * @param id id of the player
     * @return owner if found and null if not
     */

    public player findPlayer(int id) {
        for (player p : players) {
            if (p.getID() == id) return p;
        }
        return null;

    }

    /**
     * find owner in the system by id
     * @param id id of the owner
     * @return owner if found and null if not
     */

    public playgroundOwner findOwner(int id) {
        for (playgroundOwner o : playgroundOwner) {
            if (o.getID() == id) return o;
        }
        return null;
    }

    /**
     * filter playground by area
     * @param x area to search for
     * @return playground which are in this area
     */

    public Vector<playground> filterArea(String x) {
        Vector<playground> valid = new Vector<>();
        for (playground o : playgrounds) {
                if (o.getPlaygroundArea().equals(x))
                    valid.add(o);
        }
        return valid;

    }

    /**
     * filter playground by time
     * @param min first hour to search for
     * @param max second hour to search for
     * @return playgrounds between this time range
     */

    public Vector<playground> filterTime(int min ,int max) {
        Vector<playground> valid = new Vector<>();
        for (playground o : playgrounds) {
            for(hour h : o.getPlaygroundHours()) {
                if (h.getHour() >= min && h.getHour() <= max)
                    valid.add(o);
            }
        }
        return valid;

    }

    /**
     * filter playgrounds by price
     * @param min minimum price
     * @param max maximim price
     * @return playgrounds which theirs price between this range
     */

    public Vector<playground> filterPrice(double min,double max) {
        Vector<playground> valid = new Vector<>();
        for (playground o : playgrounds) {

                if (o.getPricePerHour()>=min&&o.getPricePerHour()<=max)
                    valid.add(o);
        }
        return valid;

    }

    /**
     * filter playground by available hours
     * @return playgrounds which have available hours
     */


    public Vector<playground> filterAvail() {
        Vector<playground> valid = new Vector<>();
        for (playground o : playgrounds) {

            if (o.isAvailable())
                valid.add(o);
        }
        return valid;

    }


}