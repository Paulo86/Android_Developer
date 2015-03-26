package br.curso.ex_barcode;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private TextView tv_retorno;
	private Button btn_scan;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		tv_retorno = (TextView) findViewById(R.id.tv_retorno);
		btn_scan = (Button) findViewById(R.id.btn_scan);
		btn_scan.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent mIntent = new Intent(
						"com.google.zxing.client.android.SCAN");
				mIntent.putExtra("SCAN_MODE",
						"QR_CODE_MODE,CODE_39_MODE,CODE_128_MODE");
				//
				if (mIntent.resolveActivity(getPackageManager()) == null) {

					// Toast.makeText(getBaseContext(), "App Não Instalada",
					// Toast.LENGTH_SHORT).show();
					
					String url = "market://details?id=com.google.zxing.client.android";
					
					Intent mIntentLoja = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
					startActivity(mIntentLoja);
					

				} else {
					startActivityForResult(mIntent, 10);
				}
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		switch (requestCode) {
		case 10:

			if (resultCode == RESULT_OK) {
				String res = data.getStringExtra("SCAN_RESULT");
				tv_retorno.setText(res);
			} else {
				tv_retorno.setText("Cancelado");
			}
			//
			break;

		default:
			break;
		}

	}

}
