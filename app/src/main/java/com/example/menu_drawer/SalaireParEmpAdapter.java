package com.example.menu_drawer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SalaireParEmpAdapter extends BaseAdapter {

    private Context mContext;
    private Activity activity;
    int mResource;

    private ArrayList<SalaireParEmploye> arraylist;
    private List<SalaireParEmploye> list_travail = null;
    private LayoutInflater inflater;
    private ImageView img_delete_travail, img_edit_travail;

    public SalaireParEmpAdapter(@NonNull Context context, @NonNull List<SalaireParEmploye> travails, Activity activity) {
        this.mContext = context;
        this.inflater = LayoutInflater.from(context);
        this.list_travail = travails;
        this.arraylist = new ArrayList<SalaireParEmploye>();
        this.arraylist.addAll(list_travail);
        this.activity = activity;
    }
    @Override
    public int getCount() {
        return list_travail.size();
    }

    @Override
    public SalaireParEmploye getItem(int position) {
        return list_travail.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


//    public SalaireParEmpAdapter(@NonNull Context context, @NonNull List<Travail> travails, Activity activity) {
//        this.mContext = context;
//        this.inflater = LayoutInflater.from(context);
//        this.list_travail = travails;
//        this.arraylist = new ArrayList<Travail>();
//        this.arraylist.addAll(list_travail);
//        this.activity = activity;
//    }

    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        view = inflater.inflate(R.layout.adapter_view_salaire_par_employe, null);
        //get the salaire par employes
        String num_Emp = getItem(position).getNum_employe_S();
        String nom_Emp = getItem(position).getNom_employe_S();
        String adresse = getItem(position).getAdresse_S();
       double salaire = getItem(position).getSalaire();
       String salaire_1 = new Double (salaire).toString();

        //Create the work information
        SalaireParEmploye t = new SalaireParEmploye(num_Emp, nom_Emp, adresse, salaire);

        TextView tvNumEmplS = (TextView) view.findViewById(R.id.id_num_employe_salaireParEmp);
        TextView tvNomEmplS = (TextView) view.findViewById(R.id.nom_salaire_par_Emp);
        TextView tvAdresseS = (TextView) view.findViewById(R.id.adresse_salaire_par_Emp);
//        TextView tvDateSalaire = (TextView) view.findViewById(R.id.date_salaire_par_Emp);
        TextView tvSalaire = (TextView) view.findViewById(R.id.salaire_par_Emp);

        //type String Date
        tvNumEmplS.setText(num_Emp);
        tvNomEmplS.setText(nom_Emp);
        tvAdresseS.setText(adresse);
        tvSalaire.setText(salaire_1);


        //        Populate Spinner
        List<String> list_entreprise = new ArrayList<String>();
//        list_entreprise.add(num_Ent);
        list_entreprise.add("Akata");
        list_entreprise.add("Kintana");
        list_entreprise.add("Volana");
        list_entreprise.add("CrystalVolatile");

        List<String> list_employe = new ArrayList<String>();
//        list_employe.add(num_Emp);
        list_employe.add("E0012(Rakotosoa)");
        list_employe.add("E002(Vololona Ryan)");
        list_employe.add("E003(Mbela)");
        list_employe.add("E004(Pelasoa)");

        return view;
    }

//    public void filter(String text) {
//        text = text.toLowerCase(Locale.getDefault());
//        list_travail.clear();
//        if (text.length() == 0) {
//            list_travail.addAll(arraylist);
//        } else {
//            for (SalaireParEmploye travail : arraylist) {
//                if (travail.getNum_entreprise_T().toLowerCase(Locale.getDefault()).contains(text) ||
//                        travail.getNum_employe_T().toLowerCase(Locale.getDefault()).contains(text) ||
//                        travail.getDate_travail().toLowerCase(Locale.getDefault()).contains(text)) {
//                    list_travail.add(travail);
//                }
//            }
//        }
//    }
}

