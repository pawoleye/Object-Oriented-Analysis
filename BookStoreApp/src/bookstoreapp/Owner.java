/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStoreApp;

import java.util.*;

/**
 *
 * @author apisa
 */

public class Owner {
    private static Owner instance;
    private ArrayList<Book> books = new ArrayList<Book>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    
    private Owner(){
        
    }
    
    public static Owner getInstance(){
        if(instance == null){
            instance = new Owner();
        }
        return instance;
    }
    
    public void addBook(Book b){
        books.add(b);
    }
    public void removeBook(Book b){
        books.remove(b);
    }
    
    public ArrayList<Book> getBooks(){
        return books;
    }
    
    public void addCustomer(Customer c){
        customers.add(c);
    }
    public void removeCustomer(Customer c){
        customers.remove(c);
    }
    
    public ArrayList<Customer> getCustomers(){
        return customers;
    }
    
}
