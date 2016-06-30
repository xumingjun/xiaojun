package gitdroid.zhuoxin.com.gitdroid.home;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;
import gitdroid.zhuoxin.com.gitdroid.R;

/**
 * Created by user on 2016/6/30.
 * 最热门仓库Fragment
 */
public class HotRepoFragment extends Fragment {
    //找控件
    @Bind(R.id.viewPager)ViewPager viewPager;
    @Bind(R.id.tabLayout)TabLayout tabLayout;
    //
    private HotRepoPagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hot_repo,container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        //实例化Adapter
        adapter = new HotRepoPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
