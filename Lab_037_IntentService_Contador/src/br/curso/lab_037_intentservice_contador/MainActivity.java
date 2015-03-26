package br.curso.lab_037_intentservice_contador;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tv_contador;
	private Button btn_run;
	//
	private ContadorReceiver receiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		tv_contador = (TextView) findViewById(R.id.telainicial_tv_contador);
		btn_run = (Button) findViewById(R.id.telainicial_btn_run);
		btn_run.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				btn_run.setEnabled(false);
				//
				startService(new Intent("NOVO_VALOR"));
			}
		});
		//
		IntentFilter filter = new IntentFilter("NV");
		filter.addCategory(Intent.ACTION_DEFAULT);
		//
		receiver = new ContadorReceiver();
		//
		registerReceiver(receiver, filter);
	}

	@Override
	protected void onDestroy() {
		unregisterReceiver(receiver);
		//
		super.onDestroy();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private class ContadorReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			String valor = intent.getStringExtra(Constantes.NOVO_VALOR);
			int tipo = intent.getIntExtra(Constantes.TIPO, 0);
			//
			switch (tipo) {
			case 0:
				tv_contador.setText(valor);
				break;
			case 1:
				btn_run.setEnabled(true);
				break;
			default:
				break;
			}

		}

	}

}
