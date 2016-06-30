package gitdroid.zhuoxin.com.gitdroid.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import gitdroid.zhuoxin.com.gitdroid.R;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;


/**
 * Created by user on 2016/6/30.
 */
public class RepoListFragment extends Fragment{
    @Bind(R.id.ptrClassicFrameLayout)PtrClassicFrameLayout ptrFrameayoutL;
    @Bind(R.id.lvRepos)ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> datas = new ArrayList<String>();
    private static int count;

    public static RepoListFragment getInstance(String language){
        RepoListFragment fragment = new RepoListFragment();
        Bundle args =  new Bundle();
        args.putSerializable("ket_language",language);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_repo_list,container,false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);


        ptrFrameayoutL.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                loadData(20);
            }
        });
    }

    private  void  loadData(final int size){
       new Thread(new Runnable() {
           @Override
           public void run() {
               try {
                   Thread.sleep(1000);
                   datas.clear();
                   for (int i= 1;i<=size;i++){
                       count++;
                       datas.add("我是第"+count+"条数据");
                   }
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }

               ptrFrameayoutL.post(new Runnable() {
                   @Override
                   public void run() {
                       //添加刷新数据
                       adapter.clear();
                       adapter.addAll(datas);
                       adapter.notifyDataSetChanged();
                       //下拉刷新完成
                       ptrFrameayoutL.refreshComplete();
                   }
               });

           }
       }).start();
    };
    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
