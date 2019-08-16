package com.example.latihan_data_intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SubmitActivity extends AppCompatActivity {
    String nama, alamat, pesan;

    TextView tvName;
    TextView tvAddress;
    TextView tvOrder;

    Button btnCancel;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit1);

        tvName = (TextView) findViewById(R.id.hilih);
        tvAddress = (TextView) findViewById(R.id.idih);
        tvOrder = (TextView) findViewById(R.id.waduu);

        btnCancel = (Button)findViewById(R.id.batal);

        getData();

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancel = new Intent(SubmitActivity.this,HomeActivity.class);
                startActivity(cancel);
                finish();
            }
        });
    }

    private void getData() {
        nama = getIntent().getStringExtra("nama");
        pesan = getIntent().getStringExtra("pesan");
        alamat = getIntent().getStringExtra("alamat");

        tvName.setText(nama);
        tvAddress.setText(alamat);
        tvOrder.setText(pesan);
    }
}
