package BusinnesLogik;

import BusinnesLogik.GesetzlicherVertreter;
import BusinnesLogik.Termin;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-02-14T09:13:37")
@StaticMetamodel(Patient.class)
public class Patient_ extends Person_ {

    public static volatile SingularAttribute<Patient, String> istSozialversichert;
    public static volatile ListAttribute<Patient, Termin> ListeTermin;
    public static volatile SingularAttribute<Patient, GesetzlicherVertreter> einGesetzlicherVertreter;
    public static volatile SingularAttribute<Patient, String> bluttgruppe;
    public static volatile SingularAttribute<Patient, String> istPrivatversichert;

}