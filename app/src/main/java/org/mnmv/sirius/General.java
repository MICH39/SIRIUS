package org.mnmv.sirius;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class General extends AppCompatActivity {

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u_general);

        //Верхняя
        Toolbar myToolbar = findViewById(R.id.sirius_bar);
        setSupportActionBar(myToolbar);

        //Нижняя Панелька
        BottomNavigationView bottomNavigationView = findViewById(R.id.bnve);
        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(1);
        menuItem.setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_marks:
                        Intent int_to_posts = new Intent(General.this, Marks.class);
                        startActivity(int_to_posts);
                        overridePendingTransition(0, 0);
                        finish();
                        break;
                    case R.id.nav_menu:

                        break;
                    case R.id.nav_sets:
                        Intent int_to_sets = new Intent(General.this, Settings.class);
                        startActivity(int_to_sets);
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.nav_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_sets:
                Toast.makeText(this, "Скоро", Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
}