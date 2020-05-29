
package GOFO;

import java.util.ArrayList;
import java.util.Scanner;
import GOFO.Validate;

/**
 * @author
 *
 */
enum role {

	PLAYER, PLAYGROUNDOWNER
}

public class User {
// This take player object and playgroundowner object
	private ArrayList<User> players;
	private ArrayList<User> playgroundowners;

	// private String passwor;
	static role userRole;

	private String phone;
	private String email;
	private String password;
	private String name;
	private String userName;
	public int id; // unique id for each user
	public static int countID = 1;
	private String errorLogIn;

	public String getErrorLogIn() {
		return errorLogIn;
	}

	public void setErrorLogIn(String errorLogIn) {
		this.errorLogIn = errorLogIn;
	}

	public static String input;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public User() {
	}

	public void register(User userReg) {

		if ((Validate.ValidateUser(userReg)) && (userReg.userRole.equals(role.PLAYER))) {
			countID++;
			userReg.id = countID;
			players.add(userReg);
		} else if ((Validate.ValidateUser(userReg)) && (userReg.userRole.equals(role.PLAYGROUNDOWNER))) {
			countID++;
			userReg.id = countID;
			playgroundowners.add(userReg);
		}
	}

	public void login(String nam, String pass) {
		/*
		 * User userlog=new User();
		 * if(nam.equals(players.equals(userlog.userName))&&(pass.equals(players.equals(
		 * userlog.password)))) players.showPlayerList(); else
		 * if(nam.equals(playgroundowners.equals(userlog.userName))&&(pass.equals(
		 * playgroundowners.equals(userlog.password))))
		 * playgroundowners.showOwnerList(); else
		 * userlog.setErrorLogIn("Error in log in Try again");
		 */

	}

	public String getEmail() {
		return email;
	}

	public User(String phone, String email, String password, String name, String userName) {
		super();
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.name = name;
		this.userName = userName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input;
		do {
			System.out.println("Enter \"login\", \"register\", or \"exit\"");
			input = scanner.nextLine();
			if (input.equals("login")) {
				// get login details
			} else if (input.equals("register")) {
				// get register details
			} else if (input.equals("exit")) {
				break; // exit the loop
			} else {
				// invalid input, tell them to try again
			}
		} while (true);

	}

}
