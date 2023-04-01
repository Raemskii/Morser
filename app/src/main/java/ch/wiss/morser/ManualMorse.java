package ch.wiss.morser;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.ToneGenerator;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class ManualMorse extends AppCompatActivity {

    Button btn;
    CameraManager cam;
    String camId;
    ToneGenerator toneGen;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_morse);

        cam = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            camId = cam.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

        toneGen = new ToneGenerator(AudioManager.STREAM_MUSIC, 100);

        btn = findViewById(R.id.btnMorse);
        btn.setOnTouchListener((view, motionEvent) -> {
            if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                Log.d("PRESSED", "Button Pressed");
                setLightOn();
            } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                Log.d("RELEASED", "Button released");
                setLightOff();
            }
            return true;
        });
    }

    private void setLightOn(){
        try {
            toneGen.startTone(ToneGenerator.TONE_CDMA_ANSWER);
            cam.setTorchMode(camId, true);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    private void setLightOff(){
        try {
            toneGen.stopTone();
            cam.setTorchMode(camId, false);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }
}