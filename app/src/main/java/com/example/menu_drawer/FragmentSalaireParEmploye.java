package com.example.menu_drawer;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import java.util.ArrayList;
import java.util.List;

public class FragmentSalaireParEmploye extends Fragment implements SearchView.OnQueryTextListener{
    private Activity activity;
    public static SalaireParEmpAdapter adapter;
    public static ListView list_salaire;
    private SearchView text_search_travail;

    public FragmentSalaireParEmploye() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_salaire_par_employe, container, false);
        this.list_salaire = view.findViewById(R.id.listViewSalaireParEmpl);
        this.activity = getActivity();

        //Create list of works
        SalaireParEmploye one = new SalaireParEmploye("E001", "Rakotomalala", "Ambinagnibe",10000);

        //Add the work in an array list
        ArrayList<SalaireParEmploye> list = new ArrayList<>();
        list.add(one);


        adapter = new SalaireParEmpAdapter(view.getContext(), list, activity);
        this.list_salaire.setAdapter(adapter);
        this.text_search_travail = view.findViewById(R.id.text_search_par_NumEn);
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

        return view;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
//        adapter.filter(text);
        return false;
    }
}
