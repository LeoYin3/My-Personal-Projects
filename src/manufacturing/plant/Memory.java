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
public class Memory extends Component {

    private double response;
    private double capacity;
    private boolean full;
    private String name;
    private boolean broken;
    
    public Memory(){
    
    }
    
    public Memory(String name, boolean broken, double response, double capacity, boolean full){
        this.name = name;
        this.broken = broken;
        this.response = response;
        this.capacity = capacity;
        this.full = full;
    }
    
    public double getResponse(){
        return response;
    }
    
    public void setResponse(double response){
        this.response = response;
    }
    
    public double getCapacity(){
        return capacity;
    }
    
    public void setCapacity(double capacity){
        this.capacity = capacity;
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
        return "Memory";
    }
    
    @Override
    public int compareTo(Component x) {
        return this.getName().compareTo(x.getName());
    }
    
    @Override
    public String toString()
    {
        return "Name: " + name + "\nBroken: " + broken + "\nResponse: " + response + "\nCapacity: " + 
                capacity + "\nFull: " + full + "\n";
    }

}
