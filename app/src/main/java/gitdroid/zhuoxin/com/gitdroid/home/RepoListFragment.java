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


/**
 * Created by user on 2016/6/30.
 */
public class RepoListFragment extends Fragment{
    @Bind(R.id.lvRepos)ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> datas = new ArrayList<String>();


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
        for (int i= 1;i<=10;i++){
            datas.add("我是第"+i+"条数据");
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);
        adapter.addAll(datas);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
