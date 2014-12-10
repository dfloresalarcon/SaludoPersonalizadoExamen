package com.example.dfloresalarcon.saludopersonalizado;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class MainActivity extends Activity {

    String trato="";
    String opcionES="";

    ArrayList<String> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText txtNombre = (EditText)findViewById(R.id.txtNombre);
        final TextView salida = (TextView)findViewById(R.id.salida);
        final Button btnSaludar = (Button)findViewById(R.id.btnSaludar);

        btnSaludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                RadioGroup radioTrato = (RadioGroup)findViewById(R.id.agruparRadios);
                if (R.id.rbtnSr == radioTrato.getCheckedRadioButtonId()){
                   trato = "Sr.";
                }
                else{
                   trato = "Sra.";
                }
            }
        });

        Spinner spinner = (Spinner)findViewById(R.id.spinner);
        //crear un ArrayList
        lista = new ArrayList<String>();
        // añadir hola y adios en el array (2 items)
        lista.add("Hola");
        lista.add("Adios");
        // crear el adaptador del ArrayList
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista);
        //ArrayAdapter<Tipo> nombredeladapter = new ArrayAdapter<Tipo>(this, android.R.layout.simple_spinner_item,	 nuestroarray);       
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //nombredeladapyer.setDropDownResource(android.R.layout.simple_spinner_dropdown_item);

        //enviar nuestro adapter creado
        spinner.setAdapter(adaptador);

        //sobrescribir el metodo serOnItemSelectedListener(new AdapterView.onItemSelectedListener(){...}
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View v, int position, long arg3) {
                //mostrar elemento seleccionado
               salida.setText(""+arg0.getItemAtPosition(position).toString()+" "+trato+" "+txtNombre.getText().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
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
