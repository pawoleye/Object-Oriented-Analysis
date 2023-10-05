/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

import java.util.ArrayList;


/**
 *
 * @author preva
 */
public class FoodCategory extends FoodComponent{
    private ArrayList<FoodComponent> list;  
    private final String name;
    private double price;

    public FoodCategory(String s) {
        name = s;
        list = new ArrayList<>();    
    }
    
    public void add(FoodComponent f){
        list.add(f);
    }
    
    public void remove(FoodComponent f){
        list.remove(f);
    }

     @Override
    public double getPrice() {
        double total=0;
        for (FoodComponent e : list){
            total += e.getPrice();
        }  
        return total;
    }

    @Override
    public void print(int level) {
        String indent = "";
        
        for (int i = 0; i < level; i++) {
            indent += "   ";
        }
        System.out.println(indent +"FoodCategory (" + name + ", " + getPrice() + ") contains: ");
        for (FoodComponent e : list){
            e.print(level+1);
        }
    }
}
