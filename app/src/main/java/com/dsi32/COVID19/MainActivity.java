package com.dsi32.COVID19;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;



public class MainActivity extends AppCompatActivity{
    TextView TV;
    TextView TV1;
    TextView TV2;
    TextView TV3;
    TextView TV4;
    TextView TexteV;
    private DrawerLayout mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);
        }

        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(
                menuItem -> {
                    // set item as selected to persist highlight
                    menuItem.setChecked(true);
                    // close drawer when item is tapped
                    mDrawerLayout.closeDrawers();

                    // Add code here to update the UI based on the item selected
                    // For example, swap UI fragments here

                    return true;
                });
        Toast.makeText(this, getString(R.string.message), Toast.LENGTH_LONG).show();
        TexteV = findViewById(R.id.act1);
        TexteV.setOnClickListener(v -> {
            Intent inte = new Intent(MainActivity.this,MainActivityConnexion.class);
            startActivity(inte);
        });



        TV1 = findViewById(R.id.act4);
        TV1.setOnClickListener(v -> {
            Intent in = new Intent(MainActivity.this,MainActivityContact.class);
            startActivity(in);
        });
        TV2 = findViewById(R.id.act2);
        TV2.setOnClickListener(v -> {
            Intent inte = new Intent(MainActivity.this,MainActivityNotification.class);
            startActivity(inte);
        });
        TV3 = findViewById(R.id.act3);
        TV3.setOnClickListener(v -> {
            Intent inte = new Intent(MainActivity.this,MainActivityInformation.class);
            startActivity(inte);
        });
        TV4 = findViewById(R.id.act5);
        TV4.setOnClickListener(v -> {
            Intent inte = new Intent(MainActivity.this,MainActivityListeContact.class);
            startActivity(inte);
        });

        findViewById(R.id.log_out).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                disconnect();
            }
        });

    }

    private void signOut() {

        FirebaseAuth.getInstance().signOut();

    }

    public void disconnect() {
        signOut();
        finish();
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}


