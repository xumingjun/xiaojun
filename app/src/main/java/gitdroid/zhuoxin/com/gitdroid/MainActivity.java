package gitdroid.zhuoxin.com.gitdroid;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.GridLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import gitdroid.zhuoxin.com.gitdroid.commons.ActivityUtils;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    // https://github.com/feicui-android/GitDroid.git
    // ButterKnife 库
    // compile 'com.jakewharton:butterknife:7.0.1'

    @Bind(R.id.navigationView)NavigationView navigationView;//侧滑菜单试图
    @Bind(R.id.drawerLayout)DrawerLayout drawerLayout;
    @Bind(R.id.toolbar)Toolbar toolbar;
    private ActivityUtils activityUtils;
    private MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.bind(this);
        navigationView.setNavigationItemSelectedListener(this);
        activityUtils = new ActivityUtils(this);
        //处理
        setSupportActionBar(toolbar);
        //返回键显示
//      getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //抽屉开关
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();//同步状态

        //默认选中最热门
        menuItem = navigationView.getMenu().findItem(R.id.github_hot_repo);
        menuItem.setChecked(true);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        //将默认选中项手动设置为false
        if (menuItem.isChecked()){
            menuItem.setChecked(false);
        }
        switch (item.getItemId()){
            case R.id.github_hot_repo:
                activityUtils.showToast(R.string.hot_repo);
                break;
            case R.id.arsenal_my_repo:
                activityUtils.showToast(R.string.my_repo);
                break;
            case R.id.tips_daily:
                activityUtils.showToast(R.string.tips_daily);
                break;
            /*case R.id.tips_share:
                //测试代码，按下分享，关闭侧滑
                drawerLayout.closeDrawer(GravityCompat.START);
                break;*/
        }

        return true;//返回ture，代表该菜单项变为选中

    }

    @Override
    public void onBackPressed() {

        //如果侧滑菜单开启，则关闭
        //如果侧滑没有开启，额突出当前Activity
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

    }
}