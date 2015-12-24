/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package inteldriverfix;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Sanatt Abrol
 */
public class Inteldriverfix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        if(check())
            System.out.println("YES");
        
    }
    public static boolean check(){
        boolean dekh = false;
        try{
            
            ProcessBuilder builder = new ProcessBuilder(
            "cmd.exe", "/c", "D:\\IShortcuts\\Intelfix\\check.bat");
            builder.redirectErrorStream(true);
            Process p = builder.start(); 
            BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream()));
            String s,a="";  
            while((s=reader.readLine())!=null)
                  a+=s+"\n";
            System.out.println(a);
            if(a.contains("Driver is running"))
                dekh = true;
            }
        catch(HeadlessException | IOException e){ 
        System.out.println(e);
        }
        return dekh;
    }
}
