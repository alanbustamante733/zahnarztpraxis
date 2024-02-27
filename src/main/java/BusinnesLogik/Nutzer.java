
package BusinnesLogik;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nutzer implements Serializable {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_nutzer;
    private String nutzerName;
    private String password;
    private String rolle;

    public Nutzer() {
    }

    public Nutzer(int id_nutzer, String nutzerName, String password, String rolle) {
        this.id_nutzer = id_nutzer;
        this.nutzerName = nutzerName;
        this.password = password;
        this.rolle = rolle;
    }

    public int getId_nutzer() {
        return id_nutzer;
    }

    public void setId_nutzer(int id_nutzer) {
        this.id_nutzer = id_nutzer;
    }

    public String getNutzerName() {
        return nutzerName;
    }

    public void setNutzerName(String nutzerName) {
        this.nutzerName = nutzerName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRolle() {
        return rolle;
    }

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }

}
