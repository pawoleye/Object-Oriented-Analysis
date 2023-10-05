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
public class Flight {
    private int flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private int capacity;
    private int numberOfSeatsLeft;
    private double originalPrice;
    
    public Flight(int flightNumber, String origin, String destination, String departureTime, int capacity, int numberOfSeatsLeft,int originalPrice){
        if (origin.equals(destination)){
            throw new IllegalArgumentException("Destination can not be the same as origin!"); 
        }
        
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.capacity = capacity;
        this.numberOfSeatsLeft = numberOfSeatsLeft;
        this.originalPrice = originalPrice;
        
        
    }

    /**
     * @return the flightNumber
     */
    public int getFlightNumber() {
        return flightNumber;
    }

    /**
     * @param flightNumber the flightNumber to set
     */
    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    /**
     * @return the origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * @param origin the origin to set
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * @return the departureTime
     */
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * @param departureTime the departureTime to set
     */
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * @return the numberOfSeatsLeft
     */
    public int getNumberOfSeatsLeft() {
        return numberOfSeatsLeft;
    }

    /**
     * @param numberOfSeatsLeft the numberOfSeatsLeft to set
     */
    public void setNumberOfSeatsLeft(int numberOfSeatsLeft) {
        this.numberOfSeatsLeft = numberOfSeatsLeft;
    }

    /**
     * @return the originalPrice
     */
    public double getOriginalPrice() {
        return originalPrice;
    }

    /**
     * @param originalPrice the originalPrice to set
     */
    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }
    
    public boolean bookASeat(){
      if (this.getNumberOfSeatsLeft() > 0){
          this.numberOfSeatsLeft--;
          return true;
      }
      return false;
    }
    
    /**
     *
         * @return string representation of the flight information  
     */
    @Override
    public String toString() {
        return "Flight " + flightNumber + ", " + origin + " to " + destination + ", " + departureTime + ", original price: $" + originalPrice ;
    } 


}
