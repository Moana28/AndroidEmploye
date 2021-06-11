package com.example.menu_drawer;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import static com.example.menu_drawer.R.id.text_search_entreprise;
import static com.example.menu_drawer.R.layout.adapter_view_entreprise;
import static com.example.menu_drawer.R.layout.fragment_second;
//import static com.example.menu_drawer.R.layout.popupdeletee;

public class FragmentSecond extends Fragment implements SearchView.OnQueryTextListener {
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private Context mContext;
    public static EntrepriseAdapter adapter_entreprise;
    public static ListView list_entreprise;
    private SearchView text_search_entreprise;
    private Activity activity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_second,container,false);
        this.list_entreprise = view.findViewById(R.id.listViewEntreprise);

        this.activity = getActivity();
                //Create list of entreprise
        Entreprise one = new Entreprise( "ZK001", "Akata");
        Entreprise two = new Entreprise("ZK002", "Cactus");
        Entreprise three = new Entreprise("ZK003", "IT Fluency");
        Entreprise four = new Entreprise("ZK004", "Ingenyosa");
        Entreprise five = new Entreprise("ZD005", "Blue Lagoon");
        Entreprise six = new Entreprise("ZK006",  "Letter Fabrics");
        Entreprise seven = new Entreprise("ZK007", "RomaniaK");
        Entreprise eight = new Entreprise("ZK008","FaraX");

        /* Add the entreprise objects to an ArrayList */
        ArrayList<Entreprise> entrepriseList = new ArrayList<>();
        entrepriseList.add(one);
        entrepriseList.add(two);
        entrepriseList.add(three);
        entrepriseList.add(four);
        entrepriseList.add(five);
        entrepriseList.add(six);
        entrepriseList.add(seven);
        entrepriseList.add(eight);

        adapter_entreprise = new EntrepriseAdapter(view.getContext(),entrepriseList, activity);
        this.list_entreprise.setAdapter(adapter_entreprise);
        this.text_search_entreprise = view.findViewById(R.id.text_search_entreprise);
        text_search_entreprise.setOnQueryTextListener(this);

        //PopUp
        //Show popup add entreprise
        FloatingActionButton fab = view.findViewById(R.id.float_add_Entreprise);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity;
                PopUpEntreprise popUpEntreprise = new PopUpEntreprise((Activity) getContext());
                popUpEntreprise.setTitleEntreprise("AJOUTER UNE NOUVELLE ENTREPRISE");
                popUpEntreprise.build();
                //Bouton annuler
                popUpEntreprise.getBtn_annuler_Entreprise().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popUpEntreprise.dismiss();
                    }
                });
                //Close bouton
                popUpEntreprise.getClose().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popUpEntreprise.dismiss();
                    }
                });
                //Bouton valider
                popUpEntreprise.getBtn_save_Entreprise().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(view.getContext(), "Enregistrer entreprise", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
       //End Search
        //inflate the layout for this layout
        return view;

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter_entreprise.filter(text);
        return false;
    }
}


