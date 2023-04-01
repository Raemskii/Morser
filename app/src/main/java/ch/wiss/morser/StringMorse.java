package ch.wiss.morser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class StringMorse extends AppCompatActivity {

    Button btnStart;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string_morse);

        btnStart = findViewById(R.id.btnMorseStart);
        input = findViewById(R.id.editTextInput);
    }

    public void startMorsing(){
        char[] textArray = input.toString().toCharArray();

        ArrayList<String> soundArray = generateSoundString(textArray);

        generateSounds(soundArray);
    }

    private void generateSounds(ArrayList<String> soundArray) {

        for(int i = 0; i < soundArray.size(); i++){

        }
    }

    private ArrayList<String> generateSoundString(char[] textArray) {

        ArrayList<String> result = new ArrayList<>();

        for(int i = 0; i < textArray.length; i++){
            switch(textArray[i]){
                case 'a': result.add("sl"); break;
                case 'b': result.add("lsss"); break;
                case 'c': result.add("lsls"); break;
                case 'd': result.add("lss"); break;
                case 'e': result.add("s"); break;
                case 'f': result.add("ssls"); break;
                case 'g': result.add("lls"); break;
                case 'h': result.add("ssss"); break;
                case 'i': result.add("ss"); break;
                case 'j': result.add("slll"); break;
                case 'k': result.add("lsl"); break;
                case 'l': result.add("slss"); break;
                case 'm': result.add("ll"); break;
                case 'n': result.add("ls"); break;
                case 'o': result.add("lll"); break;
                case 'p': result.add("slls"); break;
                case 'q': result.add("llsl"); break;
                case 'r': result.add("sls"); break;
                case 's': result.add("sss"); break;
                case 't': result.add("l"); break;
                case 'u': result.add("ssl"); break;
                case 'v': result.add("sssl"); break;
                case 'w': result.add("sll"); break;
                case 'x': result.add("lssl"); break;
                case 'y': result.add("lsll"); break;
                case 'z': result.add("llss"); break;
            }
        }
        return result;
    }
}