package com.biobirding.biobirding;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.biobirding.biobirding.activity.MainActivity;import com.biobirding.biobirding.helper.CustomSnackBar;

public class BaseActivity extends AppCompatActivity {

    protected int accessLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPref = getSharedPreferences("bio", Context.MODE_PRIVATE);
        boolean authenticate = sharedPref.getBoolean("authenticate_bio", false);
        this.accessLevel = sharedPref.getInt("access_level", 0);

        if(!authenticate){
            startActivity(new Intent(MainActivity.BaseActivity.this, LoginActivity.class));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.about:
                CustomSnackBar.make(getWindow().getDecorView(), getResources().getString(R.string.dev));
                return true;

            case R.id.editAccount:
                CustomSnackBar.make(getWindow().getDecorView(), getResources().getString(R.string.dev));
                return true;

            case R.id.loggof:
                startActivity(new Intent(MainActivity.BaseActivity.this, LogoffActivity.class));
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
