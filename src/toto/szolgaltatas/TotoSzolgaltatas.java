package toto.szolgaltatas;

import toto.tarolo.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;

public class TotoSzolgaltatas {

    private List<Fordulo> fajl = new ArrayList();

    public TotoSzolgaltatas() throws IOException {

        try (BufferedReader br = new BufferedReader(new BufferedReader(new FileReader("toto.csv"))) {
            String line;
            int j = 0;
            while ((line  = br.readLine()) !=null) {
            Fordulo sor = new Fordulo();
                String[] values = line.split(";");
                sor.setEv(Integer.parseInt(values[0]));
                sor.setHet(Integer.parseInt(values[1]));
        
            try{
                
                sor.setForduloAHeten(Integer.parseInt(values[2]));
                }
                catch(Exception e){
                    sor.setForduloAHeten(1);                                                                      
                }
                
            try{
                sor.setDatum(new SimpleDateFormat("yyy.mm.dd").parse(values[3]));
                }
                catch(Exception e){
             sor.setDatum(new SimpleDateFormat("yyy.mm.dd").parse("2019.03.03"));      
             }
                sor.setTalalatok(Integer.parseInt(values[4]), Integer.parseInt((values[5].substring(0, values[5].length() - 3)).replaceAll("\\s", "")));
                sor.setTalalatok(Integer.parseInt(values[6]), Integer.parseInt((values[7].substring(0, values[7].length() - 3)).replaceAll("\\s", "")));
                sor.setTalalatok(Integer.parseInt(values[8]), Integer.parseInt((values[9].substring(0, values[9].length() - 3)).replaceAll("\\s", "")));
                sor.setTalalatok(Integer.parseInt(values[10]), Integer.parseInt((values[11].substring(0, values[11].length() - 3)).replaceAll("\\s", "")));
                sor.setTalalatok(Integer.parseInt(values[12]), Integer.parseInt((values[13].substring(0, values[13].length() - 3)).replaceAll("\\s", "")));
                for (int i = 14; i < 28; i++) {
                    sor.setEredmenyek(values[i]);
                }
                fajl.add(sor);
                ++j;
        }

        } catch(FileNotFoundException ex) {
                    System.err.printf("Hiba: %s", ex.getMessage());
                } catch(IOException ex){
                    System.err.printf("Hiba: %s", ex.getMessage());
                }catch (Exception e){
                    System.err.printf("Hiba: %s", e.getMessage());
                    }               
                
                 }
    
        public List<Fordulo> getFajl() {
        return fajl;
    }

}
