package at.ums.lfsums.modelo;

/**
 * Created by luna-aleixos on 29.02.2016.
 */
public class Lieferschein {

    public String idLieferschein;
    public String idKunde;
    public String datum;
    public String artikel;
    public float menge;
    public String eh;
    public String photo;
    public String signature;
    public String idMitarbeiter;

    public Lieferschein(String idLieferschein, String idKunde, String datum, String artikel,
                        float menge, String eh, String photo, String signature, String idMitarbeiter){
        this.idLieferschein = idLieferschein;
        this.idKunde = idKunde;
        this.datum = datum;
        this.artikel = artikel;
        this.menge = menge;
        this.eh  = eh;
        this.photo = photo;
        this.signature = signature;
        this.idMitarbeiter = idMitarbeiter;
    }




}
