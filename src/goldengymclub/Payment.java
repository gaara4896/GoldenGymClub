/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldengymclub;

/**
 *
 * @author Neoh
 */
public class Payment {
    
    private String date;
    private String person_entry;
    private double amount;
    private String details;
    private String member_id;

    public Payment(String date, String person_entry, String details, String member_id, double amount){
        this.date = date;
        this.person_entry = person_entry;
        this.member_id = member_id;
        this.details = details;
        this.amount = amount;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }
    
}
