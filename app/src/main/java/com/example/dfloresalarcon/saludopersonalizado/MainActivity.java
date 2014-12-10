package com.example.dfloresalarcon.saludopersonalizado;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends Activity {

    String saludo="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnHola = (Button)findViewById(R.id.btnHola);
        final EditText txtNombre = (EditText)findViewById(R.id.txtNombre);
        final TextView salida = (TextView)findViewById(R.id.salida);



        btnHola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup radio = (RadioGroup)findViewById(R.id.agruparRadios);
                if (R.id.rbtnSr == radio.getCheckedRadioButtonId()){
                    saludo+=" Sr. "+txtNombre.getText().toString();
                }
                else{
                    saludo+=" Sra. "+txtNombre.getText().toString();
                }

                salida.setText(btnHola.getText()+saludo);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
