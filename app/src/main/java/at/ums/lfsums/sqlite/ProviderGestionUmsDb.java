package at.ums.lfsums.sqlite;

/**
 * Created by luna-aleixos on 11.03.2016.
 */


import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.text.TextUtils;


import at.ums.lfsums.sqlite.ContratoGestionUmsDb.Kunden;
import at.ums.lfsums.sqlite.GestionUmsDbHelper.Tablas;

/**
 * {@link ContentProvider} que encapsula el acceso a la base de datos de GestionUmsDb
 */
public class ProviderGestionUmsDb extends ContentProvider {

    // Comparador de URIs
    public static final UriMatcher uriMatcher;

    // Casos
    public static final int KUNDE = 100 ;
    public static final int KUNDE_ID = 101;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(ContratoGestionUmsDb.AUTORIDAD_CONTENIDO, "kunden", KUNDE);
        uriMatcher.addURI(ContratoGestionUmsDb.AUTORIDAD_CONTENIDO, "kunden/*", KUNDE_ID);
    }

    private GestionUmsDbHelper bd;
    private ContentResolver resolver;


    @Override
    public boolean onCreate() {
        bd = new GestionUmsDbHelper(getContext());
        resolver = getContext().getContentResolver();
        return true;
    }

    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)) {
            case KUNDE:
                return ContratoGestionUmsDb.Kunden.MIME_COLECCION;
            case KUNDE_ID:
                return ContratoGestionUmsDb.Kunden.MIME_RECURSO;
            default:
                throw new IllegalArgumentException("Tipo desconocido: " + uri);
        }
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // Obtener base de datos
        SQLiteDatabase db = bd.getWritableDatabase();
        // Comparar Uri
        int match = uriMatcher.match(uri);

        Cursor c;

        switch (match) {
            case KUNDE:
                // Consultando todos los registros
                c = db.query(Tablas.KUNDEN, projection,
                        selection, selectionArgs,
                        null, null, sortOrder);
                c.setNotificationUri(resolver, ContratoGestionUmsDb.Kunden.URI_CONTENIDO);
                break;
            case KUNDE_ID:
                // Consultando un solo registro basado en el Id del Uri
                String idKunde = Kunden.obtenerKunde(uri);
                c = db.query(Tablas.KUNDEN, projection,
                        Kunden.ID + "=" + "\'" + idKunde + "\'"
                                + (!TextUtils.isEmpty(selection) ?
                                " AND (" + selection + ')' : ""),
                        selectionArgs, null, null, sortOrder);
                c.setNotificationUri(resolver, uri);
                break;
            default:
                throw new IllegalArgumentException("URI no soportada: " + uri);
        }
        return c;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        return 0;
    }
}