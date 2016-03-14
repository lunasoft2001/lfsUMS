package at.ums.lfsums.modelo;

/**
 * Created by luna-aleixos on 29.02.2016.
 */
public class Kunden {

    public String idKunden;
    public String nameKunde;
    public String adresse;
    public String ort;
    public String plz;
    public String telefon;
    public String email;

    public Kunden(String idKunden, String nameKunde, String adresse, String ort,
                String plz, String telefon, String email){
            this.idKunden = idKunden;
            this.nameKunde = nameKunde;
            this.adresse = adresse;
            this.ort = ort;
            this.plz = plz;
            this.telefon = telefon;
            this.email = email;
    }

}
