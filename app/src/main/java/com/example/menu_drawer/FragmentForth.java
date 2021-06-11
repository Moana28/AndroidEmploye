package com.example.menu_drawer;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import static com.example.menu_drawer.R.id.text_search_entreprise;
import static com.example.menu_drawer.R.layout.popup_add_employe;
import static com.example.menu_drawer.R.layout.popup_add_travail;

public class FragmentForth extends Fragment implements SearchView.OnQueryTextListener {
    private Activity activity;
    public static TravailAdapter adapter;
    public static ListView list_travail;
    private SearchView text_search_travail;

    public FragmentForth() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forth_travail, container, false);
        View convertView = inflater.inflate(R.layout.adapter_view_travail, null);
        this.list_travail = view.findViewById(R.id.listViewTravail);
        this.activity = getActivity();

        //Create list of works
        Travail one = new Travail("E001", "Zk003", 12);
        Travail two = new Travail("E002", "Zk002", 7);
        Travail three = new Travail("E003", "Zk001", 8);
        Travail four = new Travail("E004", "Zk001", 18);
        Travail five = new Travail("E005", "Zk002", 9);
        Travail six = new Travail("E006", "Zk001", 8);
        Travail seven = new Travail("E007", "Zk002", 18);
        Travail eight = new Travail("E008", "Zk003", 9);

        //Add the work in an array list
        ArrayList<Travail> travail_list = new ArrayList<>();
        travail_list.add(one);
        travail_list.add(two);
        travail_list.add(three);
        travail_list.add(four);
        travail_list.add(five);
        travail_list.add(six);
        travail_list.add(seven);
        travail_list.add(eight);

        adapter = new TravailAdapter(view.getContext(), travail_list, activity);
        this.list_travail.setAdapter(adapter);
        this.text_search_travail = view.findViewById(R.id.text_search_travail);
        text_search_travail.setOnQueryTextListener(this);
//        Populate Spinner
        List<String> list_entreprise = new ArrayList<String>();
        list_entreprise.add("---------------- Choisir une entreprise -----------------");
        list_entreprise.add("Akata");
        list_entreprise.add("Kintana");
        list_entreprise.add("Volana");
        list_entreprise.add("CrystalVolatile");

        List<String> list_employe = new ArrayList<String>();
        list_employe.add("---------------- Choisir un employe -----------------");
        list_employe.add("E0012(Rakotosoa)");
        list_employe.add("E002(Vololona Ryan)");
        list_employe.add("E003(Mbela)");
        list_employe.add("E004(Pelasoa)");

        //Show pop up
        FloatingActionButton fab = view.findViewById(R.id.float_add_Travail);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                PopUpTravail popUpTravail = new PopUpTravail(activity);
                popUpTravail.setTitre_travail("AJOUTER UN TRAVAIL");
                popUpTravail.populateSpinnerEmploye(popUpTravail.getNumEm(),list_employe,convertView);
                popUpTravail.populateSpinnerEntreprise(popUpTravail.getNumEn(),list_entreprise ,convertView);
                popUpTravail.build();

                //Close onclick
                popUpTravail.getClose().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popUpTravail.dismiss();
                    }
                });

                //Annuler onClick
                popUpTravail.getBtn_annuler_Tr().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popUpTravail.dismiss();
                    }
                });

                //Save Onclick
                popUpTravail.getBtn_save_travail().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Save travail function
//                        Toast.makeText(view.getContext(), "Date travail: "+popUpTravail.getDateTravail(), Toast.LENGTH_SHORT).show();
                    }
                });
            }


        });

                return view;
        }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        adapter.filter(text);
        return false;
    }
}