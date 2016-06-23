package com.iiseeu.demo.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.iiseeu.demo.R;
import com.iiseeu.demo.utils.ColorUtils;
import com.tbruyelle.rxpermissions.RxPermissions;
import com.xys.libzxing.zxing.activity.CaptureActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.functions.Action1;

/**
 * Author: housong
 * Date: 2016/6/23 13:34
 */
public class DemoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.recyclerView) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_activity);
        ButterKnife.bind(this);
        initToolbar();
        initView();
    }

    private void initToolbar() {
        toolbar.setTitle(R.string.toolbar_text);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
    }

    private void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                scanQRCode();
                break;
        }
    }

    private void scanQRCode() {
        RxPermissions.getInstance(this).request(Manifest.permission.CAMERA)
                .subscribe(new Action1<Boolean>() {
                    @Override
                    public void call(Boolean aBoolean) {
                        if (aBoolean) {
                            startActivityForResult(new Intent(DemoActivity.this, CaptureActivity.class), 1);
                        } else {
                            Toast.makeText(DemoActivity.this, "没有为该应用开启相机权限", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    private RecyclerView.Adapter<DemoHolder> adapter = new RecyclerView.Adapter<DemoHolder>() {

        private List<String> items = getItems();

        @Override
        public DemoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(DemoActivity.this).inflate(android.R.layout.simple_list_item_1, null, false);
            return new DemoHolder(view);
        }

        @Override
        public void onBindViewHolder(DemoHolder holder, final int position) {
            holder.textView.setTextColor(ColorUtils.getRandomColor());
            holder.textView.setText(items.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClick(v, position);
                }
            });
        }

        @Override
        public int getItemCount() {
            return items.size();
        }
    };


    interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    private OnItemClickListener itemClickListener;

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }


    class DemoHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public DemoHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(android.R.id.text1);
        }
    }

    private List<String> getItems() {
        List<String> items = new ArrayList<>();
        items.add("二维码扫描");
        return items;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 1:
                    String result = data.getExtras().getString("result");
                    Toast.makeText(DemoActivity.this, result, Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
