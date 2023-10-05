/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.util.ArrayList;        
import java.util.Scanner;

/**
 *
 * @author preva
 */
public class Manager {
    ArrayList<Flight> f = new ArrayList<Flight>();
    ArrayList<Ticket> t = new ArrayList<Ticket>();

    public void createFlights(){
        Scanner input = new Scanner(System.in);
        int noFlights,flightN,capacity,noSeats,oPrice;
        String origin,destination,depT;
        
        System.out.println("How many flights are being entered:");
        noFlights = input.nextInt();
        System.out.println("");
        
        for(int i=0; i < noFlights; i++){
            System.out.println("For flight " +(i+1));
            System.out.println("Enter Flight Number:");
            flightN = input.nextInt();
            System.out.println("Enter Origin:");
            origin = input.next();
            System.out.println("Enter Destination:");
            destination = input.next();
            System.out.println("Enter departure time:");
            depT = input.next();                          //For this enter time like 7pm
            System.out.println("Enter Capacity:");
            capacity = input.nextInt();
            System.out.println("Enter Number of Seats left:");
            noSeats = input.nextInt();
            System.out.println("Enter Original Price:");
            oPrice = input.nextInt();
            
            f.add(new Flight(flightN,origin,destination,depT,capacity,noSeats,oPrice));
        }
        
    }
    
    public void displayAvailableFlights(String origin, String destination){
        for(Flight fly : f){
            if (fly.getOrigin().equals(origin) && fly.getDestination().equals(destination) && fly.getNumberOfSeatsLeft() != 0){
                System.out.println(fly.getNumberOfSeatsLeft()+" seat(s) is left for "+fly);
            }
            else{
                System.out.println("Unfortunately that flight is not available.");
            }
        }
    }
    
    public Flight getFlight(int flightNumber){
        for(Flight fly : f){
            if (fly.getFlightNumber() == flightNumber){
                return fly;
            }
        }
     return null;   
    }
    
    public void bookSeat(int flightNumber, Passenger p){  
        Flight fly = getFlight(flightNumber);
        if(fly != null && fly.getNumberOfSeatsLeft() > 0){
            t.add(new Ticket(p,fly,fly.getOriginalPrice()));
            for(Ticket tick : t){
                if(tick.getPassenger() == p && tick.getFlight()== fly){
                    tick.setPrice(p.applyDiscount(fly.getOriginalPrice()));
                    System.out.println(tick + " is successfully booked.");
                    fly.bookASeat();
                    break;
                }
        }
                       
        }  
        else{
            System.out.println("Unfortunately flight is not available to be booked for: " + p.getName());
        }
    }
    
    public static void main(String[] args){
        Manager m1 = new Manager();    
        m1.createFlights();
        System.out.println("");
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter flights to look for:");
        System.out.println("From:");
        String from = input.next();
        System.out.println("To:");
        String to = input.next();
        m1.displayAvailableFlights(from, to);
        System.out.println("");
                
        Member p1 = new Member("Jack Black", 35);
        p1.setYearsOfMembership(6);     
        System.out.println("");
        m1.bookSeat(01, p1);
        
        System.out.println("");
        NonMember p2 = new NonMember ("Taylor Swift", 66);
        m1.bookSeat(01, p2);
        
        System.out.println("");
        
        Member p3 = new Member("Dani Green", 25);
        p3.setYearsOfMembership(2);
        m1.bookSeat(01, p3);
        
        System.out.println("");
        
        NonMember p4 = new NonMember("Olivia Young", 19);
        m1.bookSeat(2, p4);
    }
    
}
