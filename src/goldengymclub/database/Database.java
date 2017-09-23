/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldengymclub.database;

import goldengymclub.Admin;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
    
    public boolean addMember(){
        return true;
    }
    
    
    
}
