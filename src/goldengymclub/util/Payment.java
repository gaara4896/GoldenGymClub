/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldengymclub.util;

import goldengymclub.util.Member;

/**
 *
 * @author Neoh
 */
public class Payment {
    
    private String date;
    private String person_entry;
    private String details;
    private Member member;
    private double amount;

    public Payment(String date, String person_entry, String details, Member member, double amount){
        this.date = date;
        this.person_entry = person_entry;
        this.member = member;
        this.details = details;
        this.amount = amount;
    }
    
    @Override
    public String toString(){
        
        return date + "     RM" + String.valueOf(amount) + "     " + person_entry + "     "+ details;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPerson_entry() {
        return person_entry;
    }

    public void setPerson_entry(String person_entry) {
        this.person_entry = person_entry;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
    
    
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
