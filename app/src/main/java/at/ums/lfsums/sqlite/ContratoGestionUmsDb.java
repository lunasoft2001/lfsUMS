package at.ums.lfsums.sqlite;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by luna-aleixos on 29.02.2016.
 * Clase que establece los nombres a usar en la base de datos
 */
public class ContratoGestionUmsDb {


    interface ColumnasKunden {
        String ID = BaseColumns._ID;
        String NAME = "name";
        String ADRESSE = "adresse";
        String ORT = "ort";
        String PLZ = "plz";
        String TELEFON = "telefon";
        String EMAIL = "email";
    }

    interface ColumnasLieferschein {
        String ID = BaseColumns._ID;
        String ID_KUNDE = "idKunde";
        String DATUM = "datum";
        String ARTIKEL = "artikel";
        String MENGE = "menge";
        String EH = "eh";
        String PHOTO = "photo";
        String SIGNATURE = "signature";
        String ID_MITARBEITER = "idMitarbeiter";
    }

    interface ColumnasMitarbeiter {
        String ID = BaseColumns._ID;
        String NAME = "name";
        String PRÄFIX = "präfix";
    }

    public static final String AUTORIDAD_CONTENIDO = "at.ums.lieferscheinums";

    public static final Uri URI_BASE = Uri.parse("content://" + AUTORIDAD_CONTENIDO);

    private static final String RUTA_KUNDEN = "kunden";
    private static final String RUTA_LIEFERSCHEIN = "lieferschein";
    private static final String RUTA_MITARBEITER = "mitarbeiter";


    /**
     * Controlador de la tabla Kunden
      */

    public static class Kunden implements ColumnasKunden{

        public static final Uri URI_CONTENIDO =
                URI_BASE.buildUpon().appendPath(RUTA_KUNDEN).build();

        public static final String MIME_RECURSO =
                "vnd.android.cursor.item/vnd." + AUTORIDAD_CONTENIDO + "/" + RUTA_KUNDEN;

        public static final String MIME_COLECCION =
                "vnd.android.cursor.dir/vnd." + AUTORIDAD_CONTENIDO + "/" + RUTA_KUNDEN;


        public static final String PARAMETRO_FILTRO = "filtro";
        public static final String FILTRO_KUNDE = "kunde";

        public static String obtenerKunde(Uri uri) {
            return uri.getLastPathSegment();
        }

        /**
         * Construye ua {@link Uri} para el {@link #ID} solicitado
         */

        public static Uri crearKunde(String id){
            return URI_CONTENIDO.buildUpon().appendPath(id).build();
        }

        public static boolean tieneFiltro(Uri uri) {
            return uri != null &&uri.getQueryParameter(PARAMETRO_FILTRO) != null;
        }

    }

    public static class Lieferschein implements ColumnasLieferschein{

        public static final Uri URI_CONTENIDO =
                URI_BASE.buildUpon().appendPath(RUTA_LIEFERSCHEIN).build();

        public static String obtenerLieferschein(Uri uri) {
            return uri.getLastPathSegment();
        }

        public static Uri crearLieferschein(String id){
            return URI_CONTENIDO.buildUpon().appendPath(id).build();
        }


    }

    public static class Mitarbeiter implements ColumnasMitarbeiter{
        //Metodos auxiliares
    }


    private ContratoGestionUmsDb(){

    }

}
