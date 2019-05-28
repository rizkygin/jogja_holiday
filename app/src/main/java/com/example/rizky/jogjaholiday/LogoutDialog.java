package com.example.rizky.jogjaholiday;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.zip.Inflater;

public class LogoutDialog extends DialogFragment implements View.OnClickListener {


    Button Yes,No;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_logout,container,false);

        Yes = view.findViewById(R.id.btnYes);
        No = view.findViewById(R.id.btnNo);

        Yes.setOnClickListener(this);
        No.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View v) {
        switch  (v.getId()){
            case R.id.btnYes:
                FirebaseAuth.getInstance().signOut();
                getDialog().dismiss();
                break;
            case R.id.btnNo:
                getDialog().dismiss();
                break;
        }
    }
}
