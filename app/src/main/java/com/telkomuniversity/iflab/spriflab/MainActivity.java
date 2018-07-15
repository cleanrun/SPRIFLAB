package com.telkomuniversity.iflab.spriflab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    // item dari layout
    private TextView tvForm;
    private TextView tvTabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvForm = findViewById(R.id.tvForm);
        tvTabel = findViewById(R.id.tvTabel);

        tvForm.setOnClickListener(this);
        tvTabel.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == tvForm){
            try{
                Intent formIntent = new Intent(MainActivity.this, FormRuanganActivity.class);
                startActivity(formIntent);
                // belom bikin onPause atau finish
            } catch(Exception e){
                Toast.makeText(MainActivity.this, "Exception detected!", Toast.LENGTH_SHORT).show();
            }
        }
        else if(view == tvTabel){
            try{
                Intent tabelIntent = new Intent(MainActivity.this, TabelActivity.class);
                startActivity(tabelIntent);
                // belom bikin onPause atau finish
            } catch(Exception e){
                Toast.makeText(MainActivity.this, "Exception detected!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menuAbout:
                Toast.makeText(MainActivity.this, getString(R.string.copyright), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuAdminLogin:
                Intent adminLoginIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(adminLoginIntent);
                finish();
                return true;
            default:
                return true;
        }
    }

}
