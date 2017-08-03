package com.example.jonathanguerrero.senasoftapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private MainFragment mainFragment;
    private CategoryFragment categoryFragment;
    private AboutFragment aboutFragment;
    private ResultadoFragment resultadoFragment;
    private FragmentManager fragmentManager = getSupportFragmentManager();


    private FloatingActionButton fab;


    public void showFloattingButton(){
        this.fab.show();
    }
    public void hideFloattingButton(){
        this.fab.hide();
    }
    public void setBarTitle(int opcion){
        switch (opcion){
            case 0:
                getSupportActionBar().setTitle("Home");
                break;
            case 1:
                getSupportActionBar().setTitle("Categorias");
                break;
            case 2:
                getSupportActionBar().setTitle("Resultados");
                break;
            case 3:
                getSupportActionBar().setTitle("Acerca de");
                break;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setBarTitle(0);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideFloattingButton();
                Fragment currentFragment = fragmentManager.findFragmentById(R.id.mainLayout);
                if (currentFragment instanceof TabResultadosFragment) {
                    fragmentManager.beginTransaction().replace(R.id.mainLayout, resultadoFragment).commit();
                }else{
                    if (currentFragment instanceof PdfFragment) {
                        fragmentManager.beginTransaction().replace(R.id.mainLayout, categoryFragment).commit();
                    }
                }

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

                initializeControls();

    }


    private void initializeControls() {
        mainFragment = new MainFragment();
        categoryFragment = new CategoryFragment();
        aboutFragment = new AboutFragment();
        resultadoFragment = new ResultadoFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.mainLayout, mainFragment).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            //General
            fab.hide();
            fragmentManager.beginTransaction().replace(R.id.mainLayout, mainFragment).commit();
        } else if (id == R.id.nav_gallery) {
            //Categoria
            fab.hide();
            fragmentManager.beginTransaction().replace(R.id.mainLayout, categoryFragment).commit();
        } else if (id == R.id.nav_slideshow) {
            //Resultados
            fab.hide();
            fragmentManager.beginTransaction().replace(R.id.mainLayout, resultadoFragment).commit();
        } else if (id == R.id.nav_share) {
            fab.hide();
            fragmentManager.beginTransaction().replace(R.id.mainLayout, aboutFragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
