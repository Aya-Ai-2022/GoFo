/**
 * This class check for some conditions which should be available in the date entered during registering
 * like the email which should be valid and we check for that by a code which is sent to the email entered
 * then we ask for that code to make the user continue in the system
 * also it check for password which should be strong with at least 8 digits and a uppercase character.
 */

public final class Validate {


    public Validate() {
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



}
