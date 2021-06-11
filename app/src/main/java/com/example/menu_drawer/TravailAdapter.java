package com.example.menu_drawer;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TravailAdapter extends BaseAdapter {
    private Context mContext;
    private Activity activity;
    int mResource;

    private ArrayList<Travail> arraylist;
    private List<Travail> list_travail = null;
    private LayoutInflater inflater;
    private ImageView img_delete_travail, img_edit_travail;

    public TravailAdapter(@NonNull Context context, @NonNull List<Travail> travails, Activity activity) {
        this.mContext = context;
        this.inflater = LayoutInflater.from(context);
        this.list_travail = travails;
        this.arraylist = new ArrayList<Travail>();
        this.arraylist.addAll(list_travail);
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return list_travail.size();
    }

    @Override
    public Travail getItem(int position) {
        return list_travail.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = inflater.inflate(R.layout.adapter_view_travail, null);
        //get the works of employees
        String num_Emp = getItem(position).getNum_employe_T();
        String num_Ent = getItem(position).getNum_entreprise_T();
//        String date_T = getItem(position).getDate_travail();
        double nbH = getItem(position).getNbHeure();
        String nbH_1 = new Double(nbH).toString();
        //Create the work information
        Travail t = new Travail(num_Emp, num_Ent, nbH);

        TextView tvNumEmplT = (TextView) convertView.findViewById(R.id.list_id_num_employeT);
        TextView tvNumEntrT = (TextView) convertView.findViewById(R.id.list_num_employeT);
        TextView tvnbHeure = (TextView) convertView.findViewById(R.id.list_nb_heureT);
//        TextView tvDate = (TextView) convertView.findViewById(R.id.list_date_travail);

        //type String Date
        tvNumEmplT.setText(num_Emp);
        tvNumEntrT.setText(num_Ent);
        tvnbHeure.setText(nbH_1);
//        tvDate.setText(date_T);

        //Suppression d'un travail
        this.img_delete_travail = convertView.findViewById(R.id.delete_Travail);
        img_delete_travail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myDialog = new AlertDialog.Builder(mContext);
                myDialog.setTitle("Suppression d' un travail");
                myDialog.setMessage("Voulez-vous vraiment supprimer ?");
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

        //        Populate Spinner
        List<String> list_entreprise = new ArrayList<String>();
        list_entreprise.add(num_Ent);
        list_entreprise.add("Akata");
        list_entreprise.add("Kintana");
        list_entreprise.add("Volana");
        list_entreprise.add("CrystalVolatile");

        List<String> list_employe = new ArrayList<String>();
        list_employe.add(num_Emp);
        list_employe.add("E0012(Rakotosoa)");
        list_employe.add("E002(Vololona Ryan)");
        list_employe.add("E003(Mbela)");
        list_employe.add("E004(Pelasoa)");

        PopUpTravail tr = new PopUpTravail(activity);
        //Modification d'un employe
        this.img_edit_travail = convertView.findViewById(R.id.edit_Travail);
        View finalConvertView = convertView;
        img_edit_travail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tr.setNbheures1T(nbH_1);
//                tr.setDate_travail(date_T);
                tr.setTitre_travail("MODIFIER UN TRAVAIL");
                tr.populateSpinnerEmploye(tr.getNumEm(),list_employe ,finalConvertView);
                tr.populateSpinnerEntreprise(tr.getNumEn(),list_entreprise,finalConvertView);
                tr.build();
            }
        });

        //Annuler onClick
        tr.getBtn_annuler_Tr().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tr.dismiss();
            }
        });

        //Close onCllick
        tr.getClose().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tr.dismiss();
            }
        });

        //Save onClick
        tr.getBtn_save_travail().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Save
            }
        });
        return convertView;
    }
    public void filter(String text) {
        text = text.toLowerCase(Locale.getDefault());
        list_travail.clear();
        if (text.length() == 0) {
            list_travail.addAll(arraylist);
        } else {
            for (Travail travail : arraylist) {
                if (travail.getNum_entreprise_T().toLowerCase(Locale.getDefault()).contains(text) ||
                        travail.getNum_employe_T().toLowerCase(Locale.getDefault()).contains(text)) {
                    list_travail.add(travail);
                }
            }
        }
    }
}
