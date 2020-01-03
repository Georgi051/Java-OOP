package encapsulation.footballteamgenerator;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        Exceptions.isValidName(name);
        this.name = name;
    }

    private void setEndurance(int endurance) {
        Exceptions.isStatInRange("Endurance", endurance);
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        Exceptions.isStatInRange("Sprint", sprint);
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        Exceptions.isStatInRange("Dribble", dribble);
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        Exceptions.isStatInRange("Passing", passing);
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        Exceptions.isStatInRange("Shooting", shooting);
        this.shooting = shooting;
    }

    public double overallSkillLevel() {
        return (this.dribble + this.endurance + this.passing + this.shooting + this.sprint) / 5.0;
    }
}
