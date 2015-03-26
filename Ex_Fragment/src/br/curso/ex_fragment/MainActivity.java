package br.curso.ex_fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements Frag_01.IFrag_01 {
	
	private Context context;

	private Button btn_frag_01;
	private Button btn_frag_02;
	//
	private Frag_01 f_01;
	private Frag_02 f_02;

	private int iFrag = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		context =  getBaseContext();
		//
		btn_frag_01 = (Button) findViewById(R.id.btn_frag_01);
		btn_frag_01.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				iFrag = 1;
				//
				setFrag(iFrag);
			}
		});
		btn_frag_02 = (Button) findViewById(R.id.btn_frag_02);
		btn_frag_02.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				iFrag = 2;
				//
				setFrag(iFrag);
			}
		});
		//
		setFrag(iFrag);

	}

	protected void setFrag(int iFragmento) {

		FragmentManager fm = getSupportFragmentManager();
		String sTag = "";

		switch (iFragmento) {
		case 1:
			sTag = "frag_01";

			if (fm.findFragmentByTag(sTag) == null) {
				if (f_01 == null) {
					f_01 = new Frag_01();
					f_01.delegate = this;
				}
				//
				FragmentTransaction ft = fm.beginTransaction();
				ft.replace(R.id.ll_frag, f_01, sTag);
				ft.commit();
			} else {
				f_01 = (Frag_01) fm.findFragmentByTag(sTag);
			}

			break;
		case 2:
			sTag = "frag_02";

			if (fm.findFragmentByTag(sTag) == null) {
				if (f_02 == null) {
					f_02 = new Frag_02();
				}
				//
				FragmentTransaction ft = fm.beginTransaction();
				ft.replace(R.id.ll_frag, f_02, sTag);
				ft.commit();
			} else {
				f_02 = (Frag_02) fm.findFragmentByTag(sTag);
			}

			break;

		default:
			break;
		}

	}

	@Override
	public void mostramensagem(String mensagem) {
		Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show();
		
	}

}
