package com.example.irek.zadanie_rekrutacyjne;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ListView lvLista;
    Button bStart;
    Button bStop;

    private boolean startLoop;
    private int previousId = -1;
    private static int refreshRate = 1;// in seconds
    private MyListAdapter adapter;
    private ArrayList<Element> elementList = new ArrayList<Element>();
    private TaskList tasks = new TaskList();

    private Context context;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        context = this;

        lvLista = (ListView) findViewById( R.id.lv_list );

        bStart = (Button) findViewById( R.id.Start );
        bStop = (Button) findViewById( R.id.Stop );

        bStart.setOnClickListener( this );
        bStop.setOnClickListener( this );

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.Start:
                startLoop = true;
                bStop.setText( "Stop" );
                myThread().start();
                break;

            case R.id.Stop:
                if (!startLoop) {
                    elementList.clear();
                    adapter = new MyListAdapter( context, R.layout.element_list, elementList );
                    lvLista.setAdapter( adapter );
                }
                startLoop = false;
                bStop.setText( "Reset" );

                break;
        }
    }

    public Thread myThread() {

        handler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                elementList = tasks.List;
                adapter = new MyListAdapter( context, R.layout.element_list, elementList );
                lvLista.setAdapter( adapter );
            }
        };
        Thread thread = new Thread( new Runnable() {
            int randomElement;

            @Override
            public void run() {
                try {
                    int updatecount = 21;
                    while (startLoop) {

                        if (tasks.size() < 5) {
                            tasks.addElement();
                        } else {
                            Random r = new Random();
                            int randomNumber = r.nextInt( 5 );
                            randomElement = randomNumber % 5;

                            if (updatecount == 21) { // 35%
                                updatecount = 1;
                                tasks.resetElement( randomElement );
                            } else if (updatecount % 3 == 0) { // 35%
                                tasks.resetElement( randomElement );
//                                tasks.addPreviousValueToElement( randomElement, previousId );
                            } else if (updatecount % 8 == 0) { // 10%
                                tasks.deleteElement( randomElement );
//                                tasks.addPreviousValueToElement( randomElement, previousId );
                            } else if (updatecount % 19 == 0) { // 5%
                                tasks.addPreviousValueToElement( randomElement, previousId );
                            } else { // 50%
                                tasks.incrementElement( randomElement );
                            }

                             updatecount++;
                        }

                        Message message = new Message();
                        handler.sendMessage( message );

                        previousId = randomElement;
                        Thread.sleep( refreshRate * 1000 );

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } );

        return thread;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState( outState );

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState( savedInstanceState );
    }


}
