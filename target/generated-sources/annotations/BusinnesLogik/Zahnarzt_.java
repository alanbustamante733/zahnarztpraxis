package BusinnesLogik;

import BusinnesLogik.Nutzer;
import BusinnesLogik.Termin;
import BusinnesLogik.Uhrzeit;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-02-14T09:13:37")
@StaticMetamodel(Zahnarzt.class)
public class Zahnarzt_ extends Person_ {

    public static volatile SingularAttribute<Zahnarzt, String> fachrichtung;
    public static volatile ListAttribute<Zahnarzt, Termin> ListeTermin;
    public static volatile SingularAttribute<Zahnarzt, Nutzer> einNutzer;
    public static volatile SingularAttribute<Zahnarzt, Uhrzeit> einUhrzeit;

}