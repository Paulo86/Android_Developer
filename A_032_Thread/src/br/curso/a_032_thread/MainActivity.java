package br.curso.a_032_thread;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView tv_contador;
	private Button btn_thread;

	private int iIndex;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		tv_contador = (TextView) findViewById(R.id.telainicial_tv_contador);
		btn_thread = (Button) findViewById(R.id.telainicial_btn_acionar_thread);
		btn_thread.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				btn_thread.setEnabled(false);
				//
				Thread thread = new Thread() {

					@Override
					public void run() {
						try {

							iIndex = 0;

							while (iIndex < 25) {
								iIndex++;

								sleep(100);

								runOnUiThread(new Runnable() {

									@Override
									public void run() {
										tv_contador.setText(String
												.valueOf(iIndex));
									}
								});
							}
							//
							runOnUiThread(new Runnable() {

								@Override
								public void run() {
									btn_thread.setEnabled(true);
								}
							});

						} catch (Exception e) {
							// TODO: handle exception
						}
					}

				};
				
				thread.start();
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
