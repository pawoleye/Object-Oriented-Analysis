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
public class Member extends Passenger{
    private int yearsOfMembership;
                                            
    public Member(String name, int age) {
        super(name, age);
    }

    @Override
    public double applyDiscount(double p) {
        if (yearsOfMembership > 5){
            return (p-(p*0.5));
        }
        else if (yearsOfMembership >1 && yearsOfMembership < 5){
            return (p-(p*0.1));
        }
        return p;     
    }

    public int getYearsOfMembership() {
        return yearsOfMembership;
    }

    public void setYearsOfMembership(int yearsOfMembership) {
        this.yearsOfMembership = yearsOfMembership;
    }                       
}
