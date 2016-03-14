package at.ums.lfsums.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import at.ums.lfsums.modelo.Lieferschein;
import at.ums.lfsums.sqlite.GestionUmsDbHelper.Tablas;

/**
 * Created by luna-aleixos on 29.02.2016.
 *  * Clase auxiliar que implementa a {@link GestionUmsDbHelper para llevar a cabo el CRUD
 * sobre las entidades existentes.
 */
public final class OperacionesBaseDatos {

    private static GestionUmsDbHelper baseDatos;
    private static OperacionesBaseDatos instancia = new OperacionesBaseDatos();

    private OperacionesBaseDatos(){
    }

    public static OperacionesBaseDatos obtenerInstancia(Context contexto) {
        if (baseDatos == null) {
            baseDatos = new GestionUmsDbHelper(contexto);
        }
        return instancia;
    }

    // OPERACIONES KUNDEN

    public Cursor obtenerKunden() {
        SQLiteDatabase db = baseDatos.getReadableDatabase();

        String sql = "SELECT * FROM " + Tablas.KUNDEN;

        return db.rawQuery(sql, null);
    }

    // OPERACIONES LIEFERSCHEIN

    public Cursor obtenerLieferschein() {
        SQLiteDatabase db = baseDatos.getReadableDatabase();

        String sql = "SELECT * FROM " + Tablas.LIEFERSCHEIN;

        return  db.rawQuery(sql, null);
    }


    public String insertarLieferschein(Lieferschein lieferschein) {
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        ContentValues valores = new ContentValues();

        valores.put(ContratoGestionUmsDb.Lieferschein.ID, lieferschein.idLieferschein);
        valores.put(ContratoGestionUmsDb.Lieferschein.DATUM, lieferschein.datum);
        valores.put(ContratoGestionUmsDb.Lieferschein.ID_MITARBEITER, lieferschein.idMitarbeiter);
        valores.put(ContratoGestionUmsDb.Lieferschein.ID_KUNDE, lieferschein.idKunde);
        valores.put(ContratoGestionUmsDb.Lieferschein.ARTIKEL, lieferschein.artikel);
        valores.put(ContratoGestionUmsDb.Lieferschein.MENGE, lieferschein.menge);
        valores.put(ContratoGestionUmsDb.Lieferschein.EH, lieferschein.eh);
        valores.put(ContratoGestionUmsDb.Lieferschein.PHOTO, lieferschein.photo);
        valores.put(ContratoGestionUmsDb.Lieferschein.SIGNATURE, lieferschein.signature);

        long insert = db.insertOrThrow(Tablas.LIEFERSCHEIN, null, valores);

        Log.i("insertDB", String.valueOf(insert));

        return lieferschein.idLieferschein;
    }

    public boolean actualizarLieferschein(Lieferschein lieferscheinNuevo){
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        ContentValues valores = new ContentValues();

        valores.put(ContratoGestionUmsDb.Lieferschein.DATUM, lieferscheinNuevo.datum);
        valores.put(ContratoGestionUmsDb.Lieferschein.ID_MITARBEITER, lieferscheinNuevo.idMitarbeiter);
        valores.put(ContratoGestionUmsDb.Lieferschein.ID_KUNDE, lieferscheinNuevo.idKunde);
        valores.put(ContratoGestionUmsDb.Lieferschein.ARTIKEL, lieferscheinNuevo.artikel);
        valores.put(ContratoGestionUmsDb.Lieferschein.MENGE, lieferscheinNuevo.menge);
        valores.put(ContratoGestionUmsDb.Lieferschein.EH, lieferscheinNuevo.eh);
        valores.put(ContratoGestionUmsDb.Lieferschein.PHOTO, lieferscheinNuevo.photo);
        valores.put(ContratoGestionUmsDb.Lieferschein.SIGNATURE, lieferscheinNuevo.signature);

        String whereClause = ContratoGestionUmsDb.Lieferschein.ID + "=?";
        // La linea anterior tb. se puede escribir como sigue
        // String whereClausule = String.format("%s=?", ContratoGestionUmsDb.Lieferschein.ID);
        String[] whereArgs = {lieferscheinNuevo.idLieferschein};

        int resultado = db.update(Tablas.LIEFERSCHEIN, valores, whereClause, whereArgs);

        return resultado > 0;
    }


    public boolean eliminarLieferschein(String idLieferschein) {
        SQLiteDatabase db = baseDatos.getWritableDatabase();

        String whereClause = ContratoGestionUmsDb.Lieferschein.ID + "=?";
        String[] whereArgs = {idLieferschein};

        int resultado = db.delete(Tablas.LIEFERSCHEIN, whereClause, whereArgs);

        return resultado > 0;
    }



    // OPERACIONES MITARBEITER

    public Cursor obtenerMitarbeiter() {
        SQLiteDatabase db = baseDatos.getReadableDatabase();

        String sql = "SELECT * FROM " + Tablas.MITARBEITER;

        return  db.rawQuery(sql, null);
    }

//    public String insertarMitarbeieter(Mitarbeiter mitarbeiter) {
//        ContentValues valores = new ContentValues();
//        // Generar Pk??
//        valores.put(Mitarbeiter.ID, mitarbeiter.idMitarbeiter);
//        valores.put(Mitarbeiter.NAME, mitarbeiter.);
//    }


}
