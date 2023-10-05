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
public abstract class Status {
    private String Acc_Status;

    public Status(String status){
        Acc_Status = status;
    }
    public abstract String getStatus();
    public abstract Status setGold();
    public abstract Status setSilver();
}