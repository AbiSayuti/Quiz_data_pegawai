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

public class MainActivitykeluarga extends AppCompatActivity {


    String nama,alamat,user,HP,email,gender,pendidikanterakhir,ipk,jurusan,tingkatpndd,ayah,ibu,istri,keluarga,anak;

    EditText etibu,etayah,etistri;

    Button btnnext2;

    Spinner spinkeluarga,spinanak;

    String[] dataanak = new String[]{

            "1", "2", "3",
    };


    String[] datatkeluarga = new String[]{

            "Sudah", "Belum",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitykeluarga);

        btnnext2 = (Button)findViewById(R.id.btnnext2);

        etayah = (EditText) findViewById(R.id.etayah);
        etibu = (EditText) findViewById(R.id.etibu);
        etistri = (EditText) findViewById(R.id.etistri);
        spinkeluarga = (Spinner) findViewById(R.id.spinkeluarga);
        spinanak = (Spinner) findViewById(R.id.spinanak);


        Intent a1 = getIntent();
        //mengambil data yang sudh di deklarasi ke dalam variable nama
        nama = a1.getStringExtra("nama");
        alamat = a1.getStringExtra("alamat");
        user = a1.getStringExtra("user");
        HP = a1.getStringExtra("HP");
        email = a1.getStringExtra("email");
        gender = a1.getStringExtra("gender");
        ipk = a1.getStringExtra("ipk");
        pendidikanterakhir = a1.getStringExtra("pnddterakhir");
        jurusan = a1.getStringExtra("jurusan");
        tingkatpndd = a1.getStringExtra("tingkatpndd");









        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datatkeluarga);
        spinkeluarga.setAdapter(adapter);


        spinkeluarga.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               keluarga  = adapterView.getItemAtPosition(i).toString();

                if(spinkeluarga.getSelectedItem().toString() == "Sudah"){
                    //// yang gone saat spin nya Link
                    etistri.setVisibility(View.VISIBLE);
                    spinanak.setVisibility(View.VISIBLE);

                }else if (spinkeluarga.getSelectedItem().toString() == "Belum"){
                    etistri.setVisibility(View.INVISIBLE);
                    spinanak.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataanak);
        spinanak.setAdapter(adapter2);

        spinanak.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                anak  = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btnnext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                ayah = etayah.getText().toString();
                ibu = etibu.getText().toString();
                istri = etistri.getText().toString();

                Intent nP = new Intent(getApplicationContext(), ActivityAkhir.class);
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
                nP.putExtra("anak",anak);
                nP.putExtra("ayah",ayah);
                nP.putExtra("ibu",ibu);
                nP.putExtra("keluarga",keluarga);
                nP.putExtra("istri",istri);
                startActivity(nP);

            }
        });

    }
}
