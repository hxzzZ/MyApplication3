package hxz.application;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by hxz on 2017-08-16.
 */

public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.ViewHolder> {



    private List<appInfo> appInfoList;

    public AppListAdapter(List<appInfo> appInfoList) {
        this.appInfoList = appInfoList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
