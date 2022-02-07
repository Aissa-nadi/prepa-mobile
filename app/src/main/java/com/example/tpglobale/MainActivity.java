package com.example.tpglobale;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gallery gallery = findViewById(R.id.gallery);

        gallery.setAdapter(new GalleryAdapter(this));


        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0)
                {
                    Car car = new Car(1,"car 1","desc 1");
                    Intent i = new Intent(MainActivity.this,ListeViewActivity.class);
                    i.putExtra("Car",car);
                    startActivity(i);
                }
                if(position == 1)
                {
                    Intent i = new Intent(MainActivity.this,AddEditNoteActivity.class);
                    startActivity(i);
                }
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example, menu);
        return true;
    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mail:
                Intent i = new Intent(MainActivity.this,ListeViewActivity.class);
                startActivity(i);
                Toast.makeText(this, "Selected Item: mail " , Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Intent i2 = new Intent(MainActivity.this,settingsActivity.class);
                startActivity(i2);
                Toast.makeText(this, "Selected Item: upload" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.upload:
                Toast.makeText(this, "Selected Item: uplaod " , Toast.LENGTH_SHORT).show();
               break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }


}