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
public class Member {
    
    public static final String MEMBERSHIP_DELUXE = "Deluxe";
    public static final String MEMBERSHIP_NON_DELUXE = "Non-Deluxe";
    public static final String MEMBERSHIP_WEEK_DAY = "Week-Day";
    
    private String member_id;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private String membership;
    
    public Member(String memberid, String firstname, String lastname, String email, String phone, String membership){
        this.member_id = memberid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.membership = membership;
    }
    
    
    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }
   
    
}
