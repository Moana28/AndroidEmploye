package com.example.menu_drawer;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EntrepriseAdapter extends BaseAdapter {
    private static final String TAG = "EntrepriseAdapter";

    private Context mContext;
    private Activity activity;
    int mResource;

    private ArrayList<Entreprise> arraylist_entreprise;
    private List<Entreprise> list_entreprise = null;
    private LayoutInflater inflater;
    private ImageView img_delete_entreprise;
    private ImageView img_edit_entreprise;
    private TextView close;

    public EntrepriseAdapter(@NonNull Context context, @NonNull List<Entreprise> entreprises, Activity activity) {
        this.mContext = context;
        this.inflater = LayoutInflater.from(context);
        this.list_entreprise = entreprises;
        this.arraylist_entreprise = new ArrayList<Entreprise>();
        this.arraylist_entreprise.addAll(list_entreprise);
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return list_entreprise.size();
    }

    @Override
    public Entreprise getItem(int position) {
        return list_entreprise.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = inflater.inflate(R.layout.adapter_view_entreprise,null);
        //get the entreprise information
        String num_entreprise  = getItem(position).getNum_entreprise();
        String design_entreprise = getItem(position).getDesign_entreprise();

        //Create the entreprise object with the information
        Entreprise e = new Entreprise(num_entreprise,design_entreprise);

        TextView tvNumE = (TextView) convertView.findViewById(R.id.list_num_entreprise);
        TextView tvDesE = (TextView) convertView.findViewById(R.id.list_design_entreprise);

        tvNumE.setText(num_entreprise);
        tvDesE.setText(design_entreprise);

        //Suppression d'une entreprise
        this.img_delete_entreprise = convertView.findViewById(R.id.delete_Entreprise);
        img_delete_entreprise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myDialog = new AlertDialog.Builder(mContext);
                myDialog.setTitle("Suppression d' un travail");
                myDialog.setMessage("Voulez-vous vraiment supprimer l'entreprise "+design_entreprise+"?");
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

        PopUpEntreprise p = new PopUpEntreprise(activity);
        //Modification d'une entreprise
        this.img_edit_entreprise = convertView.findViewById(R.id.edit_Entreprise);
        img_edit_entreprise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.setEditnumeroE(num_entreprise);
                p.setEditdesignE(design_entreprise);
                p.setTitleEntreprise("MODIFIER UNE ENTREPRISE");
                p.build();
            }
        });

        //Annuler onClick
        p.getBtn_annuler_Entreprise().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.dismiss();
            }
        });

        //Close onCllick
        p.getClose().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.dismiss();
            }
        });
        return convertView;
    }

    public void filter(String text) {
        text = text.toLowerCase(Locale.getDefault());
        list_entreprise.clear();
        if (text.length() == 0) {
            list_entreprise.addAll(arraylist_entreprise);
        } else {
            for (Entreprise entreprise : arraylist_entreprise) {
                if (entreprise.getNum_entreprise().toLowerCase(Locale.getDefault()).contains(text) ||
                        entreprise.getDesign_entreprise().toLowerCase(Locale.getDefault()).contains(text)) {
                    list_entreprise.add(entreprise);
                }
            }
        }
    }
}


