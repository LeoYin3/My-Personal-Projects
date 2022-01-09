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
import java.util.Scanner;//import scanner for file of ball.4u
import java.io.File;//import file to use the file
import javax.swing.JOptionPane;//import JOptionePane for user interaction and message display
import java.io.FileNotFoundException;//import filenotfoundexception to help with file errors
public class yinbasketball4u {
    /**
     * creates the main screen for the user to navigate with
     * @param teams uses the team object as an array for the method
     */
    public static void selectorScreen(Team[] teams) {
        String input = "";
        while (!input.equalsIgnoreCase("q")) {
            input = JOptionPane.showInputDialog("Pick an option\n1.View Team menu\n2.View Player menu\nType q for quit"); 
            if (input.equalsIgnoreCase("1")) {
                listTeams(teams);

            } 
            else if (input.equalsIgnoreCase("2")) {
                listPlayers(teams);
            } 
            else if (input.equalsIgnoreCase("q")) {
                System.exit(0);
                JOptionPane.showMessageDialog(null, "See you later alligator");
            }
            else{
                JOptionPane.showMessageDialog(null,"Invalid Command");
            }

        }
    }
    /**
     * method used to skip lines in ball.4u
     * @param sc calls scanner to read ball.4u
     * @param lineNum reads the line number (element) of the ball.4u
     */
    public static void lineSkipper(Scanner sc, int lineNum) {
        for (int i = 0; i < lineNum; i++) {
            if (sc.hasNextLine()) {
                sc.nextLine();
            }
        }
    }
    public static void main(String[] args) {
JOptionPane.showMessageDialog(null, "Welcome to Basketball4U");//introduction screen
        final Player player[] = new Player[5];//initializes a player array for use
        Team[] teams = new Team[1];//initializes a team array
        try {//used to avoid file not read error
            File basketball = new File("src//yinbasketball4u2//ball.4u");//imports the file
            Scanner sc = new Scanner(basketball); //scans the file
            int x = Integer.parseInt(sc.nextLine());//imputs the first line of the file
            teams = new Team[x];//creates a team array equal to the size of the first value
            lineSkipper(sc, 0);//skip first line
            for (int i = 0; i < x; i++) {//start storing team array info
                String teamName = sc.nextLine();//stores team name
                String win = sc.nextLine();//reads team wins
                String lose = sc.nextLine();//reads team losses
                //makes the values an integer to store
                int wins = Integer.parseInt(win);
                int loss = Integer.parseInt(lose);

                for (int j = 0; j < 5; j++) {//loop for player array
                    //reads player information
                    player[j] = new Player(sc.nextLine());//stores player name
                    player[j].setPlayerSpeed(Integer.parseInt(sc.nextLine()));//stores player speed
                    player[j].setPlayerThree(Integer.parseInt(sc.nextLine()));//stores player three pointer
                    player[j].setPlayerDunk(Integer.parseInt(sc.nextLine()));//stores player dunking
                    player[j].setPlayerDefense(Integer.parseInt(sc.nextLine()));//stores player defense

                }
                teams[i] = new Team(teamName, wins, loss, player[0], player[1], player[2], player[3], player[4]);//initialize team constructor

            }
        
        } 
        catch (FileNotFoundException x) {//used if file is not found
            System.out.println(x);
        }
//        swapPlayer("Roy Allen","Vance Carter", teams);
        String name1="Roy Allen";
        String name2="Vance Carter";
        int[] a1 =(findPlayer(name1, teams));
        int[] a2 =(findPlayer(name2, teams));
        Player player1 = new Player(name1);
        Player player2 = new Player(name2);
        teams[a1[0]].setPlayer(player2, a1[1]);
        teams[a2[0]].setPlayer(player1,a2[1]);
        int[] a3 =(findPlayer(name1, teams));
        int[] a4 =(findPlayer(name2, teams));
                
        display(teams);//outputs teams and player info to the consol
        selectorScreen(teams);//begins the JOptionPane menu screen

    }
    /**
     * outputs the stored values to the console for user to reference and to verify all values are stored correctly
     * @param teams 
     */
    private static void display(Team[] teams) {
        for (int i = 0; i < teams.length; i++) {
            System.out.println(teams[i]);
        }
    }
    /**
     * 
     * @param teams uses team object array for the method to use
     */
    private static void listPlayers(Team[] teams) {
        //intitialize variables
        String pInfo;
        boolean exist = false;
        pInfo = JOptionPane.showInputDialog("Type 1 to enter a player name to search for\nType 2 for trade menu \nor type b to go back ");//promts user for player name
//        System.out.println(teams.length);
        int select = Integer.parseInt(pInfo);
        if(select == 1){
            for (int i = 0; i < teams.length; i++) {//searches for player
                for(int j =1; j < 6; j++){//searches all 5 players on the team
                if (pInfo.equalsIgnoreCase(teams[i].getPlayer(j).getPlayerName())) {//found a match

                    System.out.println(teams[i].getPlayer(j).getPlayerName());
                    JOptionPane.showMessageDialog(null, teams[i].getName()+"\n"+ teams[i].getPlayer(j).toString());
                    exist = true;
                }  
                else if (i == teams.length - 1 && pInfo.equalsIgnoreCase("b")){
                    JOptionPane.showMessageDialog(null, "Returning to main menu");
                    break;
                }
            }
            }
            


        }
        else if (select == 2){
            pInfo = JOptionPane.showInputDialog("Which player would you like to select?");
        }
                    if (exist == false) {//player is not found
                JOptionPane.showMessageDialog(null, "Sorry this person doesn't exist");//informs user that players does not exist
//                break; //back to main menu
            }

    }
    /**
     * used for user interaction
     * @param teams object array for the method to use
     */
    private static int[] findPlayer(String PlayerName,Team[] teams){
                int[] arr={-1,-1};
                for (int i = 0; i < teams.length; i++) {//searches for player
                for(int j =1; j < 6; j++){//searches all 5 players on the team
                if (PlayerName.equalsIgnoreCase(teams[i].getPlayer(j).getPlayerName())) {                   
                    arr[0]=i;
                    arr[1]=j;     
                }  
                else if (i == teams.length - 1 && PlayerName.equalsIgnoreCase("b")){
                    JOptionPane.showMessageDialog(null, "Returning to main menu");                  
                }
            }
            }
                 return arr;
    }
    private static void swapPlayer(Team[] teams,String name1,String name2){//String PlayerName,Team[] teams
//        String name1="Roy Allen";
//        String name2="Vance Carter";
        int[] a1 =(findPlayer(name1, teams));
        int[] a2 =(findPlayer(name2, teams));
        Player player1 = new Player(name1);
        Player player2 = new Player(name2);
        teams[a1[0]].setPlayer(player2, a1[1]);
        teams[a2[0]].setPlayer(player1,a2[1]);

    }
    private static void listTeams(Team[] teams) {
        //initialize variables
        String show = "\n";
        String tName;
        String t1;
        String t2;
        int a = 0;
        int wins, lose;
        int b = 0;
        boolean found = false;
        String user;
        boolean nextstep = true;
        boolean aexist=false;
        boolean bexist=false;

        for (int i = 0; i < teams.length; i++) {//loops for the array length
            show = show + teams[i].getName() + "\n";//retrieves team names
        }
        user = JOptionPane.showInputDialog("Teams in League" + show + "\n1.View Team\n2.Simulate Game\nPress b to back");//gets user input
        if (user.equalsIgnoreCase("1")) {//if user selects option 1
            tName = JOptionPane.showInputDialog("Select team to view (enter a random value to go back)");//promts user to pick a team
            for (int i = 0; i < teams.length; i++) {//searches for the team
                if (tName.equalsIgnoreCase(teams[i].getName())) {
                     found = true;//only true if team is found
                    if(found == true){//display different messages for when team is found and when team doesn't exist in the database
                         JOptionPane.showMessageDialog(null, teams[i].toString() + "\n");
                         break;
                    }
                    else if(found == false){
                         JOptionPane.showMessageDialog(null, "Sorry this team doesn't exist, returning to main menu");
                         break;
                    }
                } 
                else if (tName.equalsIgnoreCase("b")) {//back to main screen if user enters b
                  JOptionPane.showMessageDialog(null, "Returning to main menu");
                  break;
                    
                }
            }
            if (found == false){
                JOptionPane.showMessageDialog(null, "Input not found. Returning to main menu");
            }
        } 
        else if (user.equalsIgnoreCase("2")) {//if user inputs 2
            for (int i = 0; i < teams.length; i++) {
                show = show + teams[i].getName() + "\n";
            }
            
            //gets the 2 team names from user
            t1 = JOptionPane.showInputDialog("Pick your First team you want to play");
            t2 = JOptionPane.showInputDialog("Pick your Second team you want to play");
            for (int i = 0; i < teams.length; i++) {//searches for the teams
       
                if (t1.equalsIgnoreCase(teams[i].getName())) {
                    a = teams[i].getScore();//team one score
                    aexist=true;
                }
                else if (t2.equalsIgnoreCase(teams[i].getName())) {
                b = teams[i].getScore();//team two score
                bexist=true;
                }
                }            
                if (!aexist){
                    JOptionPane.showMessageDialog(null, "The first team does not exist! Returning to main menu.");
                }
                else if (!bexist){
                    JOptionPane.showMessageDialog(null, "The second team does not exist! Returning to main menu.");
                }
              
            else{
            if (a > b) {//team one beatst team two
                JOptionPane.showMessageDialog(null, "Game Results\n" + t1 + " Wins\n" + t1 + "\nPoints: " + a + "\n\n" + t2 + "\nPoints: " + b);
                for (int i = 0; i < teams.length; i++) {
                    if (t1.equalsIgnoreCase(teams[i].getName())) {
                        wins = teams[i].getWins() + 1;
                        teams[i].setWins(wins);//adds win to team one
                    }
                    else if(t2.equalsIgnoreCase(teams[i].getName())) {
                        lose = teams[i].getLoss() + 1;
                        teams[i].setLoss(lose);//adds loss to team two
                    }
                }
            } 
            
            else if (b > a) {//if team two beats team one
                JOptionPane.showMessageDialog(null, "Game Results\n" + t2 + " Wins\n" + t1 + "\nPoints: " + a + "\n\n" + t2 + "\nPoints: " + b);
                for (int i = 0; i < teams.length; i++) {
                    if (t2.equalsIgnoreCase(teams[i].getName())) {
                        wins = teams[i].getWins() + 1;
                        teams[i].setWins(wins);//adds win to team two
                    }
                    else if (t1.equalsIgnoreCase(teams[i].getName())) {
                        lose = teams[i].getLoss() + 1;
                        teams[i].setLoss(lose);//adds loss to team one
                    }
                }
            }
            else if (a == b){//if teams tie
                JOptionPane.showMessageDialog(null, "Game Results\n" + t1 + " Ties\n" + t2 + "\nPoints: " + a + "\n\n" + t2 + "\nPoints: " + b);
                for (int i = 0; i < teams.length; i++) {//no wins or losses assigned
                    if (t1.equalsIgnoreCase(teams[i].getName())) {
                        wins = teams[i].getWins() + 0;
                        teams[i].setWins(wins);
                    }
                    else if (t2.equalsIgnoreCase(teams[i].getName())) {
                        lose = teams[i].getLoss() + 0;
                        teams[i].setLoss(lose);
                    }
                }
            }
        }
        }
        else{
            JOptionPane.showMessageDialog(null, "Returning to main menu");
        }

    }
    
}
