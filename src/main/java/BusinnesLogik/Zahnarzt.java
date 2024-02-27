package BusinnesLogik;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Zahnarzt extends Person {
    
    //private int id_zahnarzt;
    private String fachrichtung;
    @OneToMany (mappedBy="zahnar")
    private List<Termin> ListeTermin;
    @OneToOne
    private Nutzer einNutzer;
    @OneToOne
    private Uhrzeit einUhrzeit;

    public Zahnarzt() {
    }

    public Zahnarzt(String fachrichtung, List<Termin> ListeTermin, Nutzer einNutzer, Uhrzeit einUhrzeit, int id, String ausweisnummer, String name, String nachname, String telefon, String adresse, Date geburtsdatum) {
        super(id, ausweisnummer, name, nachname, telefon, adresse, geburtsdatum);
        this.fachrichtung = fachrichtung;
        this.ListeTermin = ListeTermin;
        this.einNutzer = einNutzer;
        this.einUhrzeit = einUhrzeit;
    }
    
    public String getFormatiertesDatum () {
        SimpleDateFormat formatDesDatum = new SimpleDateFormat("dd-MM-yyyy");
        
        return formatDesDatum.format(geburtsdatum);
    }
    
    public String getFachrichtung() {
        return fachrichtung;
    }

    public void setFachrichtung(String fachrichtung) {
        this.fachrichtung = fachrichtung;
    }

    public List<Termin> getListeTermin() {
        return ListeTermin;
    }

    public void setListeTermin(List<Termin> ListeTermin) {
        this.ListeTermin = ListeTermin;
    }

    public Nutzer getEinNutzer() {
        return einNutzer;
    }

    public void setEinNutzer(Nutzer einNutzer) {
        this.einNutzer = einNutzer;
    }

    public Uhrzeit getEinUhrzeit() {
        return einUhrzeit;
    }

    public void setEinUhrzeit(Uhrzeit einUhrzeit) {
        this.einUhrzeit = einUhrzeit;
    }
    
    
    
}
