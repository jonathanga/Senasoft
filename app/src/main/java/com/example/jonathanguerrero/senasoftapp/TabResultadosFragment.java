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
public class TabResultadosFragment extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int items_count = 4;
    public Bundle b;



    public TabResultadosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inicializar los elementos del tab
        View x = inflater.inflate(R.layout.fragment_tab_resultados,null);
        ((MainActivity)getActivity()).showFloattingButton();

        tabLayout = (TabLayout) x.findViewById(R.id.tabMain2);
        viewPager= (ViewPager) x.findViewById(R.id.viewPager2);
        Bundle b = this.getArguments();

        //Fijar el adaptador del viewPager
        viewPager.setAdapter(new MyAdpater2(getChildFragmentManager(),b));

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });


        return x;
    }
    class MyAdpater2 extends FragmentPagerAdapter {
        private Bundle bundle;

        public MyAdpater2(FragmentManager fm,Bundle data) {
            super(fm);
            bundle = data;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: {
                    ListaResultadosFragment temp = new ListaResultadosFragment();
                    Bundle nuevo = new Bundle();
                    nuevo.putInt("pos",bundle.getInt("pos"));
                    nuevo.putInt("dia", 0);
                    temp.setArguments(nuevo);
                    return temp;
                }
                case 1: {
                    ListaResultados2Fragment temp = new ListaResultados2Fragment();
                    Bundle nuevo = new Bundle();
                    nuevo.putInt("pos",bundle.getInt("pos"));
                    nuevo.putInt("dia", 1);
                    temp.setArguments(nuevo);
                    return temp;
                }
                case 2:{
                    ListaResultados3Fragment temp = new ListaResultados3Fragment();
                    Bundle nuevo = new Bundle();
                    nuevo.putInt("pos",bundle.getInt("pos"));
                    nuevo.putInt("dia", 2);
                    temp.setArguments(nuevo);
                    return temp;
                }
                case 3:{
                    ListaResultados4Fragment temp = new ListaResultados4Fragment();
                    Bundle nuevo = new Bundle();
                    nuevo.putInt("pos",bundle.getInt("pos"));
                    nuevo.putInt("dia", 3);
                    temp.setArguments(nuevo);
                    return temp;
                }


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
                case 0: return getResources().getString(R.string.dia1Tab);
                case 1: return getResources().getString(R.string.dia2Tab);
                case 2: return getResources().getString(R.string.dia3Tab);
                case 3: return getResources().getString(R.string.dia4Tab);
            }
            return null;
        }
    }

}
