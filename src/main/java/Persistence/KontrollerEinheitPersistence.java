
package Persistence;

import BusinnesLogik.GesetzlicherVertreter;
import BusinnesLogik.Nutzer;
import BusinnesLogik.Patient;
import BusinnesLogik.Praxismitarbeiter;
import BusinnesLogik.Zahnarzt;
import Persistence.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KontrollerEinheitPersistence {
    
    UhrzeitJpaController uhrzeitJPA = new UhrzeitJpaController();
    ZahnarztJpaController zahnarztJPA = new ZahnarztJpaController();
    PatientJpaController patientJPA = new PatientJpaController();
    PersonJpaController personJPA = new PersonJpaController();
    GesetzlicherVertreterJpaController gesetzlichervertreterJPA = new GesetzlicherVertreterJpaController();
    PraxismitarbeiterJpaController praxismitarbeiterJPA = new PraxismitarbeiterJpaController();
    TerminJpaController terminJPA = new TerminJpaController();
    NutzerJpaController nutzerJPA = new NutzerJpaController();

    public KontrollerEinheitPersistence() {
    }
    
    
    
    
    public void nutzerErstellen(Nutzer nutz) {
        nutzerJPA.create(nutz);
    }

    public List<Nutzer> getNutzer() {
        return nutzerJPA.findNutzerEntities();
    }

    public void nutzerLoeschen(int id) {
        try {
            nutzerJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(KontrollerEinheitPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Nutzer nutzerBringen(int id) {
        return nutzerJPA.findNutzer(id);
    }

    public void nutzerBearbeiten(Nutzer nutz) {
        try {
            nutzerJPA.edit(nutz);
        } catch (Exception ex) {
            Logger.getLogger(KontrollerEinheitPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Zahnarzt> getZahnaerzte() {
        return zahnarztJPA.findZahnarztEntities();
    }

    public void zahnarztErstellen(Zahnarzt zahn) {
        zahnarztJPA.create(zahn);
    }

    public void zahnarztLoeschen(int id) {
        try {
            zahnarztJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(KontrollerEinheitPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void zahnarztBearbeiten(Zahnarzt zahn) {
        try {
            zahnarztJPA.edit(zahn);
        } catch (Exception ex) {
            Logger.getLogger(KontrollerEinheitPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Zahnarzt zahnarztBringen(int id) {
        return zahnarztJPA.findZahnarzt(id);
    }

    public void praxisMitarbeiterErstellen(Praxismitarbeiter praxis) {
        
        praxismitarbeiterJPA.create(praxis);
        
    }

    public List<Praxismitarbeiter> getPraxisMitarbeiter() {
        return praxismitarbeiterJPA.findPraxismitarbeiterEntities();
    }

    public void praxisMitarbeiterLoeschen(int id) {
        try {
            praxismitarbeiterJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(KontrollerEinheitPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Praxismitarbeiter praxisMitarbeiterBringen(int id) {
        return praxismitarbeiterJPA.findPraxismitarbeiter(id);
    }

    public void praxisMitarbeiterBearbeiten(Praxismitarbeiter praxis) {
        try {
            praxismitarbeiterJPA.edit(praxis);
        } catch (Exception ex) {
            Logger.getLogger(KontrollerEinheitPersistence.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void patientErstellen(Patient pati) {
        
        patientJPA.create(pati);
        
    }

    public void vertreterErstellen(GesetzlicherVertreter vertre) {
        
        gesetzlichervertreterJPA.create(vertre);
        
    }

    

    
    
    
    
}
