package com.bapoto.vtc.ui;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.bapoto.bapoto.R;
import com.bapoto.vtc.fragments.AllReservationFragment;
import com.bapoto.vtc.fragments.ChatFragment;
import com.bapoto.vtc.fragments.ProfileFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class ProfileActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
// FOR DESIGN
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;


    // FOR FRAGMENTS
//1 Declare fragment handled by nav drawer
    private Fragment fragmentAllReservations;
    private Fragment fragmentProfile;
    private Fragment fragmentChat;

// FOR DATAS
    //2 Identify each fragment with unique number
    private static final int FRAGMENT_ALL_RESAS = 0;
    private static final int FRAGMENT_PROFILE = 1;
    private static final int FRAGMENT_CHAT = 2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        this.configureToolBar();
        this.configureDrawerLayout();
        this.configureNavigationView();
        this.showFirstFragment();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //4 handle Navigation item click
        int id = item.getItemId();

        switch (id) {
            case R.id.activity_profile_drawer_chat:
                this.showFragment(FRAGMENT_CHAT);
                break;
            case R.id.activity_profile_drawer_profile:
                this.showFragment(FRAGMENT_PROFILE);
                break;
            case R.id.activity_profile_drawer_allReservations:
                this.showFragment(FRAGMENT_ALL_RESAS);
                break;
            default:
                break;
        }

        this.drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        //5 handle back click to close menu
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();

        }

    }

    //-------------
    //CONFIGURATION
    //-------------

    //1 Configure Toolbar
    private void configureToolBar() {
        this.toolbar = findViewById(R.id.activity_profile_toolbar);
        setSupportActionBar(toolbar);
    }

    //2 Configure Drawer Layout
    private void configureDrawerLayout() {
        this.drawerLayout = findViewById(R.id.activity_profile_drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    //3 Configure Navigation view
    private void configureNavigationView() {
       this.navigationView = findViewById(R.id.activity_profile_nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //---------
    //FRAGMENTS
    //---------


    private void showFirstFragment(){
        Fragment visibleFragment = getSupportFragmentManager()
                .findFragmentById(R.id.activity_profile_frame_layout);
        if (visibleFragment == null) {
            //1.1 show new fragment
            this.showFragment(FRAGMENT_PROFILE);
            //1.2 Mark as selected the menu item to corresponding profile fragment
            this.navigationView.getMenu().getItem(0).setChecked(true);
        }
    }

    //3 Generic method who will replace and show a fragment inside the ProfileActivity Frame Layout
    private void startTransactionFragment(Fragment fragment) {
        if (!fragment.isVisible()) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.activity_profile_frame_layout,fragment).commit();
        }
    }

    //5 Show fragment according an Identifier
    private void showFragment(int fragmentIdentifier) {
        switch (fragmentIdentifier) {
            case FRAGMENT_ALL_RESAS:
                this.showAllResaFragment();
                break;
            case FRAGMENT_PROFILE:
                this.showProfileFragment();
                break;
            case FRAGMENT_CHAT:
                this.showChatFragment();
                break;
            default:
                break;
        }
    }


    //4 Create each fragment page and show it
    private void showProfileFragment() {
        if (this.fragmentProfile == null) this.fragmentProfile = ProfileFragment.newInstance();
        this.startTransactionFragment(this.fragmentProfile);
    }

    private void showAllResaFragment() {
        if (this.fragmentAllReservations == null) this.fragmentAllReservations
                = AllReservationFragment.newInstance();
        this.startTransactionFragment(this.fragmentAllReservations);
    }

    private void showChatFragment() {
        if (this.fragmentChat == null) this.fragmentChat = ChatFragment.newInstance();
        this.startTransactionFragment(this.fragmentChat);
    }
}

