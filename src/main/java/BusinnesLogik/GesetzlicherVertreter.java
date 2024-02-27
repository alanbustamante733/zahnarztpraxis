
package BusinnesLogik;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;

@Entity
public class GesetzlicherVertreter extends Person implements Serializable {
    
    private String artDerVerantwortung;
    

    public GesetzlicherVertreter() {
    }

    public GesetzlicherVertreter(String artDerVerantwortung, int id, String ausweisnummer, String name, String nachname, String telefon, String adresse, Date geburtsdatum) {
        super(id, ausweisnummer, name, nachname, telefon, adresse, geburtsdatum);
        this.artDerVerantwortung = artDerVerantwortung;
    }



    public String getArtDerVerantwortung() {
        return artDerVerantwortung;
    }

    public void setArtDerVerantwortung(String artDerVerantwortung) {
        this.artDerVerantwortung = artDerVerantwortung;
    }



    public Date getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(Date geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }




    
}
