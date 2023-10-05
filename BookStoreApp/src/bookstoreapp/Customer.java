/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookStoreApp;

/**
 *
 * @author apisa
 */
public class Customer {

    private String username;
    private String password;
    private double points;
    private Status status;

    public Customer(String user_name, String pass_word) {
        username = user_name;
        password = pass_word;
        points = 0;
        status = new SilverStatus();
    }

    public String displayLoginMessage() {
        return ("Welcome " + username + ". " + "You have " + Math.round(points) + " points. Your status is " + status.getStatus() + ".");
    }

    public Status getStatus() {
        return status;
    }

    public String getPassword() {
        return password;
    }

    public double getPoints() {
        return points;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String n) {
        this.password = n;
    }

    public void setPoints(double p) {
        this.points = p;
        if (points > 1000) {
            status = status.setGold();
        } else {
            status = status.setSilver();
        }
    }

    public void setStatus(Status s) {
        status = s;
    }

    public void setUsername(String u) {
        this.username = u;
    }

}
