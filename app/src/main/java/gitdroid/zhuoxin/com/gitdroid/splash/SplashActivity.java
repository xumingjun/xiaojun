package gitdroid.zhuoxin.com.gitdroid.splash;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import gitdroid.zhuoxin.com.gitdroid.MainActivity;
import gitdroid.zhuoxin.com.gitdroid.R;
import gitdroid.zhuoxin.com.gitdroid.commons.ActivityUtils;

/**
 * 首页面,第一次启动时进入的页面
 */
public class SplashActivity extends AppCompatActivity {

    @Bind(R.id.btnLogin) Button btnLogin;
    @Bind(R.id.btnEnter) Button btnEnter;

    private ActivityUtils activityUtils;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
        ButterKnife.bind(this);
        activityUtils = new ActivityUtils(this);
    }

    @OnClick(R.id.btnLogin)
    public void login() {
        Toast.makeText(this, "login", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btnEnter)
    public void enter() {
        activityUtils.startActivity(MainActivity.class);
        finish();
    }
}
