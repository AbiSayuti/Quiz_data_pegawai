package com.abisayuti.quizdatapegawai;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    String nama,alamat,user,HP,email,gender;

    EditText txtNama,txtemail,txtalamat,txtuser,txtHP;

    Button btnsubmit;

    Spinner spingender;

    String[] dataGender = new String[]{

            "Laki-laki " , "Perempuan "
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsubmit = (Button)findViewById(R.id.btnSubmit);
        txtalamat = (EditText) findViewById(R.id.etalamat);
        txtemail = (EditText) findViewById(R.id.etEmail);
        txtuser = (EditText) findViewById(R.id.etUser);
        txtHP = (EditText) findViewById(R.id.etHP);
        txtNama = (EditText) findViewById(R.id.etFullname);
        spingender = (Spinner) findViewById(R.id.spinGender);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataGender);
        spingender.setAdapter(adapter);

        spingender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                gender = adapterView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //string untuk mengambil nilai
                 nama = txtNama.getText().toString();
                 alamat = txtalamat.getText().toString();
                 user = txtuser.getText().toString();
                 HP = txtHP.getText().toString();
                 email = txtemail.getText().toString();

                //intent ke kelas getExtra
                Intent nP = new Intent(getApplicationContext(), MainActivitypendidikan.class);
                nP.putExtra("nama",nama);
                nP.putExtra("alamat",alamat);
                nP.putExtra("user",user);
                nP.putExtra("HP",HP);
                nP.putExtra("email",email);
                nP.putExtra("gender",gender);
                startActivity(nP);
            }
        });

    }
}
