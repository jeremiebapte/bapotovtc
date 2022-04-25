package com.bapoto.vtc.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.bapoto.vtc.fragments.AllReservationFragment;
import com.bapoto.vtc.fragments.ChatFragment;
import com.bapoto.vtc.fragments.PageFragment;
import com.bapoto.vtc.fragments.ProfileFragment;

public class PageAdapter extends FragmentPagerAdapter {


    public PageAdapter(FragmentManager mgr) {
        super(mgr);

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Page 1
                return  ProfileFragment.newInstance();
            case 1: // Page 2
                return ChatFragment.newInstance();
            case 2: // page 3
                return AllReservationFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return (3);
    }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0: //Page 1
                    return "Mon Profil";
                case 1: //Page 2
                    return "Démarrer une Discussion";
                case 2: // page 3
                    return "Mes réservation passées";
                default:
                    return null;
            }
        }
}
