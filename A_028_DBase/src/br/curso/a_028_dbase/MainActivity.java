package br.curso.a_028_dbase;

import br.curso.a_028_dbase.dao.TorcedorDao;
import br.curso.a_028_dbase.vo.Torcedor;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		TorcedorDao torcedorDao = new TorcedorDao(getBaseContext());
		
		Torcedor torcedor = new Torcedor();
		//
		torcedor.setIdtorcedor(1);
		torcedor.setNome("Hugo");
		torcedor.setEmail("email");
		torcedor.setCelular("celular");
		torcedor.setAltura(1.75);
		//
		//torcedorDao.ins(torcedor);
		//
		torcedor.setCelular("Novo celular");
//		//
		torcedorDao.upd(torcedor);
//		//
		Torcedor torcedor_aux = torcedorDao.obterTorcedor(1);
//		//
		torcedorDao.del(1);
		//
		
		Torcedor torcedor_aux2 = torcedorDao.obterTorcedor(1);
		
		@SuppressWarnings("unused")
		
		int a = 10;
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
