package br.curso.a_023_intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SegundaTela extends Activity {

	private TextView tv_valor;
	private Button btn_finalizar;
	//
	private String resultado;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.segundatela);
		//
		Bundle bundle = getIntent().getExtras();
		//
		if (bundle != null) {
			resultado = bundle.getString(Constantes.VALOR);
		} else {
			resultado = "0";
		}
		//
		tv_valor = (TextView) findViewById(R.id.segundatela_tv_valor);
		btn_finalizar = (Button) findViewById(R.id.segundatela_btn_fim);
		btn_finalizar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//finish();
				resultado += " - Alterado";
				//
				Bundle bundle = new Bundle();
				bundle.putString(Constantes.RETORNO, resultado);
				//
				Intent mIntent = new Intent();
				mIntent.putExtras(bundle);
				//
				setResult(RESULT_OK, mIntent);
				finish();
			}
		});
		//
		tv_valor.setText(resultado);

	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}

	// @Override
	// public void onBackPressed() {
	// Intent mIntent = new Intent(getBaseContext(), MainActivity.class);
	// //
	// startActivity(mIntent);
	// //
	// finish();
	// }
}
