
package BusinnesLogik;

import Persistence.KontrollerEinheitPersistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KontrollerEinheit {
    
    KontrollerEinheitPersistence kontrollPersis = new KontrollerEinheitPersistence();
    
    public void nutzerErstellen (String nutzerName, String password, String rolle ) {
        
        Nutzer nutz = new Nutzer();
        nutz.setNutzerName(nutzerName);
        nutz.setPassword(password);
        nutz.setRolle(rolle);
        
        kontrollPersis.nutzerErstellen(nutz);
        
    }

    public List <Nutzer> getNutzer() {
        
        return kontrollPersis.getNutzer();
        
        
    }

    public void nutzerLoeschen(int id) {
        kontrollPersis.nutzerLoeschen(id);
    }

    public Nutzer nutzerBringen(int id) {
        return kontrollPersis.nutzerBringen(id);
    }

    public void nutzerBearbeiten(Nutzer nutz) {
        kontrollPersis.nutzerBearbeiten(nutz);
    }

    public List <Zahnarzt> getZahnaerzte() {
        
        return kontrollPersis.getZahnaerzte();
    }

    public void zahnarztErstellen(String ausweisnummer, String name, String nachname, String telefon, String adresse, String fachrichtung, Date geburtsdatum) {
        
        Zahnarzt zahn = new Zahnarzt();
        zahn.setAusweisnummer(ausweisnummer);
        zahn.setName(name);
        zahn.setNachname(nachname);
        zahn.setTelefon(telefon);
        zahn.setAdresse(adresse);
        zahn.setFachrichtung(fachrichtung);
        zahn.setGeburtsdatum(geburtsdatum);
        
        
        kontrollPersis.zahnarztErstellen(zahn);
        
    }

    public void zahnarztLoeschen(int id) {
        kontrollPersis.zahnarztLoeschen(id);
    }

    public void zahnarztBearbeiten(Zahnarzt zahn) {
        kontrollPersis.zahnarztBearbeiten(zahn);
    }

    public Zahnarzt zahnarztBringen(int id) {
        return kontrollPersis.zahnarztBringen(id);
    }
    
    

    public void praxisMitarbeiterErstellen(String ausweisnummer, String name, String nachname, String telefon, String adresse, String abteilung, Date geburtsdatum) {
        
        Praxismitarbeiter praxis = new Praxismitarbeiter();
        praxis.setAusweisnummer(ausweisnummer);
        praxis.setName(name);
        praxis.setNachname(nachname);
        praxis.setTelefon(telefon);
        praxis.setAdresse(adresse);
        praxis.setAbteilung(abteilung);
        praxis.setGeburtsdatum(geburtsdatum);
        
        
        kontrollPersis.praxisMitarbeiterErstellen(praxis);
        
    }

    public List<Praxismitarbeiter> getPraxisMitarbeiter() {
        
        return kontrollPersis.getPraxisMitarbeiter();
    }

    public void praxisMitarbeiterLoeschen(int id) {
        kontrollPersis.praxisMitarbeiterLoeschen(id);
    }

    public Praxismitarbeiter praxisMitarbeiterBringen(int id) {
        return kontrollPersis.praxisMitarbeiterBringen(id);
    }


    public void praxismitarbeiterBearbeiten(Praxismitarbeiter praxis) {
        kontrollPersis.praxisMitarbeiterBearbeiten(praxis);
    }

    public void patientErstellen(String ausweisnummer, String name, String nachname, String telefon, String adresse, Date geburtsdatum, String tSozialversichert, String tPrivatversichert, String bluttgruppe) {
        
        Patient pati = new Patient();
        pati.setAusweisnummer(ausweisnummer);
        pati.setName(name);
        pati.setNachname(nachname);
        pati.setTelefon(telefon);
        pati.setAdresse(adresse);
        pati.setGeburtsdatum(geburtsdatum);
        pati.setIstSozialversichert(tSozialversichert);
        pati.setIstPrivatversichert(tPrivatversichert);
        pati.setBluttgruppe(bluttgruppe);
        
        kontrollPersis.patientErstellen(pati);
    }

    public boolean loginUeberpruefung(String nutzer, String passwort) {
        
        boolean login = false;
        
        List<Nutzer> listeNutzer = new ArrayList<Nutzer>();
        listeNutzer = kontrollPersis.getNutzer();
        
        for (Nutzer nutz : listeNutzer) {
            if(nutz.getNutzerName().equals(nutzer)) {
                if(nutz.getPassword().equals(passwort)) {
                  login = true;  
                }
                else {
                  login = false;
                }
            }
        }
        
        return login;
    }

    

    public void vertreterHerstellen(String ausweisnummerGesetzlicherVertreter, String nameGesetzlicherVertreter, String nachnameGesetzlicherVertreter, String telefonGesetzlicherVertreter, String adresseGesetzlicherVertreter, String artDerVerantwortung, Date geburtsdatumGesetzlicherVertreter) {
        
        GesetzlicherVertreter vertre = new GesetzlicherVertreter();
        
        vertre.setAusweisnummer(ausweisnummerGesetzlicherVertreter);
        vertre.setName(nameGesetzlicherVertreter);
        vertre.setNachname(nachnameGesetzlicherVertreter);
        vertre.setTelefon(telefonGesetzlicherVertreter);
        vertre.setAdresse(adresseGesetzlicherVertreter);
        vertre.setArtDerVerantwortung(artDerVerantwortung);
        vertre.setGeburtsdatum(geburtsdatumGesetzlicherVertreter);
        
        kontrollPersis.vertreterErstellen(vertre);
    }
}
    



    

    


    



