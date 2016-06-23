package com.iiseeu.demo.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.iiseeu.demo.R;
import com.iiseeu.demo.ui.fragment.CardFragment;
import com.iiseeu.demo.utils.ColorUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by housong on 2016/6/13.
 */
public class MainActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {


    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.tabLayout) TabLayout tabLayout;
    @Bind(R.id.viewPager) ViewPager viewPager;
    @Bind(R.id.drawerLayout) DrawerLayout drawerLayout;
    private ShareActionProvider shareActionProvider;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initToolbar();
        initDrawerLayout();
        initViewPager();
    }

    private void initToolbar() {
        toolbar.setTitleTextColor(ColorUtils.getRandomColor());
        toolbar.setTitle("Demo");
        setSupportActionBar(toolbar);
//        toolbar.inflateMenu(R.menu.main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setOnMenuItemClickListener(this);
    }

    private void initDrawerLayout() {
        //drawerLayout与tooBar绑定
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        //同步状态
        toggle.syncState();
        drawerLayout.addDrawerListener(toggle);
    }

    private void initViewPager() {
        MainPagerAdapter adapter = new MainPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
//        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menu.findItem(R.id.action_share));
//        Intent intent = new Intent(Intent.ACTION_SEND);
//        intent.setType("text/*");
//        shareActionProvider.setShareIntent(intent);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_share:
                Toast.makeText(MainActivity.this, "share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_settings:
                Toast.makeText(MainActivity.this, "settings", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    private final String[] TITLES = {"分类", "主页", "热门推荐", "热门收藏", "本月热榜", "今日热榜", "专栏", "随机"};

    class MainPagerAdapter extends FragmentPagerAdapter {


        public MainPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new CardFragment();
        }

        @Override
        public int getCount() {
            return TITLES.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return TITLES[position];
        }
    }

    @Override
    public void finish() {
        moveTaskToBack(true);
    }


}
