package br.curso.a_027_tabs;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {

	private ActionBar actionbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_main);
		actionbar = getActionBar();
		//
		actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionbar.setDisplayShowTitleEnabled(true);
		//

		Tab tab = actionbar.newTab();
		tab.setText("Android")
				.setTabListener(

						new CustomTabListener<AndroidFragment>(this, "android",
								AndroidFragment.class)

				).setIcon(R.drawable.android);

		actionbar.addTab(tab);

		tab = actionbar.newTab();
		tab.setText("Apple")
				.setTabListener(

						new CustomTabListener<AppleFragment>(this, "apple",
								AppleFragment.class)

				).setIcon(R.drawable.apple);

		actionbar.addTab(tab);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
