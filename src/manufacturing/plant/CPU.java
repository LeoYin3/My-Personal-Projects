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
public class CPU extends Component {

    private double speed;
    private int processors;
    private boolean virtualization;
    private String name;
    private boolean broken;
    
    public CPU(){
        
    }
    
    public CPU(String name, boolean broken, double speed, int processors, boolean virtualization){
        this.name = name;
        this.broken = broken;
        this.speed = speed;
        this. processors = processors;
        this.virtualization = virtualization;
    }
    public double getSpeed(){
        return speed;
    }
    
    public void setSpeed(double speed){
        this.speed = speed;
    }
    
    public int getProcessors(){
        return processors;
    }
    
    public void setProcessors(int processors){
        this.processors = processors;
    }
    
    public boolean getVirtualization(){
        return virtualization;
    }
    
    public void setVirtualization(boolean virtualization){
        this.virtualization = virtualization;
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
        return "CPU";
    }
    
    @Override
    public String toString()
    {
        return "Name: " + name + "\nBroken: " + broken + "\nSpeed: " + speed + "\nProcessors: " + 
                processors + "\nVirtualization: " + virtualization + "\n";
    }

    @Override
    public int compareTo(Component x) {
        return this.getName().compareTo(x.getName());
    }
}
