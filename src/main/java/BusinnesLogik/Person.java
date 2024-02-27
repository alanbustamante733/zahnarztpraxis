package BusinnesLogik;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
public class Person implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String ausweisnummer;
    private String name;
    private String nachname;
    private String telefon;
    private String adresse;
    @Temporal(TemporalType.DATE)
     Date geburtsdatum;

    public Person() {
    }

    public Person(int id, String ausweisnummer, String name, String nachname, String telefon, String adresse, Date geburtsdatum) {
        this.id = id;
        this.ausweisnummer = ausweisnummer;
        this.name = name;
        this.nachname = nachname;
        this.telefon = telefon;
        this.adresse = adresse;
        this.geburtsdatum = geburtsdatum;
    }
    
    

    public String getAusweisnummer() {
        return ausweisnummer;
    }

    public void setAusweisnummer(String ausweisnummer) {
        this.ausweisnummer = ausweisnummer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Date getGeburtsdatum() {
        return geburtsdatum;
    }

    public void setGeburtsdatum(Date geburtsdatum) {
        this.geburtsdatum = geburtsdatum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
