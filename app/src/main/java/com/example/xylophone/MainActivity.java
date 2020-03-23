package com.example.xylophone;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonC;
    Button buttonD;
    Button buttonE;
    Button buttonF;
    Button buttonG;
    Button buttonA;
    Button buttonB;

    MediaPlayer player = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        catchReferencesFromLayout();
        Button[] buttons = new Button[7];
        buttons[0] = buttonC;
        buttons[1] = buttonD;
        buttons[2] = buttonE;
        buttons[3] = buttonF;
        buttons[4] = buttonG;
        buttons[5] = buttonA;
        buttons[6] = buttonB;
        registerForEvents(buttons);
    }

    private void catchReferencesFromLayout() {
        this.buttonC = findViewById(R.id.buttonC);
        this.buttonD = findViewById(R.id.buttonD);
        this.buttonE = findViewById(R.id.buttonE);
        this.buttonF = findViewById(R.id.buttonF);
        this.buttonG = findViewById(R.id.buttonG);
        this.buttonA = findViewById(R.id.buttonA);
        this.buttonB = findViewById(R.id.buttonB);
    }

    private void registerForEvents(Button[] buttons) {
        for(final Button button : buttons){
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    buttonPressed(button);
                }
            });
        }
    }

    private void buttonPressed(Button button) {
        playSong(button.getText());
    }

    private void playSong(CharSequence musicalNote) {
        //player.setDataSource();
    }
}
