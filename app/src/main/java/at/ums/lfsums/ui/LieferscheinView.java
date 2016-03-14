package at.ums.lfsums.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import at.ums.lfsums.modelo.Lieferschein;
import at.ums.lfsums.R;
import at.ums.lfsums.sqlite.OperacionesBaseDatos;


public class LieferscheinView extends AppCompatActivity {

    private EditText etLieferscheinnummer, etDatum, etBemerkung, etMenge, etEH, etKundenummer;
    private Spinner spinnerKundenummer;
    private ImageView imageViewPhoto, imageViewSignature;
    private Button mBotonZuruck, mBotonSpeichern, mBotonSenden;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lieferschein_view);

        etLieferscheinnummer = (EditText) findViewById(R.id.etLieferscheinnummer);
        spinnerKundenummer = (Spinner) findViewById(R.id.spinnerKundenummer);
        etDatum = (EditText) findViewById(R.id.etDatum);
        etBemerkung = (EditText) findViewById(R.id.etBemerkung);
        etMenge = (EditText) findViewById(R.id.etMenge);
        etEH = (EditText) findViewById(R.id.etEH);
        imageViewPhoto = (ImageView) findViewById(R.id.imageViewPhoto);
        imageViewSignature = (ImageView) findViewById(R.id.imageViewSignature);


        //Boton Zuruck (atras)
        mBotonZuruck = (Button)findViewById(R.id.buttonZuruck);
        mBotonZuruck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        //Boton guardar (Speichern)
        mBotonSpeichern = (Button)findViewById(R.id.buttonSpeichern);
        mBotonSpeichern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveLieferschein();
                finish();

                Toast.makeText(getApplicationContext(),
                        "Lieferschein " + etLieferscheinnummer.getText().toString() + " speichert",
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    private void saveLieferschein(){ //para validar los campos en la vista

        String idLieferschein = etLieferscheinnummer.getText().toString();
        String idKunde = "0004";
        String datum = etDatum.getText().toString();
        String artikel = etBemerkung.getText().toString();
        float menge = Float.valueOf(etMenge.getText().toString());
        String eh = etEH.getText().toString();
        String photo = imageViewPhoto.toString();
        String signature = imageViewSignature.toString();
        String idMitarbeiter = "0001";

        Lieferschein values = new Lieferschein(idLieferschein, idKunde, datum, artikel,
                menge, eh, photo, signature, idMitarbeiter);

        OperacionesBaseDatos dataBD = OperacionesBaseDatos.obtenerInstancia(getApplicationContext());
        String data = dataBD.insertarLieferschein(values);

        Log.i("result", data);


    }




}
