package br.curso.a_viewpager_ex;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements Frag_02.IF02{

	private Context context;
	//
	private ViewPager pager;
	//
	private String[] titles = { "Titulo 1 ", "Titulo 2", "Titulo 3" };
	private ArrayList<Fragment> fragments;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.telainicial);
		//
		context = getBaseContext();
		//
		pager = (ViewPager) findViewById(R.id.pager);
		//
		fragments = new ArrayList<Fragment>();
		fragments.add(new Frag_01());
		//
		Frag_02 f_02 = new Frag_02();
		f_02.delegate = this;
		//
		fragments.add(f_02);
		fragments.add(new Frag_03());
		//
		pager.setAdapter(new FPagerAdapter(getSupportFragmentManager(),
				fragments));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private class FPagerAdapter extends FragmentPagerAdapter {

		private ArrayList<Fragment> fragments;

		public FPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
			super(fm);
			this.fragments = fragments;
		}

		@Override
		public Fragment getItem(int position) {
			return fragments.get(position);
		}

		@Override
		public int getCount() {
			return fragments.size();
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return titles[position];
		}

	}
	
	
	
	public void fazqualquercoisa(){
		Toast.makeText(context, "Olá", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void acionarMudanca(int indice) {
		pager.setCurrentItem(indice);
	}

}
