/**
 * 
 */
package GOFO;

import java.util.*;

/**
 * @author ayasa
 *
 */
public class Admin {

	//private Arraylist<playgroundowner>playgroundOwner;
//	private Arraylist<playground>playgrounds;
	private String adminName;
	
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	private String adminPass;
	private  String[]account = {"adminGofo","@dminGoFO##"};
	private boolean active = false;

//
    public boolean checkEmailPassword()
    {

        if((adminName.equals(account[0])) && (adminPass.equals(account[1])))
            return true;
        else
            return false;
    }
    public void adminLogin(){
    	
    	if(checkEmailPassword()==true)
    		active =true;
    	
    }
    

    public void deactivateAccount()
    {
         active = false;
    }

	public void approveplayground() {
		// TODO - implement admin.approveplayground
		throw new UnsupportedOperationException();
	}

	public void suspendplayground() {
		// TODO - implement admin.suspendplayground
		throw new UnsupportedOperationException();
	}

	public void deletplayground() {
		// TODO - implement admin.deletplayground
		throw new UnsupportedOperationException();
	}

	public void activateplayground() {
		// TODO - implement admin.activateplayground
		throw new UnsupportedOperationException();
	}

	public String getAdminPass() {
		return this.adminPass;
	}

	/**
	 * 
	 * @param adminPass
	 */
	public void SetAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}
	 public static void main(String[] args) 
	    {
          Admin A=new Admin();
	      Scanner input = new Scanner (System.in);  

	      String name;
	      String password;


	      System.out.println("Welcome !");
	      System.out.println("\nEnter your username and password to login to your account.");    

	      System.out.println("Username: ");
	      name = input.nextLine();
	      A.setAdminName(name);

	      System.out.println("Password: ");
	        password = input.nextLine();
	        A.SetAdminPass(password);

	    

	        if(A.checkEmailPassword())
	            System.out.println("You are logged in!");
	        else
	            System.out.println("The username and password you entered are incorrect.");
	    }

	



}
