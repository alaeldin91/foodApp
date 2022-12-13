package com.example.foodapp;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.foodapp.databinding.ActivityMainBinding;
import com.example.foodapp.helper.PreferencesHelper;
import com.firebase.ui.auth.AuthUI;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.button.MaterialButton;
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
   private PreferencesHelper preferencesHelper;
    private static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (String child : children) {
                boolean success = deleteDir(new File(dir, child));
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
        preferencesHelper.putString("phoneNumber","");
        preferencesHelper.putString("password","");
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
        }
        catch (Exception ignored) {
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
       NavController navController = Navigation.findNavController(this, R.id.fragment);
       NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
       NavigationUI.setupWithNavController(navigationView, navController);
       NavigationUI.setupWithNavController(bottomNavigationView, navController);
        binding.appBarMain.textToolBar.setText(getString(R.string.menu_home));
        AppBarConfiguration appBarBottomConfiguration = new AppBarConfiguration.Builder(
              R.id.home, R.id.favourite)
            .build();
       navigationView.setNavigationItemSelectedListener(this);
          NavigationUI.setupActionBarWithNavController(this, navController, appBarBottomConfiguration);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        preferencesHelper = new PreferencesHelper(this);
    }


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
            showDialogLogout(navigationView);
        }
        return false;
    }

    public void showDialogLogout(View v) {
        Dialog dialogLogout = new Dialog(v.getContext());
        dialogLogout.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogLogout.setContentView(R.layout.dialoge_logout);
        dialogLogout.setCancelable(true);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialogLogout.getWindow().getAttributes());
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
        MaterialButton ok = dialogLogout.findViewById(R.id.btnLogout);
        MaterialButton cancel = dialogLogout.findViewById(R.id.btnCancel);
        dialogLogout.show();
        ok.setOnClickListener(view -> logout());
        cancel.setOnClickListener(view -> dialogLogout.dismiss());
    }
}