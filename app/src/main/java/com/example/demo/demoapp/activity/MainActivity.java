package com.example.demo.demoapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.demo.demoapp.R;
import com.xing.view.tablayout.CommonTabLayout;
import com.xing.view.tablayout.listener.CustomTabEntity;
import com.xing.view.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private CommonTabLayout commonTabLayout;
    private ArrayList<CustomTabEntity> customTabEntities = new ArrayList<>();
    private String[] titles = new String[]{"每日精选", "发现", "热门", "我的"};
    private int[] select_icon = new int[]{R.mipmap.ic_home_selected, R.mipmap.ic_discovery_selected, R.mipmap.ic_hot_selected, R.mipmap.ic_mine_selected};
    private int[] no_select_icon = new int[]{R.mipmap.ic_home_normal, R.mipmap.ic_discovery_normal, R.mipmap.ic_hot_normal, R.mipmap.ic_mine_normal};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    public void initView() {

        commonTabLayout = findViewById(R.id.tab_layout);

    }

    public void initData() {
        for (int i = 0; i < titles.length; i++) {
            final int finalI = i;
            CustomTabEntity customTabEntity = new CustomTabEntity() {
                @Override
                public String getTabTitle() {
                    return titles[finalI];
                }

                @Override
                public int getTabSelectedIcon() {
                    return select_icon[finalI];
                }

                @Override
                public int getTabUnselectedIcon() {
                    return no_select_icon[finalI];
                }
            };
            customTabEntities.add(customTabEntity);
        }
        commonTabLayout.setTabData(customTabEntities);
        commonTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                Toast.makeText(MainActivity.this, "onTabSelect=position==" + position, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onTabReselect(int position) {
                Toast.makeText(MainActivity.this, "onTabReselect=position==" + position, Toast.LENGTH_LONG).show();

            }
        });
    }
}
