package com.example.menu_drawer;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class PopUpTravail extends Dialog implements AdapterView.OnItemSelectedListener {
    //fields
    private String id_num_employe_T;
    private String numeroEntreprise;
    private String Nbheures1T;
    private String date_travail,date_change;
    private String titre_travail;
    private final Button btn_save_travail;
    private final Button btn_annuler_Tr;
    private final Spinner numEm;
    private final Spinner numEn;
    private TextView nbH,close,titre_travailview;
    private CalendarView dateT;
    private TextView dateTextView;


    //Constructor
    public PopUpTravail(Activity activity) {
        super(activity, R.style.Theme_AppCompat_Dialog);
        setContentView(R.layout.popup_add_travail);
        this.id_num_employe_T = "";
        this.numeroEntreprise = "";
        this.Nbheures1T = "";
        this.date_travail = "";
        this.titre_travail = "";
        this.btn_save_travail = findViewById(R.id.btn_save_travail);
        this.btn_annuler_Tr = findViewById(R.id.btn_annuler_Tr);
        this.numEm = findViewById(R.id.id_num_employe_T);
        this.numEn = findViewById(R.id.numeroEntreprise);
        this.nbH = findViewById(R.id.Nbheures1T);
        this.close = findViewById(R.id.close_Travail);
//        this.dateT = findViewById(R.id.date_travail);
        this.titre_travailview = findViewById(R.id.titre_travail);
//        this.dateTextView = findViewById(R.id.date_tv_Tr);
//        dateT.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
//                date_change =  dayOfMonth + "/" + (month + 1) + "/" + year;
//                dateTextView.setText(date_change);
//            }
//        });
    }

    //setters
    public void setId_num_employe_T(String id) { this.id_num_employe_T = id; }

    public void setNumeroEntreprise(String id) { this.numeroEntreprise = id; }

    public void setNbheures1T(String nb) { this.Nbheures1T = nb; }

    public void setDate_travail(String d) { this.date_travail = d; this.dateTextView.setText(d);  }

    public void setTitre_travail(String titre) { this.titre_travail = titre; }

    //getters
//    public String getDateTravail() {
//        dateT.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
//                date_change =  dayOfMonth + "/" + (month + 1) + "/" + year;
//            }
//        });
//        dateTextView.setText(date_change);
//        return date_change;
//    }

    //get spinners
    public Spinner getNumEm() { return numEm; }

    public Spinner getNumEn() { return numEn; }

    //get Buttons
    public Button getBtn_save_travail() { return btn_save_travail; }

    public Button getBtn_annuler_Tr() { return btn_annuler_Tr; }

    public TextView getClose() { return close; }

    public void populateSpinnerEmploye(Spinner spinner_num_employe_T,List<String> list_employe ,View popupView){
        spinner_num_employe_T.setOnItemSelectedListener(this);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(popupView.getContext(),android.R.layout.simple_spinner_item,list_employe); //creating adapter for spinner
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //drop dow layout style - list view with radio button
        spinner_num_employe_T.setAdapter(dataAdapter); //attaching data adapter to spinner
    }

    public void populateSpinnerEntreprise(Spinner spinner_num_employe_T, List<String> list_entreprise, View popupView){
        spinner_num_employe_T.setOnItemSelectedListener(this);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(popupView.getContext(),android.R.layout.simple_spinner_item,list_entreprise); //creating adapter for spinner
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //drop dow layout style - list view with radio button
        spinner_num_employe_T.setAdapter(dataAdapter); //attaching data adapter to spinner
    }

    public void build() {
        show();
        nbH.setText(Nbheures1T);
        titre_travailview.setText(titre_travail);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(view.getContext(),"Selected"+item,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
//            Toast.makeText(view.getContext(),"Veuillez choisir une option",Toast.LENGTH_LONG).show();
    }
}
