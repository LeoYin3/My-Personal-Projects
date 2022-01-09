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
public class Player {
    //player attributes
    private String pName = "";
    private int pSpeed = 0;
    private int pThree = 0;
    private int pDunk = 0;
    private int pDefense = 0;
    //primary constructor for player name
    public Player(String name) {
        this.pName = name;

    }
    //secondary constructor to add onto the first one
    public Player(String name, int speed, int Tpoints, int dunk, int defense) {
        this.pName = name;
        this.pSpeed = speed;
        this.pThree = Tpoints;
        this.pDunk = dunk;
        this.pDefense = defense;
    }
    /**
     * mutator method for player name
     * @param name used to change player name
     */
    public void setPlayerName(String name) {
        this.pName = name;

    }
    /**
     * accessor method to read player name
     * @return outputs the player name
     */
    public String getPlayerName() {
        return pName;
    }
    /**
     * mutator for player speed
     * @param speed used to change player speed
     */
    public void setPlayerSpeed(int speed) {
        this.pSpeed = speed;
    }
    /**
     * accessor method for player speed
     * @return outputs the player speed
     */
    public int getPlayerSpeed() {
        return pSpeed;
    }
    /**
     * mutator for player three pointer
     * @param tPoints sets the player three pointer
     */
    public void setPlayerThree(int tPoints) {
        this.pThree = tPoints;
    }
    /**
     * accessor method for the player three pointer
     * @return outputs the player three pointer
     */
    public int getPlayerThree() {
        return pThree;
    }
    /**
     * mutator for player dunk
     * @param dunk used to change player dunk
     */
    public void setPlayerDunk(int dunk) {
        this.pDunk = dunk;
    }
    /**
     * accessor method for player dunk
     * @return outputs player dunk
     */
    public int getPlayerDunk() {
        return pDunk;
    }
    /**
     * mutator method for player defense
     * @param defense set player defense
     */
    public void setPlayerDefense(int defense) {
        this.pDefense = defense;
    }
    /**
     * accessor method for player defense
     * @return outputs the player defense
     */
    public int getPlayerDefense() {
        return pDefense;
    }
    /**
     * accessor for the overall player rating
     * @return output the overall player rating
     */
    public int getPlayerScore() {
        return getPlayerSpeed() + getPlayerThree() + getPlayerDunk() + getPlayerDefense();
    }
    /**
     * output the player info
     * @return displays the player info
     */
    public String toString() {
        return "Name: " + pName + "\nSpeed: " + pSpeed + "/10\nThree Pointer: " + pThree + "/10\nDunk: " + pDunk + "/10\nDefense: " + pDefense + "/10";
    }

}
