package scoreboard.model;

// - name
// - role (bolwer,bats-man)
// - playing yeaer

public class Player {

    private int id;
    private String name;
    private Role role;
    private String year;

    public Player() {}

    // Constructor
    public Player(int id, String name, Role role, String year) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.year = year;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return (
            "[ Player Id: " +
            id +
            ", Name: " +
            name +
            ", Role :" +
            role +
            ", Year :" +
            year +
            "]"
        );
    }
}
