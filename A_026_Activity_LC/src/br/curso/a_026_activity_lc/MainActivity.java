package br.curso.a_026_activity_lc;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Context context;

	private EditText et_nome;
	private Button btn_salvar_valor;
	private Button btn_mostrar_valor;

	private String nome;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		Log.d("SISTEMA", "OnCreate");
		//
		context = getBaseContext();
		//
		if ( savedInstanceState == null){
			nome = "Android";
		} else {
			nome = savedInstanceState.getString("nome");
		}
		
		//
		et_nome = (EditText) findViewById(R.id.et_nome);
		btn_mostrar_valor = (Button) findViewById(R.id.btn_mostrar_valor);
		btn_mostrar_valor.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(context, nome, Toast.LENGTH_SHORT).show();
			}
		});
		//
		btn_salvar_valor = (Button) findViewById(R.id.btn_salvar_valor);
		btn_salvar_valor.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				nome = et_nome.getText().toString();
			}
		});
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		outState.putString("nome", nome);
		//
		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onPause() {
		super.onPause();
		//
		Log.d("SISTEMA", "OnPause");

	}

	@Override
	protected void onStop() {
		super.onStop();
		//
		Log.d("SISTEMA", "OnStop");

	}

	@Override
	protected void onResume() {
		super.onResume();
		//
		Log.d("SISTEMA", "OnResume");

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		//
		Log.d("SISTEMA", "OnDestroy");

	}
}
