package com.example.quiz;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.drawerlayout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), this::onApplyWindowInsets);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setItemIconTintList(null);
        drawerLayout = findViewById(R.id.drawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("ObsoleteSdkInt")
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.facebookPage) {
                    // Handle facebookPage action
                } else if (id == R.id.website) {
                    // Handle website action
                } else if (id == R.id.nav_privacy_policy) {
                    // Handle privacy policy action
                } else if (id == R.id.nav_terms_conditions) {
                    // Handle terms and conditions action
                } else if (id == R.id.more) {
                    // Handle more action
                } else if (id == R.id.nav_rate) {
                    Uri uri = Uri.parse("market://details?id=" + getPackageName());
                    final Intent goToMarket = getIntent(uri);
                    try {
                        startActivity(goToMarket);
                    } catch (ActivityNotFoundException e) {
                        startActivity(new Intent(Intent.ACTION_VIEW,
                                Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
                    }
                } else if (id == R.id.nav_share) {
                    final Intent shareIntent = getIntent();
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } else {
                    return false;
                }
                return true;
            }

            @NonNull
            private Intent getIntent() {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Quiz App");
                String shareMessage = "This Is Best Application For Quiz App.\n\n";
                shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + getPackageName();
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                return shareIntent;
            }

            @SuppressLint("ObsoleteSdkInt")
            @NonNull
            private Intent getIntent(Uri uri) {
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                            Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                            Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                }
                return goToMarket;
            }


        });

        }

    public void C(View view) {
        Intent intent = new Intent(MainActivity.this,QuestionActivity.class);
        startActivity(intent);
    }

    public void Cpp(View view) {
        Intent intent = new Intent(MainActivity.this,QuestionActivity2.class);
        startActivity(intent);
    }

    public void Python(View view) {
        Intent intent = new Intent(MainActivity.this,QuestionActivity3.class);
        startActivity(intent);
    }

    public void HTML(View view) {
        Intent intent = new Intent(MainActivity.this,QuestionActivity4.class);
        startActivity(intent);
    }

    private WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
        Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        return insets;



    }
}
