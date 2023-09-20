package com.example.eventmanagementproject2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView status;
    ConstraintLayout group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        status = findViewById(R.id.tv);

        group = findViewById(R.id.cl);
        group.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                handleTouchEvent(event);

                return true;
            }
        });

    }


    public void handleTouchEvent(MotionEvent me){

        String actionString;

        int count = me.getPointerCount();

        for(int i = 0; i < count; i++){

            int x = (int) me.getX(i);
            int y = (int) me.getY(i);
            int id = me.getPointerId(i);
            int action = me.getActionMasked();
            int actionIndex = me.getActionIndex();

            switch(action){

                case MotionEvent.ACTION_DOWN:
                    actionString =  "DOWN";
                    break;

                case MotionEvent.ACTION_UP:
                    actionString = "UP";
                    break;

                case MotionEvent.ACTION_POINTER_DOWN:
                    actionString = "Pointer down";
                    break;

                case MotionEvent.ACTION_POINTER_UP:
                    actionString = "Pointer up";
                    break;

                case MotionEvent.ACTION_MOVE:
                    actionString = "Moving";
                    break;

                default:
                    actionString = "";

            }

            String touch_status = "Action: " + actionString + " Index: " + actionIndex + " ID: " + id + " X: " + x + " Y:" + y;

            if(id == 0){

                status.setText(touch_status);

            }else{

                status.setText(touch_status);

            }


        }

    }
}