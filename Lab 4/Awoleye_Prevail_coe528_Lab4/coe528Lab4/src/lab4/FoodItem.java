/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;

/**
 *
 * @author preva
 */
public class FoodItem extends FoodComponent {
    private String name;
    private double price;
    
    public FoodItem(String n, double p){
        name = n;
        price = p;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void print(int level) {
        String indent = "";
        
        for (int i = 0; i < level; i++) {
            indent += "   ";
        }
        System.out.println(indent + "FoodItem: " + name +", " +price);
    }
    
}
