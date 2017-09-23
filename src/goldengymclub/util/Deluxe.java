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
public class Deluxe extends Membership{
    private static Deluxe instance;

    private Deluxe() {
        super(500, 120);
    }
    
    public static Deluxe getInstance(){
        if(instance == null){
            Deluxe.instance = new Deluxe();
            return instance;
        }else{
            return instance;
        }
    }
    
}
