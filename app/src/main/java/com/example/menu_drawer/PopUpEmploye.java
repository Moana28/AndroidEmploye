package com.example.menu_drawer;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class PopUpEmploye extends Dialog {
    //fields
    private String id_num_employe;
    private String id_nom_employe;
    private String id_adresse_employe;
    private String titre;
    private double id_tauxhoraire_employe;
    private Button btn_save_employe,btn_annuler_Employe;
    private TextView numEmployeView, nomEmployeview, adresseEmployeview,tauxEmployeview, close, titre_employeview;

    //constructor
    public PopUpEmploye (Activity activity) {
        super(activity, R.style.Theme_AppCompat_Dialog);
        setContentView(R.layout.popup_add_employe);
        this.id_num_employe = "";
        this.id_adresse_employe = "";
        this.id_nom_employe = "";
        this.id_tauxhoraire_employe = 0;
        this.titre = "";
        //buttons
        this.btn_save_employe = findViewById(R.id.btn_save_employe);
        this.btn_annuler_Employe = findViewById(R.id.btn_annuler_Employe);
        //Textviews
        this.numEmployeView = findViewById(R.id.id_num_employe);
        this.nomEmployeview = findViewById(R.id.id_nom_employe);
        this.adresseEmployeview = findViewById(R.id.id_adresse_employe);
        this.tauxEmployeview = findViewById(R.id.id_tauxhoraire_employe);
        this.close = findViewById(R.id.close_Employe);
        this.titre_employeview = findViewById(R.id.titre_employe);

    }
    public void setId_num_employe(String id) {this.id_num_employe = id;}

    public void setId_nom_employe(String id) {this.id_nom_employe = id; }

    public void setId_adresse_employe(String id){this.id_adresse_employe = id; }

    public void setId_tauxhoraire_employe(double taux) {this.id_tauxhoraire_employe = taux; }

    public void setTitre(String titre) { this.titre = titre;}

    //Button
    public Button getBtn_save_employe() {return btn_save_employe; }

    public Button getBtn_annuler_Employe() {return btn_annuler_Employe; }

    //Textview
    public TextView getClose() {return close; }

    public void build(){
        show();
        numEmployeView.setText(id_num_employe);
        nomEmployeview.setText(id_nom_employe);
        adresseEmployeview.setText(id_adresse_employe);
        String a = String.valueOf(id_tauxhoraire_employe);
        tauxEmployeview.setText(a);
        titre_employeview.setText(titre);

    }
}
