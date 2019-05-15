package com.bandhan.hazzatun.savedialouge1;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mcounter = 0,score=0;
    Button cnt, sav;
    TextView txv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cnt = (Button) findViewById(R.id.count);
        txv = (TextView) findViewById(R.id.tv);
        sav = (Button) findViewById(R.id.save);
        Intent intent=getIntent();
        Bundle extras = intent.getExtras();
        //    if (extras != null) {
        //     if (extras.containsKey("isNewItem")) {
        //    boolean isNew = extras.getBoolean("isNewItem", false);

        //     TODO: Do something with the value of isNew.
        //  }
        //  }
        score=intent.getIntExtra("count",0);
        txv = (TextView) findViewById(R.id.tv);
        txv.setText(String.valueOf(score));
        mcounter=score;

    }

    public void play(View view) {
        mcounter++;
        txv.setText(String.valueOf(mcounter));
    }

    public void save(View view) {
        final EditText input = new EditText(MainActivity.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);

        AlertDialog alertDialog = new AlertDialog.Builder(this)

                .setTitle("Save as")

                .setMessage("Exiting will close the app")
                .setView(input)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(MainActivity.this, Show.class);
                        intent.putExtra("count",mcounter);

                        String value = input.getText().toString();
                        intent.putExtra("name",value);
                        MainActivity.this.startActivity(intent);
                    }
                })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(getApplicationContext(),"No Happened",Toast.LENGTH_LONG).show();
                    }
                })
                .show();

    }
}
