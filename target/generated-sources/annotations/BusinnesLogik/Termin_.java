package BusinnesLogik;

import BusinnesLogik.Patient;
import BusinnesLogik.Zahnarzt;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-02-14T09:13:37")
@StaticMetamodel(Termin.class)
public class Termin_ { 

    public static volatile SingularAttribute<Termin, Patient> patien;
    public static volatile SingularAttribute<Termin, Integer> id_termin;
    public static volatile SingularAttribute<Termin, String> terminUhrzeit;
    public static volatile SingularAttribute<Termin, String> erkrankung;
    public static volatile SingularAttribute<Termin, Zahnarzt> zahnar;
    public static volatile SingularAttribute<Termin, Date> terminDatum;

}