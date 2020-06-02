package com.example.xylophone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //    private void playSong(String musicalNote) {
//        String filename = "android.resource://" + this.getPackageName() + "/raw/" + musicalNote.toLowerCase();
//        MediaPlayer player = new MediaPlayer();
//
//        registerForPlayerEvent(player);
//
//        try { player.setDataSource(this, Uri.parse(filename)); } catch (Exception e) {}
//        try { player.prepare(); } catch (Exception e) {}
//        player.start();
//    }
//
//    private void registerForPlayerEvent(MediaPlayer player) {
//        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mediaPlayer) {
//                mediaPlayer.release();
//            }
//        });
//    }
//    private class ButtonAlphaEffect extends AsyncTask<Void, Void, Void> {
//
//        Button button;
//
//        ButtonAlphaEffect(Button button){
//            this.button = button;
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//            this.button.setAlpha(1);
//        }
//    }
}