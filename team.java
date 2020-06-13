public class team {

    private String email;
    private String name;

    /**
     * constructor to assign variables
     * @param email eamil of the teammate
     * @param name name of the teammate
     */

    public team(String email,String name) {
        this.email = email;
        this.name =name;
    }

    @Override
    public String toString() {
        return "team{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}