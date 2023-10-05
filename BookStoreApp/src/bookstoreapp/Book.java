/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStoreApp;

import java.lang.Object;
import javafx.scene.*;
import javafx.scene.control.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *
 * @author apisa
 */
public class Book {
    
    private String bookName;
    private double bookPrice;
    private CheckBox bookSelect;
    
    public Book(String name, double price){
        bookName = name;
        bookPrice = price;
        bookSelect = new CheckBox();
    }
    
    public String getBookName(){
        return bookName;
    }
    public void setBookName(String name){
        bookName = name;
    }
    
    public double getBookPrice(){
        return bookPrice;
    }
    public void setBookPrice(double price){
        bookPrice = price;
    }
    
    public CheckBox getBookSelect(){
        return bookSelect;
    }
    
}
