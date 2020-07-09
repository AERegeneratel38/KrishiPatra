package com.aelcorporation.krishipatra;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.aelcorporation.krishipatra.forumsection.ForumActivity;
import com.aelcorporation.krishipatra.forumsection.ForumDetailActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.util.Calendar;

import Model.User;

import static com.aelcorporation.krishipatra.LoginActivity.PhoneNo;

public class ProfileSection extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    FirebaseDatabase database;
    DatabaseReference mUser, table_user;
    public static String DateOfBirth, DisTrict, PassWord;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_section);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
         final DatabaseReference table_user = database.getReference("User");
        final DatabaseReference mUser = table_user.child(PhoneNo);


        table_user.child(PhoneNo).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String DateOfBirth = (String) dataSnapshot.child("DOB").getValue();
                String District = (String) dataSnapshot.child("District").getValue();
                String PassWord = (String) dataSnapshot.child("Password").getValue();

                TextView DateOFBirth = (TextView)findViewById(R.id.txtDOB);
                DateOFBirth.setText(DateOfBirth);
                TextView DISTRICT = (TextView)findViewById(R.id.txtDistrict);
                DISTRICT.setText(District);





            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        final Context context = this;

        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            finish();

            }
        });

        Button btnDate = (Button)findViewById(R.id.change_DOB_button);
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");

            }
        });

        Button btnDistrict = (Button)findViewById(R.id.change_district_button);
        btnDistrict.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DistrictSelector();

            }
        });

        final TextView Password = (TextView)findViewById(R.id.txtPassword);
        Button btnPassword = (Button)findViewById(R.id.change_password_button);
        btnPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // get prompts.xml view
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.prompts, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);


                final EditText userInput = (EditText) promptsView
                        .findViewById(R.id.editTextDialogUserInput);
                final EditText userInput2 = (EditText) promptsView
                        .findViewById(R.id.editTextDialogUserInput2);

                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("ठिक",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int id) {
                                        // get user input and set it to result
                                        // edit text
                                        if (userInput.getText() == userInput2.getText()) {
                                            Password.setText(userInput.getText());
                                           mUser.child("Password").setValue(userInput.getText().toString());

                                        }
                                        else {

                                        }


                                    }
                                })
                        .setNegativeButton("रद्द",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int id) {
                                        dialog.cancel();
                                    }
                                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();

            }

        });

    }






    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayofMonth){

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayofMonth);

        //String DOBcurrent = year + "/" + ((month + 1).t) +"/" + dayofMonth;
        final String currentDateString = DateFormat.getDateInstance(DateFormat.DEFAULT).format(c.getTime());
        TextView DateOfBirth = (TextView)findViewById(R.id.txtDOB);
        DateOfBirth.setText(currentDateString);
    }

    private void DistrictSelector() {

        final String[] selectDistrict = getResources().getStringArray(R.array.selectDistrict);
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("Select your District");
        builder.setSingleChoiceItems(selectDistrict, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String myDistrict = selectDistrict[which];
               /* mUser.child("District").setValue(myDistrict);
                */TextView District = (TextView)findViewById(R.id.txtDistrict);
                District.setText(myDistrict);
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();


    }



}