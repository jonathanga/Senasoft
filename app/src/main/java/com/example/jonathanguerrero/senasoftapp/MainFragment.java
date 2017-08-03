package com.example.jonathanguerrero.senasoftapp;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int items_count = 3;


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inicializar los elementos del tab
        View x = inflater.inflate(R.layout.fragment_main,null);
        tabLayout = (TabLayout) x.findViewById(R.id.tabMain);
        viewPager= (ViewPager) x.findViewById(R.id.viewPager);
        ((MainActivity)getActivity()).hideFloattingButton();

        //Fijar el adaptador del viewPager
        viewPager.setAdapter(new MyAdpater(getChildFragmentManager()));

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });
        ((MainActivity)getActivity()).setBarTitle(0);

        return x;
    }

    class MyAdpater extends FragmentPagerAdapter{

        public MyAdpater(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: return new InformacionFragment();
                case 1: return new PublicoFragment();
                case 2: return new LugarFragment();

            }
            return null;
        }

        @Override
        public int getCount() {
            return items_count;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0: return getResources().getString(R.string.opcion1Tab);
                case 1: return getResources().getString(R.string.opcion2Tab);
                case 2: return getResources().getString(R.string.opcion3Tab);
            }
            return null;
        }
    }

}
