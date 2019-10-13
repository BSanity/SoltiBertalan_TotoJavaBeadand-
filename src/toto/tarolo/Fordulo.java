package toto.tarolo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Fordulo {
    
        private int ev;
    private int het;
    private int forduloAHeten;
    private Date datum;
    private List<Talalat> talalatok=new ArrayList();
    private List<String> eredmenyek=new ArrayList();

    public int getEv() {
        return ev;
    }

    public void setEv(int ev) {
        this.ev = ev;
    }

    public int getHet() {
        return het;
    }

    public void setHet(int het) {
        this.het = het;
    }

    public int getForduloAHeten() {
        return forduloAHeten;
    }

    public void setForduloAHeten(int forduloAHeten) {
        this.forduloAHeten = forduloAHeten;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public List<Talalat> getTalalatok() {
        return talalatok;
    }

    public void setTalalatok(int a, int b) {
        Talalat pont=new Talalat(a,b);
        
        this.talalatok.add(pont);
    }

    public List<String> getEredmenyek() {
        return eredmenyek;
    }

    public void setEredmenyek(String tipp) {
        this.eredmenyek.add(tipp);
    }

}

    
    
