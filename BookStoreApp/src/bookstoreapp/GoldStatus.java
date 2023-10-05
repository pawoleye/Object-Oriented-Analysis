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
public class GoldStatus extends Status {
    private String Acc_Status = "Gold";

    public GoldStatus(){
        super("Gold");
    }
    
    public String getStatus(){
        return Acc_Status;
    }
    
    public Status setGold(){
        GoldStatus gold = new GoldStatus();
        return gold;
    }
    
    public Status setSilver(){
        SilverStatus silver = new SilverStatus();
        return silver;
    }
}
