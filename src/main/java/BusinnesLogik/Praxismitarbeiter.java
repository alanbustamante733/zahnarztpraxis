package BusinnesLogik;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Praxismitarbeiter  extends Person {
    
    //private int id_praxismitarbeiter;
    private String Abteilung;
    @OneToOne
    private Nutzer einNutzer;

    public Praxismitarbeiter() {
    }

    public Praxismitarbeiter(String Abteilung, Nutzer einNutzer, int id, String ausweisnummer, String name, String nachname, String telefon, String adresse, Date geburtsdatum) {
        super(id, ausweisnummer, name, nachname, telefon, adresse, geburtsdatum);
        this.Abteilung = Abteilung;
        this.einNutzer = einNutzer;
    }

    public String getFormatiertesDatum () {
        SimpleDateFormat formatDesDatum = new SimpleDateFormat("dd-MM-yyyy");
        
        return formatDesDatum.format(geburtsdatum);
    }
    
    public String getAbteilung() {
        return Abteilung;
    }

    public void setAbteilung(String Abteilung) {
        this.Abteilung = Abteilung;
    }

    public Nutzer getEinNutzer() {
        return einNutzer;
    }

    public void setEinNutzer(Nutzer einNutzer) {
        this.einNutzer = einNutzer;
    }
    
}
