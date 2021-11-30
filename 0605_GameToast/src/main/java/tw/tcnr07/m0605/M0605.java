package tw.tcnr07.m0605;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class M0605 extends AppCompatActivity {

    private TextView s001;
    private TextView f000;
    private String user_select;
    private String answer;
    private ImageButton b001,b002,b003;
    private ImageView c001;
    private MediaPlayer startmusic;
    private MediaPlayer mediaWin;
    private MediaPlayer mediaLose;
    private MediaPlayer mediaDraw;
    private MediaPlayer goodnightmusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0605);
        setupViewComponent();
    }

    private void setupViewComponent() {
        b001=(ImageButton)findViewById(R.id.m0605_b001);
        b002=(ImageButton)findViewById(R.id.m0605_b002);
        b003=(ImageButton)findViewById(R.id.m0605_b003);
        c001=(ImageView)findViewById(R.id.m0605_c001);
        s001=(TextView)findViewById(R.id.m0605_s001);
        f000=(TextView)findViewById(R.id.m0605_f000);
        startmusic= MediaPlayer.create(getApplication(), R.raw.guess);
        startmusic.start();
        goodnightmusic=MediaPlayer.create(getApplication(), R.raw.goodnight);

        mediaWin= MediaPlayer.create(getApplication(), R.raw.vctory);
        mediaLose= MediaPlayer.create(getApplication(), R.raw.lose);
        mediaDraw= MediaPlayer.create(getApplication(), R.raw.haha);

        // --開啟片頭音樂-----
//        startmusic = MediaPlayer.create(getApplication(), R.raw.guess);
//        startmusic.start();
//
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
                case R.id.m0605_b001:  //選擇剪刀
                    switch (iComPlay){
                        case 1:
                            c001.setImageResource(R.drawable.scissors);
                            answer=getString(R.string.m0605_f000)+getString(R.string.m0605_f003); //平手
                            music(2);
                            f000.setTextColor(Color.YELLOW);
                            break;
                        case 2:
                            c001.setImageResource(R.drawable.stone);
                            answer=getString(R.string.m0605_f000)+getString(R.string.m0605_f002);  //輸
                            music(3);
                            f000.setTextColor(Color.RED);
                            break;
                        case 3:
                            c001.setImageResource(R.drawable.net);
                            answer=getString(R.string.m0605_f000)+getString(R.string.m0605_f001);  //贏
                            music(1);
                            f000.setTextColor(Color.GREEN);
                            break;
                    }
                    user_select=getString(R.string.m0605_s001)+" "+getString(R.string.m0605_b001);
                    break;

                case R.id.m0605_b002:  //選擇石頭
                    switch (iComPlay){
                        case 1:
                            c001.setImageResource(R.drawable.scissors);
                            answer=getString(R.string.m0605_f000)+getString(R.string.m0605_f001); //贏
                            music(1);
                            f000.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            c001.setImageResource(R.drawable.stone);
                            answer=getString(R.string.m0605_f000)+getString(R.string.m0605_f003);  //平
                            music(2);
                            f000.setTextColor(Color.YELLOW);
                            break;
                        case 3:
                            c001.setImageResource(R.drawable.net);
                            answer=getString(R.string.m0605_f000)+getString(R.string.m0605_f002);  //輸
                            music(3);
                            f000.setTextColor(Color.RED);
                            break;
                    }
                    user_select=getString(R.string.m0605_s001)+" "+getString(R.string.m0605_b002);
                    break;

                case R.id.m0605_b003:  //選擇布
                    switch (iComPlay){
                        case 1:
                            c001.setImageResource(R.drawable.scissors);
                            answer=getString(R.string.m0605_f000)+getString(R.string.m0605_f002); //輸
                            music(3);
                            f000.setTextColor(Color.RED);
                            break;
                        case 2:
                            c001.setImageResource(R.drawable.stone);
                            answer=getString(R.string.m0605_f000)+getString(R.string.m0605_f001);  //贏
                            music(1);
                            f000.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            c001.setImageResource(R.drawable.net);
                            answer=getString(R.string.m0605_f000)+getString(R.string.m0605_f003);  //平
                            music(2);
                            f000.setTextColor(Color.YELLOW);
                            break;
                    }
                    user_select=getString(R.string.m0605_s001)+" "+getString(R.string.m0605_b003);
                    break;
            }
            s001.setText(user_select);
            f000.setText(answer);
        }



    };

    private void music(int i) {
        if(startmusic.isPlaying())  startmusic.stop();
        if(mediaWin.isPlaying())  mediaWin.pause();
        if(mediaDraw.isPlaying())   mediaDraw.pause();
        if(mediaLose.isPlaying())   mediaLose.pause();
        switch (i){
            case 1:  //贏
                mediaWin.start();
                Toast.makeText(getApplicationContext(), R.string.m0605_f001, Toast.LENGTH_LONG).show();
                break;
            case 2:  //平
                mediaDraw.start();
                Toast.makeText(getApplicationContext(), R.string.m0605_f003, Toast.LENGTH_LONG).show();
                break;
            case 3:  //輸
                mediaLose.start();
                Toast.makeText(getApplicationContext(), R.string.m0605_f002, Toast.LENGTH_LONG).show();
                break;
            case 4:  //結束程式
                goodnightmusic.start();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        music(4);
        this.finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
            if(startmusic.isPlaying())  startmusic.stop();
    }

}