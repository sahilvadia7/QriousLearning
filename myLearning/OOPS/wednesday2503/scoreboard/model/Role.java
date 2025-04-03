package scoreboard.model;

public enum Role {
    BATSMEN("batsmen"),
    BOWLER("bowler"),
    WICKETKEEPER("wicketkeeper"),
    ALLROUNDERS("allrounder");

    private final String roleName;

    Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    // Method to get Role from string
    public static Role fromString(String roleName) {
        for (Role role : Role.values()) {
            if (role.roleName.equalsIgnoreCase(roleName)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Invalid Role: " + roleName);
    }
}
