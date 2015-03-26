package br.curso.a_033_asynctask;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tv_contator;
	private Button btn_thread;

	private int iIndex;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		tv_contator = (TextView) findViewById(R.id.telainicial_tv_contador);
		btn_thread = (Button) findViewById(R.id.telainicial_btn_acionar_thread);
		btn_thread.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new IniciarProcesso().execute();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private class IniciarProcesso extends AsyncTask<Void, Integer, Void> {

		// Main Thread
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			//
			btn_thread.setEnabled(false);
			iIndex = 0;
		}

		// Secundaria Thread
		@Override
		protected Void doInBackground(Void... params) {

			while (iIndex < 25) {
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					// TODO: handle exception
				}
				//
				publishProgress(++iIndex);
			}

			return null;
		}

		// Main Thread
		@Override
		protected void onProgressUpdate(Integer... values) {
			super.onProgressUpdate(values);
			//
			int iAux = values[0];
			tv_contator.setText(String.valueOf(iAux));
		}

		// Main Thread
		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			//
			btn_thread.setEnabled(true);
		}

	}

}
