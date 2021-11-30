package tw.tcnr07.m0607;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class M0504 extends AppCompatActivity {

    private CheckBox chb001,chb002,chb003,chb004,chb005;
    private CheckBox chb006,chb007,chb008,chb009,chb010;
    private CheckBox chb011,chb012,chb013,chb014,chb015;
    private CheckBox chb016,chb017,chb018,chb019,chb020;
    private TextView t01;
    private Button b001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0504);
        setupViewcomponent();
    }

    private void setupViewcomponent() {
        Intent intent = this.getIntent();
        String mode_title = intent.getStringExtra("class_title");
        this.setTitle(mode_title);
        chb001=(CheckBox)findViewById(R.id.m004_chb01);
        chb002=(CheckBox)findViewById(R.id.m004_chb02);
        chb003=(CheckBox)findViewById(R.id.m004_chb03);
        chb004=(CheckBox)findViewById(R.id.m004_chb04);
        chb005=(CheckBox)findViewById(R.id.m004_chb05);
        chb006=(CheckBox)findViewById(R.id.m004_chb06);
        chb007=(CheckBox)findViewById(R.id.m004_chb07);
        chb008=(CheckBox)findViewById(R.id.m004_chb08);
        chb009=(CheckBox)findViewById(R.id.m004_chb09);
        chb010=(CheckBox)findViewById(R.id.m004_chb10);
        chb011=(CheckBox)findViewById(R.id.m004_chb11);
        chb012=(CheckBox)findViewById(R.id.m004_chb12);
        chb013=(CheckBox)findViewById(R.id.m004_chb13);
        chb014=(CheckBox)findViewById(R.id.m004_chb14);
        chb015=(CheckBox)findViewById(R.id.m004_chb15);
        chb016=(CheckBox)findViewById(R.id.m004_chb16);
        chb017=(CheckBox)findViewById(R.id.m004_chb17);
        chb018=(CheckBox)findViewById(R.id.m004_chb18);
        chb019=(CheckBox)findViewById(R.id.m004_chb19);
        chb020=(CheckBox)findViewById(R.id.m004_chb20);

        b001=(Button)findViewById(R.id.m004_b01);
        t01=(TextView)findViewById(R.id.m004_t001);
        //設定按鈕
        b001.setOnClickListener(b001on);
    }

    private View.OnClickListener b001on= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String ans01=getString(R.string.m0504_t001);
            if(chb001.isChecked()) ans01+=chb001.getText().toString()+" ";
            if(chb002.isChecked()) ans01+=chb002.getText().toString()+" ";
            if(chb003.isChecked()) ans01+=chb003.getText().toString()+" ";
            if(chb004.isChecked()) ans01+=chb004.getText().toString()+" ";
            if(chb005.isChecked()) ans01+=chb005.getText().toString()+" ";
            if(chb006.isChecked()) ans01+=chb006.getText().toString()+" ";
            if(chb007.isChecked()) ans01+=chb007.getText().toString()+" ";
            if(chb008.isChecked()) ans01+=chb008.getText().toString()+" ";
            if(chb009.isChecked()) ans01+=chb009.getText().toString()+" ";
            if(chb010.isChecked()) ans01+=chb010.getText().toString()+" ";
            if(chb011.isChecked()) ans01+=chb011.getText().toString()+" ";
            if(chb012.isChecked()) ans01+=chb012.getText().toString()+" ";
            if(chb013.isChecked()) ans01+=chb013.getText().toString()+" ";
            if(chb014.isChecked()) ans01+=chb014.getText().toString()+" ";
            if(chb015.isChecked()) ans01+=chb015.getText().toString()+" ";
            if(chb016.isChecked()) ans01+=chb016.getText().toString()+" ";
            if(chb017.isChecked()) ans01+=chb017.getText().toString()+" ";
            if(chb018.isChecked()) ans01+=chb018.getText().toString()+" ";
            if(chb019.isChecked()) ans01+=chb019.getText().toString()+" ";
            if(chb020.isChecked()) ans01+=chb020.getText().toString()+" ";
            t01.setText(ans01);

        }
    };
}