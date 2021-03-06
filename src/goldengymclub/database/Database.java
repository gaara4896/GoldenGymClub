/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldengymclub.database;

import goldengymclub.util.Admin;
import goldengymclub.util.Member;
import goldengymclub.util.Payment;
import goldengymclub.util.Deluxe;
import goldengymclub.util.NonDeluxe;
import goldengymclub.util.Weekday;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ng Wei Shyang
 */
public class Database {
    
    private static Database instance;

    private Database() {
    }
    
    public static Database getInstance(){
        if(instance == null){
            Database.instance = new Database();
            return instance;
        }else{
            return instance;
        }
    }
    
    public String generateMemberId(int membersSize){
        
        int memberIdInt = 1000000 + membersSize + 1;
        
        return String.valueOf(memberIdInt);
    }
    
    public boolean addAdmin(Admin admin){
        File file = new File("Admin.txt");
        if(file.exists()){
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("Admin.txt", true));
                bw.write(admin.getUsername() + " " + admin.getPassword());
                bw.newLine();
                bw.flush();
                bw.close();
                return true;
            } catch (IOException ex) {
                return false;
            }
        } else {
            try {
                PrintWriter writer = new PrintWriter(file);
                writer.write(admin.getUsername() + " " + admin.getPassword() + "\n");
                writer.flush();
                writer.close();
                return true;
            } catch (FileNotFoundException ex) {
                return false;
            }
        }
    }
    
    public boolean searchAdmin(Admin admin){
        try {
            Scanner sc = new Scanner(new File("Admin.txt"));
            while(sc.hasNext()){
                if(admin.getUsername().equals(sc.next())){
                    if(admin.getPassword().equals(sc.next())){
                        sc.close();
                        return true;
                    }
                }
            }
            return false;
        } catch (FileNotFoundException ex) {
            return false;
        }
    }
    
    public boolean addNewMember(Payment payment){
        File file = new File("Members.txt");
        Member member = payment.getMember();
        
        try {
            PrintWriter writer = new PrintWriter(new File(member.getMember_id() + ".txt"));
            String toWrite = payment.getDate() + " " + payment.getPerson_entry() + " "
                + payment.getDetails() + " " + payment.getMember().getMember_id() + " "
                + payment.getAmount();
            writer.write(toWrite + "\n");
            writer.flush();
            writer.close();
        }catch(Exception e){}     
        
        int membership;
        if(member.getMembership() instanceof Deluxe){
            membership = 0;
        } else if(member.getMembership() instanceof NonDeluxe){
            membership = 1;
        } else {
            membership = 2;
        }
        String toWrite = member.getMember_id() + " " + toTextFormat(member.getFirstname()) + " " 
                        + toTextFormat(member.getLastname()) + " " + member.getEmail() + " "
                        + member.getPhone() + " " + membership;
        if(file.exists()){
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("Members.txt", true));
                bw.write(toWrite);
                bw.newLine();
                bw.flush();
                bw.close();
                return true;
            } catch (IOException ex) {
                return false;
            }
        } else {
            try {
                PrintWriter writer = new PrintWriter(file);
                writer.write(toWrite + "\n");
                writer.flush();
                writer.close();
                return true;
            } catch (FileNotFoundException ex) {
                return false;
            }
        }
    }
    
    public ArrayList<Member> getAllMember(){
        
        ArrayList<Member> members = new ArrayList();
        
        try {
            Scanner sc = new Scanner(new File("Members.txt"));
            while(sc.hasNext()){
                Member member = new Member(sc.next(), toStringFormat(sc.next()), toStringFormat(sc.next()), sc.next(), sc.next());
                
                int membership = sc.nextInt();
                
                if(membership == 0){
                    member.setMembership(Deluxe.getInstance());
                } else if(membership == 1){
                    member.setMembership(NonDeluxe.getInstance());
                } else {
                    member.setMembership(Weekday.getInstance());
                }
                members.add(member);
            }
            return members;
        } catch (FileNotFoundException ex) {
            return members;
        }
    }
    
    public boolean modifyMember(Member memberModify){
        ArrayList<Member> members = Database.getInstance().getAllMember();
        Iterator<Member> i = members.iterator();
        BufferedWriter bw = null;
        
        try {
            bw = new BufferedWriter(new FileWriter("Members.txt", false));
        } catch (IOException ex) {
            return false;
        }
        
        while(i.hasNext()){
            Member member = i.next();
            if(member.getMember_id().equals(memberModify.getMember_id())){
                int membership;
                if(memberModify.getMembership() instanceof Deluxe){
                    membership = 0;
                } else if(memberModify.getMembership() instanceof NonDeluxe){
                    membership = 1;
                } else {
                    membership = 2;
                }

                String toWrite = memberModify.getMember_id() + " " + toTextFormat(memberModify.getFirstname()) + " " 
                        + toTextFormat(memberModify.getLastname()) + " " + memberModify.getEmail() + " "
                        + memberModify.getPhone() + " " + membership;
                try {
                    bw.write(toWrite);
                    bw.newLine();
                } catch (IOException ex) {
                    return false;
                }
            } else {
                int membership;
                if(member.getMembership() instanceof Deluxe){
                    membership = 0;
                } else if(member.getMembership() instanceof NonDeluxe){
                    membership = 1;
                } else {
                    membership = 2;
                }

                String toWrite = member.getMember_id() + " " + toTextFormat(member.getFirstname()) + " " 
                        + toTextFormat(member.getLastname()) + " " + member.getEmail() + " "
                        + member.getPhone() + " " + membership;
                try {
                    bw.write(toWrite);
                    bw.newLine();
                } catch (IOException ex) {
                    return false;
                }
            }
        }
        try {
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            return false;
        }
        return true;
    }
    
    public boolean checkIdAvailable(String id){
        ArrayList<Member> members = Database.getInstance().getAllMember();
        Iterator<Member> i = members.iterator();
        
        while(i.hasNext()){
            Member member = i.next();
            if(member.getMember_id().equals(id)){
                return false;
            }
        }
        return true;
    }
    
    public boolean insertPayment(Payment payment){

        String toWrite = payment.getDate() + " " + toTextFormat(payment.getPerson_entry()) + " "
                + toTextFormat(payment.getDetails()) + " " + payment.getAmount();
        try {
            BufferedWriter bw = new BufferedWriter(
                    new FileWriter(payment.getMember().getMember_id() + ".txt", true));
            bw.write(toWrite);
            bw.newLine();
            bw.flush();
            bw.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
    
    public ArrayList<Payment> getPaymentHistory(Member member){
        
        ArrayList<Payment> payments = new ArrayList();
        
        try {
            Scanner sc = new Scanner(new File(member.getMember_id() + ".txt"));
            while(sc.hasNext()){
                Payment payment = new Payment(sc.next(), toStringFormat(sc.next()), toStringFormat(sc.next()), 
                    member, sc.nextDouble());
                payments.add(payment);
            }
            return payments;
        } catch (FileNotFoundException ex) {
            return payments;
        }
    }
    
    public String toTextFormat(String details){
        
        String processed = details.replaceAll(" ", "_");
        
        return processed;
    }
    
    public String toStringFormat(String details){
        
        String processed = details.replaceAll("_", " ");
        
        return processed;
    }

}
