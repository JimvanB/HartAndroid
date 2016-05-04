package heart.jim.com.heart;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {

    Button btTime, btSubmitHeart, btSubmitActivity;
    EditText etSys, etDia, etRate;
    Spinner spIntensity, spDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btTime = (Button) findViewById(R.id.btSetTime);
        btSubmitHeart = (Button) findViewById(R.id.btSubmitMeasurement);
        btSubmitActivity = (Button) findViewById(R.id.btSubmitActivity);

        etSys = (EditText) findViewById(R.id.heartSys);
        etDia = (EditText) findViewById(R.id.heartDia);
        etRate = (EditText) findViewById(R.id.heartPulse);

        spIntensity = (Spinner) findViewById(R.id.spIntensity);
        spDuration = (Spinner) findViewById(R.id.spDuration);


        btTime.setOnClickListener(this);
        btSubmitHeart.setOnClickListener(this);
        btSubmitActivity.setOnClickListener(this);
        spDuration.setOnItemSelectedListener(this);
        spIntensity.setOnItemSelectedListener(this);

        setSpinners();
    }

    public void setSpinners(){
        String[] arrayDuration = new String[] {
                "0.5", "1", "1.5", "2", "2.5", "3","3.5", "4", "4.5", "5", "5.5"
        };
        Spinner s = (Spinner) findViewById(R.id.spDuration);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arrayDuration);
        s.setAdapter(adapter);

        String[] arrayIntensity = new String[] {
                "Low", "Normal", "High"};
        Spinner d = (Spinner) findViewById(R.id.spIntensity);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arrayIntensity);
        d.setAdapter(adapter2);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btSubmitActivity:
                Connector.uploadAcitivty();
                break;


            case R.id.btSubmitMeasurement:
                Connector.uploadMeasurement();
                break;


        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
