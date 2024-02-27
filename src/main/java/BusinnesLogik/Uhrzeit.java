package BusinnesLogik;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Uhrzeit implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_uhrzeit;
    private String anfangsuhrzeit;
    private String endeuhrzeit;

    public Uhrzeit() {
    }

    public Uhrzeit(int id_uhrzeit, String anfangsuhrzeit, String endeuhrzeit) {
        this.id_uhrzeit = id_uhrzeit;
        this.anfangsuhrzeit = anfangsuhrzeit;
        this.endeuhrzeit = endeuhrzeit;
    }

    public int getId_uhrzeit() {
        return id_uhrzeit;
    }

    public void setId_uhrzeit(int id_uhrzeit) {
        this.id_uhrzeit = id_uhrzeit;
    }

    public String getAnfangsuhrzeit() {
        return anfangsuhrzeit;
    }

    public void setAnfangsuhrzeit(String anfangsuhrzeit) {
        this.anfangsuhrzeit = anfangsuhrzeit;
    }

    public String getEndeuhrzeit() {
        return endeuhrzeit;
    }

    public void setEndeuhrzeit(String endeuhrzeit) {
        this.endeuhrzeit = endeuhrzeit;
    }
    
    
    
}
