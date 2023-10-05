/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

/**
 *
 * @author preva
 */
public class Ticket {
    private Passenger passenger;
    private Flight flight;
    private double price;
    private static int number;
        
    public Ticket(Passenger p,Flight flight,double price){
        this.passenger = p;
        this.flight = flight;
        this.price = price;
        number++;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static int getNumber() {
        return number;
    }

    public static void setNumber(int number) {
        Ticket.number = number;
    }
    
    @Override
    public String toString(){
      return passenger.getName() + ", Flight " + flight.getFlightNumber()+ ", " +flight.getOrigin() + " to " + flight.getDestination() + ", " +flight.getDepartureTime()+ ", original price: $" + flight.getOriginalPrice()+ ", ticket price: $" + getPrice();  
    }
}
