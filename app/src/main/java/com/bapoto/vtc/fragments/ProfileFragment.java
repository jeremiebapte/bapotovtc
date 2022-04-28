package com.bapoto.vtc.fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bapoto.bapoto.R;
import com.bapoto.vtc.manager.UserManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;


public class ProfileFragment extends Fragment {
    private final UserManager userManager = UserManager.getInstance();
    private Button signOutButton;
    private ImageView profileImageView;
    private EditText usernameEditText;
    private TextView emailTextView;


    public static ProfileFragment newInstance() {
      return (new ProfileFragment());
    }

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setupListeners();
        userManager.getUserData();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        signOutButton = (Button) rootView.findViewById(R.id.signOutButton);
        signOutButton.setOnClickListener(signoutBtn);
        profileImageView = (ImageView) rootView.findViewById(R.id.profileImageView);
        usernameEditText = (EditText) rootView.findViewById(R.id.usernameEditText);
        emailTextView = (TextView) rootView.findViewById(R.id.emailTextView);


        return rootView;
    }

    private final View.OnClickListener signoutBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            userManager.signOut(ProfileFragment.newInstance().getContext()).addOnSuccessListener(aVoid -> {
                try {
                    ProfileFragment.this.finalize();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            });
        }

        private void setupListeners() {
            // Show All user's reservation button
            // binding.allResaButton.setOnClickListener(view -> {});
            // Sign out button
            signOutButton.setOnClickListener(view -> {
                userManager.signOut(ProfileFragment.newInstance().getContext()).addOnSuccessListener(aVoid -> {
                    //finish();
                });
            });

        }

   /* @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_points) {
            new AlertDialog.Builder(this)
                    .setMessage(R.string.popup_message_confirmation_delete_account)
                    .setPositiveButton(R.string.popup_message_choice_yes, (dialogInterface, i) ->
                            userManager.deleteUser(this).addOnSuccessListener(aVoid -> {
                                finish(); }))
                    .setNegativeButton(R.string.popup_message_choice_no, null)
                    .show();
        }

        return super.onOptionsItemSelected(item);

    }*/

        private void updateUIWithUserData() {
            if (userManager.isCurrentUserLogged()) {
                FirebaseUser user = userManager.getCurrentUser();

                if (user.getPhotoUrl() != null) {
                    setProfilePicture(user.getPhotoUrl());
                }
                setTextUserData(user);
                getUserData();
            }
        }

        private void setProfilePicture(Uri profilePictureUrl) {
            Glide.with(ProfileFragment.newInstance().requireContext())
                    .load(profilePictureUrl)
                    .apply(RequestOptions.circleCropTransform())
                    .into(profileImageView);
        }

        private void setTextUserData(FirebaseUser user) {

            //Get email & username from User
            String email = TextUtils.isEmpty(user.getEmail()) ? getString(R.string.info_no_email_found) : user.getEmail();
            String username = TextUtils.isEmpty(user.getDisplayName()) ? getString(R.string.info_no_username_found) : user.getDisplayName();

            //Update views with data
            usernameEditText.setText(username);
            emailTextView.setText(email);
        }

        private void getUserData() {
            userManager.getUserData().addOnSuccessListener(user -> {
                // Set the data with the user information
                String username = TextUtils.isEmpty(user.getUsername())
                        ? getString(R.string.info_no_username_found) : user.getUsername();
                usernameEditText.setText(username);
            });
        }


    };
}