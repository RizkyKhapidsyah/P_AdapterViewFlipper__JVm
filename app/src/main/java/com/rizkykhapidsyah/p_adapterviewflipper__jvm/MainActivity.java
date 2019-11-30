package com.rizkykhapidsyah.p_adapterviewflipper__jvm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AdapterViewFlipper AVF_ViewFlipper_IDJAVA;
    Button B_Mulai_IDJAVA, B_Berhenti_IDJAVA;
    TextView TV_SetInterval_IDJAVA;
    EditText ET_SetInterval_IDJAVA;

    int NilaiIntervalAwal = 2000;
    int[] ListGambar = {
            R.drawable.gambar1,
            R.drawable.gambar2,
            R.drawable.gambar3,
            R.drawable.gambar4,
            R.drawable.gambar5,
            R.drawable.gambar6,
            R.drawable.gambar7,
            R.drawable.gambar8,
            R.drawable.gambar9
    };

    String[] ListNama = {
            "Puzzle",
            "HubunganBadan",
            "KartuNama",
            "RekapData",
            "DaftarTugas",
            "MenulisSurat",
            "TongSampah",
            "BumiDenganHuruf i",
            "TampilanWeb"
    };

    String[] PesanToast = {
            "SlideShow Dijalankan",
            "SlideShow Dihentikan",
            "Interval Kosong",
            "Mohon Atur Nilai Interval Terlebih Dahulu",
            "Interval Tidak Diizinkan",
            "Nilai Interval Yang Diperbolehkan antara: 400 sd 5000"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TV_SetInterval_IDJAVA = findViewById(R.id.TV_SetInterval_IDXML);
        ET_SetInterval_IDJAVA = findViewById(R.id.ET_SetInterval_IDXML);
        B_Berhenti_IDJAVA = findViewById(R.id.B_Berhenti_IDXML);
        B_Mulai_IDJAVA = findViewById(R.id.B_Mulai_IDXML);
        AVF_ViewFlipper_IDJAVA = findViewById(R.id.AVF_ViewFlipper_IDXML);

        ET_SetInterval_IDJAVA.setText(String.valueOf(NilaiIntervalAwal));
        B_Berhenti_IDJAVA.setEnabled(false);
        B_Berhenti_IDJAVA.setTextColor(Color.GRAY);
        B_Mulai_IDJAVA.setEnabled(true);
        B_Mulai_IDJAVA.setTextColor(Color.BLACK);

        MyAdapterFlipper myAF = new MyAdapterFlipper(this, ListGambar, ListNama);
        AVF_ViewFlipper_IDJAVA.setAdapter(myAF);
        AVF_ViewFlipper_IDJAVA.setFlipInterval(NilaiIntervalAwal);
        AVF_ViewFlipper_IDJAVA.setAutoStart(false);

        B_Mulai_IDJAVA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder X = new AlertDialog.Builder(MainActivity.this);
                AlertDialog Xt;

                if (ET_SetInterval_IDJAVA.length() == 0) {
                    X.setTitle(PesanToast[2]);
                    X.setIcon(R.drawable.ic_launcher_background);
                    X.setMessage(PesanToast[3]);

                    X.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ET_SetInterval_IDJAVA.requestFocus();
                        }
                    });

                    Xt = X.create();
                    Xt.show();
                } else {
                    if ((Integer.parseInt(ET_SetInterval_IDJAVA.getText().toString()) < 400) ||
                            (Integer.parseInt(ET_SetInterval_IDJAVA.getText().toString()) > 5000)) {
                        X.setTitle(PesanToast[4]);
                        X.setIcon(R.drawable.ic_launcher_background);
                        X.setMessage(PesanToast[5]);

                        X.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ET_SetInterval_IDJAVA.requestFocus();
                            }
                        });

                        Xt = X.create();
                        Xt.show();
                    } else {
                        AVF_ViewFlipper_IDJAVA.setFlipInterval(Integer.parseInt(ET_SetInterval_IDJAVA.getText().toString()));
                        AVF_ViewFlipper_IDJAVA.startFlipping();

                        B_Berhenti_IDJAVA.setEnabled(true);
                        B_Berhenti_IDJAVA.setTextColor(Color.BLACK);
                        B_Mulai_IDJAVA.setEnabled(false);
                        B_Mulai_IDJAVA.setTextColor(Color.GRAY);
                        ET_SetInterval_IDJAVA.setEnabled(false);

                        Toast.makeText(
                                getApplicationContext(),
                                PesanToast[0],
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                }
            }
        });

        B_Berhenti_IDJAVA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AVF_ViewFlipper_IDJAVA.stopFlipping();

                B_Berhenti_IDJAVA.setEnabled(false);
                B_Berhenti_IDJAVA.setTextColor(Color.GRAY);
                B_Mulai_IDJAVA.setEnabled(true);
                B_Mulai_IDJAVA.setTextColor(Color.BLACK);
                ET_SetInterval_IDJAVA.setEnabled(true);

                Toast.makeText(
                        getApplicationContext(),
                        PesanToast[1],
                        Toast.LENGTH_SHORT)
                        .show();
            }
        });

    }
}
