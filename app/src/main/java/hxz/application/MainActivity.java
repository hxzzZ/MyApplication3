package hxz.application;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.functions.Func2;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {


    @Bind(R.id.app_list_rv)
    RecyclerView appListRv;
    @Bind(R.id.pull_down_srl)
    SwipeRefreshLayout pullDownSrl;
    private String TAG = "rx";
    private List<appInfo> mAppInfoList;
    private AppListAdapter mAppListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        appListRv.setLayoutManager(layoutManager);
        mAppInfoList = new ArrayList<>();
        mAppListAdapter = new AppListAdapter(mAppInfoList);
        appListRv.setAdapter(mAppListAdapter);
        pullDownSrl.setOnRefreshListener(this);

        pullDownSrl.post(new Runnable() {
            @Override
            public void run() {
                pullDownSrl.setRefreshing(true);
                onRefresh();
            }
        });

    }

    @Override
    public void onRefresh() {
        if (mAppInfoList != null) {
            mAppInfoList.clear();
            mAppListAdapter.notifyDataSetChanged();
        }
        loadApp();
    }

    private void loadApp() {
        PackageManager packageManager = MainActivity.this.getPackageManager();
        Observable.create(new Observable.OnSubscribe<appInfo>() {
            @Override
            public void call(Subscriber<? super appInfo> subscriber) {

            }
        });
    }

    private void scan() {
        Observable.just(1, 2, 3, 4, 5)
                .scan(new Func2<Integer, Integer, Integer>() {
                    @Override
                    public Integer call(Integer integer, Integer integer2) {
                        return integer + integer2;
                    }
                }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Log.i(TAG, "call: " + integer);//1 3 6 10 15

            }
        });
    }

    private void flatMap() {
        String a[] = {"1", "2", "3"};
        final Integer s1[] = new Integer[]{};
        Observable.from(a).flatMap(new Func1<String, Observable<Integer>>() {
            @Override
            public Observable<Integer> call(String s) {
                return Observable.from(s1);
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Log.i(TAG, "call: " + integer);
            }
        });
    }

    private void just() {
        Observable.just(1, 2, 3, 4, 5)
                .map(new Func1<Integer, String>() {
                    @Override
                    public String call(Integer integer) {
                        return integer + "";
                    }
                }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {

                Log.i(TAG, "just - call: " + s);
            }
        });
    }

    private void create() {
        Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                subscriber.onNext(1);
                subscriber.onNext(2);
                subscriber.onCompleted();
            }
        }).map(new Func1<Integer, String>() {
            @Override
            public String call(Integer integer) {
                return integer + "c";
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.i(TAG, "call: " + s);
            }
        });

    }


}
