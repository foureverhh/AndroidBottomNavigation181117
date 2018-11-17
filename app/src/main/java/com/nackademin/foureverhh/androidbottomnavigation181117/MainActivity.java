package com.nackademin.foureverhh.androidbottomnavigation181117;



import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(nav);

        setNavFragment(new WikipediaFragment());
        bottomNavigationView.setSelectedItemId(R.id.nav_text);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener nav =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment fragmentSelected = null;
                    switch (item.getItemId()) {
                        case R.id.nav_image:
                            fragmentSelected = new ImageFragment();
                            bottomNavigationView.setItemBackgroundResource(R.color.colorGreen);
                            break;
                        case R.id.nav_text:
                            fragmentSelected = new WikipediaFragment();
                            bottomNavigationView.setItemBackgroundResource(R.color.colorRed);
                            break;
                        case R.id.nav_history:
                            fragmentSelected = new HistoryFragment();
                            bottomNavigationView.setItemBackgroundResource(R.color.colorPrimaryDark);
                            break;
                    }
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container,fragmentSelected)
                            .addToBackStack(null)
                            .commit();

                    return true;
                }
            };

    private void setNavFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,fragment)
                .addToBackStack(null)
                .commit();

    }
}



