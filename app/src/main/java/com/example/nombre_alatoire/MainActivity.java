package com.example.nombre_alatoire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nombre_alatoire.R;


public class MainActivity extends AppCompatActivity {
    TextView hello_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        hello_txt = findViewById(R.id.hello);
        registerForContextMenu(hello_txt);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_contexte, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.context_edit) {
            // processing ...
            Toast.makeText(this, "this is the edit menu", Toast.LENGTH_LONG).show();
            return true;
        } else if (item.getItemId() == R.id.context_share) {
            // processing ...
            Toast.makeText(this, "this is the share menu", Toast.LENGTH_LONG).show();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        try {
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.options_settings) {
            showSettings();
            return true;
        } else if (item.getItemId() == R.id.Favorite) {
            showFavorite();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void showFavorite() {
        Toast.makeText(this, "this is the favorite menu", Toast.LENGTH_LONG).show();
    }

    private void showSettings() {
        Toast.makeText(this, "this is the Settings menu", Toast.LENGTH_LONG).show();
    }


    public void onClickShowAlert(View view) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Edit Text");
        alertDialog.setMessage("change the text content ....");
        alertDialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "this is the edit menu", Toast.LENGTH_LONG).show();
            }
        });

        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Cancel state", Toast.LENGTH_LONG).show();
            }
        });
        alertDialog.show();
    }
}