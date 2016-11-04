package com.example.irek.zadanie_rekrutacyjne;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ListView lvLista;
    Button bStart;
    Button bStop;
    private boolean stopLoop;
    private MyListAdapter adapter;
    private ArrayList<Element> elementList = new ArrayList<Element>();
    private TaskList tasks = new TaskList();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvLista = (ListView) findViewById(R.id.lv_list);

        bStart = (Button) findViewById(R.id.Start);
        bStop = (Button) findViewById(R.id.Stop);

        bStart.setOnClickListener(this);
        bStop.setOnClickListener(this);


        elementList = tasks.List;
        adapter = new MyListAdapter(this, R.layout.element_list, elementList);
        lvLista.setAdapter(adapter);
      //  tasks.addElement();



    }


    @Override
    public void onClick(View view) {

    }
}
