public class team {

    private String email;
    private String name;


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