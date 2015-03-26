package br.curso.lab_020_cadastro;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Context context;
	//
	private EditText et_nome;
	private EditText et_email;
	//
	private RadioGroup rg;
	private RadioButton rb_m;
	private RadioButton rb_f;
	//
	private ImageView iv_foto;
	private Button btn_show;

	private String sexo = "M";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		context = getBaseContext();
		//
		et_nome = (EditText) findViewById(R.id.et_nome);
		et_email = (EditText) findViewById(R.id.et_email);
		//
		rg = (RadioGroup) findViewById(R.id.rg);
		rg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.rb_m:
					iv_foto.setImageDrawable(getResources().getDrawable(
							R.drawable.man));
					sexo = "M";
					break;

				case R.id.rb_f:
					iv_foto.setImageDrawable(getResources().getDrawable(
							R.drawable.woman));
					sexo = "F";
					break;

				default:
					break;
				}

			}
		});
		rb_m = (RadioButton) findViewById(R.id.rb_m);
		rb_f = (RadioButton) findViewById(R.id.rb_f);
		//
		iv_foto = (ImageView) findViewById(R.id.iv_foto);
		//
		btn_show = (Button) findViewById(R.id.btn_show);
		btn_show.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				StringBuilder sb = new StringBuilder();
				//
				sb.append(et_nome.getText().toString()).append("\n")
						.append(et_email.getText().toString()).append("\n")
						.append("sexo: ").append(sexo);
				//
				Toast.makeText(context, sb.toString(), Toast.LENGTH_SHORT)
						.show();
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
