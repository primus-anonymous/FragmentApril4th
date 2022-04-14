package com.neocaptainnemo.fragmentapril4th.ui;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.neocaptainnemo.fragmentapril4th.R;
import com.neocaptainnemo.fragmentapril4th.ui.fm.FragmentRoot;

public class MainActivity extends AppCompatActivity implements ToolbarHolder {

    private DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer);

        NavigationView navigationView = findViewById(R.id.navigation);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_cities:

                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, new CitiesListFragment())
                                .commit();

                        drawerLayout.close();

                        return true;

                    case R.id.action_fragment:
                        getSupportFragmentManager().popBackStack();

                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, new FragmentRoot())
                                .commit();

                        drawerLayout.close();

                        return true;

                    case R.id.action_notifications:
                        getSupportFragmentManager().popBackStack();

                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container, new NotificationsFragment())
                                .commit();

                        drawerLayout.close();

                        return true;

                }
                return false;
            }
        });
    }

    @Override
    public void setToolbar(Toolbar toolbar) {
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        actionBarDrawerToggle.syncState();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @SuppressLint("NonConstantResourceId")
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.action_info:
//                Toast.makeText(this, "info", Toast.LENGTH_SHORT).show();
//                return true;
//            case R.id.action_share:
//                Toast.makeText(this, "share", Toast.LENGTH_SHORT).show();
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}