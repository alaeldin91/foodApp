package com.example.foodapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.foodapp.databinding.ActivityMainBinding;
import com.firebase.ui.auth.AuthUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.io.File;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    NavigationView navigationView;
    BottomNavigationView bottomNavigationView;
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private NavController navController;

    private static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }

            }
        }
        assert dir != null;
        return dir.delete();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.appBarMain.toolbar);
        initializeView();
    }

    private void logout() {
        trimCache(this);
        AuthUI.getInstance().signOut(MainActivity.this).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                startActivity(new Intent(MainActivity.this, UserAuthentication.class));
            } else {
                Toast.makeText(this, " the Logout is problem", Toast.LENGTH_SHORT).show();
            }

        });
    }

    private void trimCache(Context context) {
        try {
            File dir = context.getCacheDir();
            if ((dir != null) && (dir.isDirectory())) {
                deleteDir(dir);
            }
        } catch (Exception e) {
        }
    }

    private void initializeView() {
        drawer = binding.drawerLayout;
        navigationView = binding.navView;
        bottomNavigationView = binding.bottomNavigation;
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        navController = Navigation.findNavController(this, R.id.fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        binding.appBarMain.textToolBar.setText(getString(R.string.menu_home));
        //AppBarConfiguration appBarBottomConfiguration = new AppBarConfiguration.Builder(
        //      R.id.home, R.id.favourite)
        //    .build();
        navigationView.setNavigationItemSelectedListener(this);
        //  NavigationUI.setupActionBarWithNavController(this, navController, appBarBottomConfiguration);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

    /**  private void eventBottomNavigation() {
     bottomNavigationView.setOnItemSelectedListener(item -> {
     NavigationUI.onNavDestinationSelected(item, navController);
     Fragment fragment;
     int id = item.getItemId();
     if (id == R.id.home) {
     fragment = new HomeFragment();
     loadFragment(fragment);
     return true;
     } else if (id == R.id.favourite) {
     fragment = new FavouriteFragment();
     Log.i("fragment", fragment + "");
     loadFragment(fragment);
     return true;
     }
     return false;
     });
     }**/
    /**
     * private void loadFragment(Fragment fragment) {
     * FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
     * fragmentTransaction.replace(R.id.fragment, fragment);
     * fragmentTransaction.addToBackStack(null);
     * fragmentTransaction.commit();
     * }
     **/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.navLogout) {
            logout();
        }
        return false;
    }
}