package tw.tcnr07.m0608b;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class M0608b extends AppCompatActivity {

    private TextView t01;
    private Button b001;
    private String ans01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0608b);
        setupViewcomponent();
    }

    private void setupViewcomponent() {

        b001=(Button)findViewById(R.id.m004_b01);
        t01=(TextView)findViewById(R.id.m004_t001);
        //設定按鈕
        b001.setOnClickListener(b001on);
    }


    private View.OnClickListener b001on= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ans01=getString(R.string.m0608b_t001);
            for (int i = 1; i < 21; i++) {
                String idName = "m004_chb" + String.format("%02d", i);
                int resID = getResources().getIdentifier(idName, "id", getPackageName());
                CheckBox btn = ((CheckBox) findViewById(resID));
                if (btn.isChecked()) ans01 += btn.getText().toString();
            }
            t01.setText(ans01);
        }
    };
}