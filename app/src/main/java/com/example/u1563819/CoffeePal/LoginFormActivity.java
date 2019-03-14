package com.example.u1563819.CoffeePal;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.u1563819.CoffeePal.Common.Common;
import com.example.u1563819.CoffeePal.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginFormActivity extends AppCompatActivity {
    EditText editUsername, editPassword;
    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        editPassword = findViewById(R.id.userPassword);
        editUsername = findViewById(R.id.userName);
        buttonLogin = findViewById(R.id.buttonSignIn);

        //Initialise the Firebase Database
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        buttonLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){

                final ProgressDialog dialog = new ProgressDialog(LoginFormActivity.this);
                dialog.setMessage("Loading...");
                dialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        //Is user in the database
                        if(dataSnapshot.child(editUsername.getText().toString()).exists()) {
                            //Get user information
                            dialog.dismiss();
                            User user = dataSnapshot.child(editUsername.getText().toString())
                                    .getValue(User.class);
                            System.out.println(user.getName());
                            if (user.getPassword().equals(editPassword.getText().toString())) {
                                Toast.makeText(LoginFormActivity.this, "Login Successful",
                                        Toast.LENGTH_SHORT).show();

                                Intent loginSuccess = new Intent (LoginFormActivity.this,
                                        MenuActivity.class);
                                Common.currentUser = user;
                                startActivity(loginSuccess);
                                finish();

                            } else {
                                Toast.makeText(LoginFormActivity.this, "Login Failed",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            dialog.dismiss();
                            Toast.makeText(LoginFormActivity.this,"User does not exist",
                                    Toast.LENGTH_SHORT).show();
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
