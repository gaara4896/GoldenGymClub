/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldengymclub.util;

/**
 *
 * @author Ng Wei Shyang
 */
public class Weekday extends Membership{
    private static Weekday instance;

    private Weekday() {
        super(300, 100);
    }
    
    public static Weekday getInstance(){
        if(instance == null){
            Weekday.instance = new Weekday();
            return instance;
        }else{
            return instance;
        }
    }  
    
    @Override
    public String toString(){
        return "Week-Day";
    }
}
