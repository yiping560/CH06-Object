package tw.tcnr07.m0602;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class M0602 extends AppCompatActivity {

    private TextView s001;
    private TextView f000;
    private String user_select;
    private String answer;
    private ImageButton b001,b002,b003;
    private ImageView c001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0602);
        setupViewComponent();
    }

    private void setupViewComponent() {
        b001=(ImageButton)findViewById(R.id.m0602_b001);
        b002=(ImageButton)findViewById(R.id.m0602_b002);
        b003=(ImageButton)findViewById(R.id.m0602_b003);
        c001=(ImageView)findViewById(R.id.m0602_c001);
        s001=(TextView)findViewById(R.id.m0602_s001);
        f000=(TextView)findViewById(R.id.m0602_f000);

        b001.setOnClickListener(b001on);
        b002.setOnClickListener(b001on);
        b003.setOnClickListener(b001on);
    }

    private View.OnClickListener b001on=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int iComPlay = (int) (Math.random() * 3 + 1); //亂數1剪刀2石頭3布
            // 1 - scissors, 2 - stone, 3 - net.

            switch (v.getId()){
                case R.id.m0602_b001:  //選擇剪刀
                    switch (iComPlay){
                        case 1:
                            c001.setImageResource(R.drawable.scissors);
                            answer=getString(R.string.m0602_f000)+getString(R.string.m0602_f003); //平手
                            f000.setTextColor(Color.YELLOW);
                            break;
                        case 2:
                            c001.setImageResource(R.drawable.stone);
                            answer=getString(R.string.m0602_f000)+getString(R.string.m0602_f002);  //輸
                            f000.setTextColor(Color.RED);
                            break;
                        case 3:
                            c001.setImageResource(R.drawable.net);
                            answer=getString(R.string.m0602_f000)+getString(R.string.m0602_f001);  //贏
                            f000.setTextColor(Color.GREEN);
                            break;
                    }
                    user_select=getString(R.string.m0602_s001)+" "+getString(R.string.m0602_b001);
                    break;

                case R.id.m0602_b002:  //選擇石頭
                    switch (iComPlay){
                        case 1:
                            c001.setImageResource(R.drawable.scissors);
                            answer=getString(R.string.m0602_f000)+getString(R.string.m0602_f001); //贏
                            f000.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            c001.setImageResource(R.drawable.stone);
                            answer=getString(R.string.m0602_f000)+getString(R.string.m0602_f003);  //平
                            f000.setTextColor(Color.YELLOW);
                            break;
                        case 3:
                            c001.setImageResource(R.drawable.net);
                            answer=getString(R.string.m0602_f000)+getString(R.string.m0602_f002);  //輸
                            f000.setTextColor(Color.RED);
                            break;
                    }
                    user_select=getString(R.string.m0602_s001)+" "+getString(R.string.m0602_b002);
                    break;

                case R.id.m0602_b003:  //選擇布
                    switch (iComPlay){
                        case 1:
                            c001.setImageResource(R.drawable.scissors);
                            answer=getString(R.string.m0602_f000)+getString(R.string.m0602_f002); //輸
                            f000.setTextColor(Color.RED);
                            break;
                        case 2:
                            c001.setImageResource(R.drawable.stone);
                            answer=getString(R.string.m0602_f000)+getString(R.string.m0602_f001);  //贏
                            f000.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            c001.setImageResource(R.drawable.net);
                            answer=getString(R.string.m0602_f000)+getString(R.string.m0602_f003);  //平
                            f000.setTextColor(Color.YELLOW);
                            break;
                    }
                    user_select=getString(R.string.m0602_s001)+" "+getString(R.string.m0602_b003);
                    break;
            }
            s001.setText(user_select);
            f000.setText(answer);
        }
    };
}