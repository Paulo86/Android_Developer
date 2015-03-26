package br.curso.a_038_application;

import android.app.Activity;
import android.os.Bundle;

public abstract class BaseActivity extends Activity {

	AppCentral AppControl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//
		AppControl = (AppCentral) getApplication();
		//
		mostrarValor(10);
		//

	}
	
	protected abstract void mostrarValor(int iIndex);

}
