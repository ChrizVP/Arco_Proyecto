package com.example.intefaz_main;


import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Set;

public class Divice_BT extends AppCompatActivity {

    ListView IdLista;


    public static String EXTRA_DEVICE_ADDRESS = "Divice_BT";
    private static final String TAG = "Divice_BT";
    private BluetoothAdapter mBtAdapter;

    private ArrayAdapter<String> mPairedDeviceArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_divice__bt);
        getSupportActionBar().hide();
    }




    @SuppressLint("MissingPermission")
    @Override
    public void onResume(){

        super.onResume();

        VerificarEstadoBT();

        mPairedDeviceArrayAdapter = new ArrayAdapter<String>(this, R.layout.divice_names);
        IdLista = (ListView) findViewById(R.id.id_lista_bt);
        IdLista.setAdapter(mPairedDeviceArrayAdapter);
        IdLista.setOnItemClickListener(mDeviceClickListener);

        mBtAdapter = BluetoothAdapter.getDefaultAdapter();

        Set <BluetoothDevice> pairedDevices = mBtAdapter.getBondedDevices();
        //Set pairedDevices = mBtAdapter.getBondedDevices();

        if(pairedDevices.size()>0)
        {
            for(BluetoothDevice device : pairedDevices)
            {
                mPairedDeviceArrayAdapter.add(device.getName() + "\n" + device.getAddress());
            }
        }

    }





    private AdapterView.OnItemClickListener mDeviceClickListener = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView av, View v, int arg2, long arg3) {

            // Obtener la dirección MAC del dispositivo, que son los últimos 17 caracteres en la vista
            String info = ((TextView) v).getText().toString();
            String address = info.substring(info.length() - 17);

            // Realiza un intent para iniciar la siguiente actividad
            // mientras toma un EXTRA_DEVICE_ADDRESS que es la dirección MAC.
            Intent i = new Intent(Divice_BT.this, MainActivity.class);//<-<- PARTE A MODIFICAR >->->
            i.putExtra(EXTRA_DEVICE_ADDRESS, address);
            startActivity(i);
        }
    };



    @SuppressLint("MissingPermission")
    private void VerificarEstadoBT() {
        // Comprueba que el dispositivo tiene Bluetooth y que está encendido.
        mBtAdapter= BluetoothAdapter.getDefaultAdapter();
        if(mBtAdapter==null) {
            Toast.makeText(getBaseContext(), "El dispositivo no soporta Bluetooth", Toast.LENGTH_SHORT).show();
        } else {
            if (mBtAdapter.isEnabled()) {
                Log.d(TAG, "...Bluetooth Activado...");
            } else {
                //Solicita al usuario que active Bluetooth
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, 1);

            }
        }
    }



}
