package test.cristian.lm;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ImageView;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import static com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.*;


public class Main extends ActionBarActivity implements OnMenuItemClick {

    private TextView mtitle;
    private ImageView btnmenu;
    private SlidingMenu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, FContent.newInstance("TITLE"))
                    .commit();

            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.menu, FMenu.newInstance())
                    .commit();
        }

        /**
         * SlidingMenu
         */

        menu = new SlidingMenu(this);
        menu.setMode(RIGHT);
        menu.setTouchModeAbove(TOUCHMODE_FULLSCREEN);
        //menu.setShadowWidthRes(R.dimen.shadow_width);
        //menu.setShadowDrawable(R.drawable.shadow);
        menu.setBehindOffsetRes(Sizes.MEDIUM);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SLIDING_CONTENT);
        menu.setMenu(R.layout.menu);

        /**
         * Header
         */
        mtitle = (TextView) findViewById(R.id.title);
        btnmenu = (ImageView) findViewById(R.id.option_menu);
        btnmenu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.toggle();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public TextView getMtitle() {
        return mtitle;
    }

    public SlidingMenu getMenu() {
        return menu;
    }

    @Override
    public void OnMenuItemClick(test.cristian.lm.Menu menu, View view) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, FContent.newInstance(menu.getName()))
                .commit();
    }
}
