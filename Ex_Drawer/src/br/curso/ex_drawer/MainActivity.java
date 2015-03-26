package br.curso.ex_drawer;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends FragmentActivity implements Frag_02.IFrag_02{

	private final String FRAG_01 = "FRAG_01";
	private final String FRAG_02 = "FRAG_02";

	private Frag_01 frag_01;
	private Frag_02 frag_02;

	private Context context;
	//
	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;
	private LinearLayout opc;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		context = getBaseContext();
		//
		cfg_Values();
		cfg_Actions();
	}

	private void cfg_Values() {
		mDrawerLayout = (DrawerLayout) findViewById(R.id.main_drawerlayout);
		opc = (LinearLayout) findViewById(R.id.ll_opc);
		//
		frag_01 = new Frag_01();
		frag_02 = new Frag_02();
		frag_02.setmDelegate(this);
		//
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_opcao_opened,
				R.string.drawer_opcao_closed) {

			@Override
			public void onDrawerClosed(View drawerView) {
				invalidateOptionsMenu();
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				invalidateOptionsMenu();
			}

		};
	}

	private void cfg_Actions() {
		getActionBar().setDisplayHomeAsUpEnabled(true);
		//
		FragmentManager fm = getSupportFragmentManager();
		//
		if ( fm.findFragmentByTag(FRAG_01) == null){
			FragmentTransaction ft = fm.beginTransaction();
			ft.replace(R.id.ll_container, frag_01, FRAG_01);
			ft.commit();
		}
		//
		if ( fm.findFragmentByTag(FRAG_02) == null){
			FragmentTransaction ft = fm.beginTransaction();
			ft.replace(R.id.ll_opc, frag_02, FRAG_02);
			ft.commit();
		}
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		mDrawerToggle.syncState();
		//
		super.onPostCreate(savedInstanceState);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		
		return super.onOptionsItemSelected(item);
	}

	public void fechar_drawer() {
		mDrawerLayout.closeDrawer(opc);
	}

	public void mudar_texto(String texto) {
		frag_01.mudar_Texto(texto);
	}

	@Override
	public void mudarTT(String texto) {
		frag_01.mudar_Texto(texto);
		//
		fechar_drawer();
	}

}
