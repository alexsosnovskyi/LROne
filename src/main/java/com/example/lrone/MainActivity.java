package com.example.lrone;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup price;
    RadioGroup firm;
    RadioButton radioButtonPrice;
    RadioButton radioButtonFirm;
    TextView textView;

    String[] dishes = {"Dishes", "plate", "spoon", "fork", "glass", "pan", "scoop"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, dishes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    public void OkButton (View v){


        price = findViewById(R.id.radioGroupPrice);
        firm = findViewById(R.id.radioGroupFirm);
        textView = findViewById(R.id.InputText);
        Button buttonApply = findViewById(R.id.button_apply);
        Spinner spinner = findViewById(R.id.spinner);


        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String selected = spinner.getSelectedItem().toString();
                int id = spinner.getSelectedItemPosition();
                int radioIdPrice = price.getCheckedRadioButtonId();
                int radioIdFirm = firm.getCheckedRadioButtonId();

                if ((radioIdPrice == -1 || radioIdFirm == -1 || id == 0)) {
                    Toast.makeText(MainActivity.this, "Please, enter all information",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                radioButtonPrice = findViewById(radioIdPrice);
                radioButtonFirm = findViewById(radioIdFirm);

                textView.setText("Selected item: " + selected +
                        "\n Range: " + radioButtonPrice.getText() +
                        "\n Selected firm: " + radioButtonFirm.getText());
                }
            }
        });
    }

}