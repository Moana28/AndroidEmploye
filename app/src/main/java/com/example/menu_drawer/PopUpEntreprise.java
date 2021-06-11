package com.example.menu_drawer;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class PopUpEntreprise extends Dialog {

    //fields
    private String  editnumeroE;
    private String  editdesignE, titre;
    private String titre_entreprise;
    private Button  btn_save_Entreprise;
    private Button  btn_annuler_Entreprise;
    private TextView numeroEview, designEview,close,titre_entrepriseview;

    // constructor
    public PopUpEntreprise (Activity activity) {
        super(activity, R.style.Theme_AppCompat_Dialog);
        setContentView(R.layout.popup_add_entreprise);
        this.editnumeroE = "";
        this.editdesignE = "";
        this.titre = "";
        this.btn_save_Entreprise = findViewById(R.id.btn_save_Entreprise);
        this.btn_annuler_Entreprise = findViewById(R.id.btn_annuler_Entreprise);
        this.numeroEview = findViewById(R.id.editnumeroE);
        this.designEview = findViewById(R.id.editdesignE);
        this.titre_entrepriseview = findViewById(R.id.titre_entreprise);
        this.close = findViewById(R.id.close_Entreprise);
    }

    public void setEditnumeroE(String editnumeroE) { this.editnumeroE = editnumeroE; }

    public void setEditdesignE(String editdesignE) { this.editdesignE = editdesignE; }

    public void setTitleEntreprise(String text) {this.titre = text; }

    public Button getBtn_save_Entreprise() { return btn_save_Entreprise; }

    public Button getBtn_annuler_Entreprise() {return btn_annuler_Entreprise; }

    public TextView getClose() {return close; }

    public void build() {
        show();
        numeroEview.setText(editnumeroE);
        designEview.setText(editdesignE);
        titre_entrepriseview.setText(titre);
    }



}
