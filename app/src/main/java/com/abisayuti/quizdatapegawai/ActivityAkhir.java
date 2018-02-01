package com.abisayuti.quizdatapegawai;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ActivityAkhir extends AppCompatActivity {

    String nama,alamat,user,HP,email,gender,pendidikanterakhir,ipk,jurusan,tingkatpndd,ayah,ibu,istri,keluarga,anak;
    TextView txtakhir,txtgajipokok,txtgajitunjangan,txttotal;


    int tunjangan,gaji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akhir);


        Intent a1 = getIntent();
        nama = a1.getStringExtra("nama");
        alamat = a1.getStringExtra("user");
        user = a1.getStringExtra("alamat");
        HP = a1.getStringExtra("HP");
        email = a1.getStringExtra("email");
        gender = a1.getStringExtra("gender");
        ipk = a1.getStringExtra("ipk");
        pendidikanterakhir = a1.getStringExtra("pnddterakhir");
        jurusan = a1.getStringExtra("jurusan");
        tingkatpndd = a1.getStringExtra("tingkatpndd");
        anak = a1.getStringExtra("anak");
        ayah = a1.getStringExtra("ayah");
        ibu = a1.getStringExtra("ibu");
        keluarga = a1.getStringExtra("keluarga");
        istri = a1.getStringExtra("istri");



        txtgajipokok = (TextView) findViewById(R.id.txtgajipokok);
        txtakhir = (TextView) findViewById(R.id.txtakhhir);
        txtgajitunjangan = (TextView) findViewById(R.id.txtgajitunjangan);
        txttotal = (TextView) findViewById(R.id.txtgajitotal);

        if (tingkatpndd.equalsIgnoreCase("SD")){
            gaji = 1000000;
        }else if (tingkatpndd.equalsIgnoreCase("SMP")){
            gaji = 2000000;
        }else if (tingkatpndd.equalsIgnoreCase("SMK")){
            gaji = 2500000;
        }else if (tingkatpndd.equalsIgnoreCase("D3")){
            gaji = 2700000;
        }else if (tingkatpndd.equalsIgnoreCase("S1")){
            gaji = 3000000;
        }else if (tingkatpndd.equalsIgnoreCase("S2")){
            gaji = 5000000;
        }


        if (keluarga.equalsIgnoreCase("Sudah") && (anak.equalsIgnoreCase("0"))) {
            tunjangan = 700000;
        }else if (keluarga.equalsIgnoreCase("Sudah") && (anak.equalsIgnoreCase("1"))) {
            tunjangan = 1000000;
        }else if (keluarga.equalsIgnoreCase("Sudah") && (anak.equalsIgnoreCase("2"))) {
            tunjangan = 2000000;
        }else if (keluarga.equalsIgnoreCase("Sudah") && (anak.equalsIgnoreCase("3"))) {
            tunjangan = 3000000;

        }

        int totalgaji = gaji + tunjangan;

        txtakhir.setText("Halo " + nama + "Username anda "+user + "anda tinggal di : "+alamat+"Nomor HP anda : "+HP+"email anda "+email+ "anda seorang : "
                +gender+" "+"pendidikan terakhir anda di " + pendidikanterakhir+" dengan jurusan "+jurusan+ " tingkat pendidikan terakhir anda "
                +tingkatpndd+ "jumlah anak anda :"+anak +" nama ayah anda "+ayah+" nama ibu anda "+ibu+" nama istri anda"+istri+
                " dikarenakan banyaknya pengeluaran per bulan anda maka ");
        txtgajipokok.setText("Gaji pokok anda : " + gaji);
        txtgajitunjangan.setText("Gaji tunjangan kehidupan anda : " + tunjangan);
        txttotal.setText("Gaji total  anda : " + totalgaji);
    }
}
