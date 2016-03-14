package at.ums.lfsums.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import at.ums.lfsums.sqlite.ContratoGestionUmsDb.Kunden;
import at.ums.lfsums.sqlite.ContratoGestionUmsDb.Lieferschein;
import at.ums.lfsums.sqlite.ContratoGestionUmsDb.Mitarbeiter;


/**
 * Created by luna-aleixos on 29.02.2016.
 * Clase que administra la conexión de la base de datos y su estructuración
 */
public class GestionUmsDbHelper extends SQLiteAssetHelper {

    //Creamos las variables generales de la Db

    private static final int version = 1;
    private static final String nombreDb = "GestionUmsDb.db";
//    private final Context contexto;

    public GestionUmsDbHelper(Context contexto) {
        super(contexto, nombreDb, null, version);
 //       this.contexto = contexto;
    }

    interface Tablas {
        String KUNDEN = "kunden";
        String LIEFERSCHEIN = "lieferschein";
        String MITARBEITER = "mitarbeiter";

    }

//    interface Referencias {
//        String ID_KUNDEN = String.format("REFERENCES %s(%s) ON DELETE CASCADE",
//                Tablas.KUNDEN, Kunden.ID);
//
//        String ID_MITARBEITER = String.format("REFERENCES %s(%s)",
//                Tablas.MITARBEITER, Mitarbeiter.ID);
//
//        String ID_LIEFERSCHEIN = String.format("REFERENCES %s(%s)",
//                Tablas.LIEFERSCHEIN, Lieferschein.ID);
//    }



//    @Override
//    public void onOpen(SQLiteDatabase db) {
//        super.onOpen(db);
//        if (!db.isReadOnly()){
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
//                db.setForeignKeyConstraintsEnabled(true);
//            }else{
//                db.execSQL("PRAGMA foreign_keys=ON");
//            }
//        }
//    }

