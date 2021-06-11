package com.example.menu_drawer;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SalaireGlobalAdapter extends BaseAdapter {
    private Context mContext;
    private Activity activity;

    private ArrayList<SalaireGlobal> arraylist;
    private List<SalaireGlobal> list_travail = null;
    private LayoutInflater inflater;

    public SalaireGlobalAdapter(@NonNull Context context, @NonNull List<SalaireGlobal> travails, Activity activity) {
        this.mContext = context;
        this.inflater = LayoutInflater.from(context);
        this.list_travail = travails;
        this.arraylist = new ArrayList<SalaireGlobal>();
        this.arraylist.addAll(list_travail);
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return list_travail.size();
    }

    @Override
    public SalaireGlobal getItem(int position) {
        return list_travail.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        view = inflater.inflate(R.layout.adapter_view_salaire_global, null);
        //get the salaire par employes
        String num_Emp = getItem(position).getNum_employe_G();
        String nom_Emp = getItem(position).getNom_employe_G();
        double salaire = getItem(position).getSalaire_G();
        String salaire_1 = new Double(salaire).toString();

        //Create the work information
        SalaireGlobal t = new SalaireGlobal(num_Emp, nom_Emp, salaire);

        TextView tvNumEmplS = (TextView) view.findViewById(R.id.id_num_employe_salaireGlobal);
        TextView tvNomEmplS = (TextView) view.findViewById(R.id.nom_salaire_Emp_global);
        TextView tvSalaire = (TextView) view.findViewById(R.id.salaire_global);

        //type String Date
        tvNumEmplS.setText(num_Emp);
        tvNomEmplS.setText(nom_Emp);
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
}
