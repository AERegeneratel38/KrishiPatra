package com.aelcorporation.krishipatra.forumsection;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.aelcorporation.krishipatra.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import static com.aelcorporation.krishipatra.LoginActivity.UserId;

public class ForumPostActivity extends AppCompatActivity {
    // imports
    private ImageButton imageBtn;
    private static final int GALLERY_REQUEST_CODE = 2;
    private Uri uri = null;
    private EditText textTitle;
    private EditText textDesc;
    private Button postBtn;
    private StorageReference storage;
    private FirebaseDatabase database;
    private DatabaseReference databaseRef;
    public static String downloadURL;

    private DatabaseReference mDatabaseUsers;
    FirebaseAuth mzAuth = FirebaseAuth.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("सोधपुछ");


        // initializing objects
        postBtn = (Button)findViewById(R.id.postBtn);
        textDesc = (EditText)findViewById(R.id.textDesc);
        textTitle = (EditText)findViewById(R.id.textTitle);
        storage = FirebaseStorage.getInstance().getReference();
        databaseRef = database.getInstance().getReference("Forum");


        imageBtn = (ImageButton)findViewById(R.id.imageBtn);
        //picking image from gallery
        imageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, GALLERY_REQUEST_CODE);
            }
        });
        // posting to Firebase
        postBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ForumPostActivity.this, "POSTING...", Toast.LENGTH_LONG).show();
                final String PostTitle = textTitle.getText().toString().trim();
                final String PostDesc = textDesc.getText().toString().trim();

                // do a check for empty fields
                if (!TextUtils.isEmpty(PostDesc) && !TextUtils.isEmpty(PostTitle)){
                    StorageReference filepath = storage.child(uri.getLastPathSegment());
                    filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            @SuppressWarnings("VisibleForTests")
                            //getting the post image download url
                            Task<Uri> result = taskSnapshot.getMetadata().getReference().getDownloadUrl();
                            result.addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    String downloadURL = uri.toString();
                                }
                            });
                          //  final Uri downloadUrl = taskSnapshot.getMetadata().getReference().getDownloadUrl();
                            Toast.makeText(getApplicationContext(), "Succesfully Uploaded", Toast.LENGTH_SHORT).show();
                            final DatabaseReference newPost = databaseRef.push();
                            //adding post contents to database reference
                            mDatabaseUsers.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    newPost.child("title").setValue(PostTitle);
                                    newPost.child("desc").setValue(PostDesc);
                                    newPost.child("imageUrl").setValue(downloadURL);
                                    newPost.child("uid").setValue(UserId)
/*                                    newPost.child("username").setValue(dataSnapshot.child("name").getValue())
  */                                          .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {

                                                    if (task.isSuccessful()){
                                                        Intent intent = new Intent(ForumPostActivity.this, ForumActivity.class);
                                                        startActivity(intent);
                                                    }
                                                }
                                            });
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });
                        }
                    });

                }
            }
        });

    }

    @Override
    // image from gallery result
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GALLERY_REQUEST_CODE && resultCode == RESULT_OK){
            uri = data.getData();
            imageBtn.setImageURI(uri);
        }
    }
}
