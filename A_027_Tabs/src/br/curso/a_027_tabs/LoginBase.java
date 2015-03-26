package br.curso.a_027_tabs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public abstract class LoginBase extends Activity {

	private EditText et_nome;
	private EditText et_senha;
	//
	private Button btn_cancelar;
	private Button btn_login;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//
		et_nome = (EditText) findViewById(R.id.et_nome);
		et_senha = (EditText) findViewById(R.id.et_senha);
		//
		btn_cancelar = (Button) findViewById(R.id.btn_cancelar);
		btn_cancelar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				et_nome.setText("");
				et_senha.setText("");
				//
				et_nome.requestFocus();
			}
		});
		//
		btn_login = (Button) findViewById(R.id.btn_logar);
		btn_login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				efetuar_login(et_nome.getText().toString(), et_senha.getText()
						.toString());
			}
		});

	}

	
	protected abstract void efetuar_login(String nome, String senha);

}
