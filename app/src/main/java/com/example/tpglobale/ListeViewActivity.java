package com.example.tpglobale;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListeViewActivity extends AppCompatActivity {

    List<Car> cars = new ArrayList<Car>();
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle parametres = getIntent().getExtras();

        //Etudiant2 userrecupere = (Etudiant2) parametres.getSerializable("Etudiant");

        //Car car = (Car) parametres.getSerializable("Car");

        setContentView(R.layout.activity_liste_view);

        listView = findViewById(R.id.listView);
        addCars();

        ListViewAdapter adapter = new ListViewAdapter(cars,this);


        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();



    }

    public void addCars()
    {
        cars.clear();
        cars.add(new Car(R.drawable.bmw,"BWM","Description du BMW"));
        cars.add(new Car(R.drawable.mercedec,"Mercedec","Description du Merecedec"));
        cars.add(new Car(R.drawable.porsh,"Porshe","Description du Porshe"));

    }
}