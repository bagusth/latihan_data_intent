package com.example.latihan_data_intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FoodActivity extends AppCompatActivity {

    EditText name;
    EditText address;
    EditText order;
    Button btnPesan;

    String nama, alamat, pesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_food);

        name = (EditText) findViewById(R.id.et);
        address = (EditText) findViewById(R.id.et2);
        order = (EditText) findViewById(R.id.et3);
        btnPesan = (Button) findViewById(R.id.submit);

        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passingData();
            }
        });


    }

    public void passingData() {
        nama = name.getText().toString();
        alamat = address.getText().toString();
        pesan = order.getText().toString();

        if (nama.isEmpty()) {
            name.setError("This field is required");
            return;
        }
        if (alamat.isEmpty()) {
            address.setError("This field is required");
            return;
        }
        if (pesan.isEmpty()) {
            order.setError("This field is required");
            return;
        }
        Intent order = new Intent(FoodActivity.this, SubmitActivity.class);
        order.putExtra("nama", nama);
        order.putExtra("alamat", alamat);
        order.putExtra("pesan", pesan);

        startActivity(order);
        finish();
    }
}
