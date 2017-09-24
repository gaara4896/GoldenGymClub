/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldengymclub.util;

import goldengymclub.util.Membership;

/**
 *
 * @author Neoh
 */
public class Member {
    
    private String member_id;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private Membership membership;
    
    public Member(String memberid, String firstname, String lastname, String email, String phone, Membership membership){
        this.member_id = memberid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.membership = membership;
    }
    
    public Member(String memberid, String firstname, String lastname, String email, String phone){
        this(memberid, firstname, lastname, email, phone, null);
    }
    

    @Override
    public String toString(){
        return member_id + "     " + firstname + " " + lastname;
    }

    public String getMember_id() {
        return member_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }
   
    
}
