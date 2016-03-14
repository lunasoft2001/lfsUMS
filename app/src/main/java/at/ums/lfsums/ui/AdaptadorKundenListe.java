package at.ums.lfsums.ui;
/**
 * Created by luna-aleixos on 14.03.2016.
 */

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import at.ums.lfsums.R;


public class AdaptadorKundenListe extends RecyclerView.Adapter<AdaptadorKundenListe.ViewHolder> {
    private final Context contexto;
    private Cursor items;

    private OnItemClickListener escucha;

    interface OnItemClickListener {
        public void onClick(ViewHolder holder, int idPromocion);
    }

    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        // Referencias UI
        public TextView viewName;
        public TextView viewNummer;
        public TextView viewAdresse;
        public TextView viewPlz;
        public TextView viewOrt;
        public TextView viewTelefon;
        public TextView viewEmail;

        public ViewHolder(View v) {
            super(v);
            viewName = (TextView) v.findViewById(R.id.tvKundename);
            viewNummer = (TextView) v.findViewById(R.id.tvKundenummer);
            viewAdresse = (TextView) v.findViewById(R.id.tvAdresse);
            viewPlz = (TextView) v.findViewById(R.id.tvPlz);
            viewOrt = (TextView) v.findViewById(R.id.tvOrt);
            viewTelefon = (TextView) v.findViewById(R.id.tvTelefon);
            viewEmail = (TextView) v.findViewById(R.id.tvEmail);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            escucha.onClick(this, obtenerIdKunde(getAdapterPosition()));
        }
    }

    private int obtenerIdKunde(int posicion) {
        if (items != null) {
            if (items.moveToPosition(posicion)) {
                return items.getInt(ConsultaKunden.ID_KUNDEN);
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    public AdaptadorKundenListe(Context contexto, OnItemClickListener escucha) {
        this.contexto = contexto;
        this.escucha = escucha;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_kunden_liste, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        items.moveToPosition(position);

        String s;

        // Asignación UI
        s = items.getString(ConsultaKunden.NAME);
        holder.viewName.setText(s);

        s = items.getString(ConsultaKunden.ID_KUNDEN);
        holder.viewNummer.setText(s);

        s = items.getString(ConsultaKunden.ADRESSE);
        holder.viewAdresse.setText(s);

        s = items.getString(ConsultaKunden.PLZ);
        holder.viewPlz.setText(s);

        s = items.getString(ConsultaKunden.ORT);
        holder.viewOrt.setText(s);

        s = items.getString(ConsultaKunden.TELEFON);
        holder.viewTelefon.setText(s);

        s = items.getString(ConsultaKunden.EMAIL);
        holder.viewEmail.setText(s);

//        s = items.getString(ConsultaAlquileres.URL);
//        Glide.with(contexto).load(s).centerCrop().into(holder.viewFoto);

    }

    @Override
    public int getItemCount() {
        if (items != null)
            return items.getCount();
        return 0;
    }

    public void swapCursor(Cursor nuevoCursor) {
        if (nuevoCursor != null) {
            items = nuevoCursor;
            notifyDataSetChanged();
        }
    }

    public Cursor getCursor() {
        return items;
    }

    interface ConsultaKunden {
        int ID_KUNDEN = 1;
        int NAME = 2;
        int ADRESSE = 3;
        int PLZ = 4;
        int ORT = 5;
        int TELEFON = 6;
        int EMAIL = 7;
    }
}