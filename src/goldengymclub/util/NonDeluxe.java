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
public class NonDeluxe extends Membership{
    private static NonDeluxe instance;

    private NonDeluxe() {
        super(300, 100);
    }
    
    public static NonDeluxe getInstance(){
        if(instance == null){
            NonDeluxe.instance = new NonDeluxe();
            return instance;
        }else{
            return instance;
        }
    }
}
