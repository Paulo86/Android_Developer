package br.curso.a_025_alert;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btn_alerta;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		btn_alerta = (Button) findViewById(R.id.btn_alerta);
		btn_alerta.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// AlertDialog.Builder alerta = new AlertDialog.Builder(
				// MainActivity.this);
				AlertDialog.Builder alerta = new AlertDialog.Builder(v
						.getContext());

				//
				alerta.setTitle("Confirmação de Saida");
				alerta.setMessage("Você realmente deseja sair?");
				alerta.setPositiveButton("Sim",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								finish();
							}
						});
				alerta.setNeutralButton("Cancelar", null);
				alerta.setNegativeButton("Não", null);
				//
				alerta.show();
			}
		});

	}

	@Override
	public void onBackPressed() {

		AlertDialog.Builder alerta = new AlertDialog.Builder(MainActivity.this);
		//
		alerta.setTitle("Confirmação de Saida");
		alerta.setMessage("Você realmente deseja sair?");
		alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				finish();
				//
				Toast.makeText(MainActivity.this, "Olá", Toast.LENGTH_SHORT).show();
			}
		});
		alerta.setNeutralButton("Cancelar", null);
		alerta.setNegativeButton("Não", null);
		//
		alerta.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
