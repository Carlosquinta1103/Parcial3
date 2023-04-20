package edu.sv.parcialcarlos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import edu.sv.parcialcarlos.Helper.AdminSQLiteOpenHelper;
import edu.sv.parcialcarlos.clases.eliminarfragment;
import edu.sv.parcialcarlos.clases.guardarfragment;
import android.util.Log;

import java.sql.SQLData;




public class MainActivity extends AppCompatActivity {
    BottomNavigationView btnNav;
    EditText txnombre,txapell,txtel,txcorr;
    Button btnInserts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*txnombre.findViewById(R.id.txtnombre);
        txapell.findViewById(R.id.txtapellido);
        txtel.findViewById(R.id.txttel);
        txcorr.findViewById(R.id.txtcorreo);
        btnInserts=findViewById(R.id.btnguardar);*/
        /*btnInserts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getApplicationContext(),"Parcial",null,2);
                SQLiteDatabase bd= admin.getWritableDatabase();
                String nom=txnombre.getText().toString();
                String apell=txapell.getText().toString();
                String tel=txtel.getText().toString();
                String corr=txcorr.getText().toString();

                ContentValues informacion =new ContentValues();
                informacion.put("Nombre",nom);
                informacion.put("Apellidos",apell);
                informacion.put("Teléfono",tel);
                informacion.put("Correo",corr);

                    bd.insert("Contactos", null, informacion);

                    Toast.makeText(getApplicationContext(), "Se inserto el contacto", Toast.LENGTH_LONG).show();
                    bd.close();



            }
        });*/
        btnNav = findViewById(R.id.btnNav);

        btnNav.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) navaListener);
    }
        private BottomNavigationView.OnNavigationItemSelectedListener navaListener= new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment seleccionFrag= null;

                switch (item.getItemId()){
                    case R.id.nav_guardar:
                        seleccionFrag = new guardarfragment();
                        break;
                    case R.id.nav_editar:
                        seleccionFrag = new guardarfragment();
                        break;
                    case R.id.nav_eliminar:
                        seleccionFrag = new eliminarfragment();
                        break;

                }



                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentCont, seleccionFrag).commit();
                return true;

            }



        };


    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menusimbolos,menu);
        return true ;

    }



    public boolean onOptionsItemSelected(MenuItem items) {

        //Intent intent = new Intent(this, Sumar.class);

        switch (items.getItemId()) {

            case R.id.opcion1:
                Toast.makeText(this, "Selecciono la opcion 1" + 1, Toast.LENGTH_SHORT).show();
                //startActivity(intent);
                return true;
            case R.id.opcion2:
                Toast.makeText(this, "Selecciono la opcion 2" + 1, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.opcion3:
                Toast.makeText(this, "Selecciono la opcion 3" + 1, Toast.LENGTH_SHORT).show();
                return true;


        }

        return super.onOptionsItemSelected(items);
    }
}