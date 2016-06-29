package gitdroid.zhuoxin.com.gitdroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    // https://github.com/feicui-android/GitDroid.git
    // ButterKnife 库
    // compile 'com.jakewharton:butterknife:7.0.1'

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}