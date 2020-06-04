

import java.io.IOException;
import java.util.Vector;

/**
 * @author ayasa
 *
 */
public class Admin {
    private Vector<player> players=new Vector<player>();
    private Vector<playgroundOwner>playgroundOwner=new Vector<playgroundOwner>();

    private Vector<User> users=new Vector<>();
	private Vector<playground>playgrounds=new Vector<playground>();
    private String adminName;
    private String adminPass;


    public Admin(){
        adminName="adminGofo";
        adminPass="@dminGoFO##";
    }

    public String getAdminName() {
        return adminName;
    }
    public String getAdminPass() {
        return adminPass;
    }

   public boolean verifyAdmin(String n , String p) throws IOException {
        if (n.equals(adminName)&&p.equals(adminPass)) return true;
        else return false;
    }

    public void approveplayground(playground e) {
     //check info if it's true
     //approve it
     //let playground owner add it & sending him notification
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

    public Vector<playground> getPlaygrounds() {
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

    public player findPlayer(int id){
        for(player p : players){
            if (p.getID()==id) return p;
        }
        return null;

    }

    public playgroundOwner findOwner(int id){
       for(playgroundOwner o : playgroundOwner){
            if (o.getID()==id) return o;
        }
        return null;
    }



}