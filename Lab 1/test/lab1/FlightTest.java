/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;
import org.junit.Test;  
import static org.junit.Assert.*;

/**
 *
 * @author preva
 */
public class FlightTest {

    /**
     * Test of getFlightNumber method, of class Flight.
     */
    Flight f1 = new Flight(1,"Toronto","London","17/01/23 7pm",500,250,450);

    @Test
    public void testConstructor(){
            assertEquals(1,f1.getFlightNumber());
            assertEquals("Toronto",f1.getOrigin());
            assertEquals("London",f1.getDestination());
            assertEquals("17/01/23 7pm",f1.getDepartureTime());
            assertEquals(500,f1.getCapacity());
            assertEquals(250,f1.getNumberOfSeatsLeft());
            assertEquals(450,f1.getOriginalPrice(),0);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructor(){
            Flight f2 = new Flight(1,"Toronto","Toronto","17/01/23 7pm",500,250,450);       
    }
    
    Flight f3  = new Flight(200,"New York","Mexico City","30/03/23 8pm",750,100,200);
    
    @Test
    public void testGetFlightNumber() {
        assertEquals(200,f3.getFlightNumber());
    }

    /**
     * Test of setFlightNumber method, of class Flight.
     */
    @Test
    public void testSetFlightNumber() {
        f3.setFlightNumber(221);
        assertEquals(221,f3.getFlightNumber());
    }

    /**
     * Test of getOrigin method, of class Flight.
     */
    @Test
    public void testGetOrigin() {
        assertEquals("New York",f3.getOrigin());
    }

    /**
     * Test of setOrigin method, of class Flight.
     */
    @Test
    public void testSetOrigin() {
        f3.setOrigin("Las Vegas");
        assertEquals("Las Vegas",f3.getOrigin());
    }

    /**
     * Test of getDestination method, of class Flight.
     */
    @Test
    public void testGetDestination() {
        assertEquals("Mexico City",f3.getDestination());
    }

    /**
     * Test of setDestination method, of class Flight.
     */
    @Test
    public void testSetDestination() {
        f3.setDestination("Lagos");
        assertEquals("Lagos",f3.getDestination());
    }

    /**
     * Test of getDepartureTime method, of class Flight.
     */
    @Test
    public void testGetDepartureTime() {
        assertEquals("30/03/23 8pm",f3.getDepartureTime());
    }

    /**
     * Test of setDepartureTime method, of class Flight.
     */
    @Test
    public void testSetDepartureTime() {
        f3.setDepartureTime("28/02/23 9pm");
        assertEquals("28/02/23 9pm",f3.getDepartureTime());
    }

    /**
     * Test of getCapacity method, of class Flight.
     */
    @Test
    public void testGetCapacity() {
        assertEquals(750,f3.getCapacity());
    }

    /**
     * Test of setCapacity method, of class Flight.
     */
    @Test
    public void testSetCapacity() {
        f3.setCapacity(700);
        assertEquals(700,f3.getCapacity());
    }

    /**
     * Test of getNumberOfSeatsLeft method, of class Flight.
     */
    @Test
    public void testGetNumberOfSeatsLeft() {
        assertEquals(100,f3.getNumberOfSeatsLeft());
    }

    /**
     * Test of setNumberOfSeatsLeft method, of class Flight.
     */
    @Test
    public void testSetNumberOfSeatsLeft() {
        f3.setNumberOfSeatsLeft(0);
        assertEquals(0,f3.getNumberOfSeatsLeft());
    }

    /**
     * Test of getOriginalPrice method, of class Flight.
     */
    @Test
    public void testGetOriginalPrice() {
        assertEquals(200,f3.getOriginalPrice(),0);
    }

    /**
     * Test of setOriginalPrice method, of class Flight.
     */
    @Test
    public void testSetOriginalPrice() {
        f3.setOriginalPrice(300);
        assertEquals(300,f3.getOriginalPrice(),0);
    }

    /**
     * Test of bookASeat method, of class Flight.
     */
    @Test
    public void testBookASeat() {       
        Flight f4 = new Flight(1,"Toronto","Montreal","17/04/23 7pm",500,0,150);
        assertFalse(f4.bookASeat());
    }

    /**
     * Test of toString method, of class Flight.
     */
    @Test
    public void testToString() {
       assertEquals("Flight 200, New York to Mexico City, 30/03/23 8pm, original price: $200.0",f3.toString());
    }
    
}
