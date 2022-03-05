package com.bapoto.vtc.ui;

import androidx.annotation.Nullable;

import android.content.Intent;
import android.os.Bundle;

import com.bapoto.bapoto.databinding.ActivityMainBinding;
import com.bapoto.bapoto.R;
import com.bapoto.vtc.manager.UserManager;
import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.ErrorCodes;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.material.snackbar.Snackbar;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class MainActivity extends BaseActivity<ActivityMainBinding> {
    private static final int RC_SIGN_IN = 123;
    private final UserManager userManager = UserManager.getInstance();

    @Override
   protected ActivityMainBinding getViewBinding() {
        return ActivityMainBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupListeners();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateLoginButton();
    }

    // Update Login Button when activity is resuming
    private void updateLoginButton(){
        binding.loginButton.setText(userManager.isCurrentUserLogged()?
                getString(R.string.button_login_text_logged) :
                getString(R.string.button_login_text_not_logged));
    }

    // Launching Profile Activity
    private void startProfileActivity(){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    private void setupListeners(){
        // Login/Profile Button
        binding.loginButton.setOnClickListener(view -> {
            if(userManager.isCurrentUserLogged()) {
               startProfileActivity();
            }else{
                startSignInActivity();
            }
        });

        // Reservation Button
        binding.reservationButton.setOnClickListener(view -> {
            if(userManager.isCurrentUserLogged()){
                startReservationActivity();
            }else{
                showSnackBar(getString(R.string.error_not_connected));
            }
        });
    }



    private void startSignInActivity(){

        // Choose authentication providers

        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.FacebookBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build(),
                new AuthUI.IdpConfig.EmailBuilder().build());

        // Launch the activity
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setTheme(R.style.LoginTheme)
                        .setAvailableProviders(providers)
                        .setIsSmartLockEnabled(false, true)
                        .setLogo(R.drawable.bapologo_w)
                        .build(),
                        RC_SIGN_IN);
    }

    private void startReservationActivity(){
        Intent intent = new Intent(this, ReservationActivity.class);
        startActivity(intent);
    }
    // Show Snack Bar with a message
    private void showSnackBar( String message){
        Snackbar.make(binding.layoutMain, message, Snackbar.LENGTH_SHORT).show();
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.handleResponseAfterSignIn(requestCode, resultCode, data);
    }

    // Method that handles response after SignIn Activity close
    private void handleResponseAfterSignIn(int requestCode, int resultCode, Intent data){

        IdpResponse response = IdpResponse.fromResultIntent(data);

        if (requestCode == RC_SIGN_IN) {
            // SUCCESS
            if (resultCode == RESULT_OK) {
                userManager.createUser();
                showSnackBar(getString(R.string.connection_succeed));
            } else {
                // ERRORS
                if (response == null) {
                    showSnackBar(getString(R.string.error_authentication_canceled));
                } else if (response.getError()!= null) {
                    if(response.getError().getErrorCode() == ErrorCodes.NO_NETWORK){
                        showSnackBar(getString(R.string.error_no_internet));
                    } else if (response.getError().getErrorCode() == ErrorCodes.UNKNOWN_ERROR) {
                        showSnackBar(getString(R.string.error_unknown_error));
                    }
                }
            }
        }
    }



}