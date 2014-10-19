package com.example.kevin.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MyActivity extends Activity {


    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private GridLayoutManager mGridLayoutManager;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private ArrayList<String> mData;
    private int imgs[] = {
            R.drawable.gxstc9710428878, R.drawable.h, R.drawable.mxhxm11867753492, R.drawable.i, R.drawable.lypjdjdh0545,
            R.drawable.mnxh11720107980, R.drawable.mnxqx9405550634, R.drawable.mxfbb9561660149, R.drawable.mxzbz11795369690
            , R.drawable.mxzxy9395086865, R.drawable.qcmc9349802911, R.drawable.sygjdl9631142484, R.drawable.xgmn11913114670};

    private ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<String>();

        for (int i = 0; i < imgs.length; i++) {
            data.add("#content" + i);
        }
        return data;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mGridLayoutManager = new GridLayoutManager(this, 3);
        mGridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL);
        mAdapter = new MyAdapter();
        mAdapter.bindData(getData());
        mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case R.id.action_horizontal_list_view:
                mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                mRecyclerView.setLayoutManager(mLayoutManager);
                break;
            case R.id.action_vertical_list_view:
                mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                mRecyclerView.setLayoutManager(mLayoutManager);
                break;
            case R.id.action_horizontal_grid_view:
                mGridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                mRecyclerView.setLayoutManager(mGridLayoutManager);
                break;
            case R.id.action_vertical_grid_view:
                mGridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                mRecyclerView.setLayoutManager(mGridLayoutManager);
                break;
            case R.id.action_horizontal_staggered_grid_view:
                staggeredGridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
                break;
            case R.id.action_vertical_staggered_grid_view:
                staggeredGridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                mRecyclerView.setLayoutManager(staggeredGridLayoutManager);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHoler> {

        ArrayList<String> data = new ArrayList<String>();

        public void bindData(ArrayList<String> data) {
            this.data.clear();
            this.data.addAll(data);

        }

        @Override
        public ViewHoler onCreateViewHolder(ViewGroup viewGroup, int i) {

            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_item, viewGroup, false);
            ViewHoler vh = new ViewHoler(view);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHoler viewHoler, int i) {
            viewHoler.mTextView.setText(data.get(i));
            viewHoler.mImg.setImageResource(imgs[i]);

        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public class ViewHoler extends RecyclerView.ViewHolder {

            public TextView mTextView;
            public ImageView mImg;

            public ViewHoler(View itemView) {
                super(itemView);
                mTextView = (TextView) itemView.findViewById(R.id.content);
                mImg = (ImageView) itemView.findViewById(R.id.icon);
            }
        }
    }
}
