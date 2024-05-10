package ru.mirea.reshetnikovdd.mireaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import ru.mirea.reshetnikovdd.mireaproject.databinding.ActivityFirebaseAuthBinding;


public class FirebaseAuthentication extends AppCompatActivity {
    private static final String TAG = FirebaseAuthentication.class.getSimpleName();
    private ActivityFirebaseAuthBinding binding;
    private FirebaseAuth mAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFirebaseAuthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mAuth = FirebaseAuth.getInstance();

        binding.Email.setText("asd@asd.asd");
        binding.Password.setText("00000000");

        binding.buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn(binding.Email.getText().toString(), binding.Password.getText().toString());
                if (FirebaseAuth.getInstance().getCurrentUser() != null) {
                    Intent intent = new Intent(FirebaseAuthentication.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        binding.buttonSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser user) {
        if (user != null) {
            user = mAuth.getCurrentUser();
            if (user != null) {
                String userInfo = "Email User: " + user.getEmail() + "\n"
                        + "Email Verification Status: " + user.isEmailVerified() + "\n"
                        + "Firebase UID: " + user.getUid();
                binding.signOut.setText(userInfo);
            }
            binding.buttonSignIn.setVisibility(View.VISIBLE);
            binding.Email.setVisibility(View.GONE);
            binding.Password.setVisibility(View.GONE);
        } else {
            binding.signOut.setText("Signed Out");
            binding.buttonSignIn.setVisibility(View.VISIBLE);
            binding.Email.setVisibility(View.VISIBLE);
            binding.Password.setVisibility(View.VISIBLE);
        }
    }

    private void createAccount(String email, String password) {
        Log.d(TAG, "createAccount:" + email);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            Log.w(TAG, "createUserWithEmail:failure",
                                    task.getException());
                            Toast.makeText(FirebaseAuthentication.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
    }
    private void signIn(String email, String password) {
        Log.d(TAG, "signIn:" + email);
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Log.d(TAG, "signInWithEmail:success");
                    FirebaseUser user = mAuth.getCurrentUser();
                    updateUI(user);
                } else {
                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                    Toast.makeText(FirebaseAuthentication.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                    updateUI(null);
                }
            }
        });
    }
    private void signOut() {
        mAuth.signOut();
        updateUI(null);
    }
}