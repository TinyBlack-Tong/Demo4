package com.example.demo5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.RunnableFuture;

public class MainActivity extends AppCompatActivity {
    private Button b1;
    private Button b2;
    private Button b3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView t1;

        t1=findViewById(R.id.t1);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);


        final Handler handler=new Handler(){
            public void handleMessage(Message msg){
                t1.setText(msg.arg1+"");
            }
        };




        final Runnable myWorker=new Runnable() {
            @Override
            public void run() {
//                long endtime = System.currentTimeMillis() + 10 * 1000;
//                while (System.currentTimeMillis() < endtime) {
//                    while(!Thread.interrupted()){
//                        synchronized (this) {
//                            try {
//                                wait();
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
//
//                    }
//
//                }

                int progress=0;
                while (progress<=100){
                    Message msg=new Message();
                    msg.arg1=progress;
                    handler.sendMessage(msg);
                    progress+=10;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                Message msg=handler.obtainMessage();
                msg.arg1=-1;
                handler.sendMessage(msg);

            }

        };

        handler.post(new Runnable() {
            @Override
            public void run() {
                t1.setText("123");
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread workThread = new Thread(null, myWorker, "workerThread");
                workThread.start();

            }
        });

//        b2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Thread workThread =new Thread(null,myWorker,"workerThread");
//                workThread.start();
//            }
//        });
//



    }
}
