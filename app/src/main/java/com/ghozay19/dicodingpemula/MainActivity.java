package com.ghozay19.dicodingpemula;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    // ToDo 2 ButterKnife untuk ngenalin widget Panjang
    @BindView(R.id.edit_length)
    EditText etLength;

    //ToDo 3 ButterKnife untuk ngenalin widget Lebar
    @BindView(R.id.edit_width)
    EditText etWidth;

    //ToDo 4 ButterKnife untuk ngenalin widget Tinggi
    @BindView(R.id.edit_height)
    EditText etHeight;

    //ToDo 5 ButterKnife untuk ngenalin Button Hasil
    @BindView(R.id.btn_calculate)
    Button btnHasil;

    //ToDo 6 ButterKnife untuk ngenalin TextView Hasil
    @BindView(R.id.tv_Result)
    TextView tvHasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        //Eksekusi Penghitungan
        btnHasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_calculate) {
                    String length = etLength.getText().toString().trim();
                    String width = etWidth.getText().toString().trim();
                    String height = etHeight.getText().toString().trim();
                    boolean isEmptyfields = false;
                    if (TextUtils.isEmpty(length)) {
                        isEmptyfields = true;
                        etLength.setError("Field ini tidak boleh Kosong");
                    }
                    if (TextUtils.isEmpty(width)) {
                        isEmptyfields = true;
                        etWidth.setError("Field ini tidak boleh Kosong");
                    }
                    if (TextUtils.isEmpty(height)) {
                        isEmptyfields = true;
                        etHeight.setError("Field ini tidak boleh Kosong");
                    }
                    if (!isEmptyfields) {
                        double l = Double.parseDouble(length);
                        double w = Double.parseDouble(width);
                        double h = Double.parseDouble(height);
                        double volume = l * w * h;
                        tvHasil.setText(String.valueOf(volume));
                    }

                }
            }

        });

        if (savedInstanceState != null){
            String hasil = savedInstanceState.getString(STATE_HASIL);
            tvHasil.setText(hasil);
        }

    }

    private static final String STATE_HASIL = "state_hasil";

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString(STATE_HASIL, tvHasil.getText().toString());
        super.onSaveInstanceState(outState);
    }
}
