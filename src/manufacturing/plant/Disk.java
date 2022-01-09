/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manufacturing.plant;

/**
 *
 * @author leoyi
 */
public class Disk extends Component{

    private double storage;
    private int slots;
    private boolean full;
    private String name;
    private boolean broken;
    
    public Disk(){
        
    }
    
    public Disk(String name, boolean broken, double storage, int slots, boolean full){
        this.name = name;
        this.broken = broken;
        this.storage = storage;
        this.slots = slots;
        this.full = full;
    }
    
    public double getStorage(){
        return storage;
    }
    
    public void setStorage(double storage){
        this.storage = storage;
    }
    
    public int getSlots(){
        return slots;
    }
    
    public void setSlots(int slots){
        this.slots = slots;
    }
    
    public boolean getFull(){
        return full;
    }
    
    public void setFull(boolean full){
        this.full = full;
    }
    
    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean getBroken() {
        return broken;
    }
    
    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public void setBroken(boolean broken) {
        this.broken = broken;
    }
    
    @Override
    public String getType(){
        return "Disk";
    }
    
    @Override
    public int compareTo(Component x) {
        return this.getName().compareTo(x.getName());
    }
    
    @Override
    public String toString()
    {
        return "Name: " + name + "\nBroken: " + broken + "\nStorage: "  + storage + "\nSlots: " + 
                slots + "\nFull: " + full + "\n";
}
}
