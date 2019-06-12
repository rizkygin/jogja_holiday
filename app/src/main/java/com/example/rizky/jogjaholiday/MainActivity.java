package com.example.rizky.jogjaholiday;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.IntentCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.bumptech.glide.load.engine.Resource;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jakewharton.processphoenix.ProcessPhoenix;

import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TabAdapter adapter;
    RecyclerView recyclerView;



    private TabLayout tabLayout;
    private ViewPager viewPager;

    private FirebaseDatabase mFirebaseDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthLisetener;
    private DatabaseReference myRef;
    private String userID;

    int pos;
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);




        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);


        adapter = new TabAdapter(getSupportFragmentManager());
        String pantai  = getString(R.string.pantai);
        String bukit  = getString(R.string.bukit);
        String Goa  = getString(R.string.goa);
        adapter.addFragment(new PantaiFragment(), pantai);
        adapter.addFragment(new BukitFragment(), bukit);
        adapter.addFragment(new GoaFragment(), Goa);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);



    }





    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
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
//
//        SearchView searchView = (SearchView) menu.findItem(R.id.searchView).getActionView();
//        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
//        SearchableInfo searchableInfo = searchManager.getSearchableInfo(getComponentName());
//        searchView.setSearchableInfo(searchableInfo);
//        searchView.setSubmitButtonEnabled(true);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                Toast.makeText(getApplicationContext(),query,Toast.LENGTH_LONG).show();
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                Toast.makeText(getApplicationContext(),newText,Toast.LENGTH_LONG).show();
//                return false;
//            }
//        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.Indonesia) {
            setAplocal("in");
            Intent refresh = new Intent(this,splashScreen.class);
            startActivity(refresh);
            return true;
        }
        else if( id == R.id.English){
            setAplocal("en");
            Intent refresh = new Intent(this,splashScreen.class);
            startActivity(refresh);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setAplocal(String localCode) {
        Resources res = getResources();
        DisplayMetrics  dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.setLocale(new Locale( localCode.toLowerCase()));

        res.updateConfiguration(conf,dm);
//
//        Intent nextIntent = new Intent(this,splashScreen.class);
//                ProcessPhoenix.triggerRebirth(this, nextIntent);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        item.setChecked(true);
        switch (item.getItemId()){
            case R.id.home:
                break;
            case R.id.nav_help:
                break;
            case R.id.nav_logout:
                logout();
                break;
        }
        drawer.closeDrawers();
        return true;
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }


}
