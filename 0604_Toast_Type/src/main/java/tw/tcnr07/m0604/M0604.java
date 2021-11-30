package tw.tcnr07.m0604;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class M0604 extends AppCompatActivity {

    private Button b001,b002,b003,b004;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m0604);
        setupViewComponent();
    }

    private void setupViewComponent() {
        b001=(Button)findViewById(R.id.m0604_b001);
        b002=(Button)findViewById(R.id.m0604_b002);
        b003=(Button)findViewById(R.id.m0604_b003);
        b004=(Button)findViewById(R.id.m0604_b004);

        b001.setOnClickListener(b001on);
        b002.setOnClickListener(b001on);
        b003.setOnClickListener(b001on);
        b004.setOnClickListener(b001on);
    }


    private View.OnClickListener b001on=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            toast=null;
            switch (v.getId()){
                case R.id.m0604_b001:
                    Toast.makeText(getApplicationContext(), getString(R.string.m0604_e001), Toast.LENGTH_LONG).show();
                    break;
                case R.id.m0604_b002:
                    toast=Toast.makeText(getApplicationContext(), getString(R.string.m0604_e001), Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER|Gravity.START, 0, 0);
                    toast.show();
//                    toast = Toast.makeText(getApplicationContext(), getString(R.string.m0604_b002), Toast.LENGTH_LONG);
//                    toast.setGravity(Gravity.CENTER, 0, 0);
//                    toast.show();
                    break;
                case R.id.m0604_b003:
                    toast=Toast.makeText(getApplicationContext(), getString(R.string.m0604_e001), Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.TOP|Gravity.END, 0, 0);
                    LinearLayout toastView=(LinearLayout) toast.getView();
                    ImageView imageCodeProject=new ImageView(getApplicationContext());
                    imageCodeProject.setImageResource(R.drawable.scissors);
                    toastView.addView(imageCodeProject, 0);
                    toast.show();

//                    toastView = (LinearLayout) toast.getView();
//                    ImageView imageCodeProject = new ImageView(getApplicationContext());
//                    imageCodeProject.setImageResource(R.drawable.ic_sample);
//                    toastView.addView(imageCodeProject, 0);
                    break;
                case R.id.m0604_b004:
                    LayoutInflater inflater = getLayoutInflater();
                    View layout = inflater.inflate(R.layout.custom, (ViewGroup) findViewById(R.id.llToast));

                    ImageView image = (ImageView) layout.findViewById(R.id.tvImageToast);
                    TextView title = (TextView) layout.findViewById(R.id.tvTitleToast);
                    TextView text = (TextView) layout.findViewById(R.id.tvTextToast);

                    image.setImageResource(R.drawable.scissors);
                    title.setText(getString(R.string.m0604_e001).toString());
                    text.setText(getString(R.string.m0604_e002).toString());
//-----------------------------------
//-----------------------------------
                    toast = new Toast(getApplicationContext());
                    toast.setGravity(Gravity.START | Gravity.TOP, 20, 40);
                    toast.setDuration(Toast.LENGTH_LONG);
                    toast.setView(layout);
                    toast.show();

                    break;
            }
        }
    };
}