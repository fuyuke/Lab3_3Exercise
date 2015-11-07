package my.edu.tarc.lab3_3exercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String textViewMessage;
    int fee = 0;
    int fee1 = 0;
    int fee2 = 0;
    TextView result;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button btnCalc;
    TextView finalMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinnerAge = (Spinner) findViewById(R.id.spinnerAge);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.age, android.R.layout.simple_spinner_item);
        spinnerAge.setOnItemSelectedListener(this);
        spinnerAge.setAdapter(adapter);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        textViewMessage = (parent.getItemAtPosition(position).toString());

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calcTotal(View v) {
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        int s = radioGroup.getCheckedRadioButtonId();


        if (textViewMessage.equals("below 5")) {
            fee = 50;
        } else if (textViewMessage.equals("6 to 10")){
            fee = 55;
        }else if(textViewMessage.equals("11 to 16")){
            fee=60;
        }else if (textViewMessage.equals("17 to 21")){
            fee = 70;
        }else if (textViewMessage.equals("22 to 30")){
            fee = 120;
        }  else if (textViewMessage.equals("31 to 40")){
            fee = 160;
        }   else if (textViewMessage.equals("41 to 50")){
            fee = 200;
        }   else if (textViewMessage.equals("over 50")){
            fee = 250;
        }
        if(s == R.id.btnMale){
            if(fee == 60 || fee == 160)
                fee1 = 50;
            else if(fee == 70)
                fee1 = 100;
            else if(fee == 120)
                fee1 = 100;

        }
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);
        if(checkBox.isChecked()){
            if(fee == 70)
                fee2 = 100;
            else if(fee == 120 || fee == 160)
                fee2 = 150;
            else if(fee == 200 || fee == 250)
                fee2 = 200;
        }

        //finalMessage.setText(fee + fee1 + fee2);
        String test1 = String.valueOf(fee+fee1+fee2);

        Toast.makeText(this, "Total fee is RM" + test1, Toast.LENGTH_LONG).show();

    }
}
