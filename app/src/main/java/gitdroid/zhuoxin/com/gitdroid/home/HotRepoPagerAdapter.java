package gitdroid.zhuoxin.com.gitdroid.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.CheckedInputStream;

/**
 * Created by user on 2016/6/30.
 */
public class HotRepoPagerAdapter extends FragmentPagerAdapter{
    private final List<String> languages;

    public HotRepoPagerAdapter(FragmentManager fm) {
        super(fm);
        languages = new ArrayList<>();
        languages.add("java-1");
        languages.add("java-2");
        languages.add("java-3");
        languages.add("java-4");
        languages.add("java-5");

    }

    @Override
    public Fragment getItem(int position) {
        return RepoListFragment.getInstance(languages.get(position));
    }

    @Override
    public int getCount() {
        return languages.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return languages.get(position);
    }
}
