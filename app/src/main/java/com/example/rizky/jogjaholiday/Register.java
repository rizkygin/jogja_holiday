package com.example.rizky.jogjaholiday;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

import static android.widget.Toast.*;

public class Register extends LoginActivity{
    Button ebtnSignUp;

    EditText inpPassword,inpEmail;

    private static final String TAG = "EmailPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        progressBar.setVisibility(View.GONE);

        ebtnSignUp = findViewById(R.id.btnSignUp);
        auth = FirebaseAuth.getInstance();

        inpEmail =  findViewById(R.id.etEmail);
        inpPassword=  findViewById(R.id.etPassword);



        ebtnSignUp.setOnClickListener(new View.OnClickListener() {
            private String TAG ="EmailPassword";

            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                final String password  = inpPassword.getText().toString();
                final String email  = inpEmail.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    makeText(Register.this, getText(R.string.EmailReq), LENGTH_SHORT).show();
                    return;
                }else if(TextUtils.isEmpty(password)){
                    makeText(Register.this, getText(R.string.PassReq), LENGTH_SHORT).show();
                    return;
                }else{
                    regis();
                }
            }

        });
    }

    private void regis() {

        final String password  = inpPassword.getText().toString();
        final String email  = inpEmail.getText().toString().trim();
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = auth.getCurrentUser();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(Register.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


}
