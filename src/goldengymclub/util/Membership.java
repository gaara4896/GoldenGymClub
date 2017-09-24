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
abstract public class Membership {
    protected int registrationFees;
    protected int monthlyFees;

    public Membership(int registrationFees, int monthlyFees) {
        this.registrationFees = registrationFees;
        this.monthlyFees = monthlyFees;
    }

    public int getRegistrationFees() {
        return registrationFees;
    }

    public int getMonthlyFees() {
        return monthlyFees;
    }

    
}
