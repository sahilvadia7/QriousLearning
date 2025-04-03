package scoreboard.model;

import java.util.List;

public class Match {

    private int id;
    private String type;
    private List<String> teams;
    private String result;
    private int score;

    public Match(
        int id,
        String type,
        List<String> teams,
        String result,
        int score
    ) {
        this.id = id;
        this.type = type;
        this.teams = teams;
        this.result = result;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getTeams() {
        return teams;
    }

    public void setTeams(List<String> teams) {
        this.teams = teams;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
