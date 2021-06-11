package com.example.menu_drawer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {
    private onFragmentBtnSelected listener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container,false);
        //clicker les images sur la page d'accueil
        ImageView img_entreprise = (ImageView) view.findViewById(R.id.image_entreprise);
        img_entreprise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(),SecondActivity.class);
                intent.putExtra("show", 1);
                startActivity(intent);
            }
        });
        return view;
    }

    public void onAttach(Context context) {
        super.onAttach(context);

        if(context instanceof  onFragmentBtnSelected) {
            listener = (onFragmentBtnSelected) context;
        } else {
            throw new ClassCastException(context.toString() + " must implement listener ");
        }
    }

    public interface onFragmentBtnSelected{
        public void onButtonSelected(FragmentSecond fragmentSecond);
    }

    public void redirection(Intent intent) {
//        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }
}
