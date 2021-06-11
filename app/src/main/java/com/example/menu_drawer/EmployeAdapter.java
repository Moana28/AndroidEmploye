package com.example.menu_drawer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class EmployeAdapter extends BaseAdapter {
    private static final String TAG = "EmployeAdapter";
    private Context mContext;
    private Activity activity;
    int mResource;

    private ArrayList<Employe> arraylist;
    private List<Employe> list_employe = null;
    private LayoutInflater inflater;

    private ImageView img_delete_employe;
    private ImageView img_edit_employe;

    public EmployeAdapter(@NonNull Context context, @NonNull List<Employe> employes, Activity activity) {
        this.mContext = context;
        this.inflater = LayoutInflater.from(mContext);
        this.list_employe = employes;
        this.arraylist = new ArrayList<Employe>();
        this.arraylist.addAll(list_employe);
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return list_employe.size();
    }

    @Override
    public Employe getItem(int position) {
        return list_employe.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        convertView = inflater.inflate(R.layout.adapter_view_employe,null);

        //get the employees information
        String num_employe = getItem(position).getNum_employe();
        String nom_employe = getItem(position).getNom_employe();
        String adresse_employe = getItem(position).getAdresse();
        double taux_horaire_employe = getItem(position).getTaux_horaire();
        String t = new Double(taux_horaire_employe).toString();

        //Create the employees object with the information
        Employe e = new Employe(num_employe,nom_employe,adresse_employe,taux_horaire_employe);

        TextView tvNumEmpl = (TextView) convertView.findViewById(R.id.list_id_num_employe);
        TextView tvNomEmpl = (TextView) convertView.findViewById(R.id.list_nom_employe);
        TextView tvAdresseEmpl = (TextView) convertView.findViewById(R.id.list_adresse_employe);
        TextView tvTauxHEmpl = (TextView) convertView.findViewById(R.id.list_taux_horaire_employe); //taux * nbheures

        tvNumEmpl.setText(num_employe);
        tvNomEmpl.setText(nom_employe);
        tvAdresseEmpl.setText(adresse_employe);
        tvTauxHEmpl.setText(t);

        //Suppressin d'un employe
        this.img_delete_employe = convertView.findViewById(R.id.delete_Employe);
        img_delete_employe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myDialog = new AlertDialog.Builder(mContext);
                myDialog.setTitle("Suppression d' un employe");
                myDialog.setMessage("Voulez-vous vraiment supprimer l'employe "+ nom_employe +"  ?");
                myDialog.setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(mContext, "supression effectuee", Toast.LENGTH_SHORT).show();
                    }
                });
                myDialog.setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //
                    }
                });
                myDialog.show();
            }
        });

        PopUpEmploye employe = new PopUpEmploye(activity);

        //Modification d'un employe
        this.img_edit_employe = convertView.findViewById(R.id.edit_Employe);
        img_edit_employe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                employe.setId_num_employe(num_employe);
                employe.setId_nom_employe(nom_employe);
                employe.setId_adresse_employe(adresse_employe);
                employe.setId_tauxhoraire_employe(taux_horaire_employe);
                employe.setTitre("MODIFIER UN EMPLOYE");
                employe.build();
            }
        });

        //Annuler onClick
        employe.getBtn_annuler_Employe().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                employe.dismiss();
            }
        });

        //Close onCllick
        employe.getClose().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                employe.dismiss();
            }
        });
        return convertView;
    }
    public void filter(String text) {
        text = text.toLowerCase(Locale.getDefault());
        list_employe.clear();
        if (text.length() == 0) {
            list_employe.addAll(arraylist);
        } else {
            for (Employe employe : arraylist) {
                if (employe.getNum_employe().toLowerCase(Locale.getDefault()).contains(text) ||
                        employe.getNom_employe().toLowerCase(Locale.getDefault()).contains(text) ||
                        employe.getAdresse().toLowerCase(Locale.getDefault()).contains(text)) {
                    list_employe.add(employe);
                }
            }
        }
    }
}
