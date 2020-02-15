package io.github.laplacedemon.calc24;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView resultShowText = (TextView)findViewById(R.id.resultShowText);
        final EditText editText = (EditText)findViewById(R.id.editText);
        Button calcButton = (Button)findViewById(R.id.calcButton);

        calcButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v){
                String text = editText.getText().toString();
                String[] s = text.trim().split("\\s+");
                if (s.length != 4) {
                    Toast.makeText(MainActivity.this, "请输入4个数字", Toast.LENGTH_LONG).show();
                    return ;
                }
                int[] ints = new int[s.length];
                for (int i = 0;i<ints.length;i++) {
                    try {
                        ints[i] = Integer.valueOf(s[i]);
                    } catch (Exception ex) {
                        Toast.makeText(MainActivity.this, "请输入4个数字", Toast.LENGTH_LONG).show();
                        return ;
                    }
                }

                resultShowText.setText("");
                Calc24Util.calcAndShow(resultShowText, ints[0], ints[1], ints[2], ints[3]);
            }
        });

        Button cleanButton = (Button)findViewById(R.id.cleanButton);
        cleanButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v){
                editText.setText("");
                resultShowText.setText("");
            }
        });
    }
}
