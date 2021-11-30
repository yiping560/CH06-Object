package tw.tcnr07.m0607;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class M0501 extends AppCompatActivity {


    private Spinner s001;
    private Button b001;
    private TextView ans01;
    private EditText e001;
    private String sSex; //設定公有變數，選擇的性別，後續要給點按鈕判斷男女給答案

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0501);
        setupViewcomponent();
    }

    private void setupViewcomponent() {
        Intent intent = this.getIntent();
        String mode_title = intent.getStringExtra("class_title");
        this.setTitle(mode_title);
        s001 = (Spinner) findViewById(R.id.m0501_s001);
        e001 = (EditText) findViewById(R.id.m0501_e001);
        b001 = (Button) findViewById(R.id.m0501_b001);
        ans01 = (TextView) findViewById(R.id.m0501_f000);

        // 設定 spinner item 選項------------
//使用系統格式下拉式字體無法改變
//        ArrayAdapter<CharSequence> adapterSexList = ArrayAdapter.createFromResource(
//        this,
//        R.array.m0501_a001,
//        R.layout.support_simple_spinner_dropdown_item);
//--------------------------------------------------------------
        //使用自定義格式下拉式字體可以改變
        ArrayAdapter<CharSequence> adapterSexList = ArrayAdapter.createFromResource(
                this,
                R.array.m0501_a001,
                R.layout.spinner_item);

        s001.setAdapter(adapterSexList);
        s001.setOnItemSelectedListener(s001on);
        b001.setOnClickListener(b001on);
    }


    private AdapterView.OnItemSelectedListener s001on = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            sSex = parent.getSelectedItem().toString();  //設定公有變數，選擇的性別，後續要給點按鈕判斷男女給答案
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };


    private View.OnClickListener b001on = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String strSug = getString(R.string.m0501_f000);
            //----------------------------------------------------
            //檢查年齡是否輸入
            if (e001.getText().toString().length() > 0) {
                int iage = Integer.parseInt(e001.getText().toString());
                if (sSex.equals(getString(R.string.chk01))) {  //--判斷男生，chk01的值是男--
                    if (iage < 28) {
                        strSug += getString(R.string.m0501_f001);
                    } else if (iage > 33) {
                        strSug += getString(R.string.m0501_f003);
                    } else {
                        strSug += getString(R.string.m0501_f002);
                    }
                } else {     // -女生--
                    if (iage < 25) {
                        strSug += getString(R.string.m0501_f001);
                    } else if (iage > 30) {
                        strSug += getString(R.string.m0501_f003);
                    } else {
                        strSug += getString(R.string.m0501_f002);
                    }
                }
            } else {
                strSug = getString(R.string.nospace);
            }
            //----------------------------------------------------
            ans01.setText(strSug);
        }
    };
}