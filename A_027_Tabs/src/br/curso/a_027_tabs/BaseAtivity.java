package br.curso.a_027_tabs;

import android.app.Activity;
import android.os.Bundle;

public class BaseAtivity extends Activity{
	
	protected String LOGNAME;
	protected int ProjectID;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//
		LOGNAME = "Sem Nome";
		ProjectID = 20;
	}

}
