package com.example.nata.game;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Game extends AppCompatActivity implements View.OnClickListener {

    Story story = new Story();
    Button bth1, bth0, bth2, end;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initView();
        setParams();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bth0:
                story.go(0);
                setParams();
                break;
            case R.id.bth1:
                story.go(1);
                setParams();
                break;
            case R.id.bth2:
                story.go(2);
                setParams();
                break;
            case R.id.end:
                final Intent i = new Intent(Game.this, Menu.class);
                startActivity(i);
        }
    }

    void initView(){
        bth0=findViewById(R.id.bth0);
        bth1=findViewById(R.id.bth1);
        bth2=findViewById(R.id.bth2);
        end=findViewById(R.id.end);
        text=findViewById(R.id.text);
        bth0.setOnClickListener(this);
        bth1.setOnClickListener(this);
        bth2.setOnClickListener(this);
        end.setOnClickListener(this);
        hideButoon(end);
    }

    void setParams(){
        text.setText(story.current_situation.text);
        switch (story.current_situation.direction.length){
            case 0:
                showButoon(end,0);
                hideButoon(bth0);
                hideButoon(bth1);
                hideButoon(bth2);
                break;
            case 1:
                showButoon(bth0,1);
                hideButoon(bth1);
                hideButoon(bth2);
                break;
            case 2:
                showButoon(bth0,1);
                showButoon(bth1,2);
                hideButoon(bth2);
                break;
            case 3:
                showButoon(bth0,1);
                showButoon(bth1,2);
                showButoon(bth2,3);
                break;
        }
    }

    void showButoon(Button bth, int var){
        bth.setEnabled(true);
        bth.setVisibility(View.VISIBLE);
        if (var!=0){
            bth.setText(story.current_situation.direction[var-1].tb);
        }else {
            bth.setText("Выйти в меню");
        }
    }

    void hideButoon(Button bth){
        bth.setEnabled(false);
        bth.setVisibility(View.INVISIBLE);
    }
}
