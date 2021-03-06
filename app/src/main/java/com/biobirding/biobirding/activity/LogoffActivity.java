package com.biobirding.biobirding.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.biobirding.biobirding.R;

public class LogoffActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logoff);

        //Remove as sessões de preferência do aplicativo
        SharedPreferences sharedPref = getSharedPreferences("bio", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.apply();

        //Exclui a pilha de atividades em execução
        Intent i = new Intent(this, LoginActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
        finish();
    }
}
