package com.example.btkt;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar1, seekBar2;
    private TextView textViewSeekBar1, textViewSeekBar2;
    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "SeekBarPrefs";
    private static final String SEEK1_KEY = "seekbar1_value";
    private static final String SEEK2_KEY = "seekbar2_value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        seekBar1 = findViewById(R.id.seekBar);
        seekBar2 = findViewById(R.id.seekBar2);
        textViewSeekBar1 = findViewById(R.id.textViewSeekBar1);
        textViewSeekBar2 = findViewById(R.id.textViewSeekBar2);

        // Khởi tạo SharedPreferences
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);


        int savedSeek1 = sharedPreferences.getInt(SEEK1_KEY, 50); // giá trị mặc định là 50
        int savedSeek2 = sharedPreferences.getInt(SEEK2_KEY, 50); // giá trị mặc định là 50
        seekBar1.setProgress(savedSeek1);
        seekBar2.setProgress(savedSeek2);

        textViewSeekBar1.setText(String.valueOf(savedSeek1));
        textViewSeekBar2.setText(String.valueOf(savedSeek2));


        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewSeekBar1.setText(String.valueOf(progress));

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(SEEK1_KEY, progress);
                editor.apply();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewSeekBar2.setText(String.valueOf(progress));

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(SEEK2_KEY, progress);
                editor.apply();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
