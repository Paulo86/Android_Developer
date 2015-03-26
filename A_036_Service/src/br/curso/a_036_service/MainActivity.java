package br.curso.a_036_service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button btn_tocar;
	private Button btn_parar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		btn_tocar = (Button) findViewById(R.id.btn_tocar);
		btn_tocar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// startService(new Intent("TOCAR_MUSICA_SERVICE"));
				startService(new Intent("START_SERVICE"));
			}
		});
		//
		btn_parar = (Button) findViewById(R.id.btn_parar);
		btn_parar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// stopService(new Intent("PARAR_MUSICA_SERVICE"));
				startService(new Intent("STOP_SERVICE"));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
