package BusinnesLogik;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Termin implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_termin;
    @Temporal(TemporalType.DATE)
    private Date terminDatum;
    private String terminUhrzeit;
    private String erkrankung;
    @ManyToOne
    @JoinColumn(name="id_zahnar")
    private Zahnarzt zahnar;
    
    @ManyToOne
    @JoinColumn(name="id_patie")
    private Patient patien;

    public Termin() {
    }

    public Termin(int id_termin, Date terminDatum, String terminUhrzeit, String erkrankung) {
        this.id_termin = id_termin;
        this.terminDatum = terminDatum;
        this.terminUhrzeit = terminUhrzeit;
        this.erkrankung = erkrankung;
    }

    public int getId_termin() {
        return id_termin;
    }

    public void setId_termin(int id_termin) {
        this.id_termin = id_termin;
    }

    public Date getTerminDatum() {
        return terminDatum;
    }

    public void setTerminDatum(Date terminDatum) {
        this.terminDatum = terminDatum;
    }

    public String getTerminUhrzeit() {
        return terminUhrzeit;
    }

    public void setTerminUhrzeit(String terminUhrzeit) {
        this.terminUhrzeit = terminUhrzeit;
    }

    public String getErkrankung() {
        return erkrankung;
    }

    public void setErkrankung(String erkrankung) {
        this.erkrankung = erkrankung;
    }
    
    
}
