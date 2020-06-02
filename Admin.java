

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

/**
 * @author ayasa
 *
 */
public class Admin {
    private Vector<player> players=new Vector<player>();
    private Vector<playgroundOwner>playgroundOwner=new Vector<playgroundOwner>();
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

   public boolean verifyAdmin() throws IOException {
        String name, pass;
        System.out.println("\nEnter your Username ");
        Main.input = Main.reader.readLine();
        name = Main.input;
        System.out.println("\nEnter your password ");
        Main.input = Main.reader.readLine();
        pass = Main.input;
        if (name.equals(adminName)&&pass.equals(adminPass)) return true;
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
    public void addPlayground(playground g) {
        playgrounds.add(g);
    }
    public void addPlaygroundOwner(playgroundOwner o) {
        playgroundOwner.add(o);
    }

    public Vector<player> getPlayers() {
        return players;
    }

    public Vector<playground> getPlaygrounds() {
        return playgrounds;
    }

    public Vector<playgroundOwner> getPlaygroundOwner() {
        return playgroundOwner;
    }
}