package com.wu.expandablelistview;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.TextView;

/**
 * 创建ExpandableListView适配器需要实现ExpandableListAdapter接口
 */

public class MyAdapter implements ExpandableListAdapter{
    private String[] groupStrings;
    private String[][] childStrings;
    private Context context;
    private LayoutInflater inflater;

    public MyAdapter(Context context, String[][] childStrings, String[] groupStrings) {
        this.context = context;
        this.childStrings = childStrings;
        this.groupStrings = groupStrings;
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    //获取分组的数量
    @Override
    public int getGroupCount() {
        return groupStrings.length;
    }

    //获取分组中子选项的个数
    @Override
    public int getChildrenCount(int groupPosition) {
        return childStrings.length;
    }

    //获取指定分组数据
    @Override
    public Object getGroup(int groupPosition) {
        return groupStrings[groupPosition];
    }

    //获取指定分组中子选项的数据
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childStrings[groupPosition][childPosition];
    }

    //获取指定分组的ID
    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    //获取指定分组中子选项的ID
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    //获取显示指定分组的视图
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup
            parent) {
        GroupViewHolder groupViewHolder;
        if (convertView==null){
            convertView=inflater.inflate(R.layout.item_listview_group,parent,false);
            groupViewHolder=new GroupViewHolder(convertView);
            convertView.setTag(groupViewHolder);
        }else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        groupViewHolder.textView_group.setText(groupStrings[groupPosition]);
        return convertView;
    }

    //获取指定分组中子选项卡的视图
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View
            convertView, ViewGroup parent) {
        ChlildViewHolder chlildViewHolder;
        if (convertView==null){
            convertView=inflater.inflate(R.layout.item_listview_child,parent,false);
            chlildViewHolder=new ChlildViewHolder(convertView);
            convertView.setTag(chlildViewHolder);
        }else {
            chlildViewHolder= (ChlildViewHolder) convertView.getTag();
        }
        chlildViewHolder.textView_child.setText(childStrings[groupPosition][childPosition]);
        return convertView;
    }

    //指定位置上的子选项是否能选中
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {

    }

    @Override
    public void onGroupCollapsed(int groupPosition) {

    }

    @Override
    public long getCombinedChildId(long groupId, long childId) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long groupId) {
        return 0;
    }

    public class GroupViewHolder {
        private TextView textView_group;
        public GroupViewHolder(View convertView) {
            textView_group= (TextView) convertView.findViewById(R.id.textView_group);
        }
    }

    public class ChlildViewHolder {
        private TextView textView_child;
        public ChlildViewHolder(View convertView) {
            textView_child= (TextView) convertView.findViewById(R.id.textView_child);
        }
    }
}
