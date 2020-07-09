package com.aelcorporation.krishipatra;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ValueEventListener;

import Model.User;

public class LoginActivity extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    public static String UserId, PhoneNo;
    private ProgressBar progressBar;
    private Button btnSignup, btnLogin, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       FirebaseDatabase database = FirebaseDatabase.getInstance();
       final DatabaseReference table_user = database.getReference("User");


        // set the view now
        setContentView(R.layout.activity_login);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnSignup = (Button) findViewById(R.id.btn_signup);
        btnLogin = findViewById(R.id.btn_login);
        btnReset = findViewById(R.id.btn_reset_password);


        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignUp.class));
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ForgetPassword.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog mDialog = new ProgressDialog(LoginActivity.this);
                mDialog.setMessage("Please Kindly Wait!!!");
                mDialog.show();



                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        mDialog.dismiss();

                        if(dataSnapshot.child(inputEmail.getText().toString()).exists()) {

                            User user = dataSnapshot.child(inputEmail.getText().toString()).getValue(User.class);
                            if (user.getPassword().equals(inputPassword.getText().toString())) {
                                UserId = user.getName();
                                PhoneNo = inputEmail.getText().toString();
                                Toast.makeText(LoginActivity.this, "Login Successully", Toast.LENGTH_SHORT).show();
                                Intent openhome = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(openhome);

                            } else {
                                Toast.makeText(LoginActivity.this, "Login Failed!!", Toast.LENGTH_SHORT).show();

                            }
                        }
                        else {
                            mDialog.dismiss();
                            Toast.makeText(LoginActivity.this, "User Doesn't Exist.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });
    }
}





/**
 progressBar.setVisibility(View.VISIBLE);

 //authenticate user
 auth.signInWithEmailAndPassword(email, password)
 .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
@Override
public void onComplete(@NonNull Task<AuthResult> task) {
// If sign in fails, display a message to the user. If sign in succeeds
// the auth state listener will be notified and logic to handle the
// signed in user can be handled in the listener.
progressBar.setVisibility(View.GONE);
if (!task.isSuccessful()) {
// there was an error
if (password.length() < 6) {
inputPassword.setError(getString(R.string.minimum_password));
} else {
Toast.makeText(LoginActivity.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
}
} else {
Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
startActivity(intent);
finish();
}
}
}); **/