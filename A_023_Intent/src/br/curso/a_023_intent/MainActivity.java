package br.curso.a_023_intent;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btn_chamar;
	private Button btn_finalizar;

	private TextView tv_retorno;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		tv_retorno = (TextView) findViewById(R.id.telainicial_tv_retorno);
		//
		btn_chamar = (Button) findViewById(R.id.telainicial_btn_chamar);
		btn_chamar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// Email
				Intent mIntent = new Intent(getBaseContext(), SegundaTela.class);
				// Anexo
				Bundle bundle = new Bundle();
				bundle.putString(Constantes.VALOR, "Impacta");
				// juntei o anexo ao email
				mIntent.putExtras(bundle);
				//
				// startActivity(mIntent);
				//
				// finish();
				startActivityForResult(mIntent, 10);
			}
		});

		btn_finalizar = (Button) findViewById(R.id.telainicial_btn_fim);
		btn_finalizar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// finish();
				// //
				// Toast.makeText(getBaseContext(), "Olá", Toast.LENGTH_SHORT)
				// .show();
				String numero = "994322797";
				
				Intent mIntent = new Intent(Intent.ACTION_CALL);
				mIntent.setData(Uri.parse("tel:" +numero));
				startActivity(mIntent);
				
			}
		});

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		switch (requestCode) {
		case 10:

			if (resultCode == RESULT_OK) {
				Bundle bundle = data.getExtras();
				//
				String res = bundle.getString(Constantes.RETORNO);
				tv_retorno.setText(res);
			} else {
				tv_retorno.setText("Cancelado");
			}

			break;
		default:
			break;
		}
	}

}
