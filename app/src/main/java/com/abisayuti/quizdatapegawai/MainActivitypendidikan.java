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

public class MainActivitypendidikan extends AppCompatActivity {


    String nama,alamat,user,HP,email,gender,pendidikanterakhir,ipk,jurusan,tingkatpndd;

    EditText etpendidikanterakhir,etIPK;

    Button btnnext;

    Spinner spintingkatpendidikan,spinjurusan;


    String[] datatingkat = new String[]{

            "SMP", "SMA", "D3","S1","S2"
    };

    String[] datajurusan = new String[]{

            "RPL", "Jaringan", "Mesin","Otomotif","Tata boga"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitypendidikan);


        btnnext = (Button)findViewById(R.id.btnnext);

        etIPK = (EditText) findViewById(R.id.etIPK);
        etpendidikanterakhir = (EditText) findViewById(R.id.etpendidikan);
        spinjurusan = (Spinner) findViewById(R.id.spinjurusan);
        spintingkatpendidikan = (Spinner) findViewById(R.id.spinpendidikan);


        Intent a1 = getIntent();
        //mengambil data yang sudh di deklarasi ke dalam variable nya
        nama = a1.getStringExtra("nama");
        alamat = a1.getStringExtra("alamat");
        user = a1.getStringExtra("user");
        HP = a1.getStringExtra("HP");
        email = a1.getStringExtra("email");
        gender = a1.getStringExtra("gender");





        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datatingkat);
        spintingkatpendidikan.setAdapter(adapter);


        spintingkatpendidikan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tingkatpndd = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datajurusan);
        spinjurusan.setAdapter(adapter2);


        spinjurusan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                jurusan = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


       btnnext.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {



               ipk = etIPK.getText().toString();
               pendidikanterakhir = etpendidikanterakhir.getText().toString();



               Intent nP = new Intent(getApplicationContext(), MainActivitykeluarga.class);
               nP.putExtra("nama",nama);
               nP.putExtra("alamat",alamat);
               nP.putExtra("user",user);
               nP.putExtra("HP",HP);
               nP.putExtra("email",email);
               nP.putExtra("gender",gender);
               nP.putExtra("ipk",ipk);
               nP.putExtra("pnddterakhir",pendidikanterakhir);
               nP.putExtra("jurusan",jurusan);
               nP.putExtra("tingkatpndd",tingkatpndd);
               startActivity(nP);

           }
       });



    }
}
