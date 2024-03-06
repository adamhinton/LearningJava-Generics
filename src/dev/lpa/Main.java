package dev.lpa;

import java.util.ArrayList;
import java.util.List;

interface Player{}


record BaseballPlayer(String name, String position) implements Player{
record FootballPlayer(String name, String position) implements Player{

}

public class Main {
    public static void main(String[] args) {

//        SportsTeam phillies = new SportsTeam("Philadelphia Phillies");
//        SportsTeam astros = new SportsTeam("Houston Astros");
//        scoreResult(phillies, 3, astros, 5);
//
//        var harper = new BaseballPlayer("B Harper", "Right Fielder");
//        var marsh = new BaseballPlayer("B Marsh", "Right Fielder");

//        phillies.addTeamMember(harper);
//        phillies.addTeamMember(marsh);
//
//        phillies.listTeamMembers();


        SportsTeam afc = new SportsTeam("Adelaide Crows");
        var tex = new FootballPlayer("Tex walker", "center whatever");
        afc.addTeamMember(tex);
        afc.listTeamMembers();


        var guthrie = new BaseballPlayer("Gurthire", "Center field");
        afc.addTeamMember(guthrie);

    }

    public static void scoreResult (SportsTeam team1, int t1_score, SportsTeam team2, int t2_score){
        String message = team1.setScore(t1_score, t2_score);
        team2.setScore(t2_score, t1_score);
        System.out.printf("%s %s %s %n", team1, message, team2);
    }
}

class BaseballTeam{

    private String teamName;
    private List<BaseballPlayer> teamMembers = new ArrayList<>();
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalTies = 0;

    public BaseballTeam(String teamName) {
        this.teamName = teamName;
    }

    public void addTeamMember(BaseballPlayer player){
        if (!teamMembers.contains(player)) {
            teamMembers.add(player);
        }

    }

    public void listTeamMembers() {
        System.out.println(teamName + "Roster:");
        System.out.println(teamMembers);
    }

    public int ranking() {
        return (totalLosses * 2) + (totalTies + 1);
    }

    public String setScore(int ourScore, int theirScore){
        String message = "lost to";
        if (ourScore > theirScore){
            totalWins++;
            message = "beat";
        }
        else if (ourScore == theirScore){
            totalTies++;
            message = "tied";
        }
        else{
            totalLosses++;
        }
        return message;
    }

    @Override
    public String toString() {
        return teamName + " (Ranked " + ranking() + ")";
    }
}