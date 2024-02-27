package BusinnesLogik;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Patient extends Person implements Serializable {
    
  
    private String istSozialversichert;
    private String istPrivatversichert;
    private String bluttgruppe;
    @OneToOne
    private GesetzlicherVertreter einGesetzlicherVertreter;
    @OneToMany (mappedBy="patien")
    private List<Termin> ListeTermin;

    public Patient() {
    }

    public Patient(String istSozialversichert, String istPrivatversichert, String bluttgruppe, GesetzlicherVertreter einGesetzlicherVertreter, List<Termin> ListeTermin, int id, String ausweisnummer, String name, String nachname, String telefon, String adresse, Date geburtsdatum) {
        super(id, ausweisnummer, name, nachname, telefon, adresse, geburtsdatum);
        this.istSozialversichert = istSozialversichert;
        this.istPrivatversichert = istPrivatversichert;
        this.bluttgruppe = bluttgruppe;
        this.einGesetzlicherVertreter = einGesetzlicherVertreter;
        this.ListeTermin = ListeTermin;
    }



    public String getIstSozialversichert() {
        return istSozialversichert;
    }

    public void setIstSozialversichert(String istSozialversichert) {
        this.istSozialversichert = istSozialversichert;
    }

    public String getIstPrivatversichert() {
        return istPrivatversichert;
    }

    public void setIstPrivatversichert(String istPrivatversichert) {
        this.istPrivatversichert = istPrivatversichert;
    }

    

    public String getBluttgruppe() {
        return bluttgruppe;
    }

    public void setBluttgruppe(String bluttgruppe) {
        this.bluttgruppe = bluttgruppe;
    }

    public GesetzlicherVertreter getEinGesetzlicherVertreter() {
        return einGesetzlicherVertreter;
    }

    public void setEinGesetzlicherVertreter(GesetzlicherVertreter einGesetzlicherVertreter) {
        this.einGesetzlicherVertreter = einGesetzlicherVertreter;
    }

    public List<Termin> getListeTermin() {
        return ListeTermin;
    }

    public void setListeTermin(List<Termin> ListeTermin) {
        this.ListeTermin = ListeTermin;
    }

    

    
}
