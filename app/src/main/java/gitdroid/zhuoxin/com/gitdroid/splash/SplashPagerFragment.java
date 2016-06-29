package gitdroid.zhuoxin.com.gitdroid.splash;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.BindColor;
import butterknife.ButterKnife;
import gitdroid.zhuoxin.com.gitdroid.R;
import gitdroid.zhuoxin.com.gitdroid.splash.pager.Pager2;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by user on 2016/6/29.
 */
public class SplashPagerFragment extends Fragment {
    @Bind(R.id.viewPager)ViewPager viewPager;
    @Bind(R.id.indicator)CircleIndicator indicator;//指示器
    @Bind(R.id.content)FrameLayout frameLayout;
    @Bind(R.id.layoutPhone)FrameLayout layoutPhone;//手机layout
    @Bind(R.id.ivPhoneBlank)ImageView ivPhoneBlank;
    @Bind(R.id.ivPhone)ImageView ivPhone;

    @BindColor(R.color.colorGreen) int colorGreen;   // ViewPager页面对应背景色
    @BindColor(R.color.colorRed) int colorRed;  // ViewPager页面对应背景色
    @BindColor(R.color.colorYellow) int colorYellow;    // ViewPager页面对应背景色
    private SplashPagerAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_pager,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        adapter = new SplashPagerAdapter(getContext());
        viewPager.setAdapter(adapter);
        // 添加ViewPager监听
        viewPager.addOnPageChangeListener(pageChangeListener);

        indicator.setViewPager(viewPager);
    }
    private final ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener(){
        //ARGB取值器
        final ArgbEvaluator evaluator = new ArgbEvaluator();
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            //当前positionOffset  比例
            //start颜色：做一个
            //end颜色：...
            if (position==0){
                //移动过程中有一个平移动画
                int scroll =(int)((positionOffset-1) * 150);
                //移动过程中的缩放
                layoutPhone.setTranslationX(scroll);
                float scale = 0.3f + positionOffset * 0.7f ;
                layoutPhone.setScaleX(scale);
                layoutPhone.setScaleY(scale);
                //移动过程中，手机内容的显示
                ivPhone.setAlpha(positionOffset);
                int color = (int)evaluator.evaluate(positionOffset,colorGreen,colorRed);
                frameLayout.setBackgroundColor(color);
                return;
            }
            //当在2页面与3页面之间
            if (position==1){

                layoutPhone.setTranslationX(-positionOffsetPixels);
                int color = (int)evaluator.evaluate(positionOffset,colorRed,colorYellow);
                frameLayout.setBackgroundColor(color);
                return;
            }



        }

        @Override
        public void onPageSelected(int position) {
            if (position==0){
                layoutPhone.setVisibility(View.VISIBLE);
            }
            if (position==1){
                layoutPhone.setVisibility(View.VISIBLE);
            }
            if (position==2){

                Pager2 pager2 = (Pager2) adapter.getViews(2);
                pager2.showAnimation();
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


}
