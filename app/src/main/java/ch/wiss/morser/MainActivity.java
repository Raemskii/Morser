package ch.wiss.morser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    Button btnManual;
    Button btnText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnManual = findViewById(R.id.mainBtnManual);
        btnText = findViewById(R.id.mainBtnText);
    }

    public void startManualActivity(View view){
        Log.d("MANUAL", "Manual started");

        Intent manual = new Intent(this, ManualMorse.class);
        startActivity(manual);
    }
}