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

public class FragmentSalaireGlobal extends Fragment {
    private Activity activity;
    public static SalaireGlobalAdapter adapter;
    public static ListView list_salaire;

    public FragmentSalaireGlobal() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_salaire_global, container, false);
        this.list_salaire = view.findViewById(R.id.listViewSalaireGlobal);
        this.activity = getActivity();

        //Create list of works
        SalaireGlobal one = new SalaireGlobal("E001", "Rakotomalala", 1000000);
        SalaireGlobal two = new SalaireGlobal("E002", "Kotomila", 800000);

        //Add the work in an array list
        ArrayList<SalaireGlobal> list = new ArrayList<>();
        list.add(one);
        list.add(two);

        adapter = new SalaireGlobalAdapter(view.getContext(), list, activity);
        this.list_salaire.setAdapter(adapter);

        return view;
    }

}