    /**
     *Toda esta parte de creacion de la tabla se sustituye al tener creada la tabla desde un medio externo
     *
     */



//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        //Creamos tabla Kunden
//        db.execSQL( "CREATE TABLE " + Tablas.KUNDEN +
//                "( " + Kunden.ID + " TEXT PRIMARY KEY," +
//                Kunden.NAME +" TEXT," +
//                Kunden.ADRESSE +" TEXT," +
//                Kunden.ORT +" TEXT," +
//                Kunden.PLZ +" TEXT," +
//                Kunden.TELEFON +" TEXT," +
//                Kunden.EMAIL +" TEXT)");
//
//
//        //Creamos tabla Lieferschein
//        db.execSQL("CREATE TABLE "+ Tablas.LIEFERSCHEIN +
//                "( " + Lieferschein.ID + " TEXT PRIMARY KEY," +
//                Lieferschein.ID_KUNDE + " TEXT CONSTRAINT kundeFK REFERENCES " + Tablas.KUNDEN +
//                                "(" + Kunden.ID + ") ON DELETE CASCADE ON UPDATE CASCADE," +
//                Lieferschein.DATUM + " DATE," +
//                Lieferschein.ARTIKEL + " TEXT," +
//                Lieferschein.MENGE + " NUMERIC," +
//                Lieferschein.EH + " TEXT," +
//                Lieferschein.PHOTO + " TEXT," +
//                Lieferschein.SIGNATURE + " TEXT," +
//                Lieferschein.ID_MITARBEITER + " TEXT CONSTRAINT mitarbeiterFK REFERENCES " +
//                                Tablas.MITARBEITER + "("+ Mitarbeiter.ID +") ON DELETE CASCADE ON UPDATE CASCADE)");
//
//
//        //Creamos tabla Mitarbeiter en un estilo distinto con String.format y sustituciones de "%s"
//        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY," +
//                        "%s TEXT NOT NULL,%s TEXT NOT NULL)",
//                Tablas.MITARBEITER,
//                Mitarbeiter.ID, Mitarbeiter.NAME, Mitarbeiter.PRÄFIX));
//
//        //Registros de ejemplo
//
//        //Kunden
//            //01
//        ContentValues valoresKunden = new ContentValues();
//        valoresKunden.put(Kunden.ID, "0001");
//        valoresKunden.put(Kunden.NAME, "kun01");
//        valoresKunden.put(Kunden.ADRESSE, "ad01");
//        valoresKunden.put(Kunden.ORT, "ort01");
//        valoresKunden.put(Kunden.PLZ, "plz01");
//        valoresKunden.put(Kunden.TELEFON, "tlf01");
//        valoresKunden.put(Kunden.EMAIL, "email01");
//        db.insertOrThrow(Tablas.KUNDEN, null, valoresKunden);
//            //02
//        valoresKunden.put(Kunden.ID, "0002");
//        valoresKunden.put(Kunden.NAME, "kun02");
//        valoresKunden.put(Kunden.ADRESSE, "ad02");
//        valoresKunden.put(Kunden.ORT, "ort02");
//        valoresKunden.put(Kunden.PLZ, "plz02");
//        valoresKunden.put(Kunden.TELEFON, "tlf02");
//        valoresKunden.put(Kunden.EMAIL, "email02");
//        db.insertOrThrow(Tablas.KUNDEN, null, valoresKunden);
//            //03
//        valoresKunden.put(Kunden.ID, "0003");
//        valoresKunden.put(Kunden.NAME, "kun03");
//        valoresKunden.put(Kunden.ADRESSE, "ad03");
//        valoresKunden.put(Kunden.ORT, "ort03");
//        valoresKunden.put(Kunden.PLZ, "plz03");
//        valoresKunden.put(Kunden.TELEFON, "tlf03");
//        valoresKunden.put(Kunden.EMAIL, "email03");
//        db.insertOrThrow(Tablas.KUNDEN, null, valoresKunden);
//            //04
//        valoresKunden.put(Kunden.ID, "0004");
//        valoresKunden.put(Kunden.NAME, "kun04");
//        valoresKunden.put(Kunden.ADRESSE, "ad04");
//        valoresKunden.put(Kunden.ORT, "ort04");
//        valoresKunden.put(Kunden.PLZ, "plz04");
//        valoresKunden.put(Kunden.TELEFON, "tlf04");
//        valoresKunden.put(Kunden.EMAIL, "email04");
//        db.insertOrThrow(Tablas.KUNDEN, null, valoresKunden);
//
//        //Lieferschein
//            //01
//        ContentValues valoresLieferschein = new ContentValues();
//        valoresLieferschein.put(Lieferschein.ID, "0001");
//        valoresLieferschein.put(Lieferschein.DATUM, "01/01/2016");
//        valoresLieferschein.put(Lieferschein.ID_KUNDE, "0001");//
//        valoresLieferschein.put(Lieferschein.ID_MITARBEITER, "0001");
//        valoresLieferschein.put(Lieferschein.ARTIKEL, "Ejemplo de texto 1");
//        valoresLieferschein.put(Lieferschein.MENGE, "1111");
//        valoresLieferschein.put(Lieferschein.EH, "m3");
//        valoresLieferschein.put(Lieferschein.PHOTO, "photo0001");
//        valoresLieferschein.put(Lieferschein.SIGNATURE, "signature0001");
//        db.insertOrThrow(Tablas.LIEFERSCHEIN, null, valoresLieferschein);
//            //02
//        valoresLieferschein.put(Lieferschein.ID, "0002");
//        valoresLieferschein.put(Lieferschein.DATUM, "01/01/2016");
//        valoresLieferschein.put(Lieferschein.ID_KUNDE, "0001");
//        valoresLieferschein.put(Lieferschein.ID_MITARBEITER, "0001");
//        valoresLieferschein.put(Lieferschein.ARTIKEL, "Ejemplo de texto 2");
//        valoresLieferschein.put(Lieferschein.MENGE, "2222");
//        valoresLieferschein.put(Lieferschein.EH, "m3");
//        valoresLieferschein.put(Lieferschein.PHOTO, "photo0002");
//        valoresLieferschein.put(Lieferschein.SIGNATURE, "signature0002");
//        db.insertOrThrow(Tablas.LIEFERSCHEIN, null, valoresLieferschein);
//            //03
//        valoresLieferschein.put(Lieferschein.ID, "0003");
//        valoresLieferschein.put(Lieferschein.DATUM, "03/01/2016");
//        valoresLieferschein.put(Lieferschein.ID_KUNDE, "0001");
//        valoresLieferschein.put(Lieferschein.ID_MITARBEITER, "0001");
//        valoresLieferschein.put(Lieferschein.ARTIKEL, "Ejemplo de texto 3");
//        valoresLieferschein.put(Lieferschein.MENGE, "333");
//        valoresLieferschein.put(Lieferschein.EH, "m3");
//        valoresLieferschein.put(Lieferschein.PHOTO, "photo0003");
//        valoresLieferschein.put(Lieferschein.SIGNATURE, "signature0003");
//        db.insertOrThrow(Tablas.LIEFERSCHEIN, null, valoresLieferschein);
//            //04
//        valoresLieferschein.put(Lieferschein.ID, "0004");
//        valoresLieferschein.put(Lieferschein.DATUM, "04/01/2016");
//        valoresLieferschein.put(Lieferschein.ID_KUNDE, "0002");
//        valoresLieferschein.put(Lieferschein.ID_MITARBEITER, "0001");
//        valoresLieferschein.put(Lieferschein.ARTIKEL, "Ejemplo de texto 4");
//        valoresLieferschein.put(Lieferschein.MENGE, "4444");
//        valoresLieferschein.put(Lieferschein.EH, "m3");
//        valoresLieferschein.put(Lieferschein.PHOTO, "photo0004");
//        valoresLieferschein.put(Lieferschein.SIGNATURE, "signature0004");
//        db.insertOrThrow(Tablas.LIEFERSCHEIN, null, valoresLieferschein);
//            //05
//        valoresLieferschein.put(Lieferschein.ID, "0005");
//        valoresLieferschein.put(Lieferschein.DATUM, "05/01/2016");
//        valoresLieferschein.put(Lieferschein.ID_KUNDE, "0003");
//        valoresLieferschein.put(Lieferschein.ID_MITARBEITER, "0001");
//        valoresLieferschein.put(Lieferschein.ARTIKEL, "Ejemplo de texto 5");
//        valoresLieferschein.put(Lieferschein.MENGE, "5555");
//        valoresLieferschein.put(Lieferschein.EH, "Kg.");
//        valoresLieferschein.put(Lieferschein.PHOTO, "photo0005");
//        valoresLieferschein.put(Lieferschein.SIGNATURE, "signature0005");
//        db.insertOrThrow(Tablas.LIEFERSCHEIN, null, valoresLieferschein);
//
//        //Mitarbeiter
//        ContentValues valoresMitarbeiter = new ContentValues();
//        valoresMitarbeiter.put(Mitarbeiter.ID, "0001");
//        valoresMitarbeiter.put(Mitarbeiter.NAME, "Juan Jose Luna");
//        valoresMitarbeiter.put(Mitarbeiter.PRÄFIX, "JJL");
//        db.insertOrThrow(Tablas.MITARBEITER, null, valoresMitarbeiter);
//
//
//    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.KUNDEN);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.LIEFERSCHEIN);
        db.execSQL("DROP TABLE IF EXISTS " + Tablas.MITARBEITER);

        onCreate(db);
    }
}
