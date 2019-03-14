package com.example.u1563819.CoffeePal;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.u1563819.CoffeePal.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUpFormActivity extends AppCompatActivity {

    EditText editUsername, editPassword, editName;
    Button buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_form);

        editPassword = findViewById(R.id.userPassword);
        editUsername = findViewById(R.id.userName);
        editName = findViewById(R.id.firstName);
        buttonSignUp = findViewById(R.id.buttonSignUp);

        //Initialise the Firebase Database
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog dialog = new ProgressDialog(SignUpFormActivity.this);
                dialog.setMessage("Loading...");
                dialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        //Check if username is already taken
                        if(dataSnapshot.child(editUsername.getText().toString()).exists()){
                            dialog.dismiss();
                            Toast.makeText(SignUpFormActivity.this,
                                    "User Name is already taken", Toast.LENGTH_SHORT).show();
                        }else{
                            dialog.dismiss();
                            User user = new User(editName.getText().toString(),editPassword.getText().toString());
                            table_user.child(editUsername.getText().toString()).setValue(user);
                            Toast.makeText(SignUpFormActivity.this,
                                    "Welcome to Coffee Pal!", Toast.LENGTH_SHORT).show();
                            finish();
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
