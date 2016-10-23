package com.wu.expandablelistview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public String[] groupStrings = {"西游记", "水浒传", "三国演义", "红楼梦"};
    public String[][] childStrings = {
            {"唐三藏", "孙悟空", "猪八戒", "沙和尚"},
            {"宋江", "林冲", "李逵", "鲁智深"},
            {"曹操", "刘备", "孙权", "诸葛亮", "周瑜"},
            {"贾宝玉", "林黛玉", "薛宝钗", "王熙凤"}
    };
    private MyAdapter myAdapter;
    private ExpandableListView listView_main;
    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        //点击分组的监听事件
        listView_main.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition,
                                        long id) {
                Toast.makeText(mContext, groupStrings[groupPosition], Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        //点击分组的子选项监听事件
        listView_main.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int
                    childPosition, long id) {
                Toast.makeText(mContext, childStrings[groupPosition][childPosition], Toast
                        .LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void initView() {
        listView_main = (ExpandableListView) findViewById(R.id.listView_main);
        myAdapter = new MyAdapter(mContext, childStrings, groupStrings);
        listView_main.setAdapter(myAdapter);
    }
}
