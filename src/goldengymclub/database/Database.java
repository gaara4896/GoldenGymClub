/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldengymclub.database;

import goldengymclub.Admin;
import goldengymclub.Member;
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
    
    public boolean addNewMember(Member member){
        File file = new File("Members.txt");
        int membership;
        if(member.getMembership() instanceof Deluxe){
            membership = 0;
        } else if(member.getMembership() instanceof NonDeluxe){
            membership = 1;
        } else {
            membership = 2;
        }
        String toWrite = member.getMember_id() + " " + member.getFirstname() + " " 
                        + member.getLastname() + " " + member.getEmail() + " "
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
                Member member = new Member(sc.next(), sc.next(), sc.next(), sc.next(), sc.next());
                if(sc.nextInt() == 0){
                    member.setMembership(Deluxe.getInstance());
                } else if(sc.nextInt() == 1){
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
    
    
    
}
