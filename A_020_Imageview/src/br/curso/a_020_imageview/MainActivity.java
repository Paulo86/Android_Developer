package br.curso.a_020_imageview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView iv_foto;
	private Button btn_sdcard;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		iv_foto = (ImageView) findViewById(R.id.iv_foto);
		iv_foto.setImageDrawable(getResources().getDrawable(R.drawable.woman));
		//
		btn_sdcard = (Button) findViewById(R.id.btn_sdcard);
		btn_sdcard.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// String caminho = "/sdcard/man.png";
				String caminho = Environment.getExternalStorageDirectory()
						+ "/man.png";
				//
				Bitmap bm = BitmapFactory.decodeFile(caminho);
				//
				iv_foto.setImageBitmap(bm);
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
