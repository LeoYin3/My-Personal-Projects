/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manufacturing.plant;

import java.util.*;

/**
 *
 * @author leoyi
 */
public abstract class Component 
{
    private String name;
    private boolean broken;
    
    
    public Component()
    {
        
    }
    public Component(String name, boolean broken)
    {
        this.name = name;
        this.broken = broken;
    }    
   
    public abstract String getName();
    public abstract boolean getBroken();
    public abstract String getType();
    public abstract void setName(String name);
    public abstract void setBroken(boolean broken);
    public static Comparator<Component> compName = new Comparator<Component>() {

	public int compare(Component s1, Component s2) {
	   String comp1 = s1.getName();
	   String comp2 = s2.getName();
	   return comp1.compareTo(comp2);
    }
    };
    public abstract int compareTo(Component x);
    
    @Override
    public String toString()
    {
        return "Name: " + name + "\nBroken: " + broken + "\n";
    }
    
}
