package br.curso.a_039_http;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ImageView iv_foto;
	private Button btn_download;

	private ProgressDialog progressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		iv_foto = (ImageView) findViewById(R.id.iv_foto);
		btn_download = (Button) findViewById(R.id.btn_fazerdownloadimage);
		btn_download.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new DownLoadAsync().execute();
			}
		});
	}

	private class DownLoadAsync extends AsyncTask<Void, Integer, Void> {

		@Override
		protected void onPreExecute() {
			progressDialog = new ProgressDialog(MainActivity.this);
			progressDialog.setCancelable(false);
			progressDialog.setTitle("Download de Imagem");
			progressDialog.setMessage("Aguardando Processamento!!!");
			progressDialog.show();
			//
			iv_foto.setImageDrawable(null);
		}

		@Override
		protected Void doInBackground(Void... params) {

			try {
				HttpDw.gravarImagem();
			} catch (Exception e) {
				Toast.makeText(getBaseContext(), e.toString(),
						Toast.LENGTH_LONG).show();
			}
			//
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			iv_foto.setImageDrawable(Drawable.createFromPath(HttpDw.PATH_IMAGEM
					+ HttpDw.NOME_IMAGEM));
			//
			progressDialog.cancel();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
