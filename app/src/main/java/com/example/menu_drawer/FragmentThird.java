package com.example.menu_drawer;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import static com.example.menu_drawer.R.layout.abc_search_dropdown_item_icons_2line;
import static com.example.menu_drawer.R.layout.popup_add_employe;
import static com.example.menu_drawer.R.layout.popup_add_entreprise;

public class FragmentThird extends Fragment implements SearchView.OnQueryTextListener{
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    public static EmployeAdapter adapter_employe;
    public static  ListView listview_employe;
    private  SearchView text_search_employe;
    private Activity activity;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third_employe,container,false);
        this.listview_employe = view.findViewById(R.id.listViewEmploye);

        this.activity = getActivity();
        //Create list of employees
        Employe one = new Employe("E001","GEORGES FLOYD","Rue Bob Epponge",10000);
        Employe two = new Employe("E002","BELLMAN","Ampasambazaha",7000);
        Employe three = new Employe("E003","Mark Keren","Tsarakitana II",12000);
        Employe four = new Employe("E004","Finaritra","Tanambao 9",17000);
        Employe five = new Employe("E005","Bokaty Melin","Rue Remagneva",5000);
        Employe six = new Employe("E006","Loulou","Kotokila 9",6000);
        Employe seven = new Employe("E007","Bokaty Melin","Toktok",5000);
        Employe eight = new Employe("E008","Finaritra","MBalika 7",4000);
        Employe nine = new Employe("E009","Belaky Marshall","Andranomena II",5000);

        //Add the employees objects in an arraylist
        ArrayList<Employe> employeList = new ArrayList<>();
        employeList.add(one);
        employeList.add(two);
        employeList.add(three);
        employeList.add(four);
        employeList.add(five);
        employeList.add(six);
        employeList.add(seven);
        employeList.add(eight);
        employeList.add(nine);

        adapter_employe = new EmployeAdapter(view.getContext(), employeList,activity);
        this.listview_employe.setAdapter(adapter_employe);
        this.text_search_employe = view.findViewById(R.id.text_search_employe);
        text_search_employe.setOnQueryTextListener(this);

        //Show pop up
        FloatingActionButton fab = view.findViewById(R.id.float_add_Employe);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                PopUpEmploye popUpEmploye = new PopUpEmploye((Activity) getContext());
                popUpEmploye.setTitre("AJOUTER UN EMPLOYE");
                popUpEmploye.build();

                //Entregistrer employe
                popUpEmploye.getBtn_save_employe().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(view.getContext(), "Save employe", Toast.LENGTH_SHORT).show();
                    }
                });

                //Annuler un employe
                popUpEmploye.getBtn_annuler_Employe().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popUpEmploye.dismiss();
                    }
                });

                //Close
                popUpEmploye.getClose().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popUpEmploye.dismiss();
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
        adapter_employe.filter(text);
        return false;
    }
}
