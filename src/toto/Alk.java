package toto;

import toto.szolgaltatas.*;
import toto.tarolo.*;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;


public class Alk {
    public static void main (String args[]){
    TotoSzolgaltatas start= new TotoSzolgaltatas();
    List<Fordulo> fajl=start.getFajl();
    int maximum=0;
    
    double[] szamlalo=new double[4];
    Date datum=null;
    int talalatok=14;
    int nyeremeny=0;
    for (int i=0; i< 4; ++i){
    szamlalo[i] =0;   
    }
    
    for(Fordulo sor:fajl){
            for (Talalat tal: sor.getTalalatok()) {
                if (tal.getNyeremeny()>maximum) {
                    maximum=tal.getNyeremeny();
                }
            }
            for (String er: sor.getEredmenyek()) {
                if (er.equals("1")) {
                    szamlalo[0] +=1;
                }
                else if (er.equals("2")) {
                    szamlalo[1]+=1;
                }
                else 
                {
                    szamlalo[2] +=1;
                }
                szamlalo[3] +=1;
                   
            }                
        }
        System.out.println(maximum+"FT");
        System.out.println((szamlalo[0]/szamlalo[3]*100)+"% "+
                (szamlalo[1]/szamlalo[3]*100) + "% " +
                (szamlalo[2]/szamlalo[3]*100) + "% ");
        Scanner in=new Scanner(System.in);
        System.out.println("Date (yyy.mm.dd): ");
        String s=in.nextLine();
        try {
            datum =new SimpleDateFormat("yyyy.mm.dd").parse(s);
            
        }
        catch(Exception e){
            System.out.printf("Hiba: %s", e.getMessage());
            
        }
        
        System.out.println("Tipp: ");
        s=in.nextLine();
        
        for (Fordulo sor: fajl) {
            if (sor.getDatum().equals(datum)) {
                nyeremeny=sor.getTalalatok().get(14-talalatok).getNyeremeny();
                for (int i=0; i<s.length(); ++i) {
                    if (s.charAt(i) !=sor.getEredmenyek().get(i).charAt(0))
                    {
                        --talalatok;
                        nyeremeny=sor.getTalalatok().get(14-talalatok).getNyeremeny();
                    }
                    
                }
            }
        }if (talalatok>9) {
            System.out.println("Talalatok: "+talalatok+"Nyeremeny: "+nyeremeny);
                }
            
        }
        
    
    }
    
       
 
    
    
    
    
    

