package at.ums.lfsums.ui;

/**
 * Created by luna-aleixos on 14.03.2016.
 */


import android.database.Cursor;
        import android.os.Bundle;

        import android.support.v4.app.LoaderManager;
        import android.support.v4.content.CursorLoader;
        import android.support.v4.content.Loader;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;


import at.ums.lfsums.R;
import at.ums.lfsums.sqlite.ContratoGestionUmsDb.Kunden;

public class KundenListe extends AppCompatActivity implements AdaptadorKundenListe.OnItemClickListener, LoaderManager.LoaderCallbacks<Cursor> {

    private RecyclerView listaUI;
    private LinearLayoutManager linearLayoutManager;
    private AdaptadorKundenListe adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kunden_liste);




        // Preparar lista
        listaUI = (RecyclerView) findViewById(R.id.lista);
        listaUI.setHasFixedSize(true);

        linearLayoutManager = new LinearLayoutManager(this);
        listaUI.setLayoutManager(linearLayoutManager);

        adaptador = new AdaptadorKundenListe(this, this);
        listaUI.setAdapter(adaptador);

        // Iniciar loader
        getSupportLoaderManager().restartLoader(1, null, this);

    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this, Kunden.URI_CONTENIDO, null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (adaptador != null) {
            adaptador.swapCursor(data);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
    }

    @Override
    public void onClick(AdaptadorKundenListe.ViewHolder holder, int idPromocion) {

    }
}