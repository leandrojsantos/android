package com.leandro.menu;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    int qts = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        incrementQts();
        decrementQts();
        totalQts();

        TextView msgTotal = findViewById(R.id.msgTotal);
        msgTotal.setVisibility(View.GONE);

    }

    private void incrementQts() {

        Button add = findViewById(R.id.btn_add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (qts < 20) {
                    qts++;

                    TextView addText = findViewById(R.id.qts);
                    addText.setText(String.valueOf(qts));
                }
            }
        });
    }

    private void decrementQts() {

        Button del = findViewById(R.id.btn_del);
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (qts > 0) {
                    qts--;

                    TextView delText = findViewById(R.id.qts);
                    delText.setText(String.valueOf(qts));
                }
            }
        });
    }

    private void totalQts() {

        Button total = findViewById(R.id.btn_total);
        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int valorTotal = qts * 15;
                EditText edName = findViewById(R.id.usr_name);
                TextView msgTotal = findViewById(R.id.msgTotal);


                String msg = " Sua conta é de  R$ " + valorTotal + ",00 \n Obg e volte smp \n" + edName.getText().toString();

                msgTotal.setText(msg);
                msgTotal.setVisibility(View.VISIBLE);

            }
        });
    }

}