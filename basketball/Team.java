/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yinbasketball4u2;

/**
 *
 * @author leoyi
 */
public class Team {
    //team attributes
    private String tName = "";
    private int wins = 0;
    private int loss = 0;
    private Player player1 = null;
    private Player player2 = null;
    private Player player3 = null;
    private Player player4 = null;
    private Player player5 = null;
    /**
     * primary constructor for team with name
     * @param name team name is entered
     */
    public Team(String name) {
        this.tName = name;
        wins = 0;
        loss = 0;
        player1 = null;
        player2 = null;
        player3 = null;
        player4 = null;
        player5 = null;

    }
    /**
     * secondary constructor to add onto the first one
     * @param name team name
     * @param wins team wins
     * @param loss team losses
     * @param player1 first player
     * @param player2 second player
     * @param player3 third player
     * @param player4 fourth player
     * @param player5 fifth player
     */
    public Team(String name, int wins, int loss, Player player1, Player player2, Player player3, Player player4, Player player5) {
        this(name);
        this.wins = wins;
        this.loss = loss;
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4;
        this.player5 = player5;

    }
    /**
     * mutator method for team name
     * @param name set team name
     */
    public void setName(String name) {
        this.tName = name;
    }
    /**
     * accessor method for team name
     * @return output team name
     */
    public String getName() {
        return tName;

    }
    /**
     * mutator for team wins
     * @param wins set team wins
     */
    public void setWins(int wins) {
        this.wins = wins;
    }
    /**
     * accessor method for team wins
     * @return output team wins
     */
    public int getWins() {
        return wins;
    }
    /**
     * mutator method for team losses
     * @param loss set team losses
     */
    public void setLoss(int loss) {
        this.loss = loss;
    }
    /**
     * accessor method for team losses
     * @return output team losses
     */
    public int getLoss() {
        return loss;
    }
    /**
     * accessor for player information
     * @param i picks which player on the team to display
     * @return output the player information
     */
    public Player getPlayer(int i) {
        if (i == 1) {
            return player1;
        } else if (i == 2) {
            return player2;
        } else if (i == 3) {
            return player3;
        } else if (i == 4) {
            return player4;
        } else if (i == 5) {
            return player5;
        } else {
            return null;
        }

    }
    /**
     * mutator method for players on the team
     * @param player player object to pass through the method
     * @param i picks which player to edit
     */
    public void setPlayer(Player player, int i) {
        if (i == 1) {
            this.player1 = player;
        } else if (i == 2) {
            this.player2 = player;
        } else if (i == 3) {
            this.player3 = player;
        } else if (i == 4) {
            this.player4 = player;
        } else if (i == 5) {
            this.player5 = player;
        }

    }
    /**
     * trade method to trade players
     * @param player finds the user inputted player
     * @param i finds the player number on the team
     * @return output new player from the team
     */
    public Player trade(Player player, int i) {
        if (i == 1) {
            this.player1 = player;
            return player1;
        } else if (i == 2) {
            this.player2 = player;
            return player2;
        } else if (i == 3) {
            this.player3 = player;
            return player3;
        } else if (i == 4) {
            this.player4 = player;
            return player4;
        } else if (i == 5) {
            this.player5 = player;
            return player5;
        } else {
            return null;
        }

    }
    /**
     * calculate and give team score
     * @return output the team score
     */
    public int getScore() {
        int factor = (player1.getPlayerScore() + player2.getPlayerScore() + player3.getPlayerScore() + player4.getPlayerScore() + player5.getPlayerScore()) / 4;
        return (int) (Math.random() * factor) + 75;
    }
    /**
     * check for a matching player name
     * @param name the player name to search for
     * @return output player position on the team
     */
    public int getPlayerValue(String name){
        if(name.equalsIgnoreCase(player1.getPlayerName())){
            return 1;
            
        }else if(name.equalsIgnoreCase(player2.getPlayerName())){
            return 2;
        }else if(name.equalsIgnoreCase(player3.getPlayerName())){
            return 3;
        }else if(name.equalsIgnoreCase(player4.getPlayerName())){
            return 4;
        }else if(name.equalsIgnoreCase(player5.getPlayerName())){
            return 5;
        }
        return -1;
    }
    
    /*
    String = ""
    Char = ''
    int = 0
    double/float = 0.0
    object = null
    boolean = decide true/false
    */
    
    
    /**
     * display team info
     * @return outputs the team info
     */
    public String toString() {
        return "Team Name: " + tName + "\nWins: " + wins + "\nLosses: " + loss + "\nPlayer 1: " + player1.toString()
                + "\nPlayer 2: " + player2.toString() + "\nPlayer 3: " + player3.toString() + "\nPlayer 4: " + player4.toString() + "\nPlayer 5: " + player5.toString();
    }
}
