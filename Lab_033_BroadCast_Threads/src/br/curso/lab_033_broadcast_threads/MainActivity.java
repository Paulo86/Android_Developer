package br.curso.lab_033_broadcast_threads;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tv_contador;
	private Button btn_thread;

	private int iIndex;
	private ContadorReceiver receiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		tv_contador = (TextView) findViewById(R.id.telainicial_tv_contador);
		btn_thread = (Button) findViewById(R.id.telainicial_btn_acionar_thread);
		btn_thread.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new ContadorAsync().execute();
			}
		});
		//
		IntentFilter filter = new IntentFilter(Constantes.MSG_BROADCAST);
		filter.addCategory(Intent.CATEGORY_DEFAULT);
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

	private class ContadorAsync extends AsyncTask<Void, Integer, Void> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			//
			btn_thread.setEnabled(false);
			iIndex = 0;
		}

		@Override
		protected Void doInBackground(Void... params) {

			try {

				while (iIndex < 25) {

					iIndex++;

					Thread.sleep(100);
					
					Intent mIntent = new Intent(Constantes.MSG_BROADCAST);
					mIntent.putExtra(Constantes.PAR_BROADCAST,
							String.valueOf(iIndex));
					sendBroadcast(mIntent);
				}

			} catch (Exception e) {
			}

			return null;
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			//
			btn_thread.setEnabled(true);
		}

	}

	private class ContadorReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			String valor = intent.getStringExtra(Constantes.PAR_BROADCAST);
			//
			tv_contador.setText(valor);
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
