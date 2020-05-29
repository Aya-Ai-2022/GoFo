
package GOFO;

/**
 * validating various types of input.
 * 
 * 
 */
public final class Validate {

	private static String error;

	private Validate() {
	}

	/**
	 * Returns true if a valid username is input.
	 * 
	 */
	public static User user;

	public static boolean username(String input) {
		if (!input.isEmpty() && !input.contains(" ") && input.matches("[a-zA-Z]+[a-zA-Z0-9]+")) {
			return true;
		}

		return false;
	}

	/**
	 * Returns true if a valid name is input.
	 * 
	 */
	public static boolean name(String input) {
		if (!input.isEmpty() && input.matches("[a-zA-Z ,]+")) {
			return true;
		}

		return false;
	}

	/**
	 * Check that email is valid and return true if it is.
	 * 
	 */
	public static boolean email(String input) {
		// if(!input.isEmpty() && input.contains("@") && input.contains(".")){
		// return true;
		// }

		if (!input.isEmpty() && input.matches("^[A-Za-z0-9+_.-]+@+[A-Za-z0-9.]+[.]+[a-z]+$")) {
			return true;
		}

		return false;
	}

	/**
	 * Check that phone number is valid and return true if it is.
	 * 
	 */
	public static boolean phone(String input) {
		input = input.replaceAll("[ \\-.()]", "");
		return input.matches("\\+?(\\d{8}|\\d{10,11})");
	}

	/**
	 * Validates account passwords
	 */
	public static boolean password(String password) {
		// check length
		if (password.length() >= 8 && password.matches("[a-zA-Z0-9]+")) {
			// loop through each character and check if there is (at least) 1 upper case, 1
			// lower case and 1 number
			// the following vars are set to true once an occurrence of each is found. -kg
			boolean upper = false;
			boolean lower = false;
			boolean num = false;

			for (int i = 0; i < password.length(); i++) {
				// the surrounding if statements prevent extra checks once criteria have been
				// met. -kg
				if (!upper)
					if (Character.isUpperCase(password.charAt(i)))
						upper = true;
				if (!lower)
					if (Character.isLowerCase(password.charAt(i)))
						lower = true;
				if (!num)
					if (Character.isDigit(password.charAt(i)))
						num = true;
			}

			// return true if all criteria are met. -kg
			return upper && lower && num;
		}
		return false;
	}

	public static boolean ValidatePlayer(User user) {
		if (Validate.name(user.getName())) {
			if (Validate.username(user.getUserName())) {
				if (Validate.email(user.getEmail())) {
					if (Validate.phone(user.getPhone())) {

						return true;
					} else {
						setError("Please enter a valid phone number");

					}
				} else {
					setError("Please enter a valid email");
				}
			} else {
				setError("Please enter an userName");
			}
		} else {
			setError("Please enter a  name");
		}
		return false;
	}

	public String getError() {
		return error;
	}

	public static void setError(String errr) {
		error = errr;
	}

	public static void main(String[] args) {
		
		User user = new User("01005050140", "aaaaagoogk.nit", "mk12@#SSjj11", "ggg hh", "jjjjj");
		Validate v1 = new Validate();
		System.out.println(ValidatePlayer(user));
		System.out.println(v1.getError());

		// sample test

		boolean t, m, i, o;
		t = Validate.email("ddd@.com");
		m = Validate.phone("0125");
		i = Validate.username("goodjob");
		o = Validate.email("fiiiff@fnnf.mik");

		System.out.println("THis email: " + t);
		System.out.println("THis phone: " + m);
		System.out.println("THis username :  " + i);
		System.out.println("THis email: " + o);

	}

}
