package tw.tcnr07.m0607;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class M0607 extends AppCompatActivity {
    private Intent intent=new Intent();
    private Button b001,b002,b003,b004,b005;
    private Button b006;
    private Button b007;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0607);
        setupViewcompoent();
    }

    private void setupViewcompoent() {
        b001=(Button)findViewById(R.id.m0607_b001);
        b002=(Button)findViewById(R.id.m0607_b002);
        b003=(Button)findViewById(R.id.m0607_b003);
        b004=(Button)findViewById(R.id.m0607_b004);
        b005=(Button)findViewById(R.id.m0607_b005);
        b006=(Button)findViewById(R.id.m0607_b006);
        b007=(Button)findViewById(R.id.m0607_b007);

        b001.setOnClickListener(b001on);
        b002.setOnClickListener(b001on);
        b003.setOnClickListener(b001on);
        b004.setOnClickListener(b001on);
        b005.setOnClickListener(b001on);
        b006.setOnClickListener(b001on);
        b007.setOnClickListener(b001on);

    }


    private View.OnClickListener b001on=new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.m0607_b001:
                intent.putExtra("class_title",getString(R.string.m0000_b0500));
                intent.setClass(M0607.this,M0500.class);
                break;
            case R.id.m0607_b002:
                intent.putExtra("class_title",getString(R.string.m0000_b0501));
                intent.setClass(M0607.this,M0501.class);
                break;
            case R.id.m0607_b003:
                intent.putExtra("class_title",getString(R.string.m0000_b0502));
                intent.setClass(M0607.this,M0502.class);
                break;
            case R.id.m0607_b004:
                intent.putExtra("class_title",getString(R.string.m0000_b0504));
                intent.setClass(M0607.this,M0504.class);
                break;
            case R.id.m0607_b005:
                intent.putExtra("class_title",getString(R.string.m0000_b0505));
                intent.setClass(M0607.this,M0505.class);
                break;
            case R.id.m0607_b006:
                intent.putExtra("class_title",getString(R.string.m0000_b0604));
                intent.setClass(M0607.this,M0604.class);
                break;
            case R.id.m0607_b007:
                intent.putExtra("class_title",getString(R.string.m0000_b0606));
                intent.setClass(M0607.this,M0606.class);
                break;

        }
        startActivity(intent);
    }

};

}