package edu.fjnu.cse.android_ui;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class Main5Activity extends AppCompatActivity{

    private String[] data = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine","Ten"};

    private SelectionAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_tem2);
        final ListView list = findViewById(R.id.ls);  //绑定list
        registerForContextMenu(list); // 为上下文菜单登记视图，之后，长按视图则会触发上下文菜单的创建
        mAdapter = new SelectionAdapter(this,R.layout.list_item, R.id.name, data);
        list.setAdapter(mAdapter);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        list.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            private int nr = 0;
            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // TODO Auto-generated method stub
                mAdapter.clearSelection();
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                // TODO Auto-generated method stub
                nr = 0;
                MenuInflater inflater = getMenuInflater();
                inflater.inflate(R.menu.menn_main4, menu);
                return true;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {     ///???
                // TODO Auto-generated method stub
                switch (item.getItemId()) {
                    case R.id.delete_item:
                        nr = 0;
                        mAdapter.clearSelection();
                        mode.finish();
                }
                return false;
            }

            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position,
                                                  long id, boolean checked) {
                // TODO Auto-generated method stub
                if (checked) {
                    nr++;
                    mAdapter.setNewSelection(position, checked);
                } else {
                    nr--;
                    mAdapter.removeSelection(position);
                }
                mode.setTitle(nr + "选择");
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int position, long arg3) {
                // TODO Auto-generated method stub
                list.setItemChecked(position, !mAdapter.isPositionChecked(position));
                return false;
            }
        });
    }
    private class SelectionAdapter extends ArrayAdapter<String> {

        private HashMap<Integer, Boolean> mSelection = new HashMap<Integer, Boolean>();

        public SelectionAdapter(Context context, int resource,
                                int textViewResourceId, String[] objects) {
            super(context, resource, textViewResourceId, objects);
        }

        public void setNewSelection(int position, boolean value) {
            mSelection.put(position, value);
            notifyDataSetChanged();
        }

        public boolean isPositionChecked(int position) {
            Boolean result = mSelection.get(position);
            return result == null ? false : result;
        }
        public Set<Integer> getCurrentCheckedPosition() {
            return mSelection.keySet();
        }

        public void removeSelection(int position) {
            mSelection.remove(position);
            notifyDataSetChanged();
        }
        public void clearSelection() {
            mSelection = new HashMap<Integer, Boolean>();
            notifyDataSetChanged();
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = super.getView(position, convertView, parent);//let the adapter handle setting up the row views
            v.setBackgroundColor(getResources().getColor(android.R.color.background_light)); //default color
            if (mSelection.get(position) != null) {
                v.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));// this is a selected position so make it red
            }
            return v;
        }
    }
}


/*

public class Main5Activity extends Activity {
   // private TextView mTextView;
    private ListView mListView;
    private String[] data = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine","Ten"};
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_tem2);
        initComponent();  //绑定list
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.list_item, data);
        listView.setAdapter(adapter);
        // 给ListView注册上下文菜单
        registerForContextMenu(listView); // 这里接受的参数是一个View的类型



        */
/*final ListView list = findViewById(R.id.ls);  //绑定list
        registerForContextMenu(list); // 为上下文菜单登记视图，之后，长按视图则会触发上下文菜单的创建
        mAdapter = new SelectionAdapter(this,R.layout.list_item, R.id.name, data);
        list.setAdapter(mAdapter);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);*//*

    }

    private List<String> getData() {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i <= 6; i++) {
            list.add("AHuier" + i);
        }
        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menn_main4, menu);
        return true;
    }

    */
/**
     * onCreateOptionsMenu() 与 onCreateContextMenu()的区别 第一个是普通的可选菜单 第二个是添加上下文的菜单
     *//*

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        // 加载xml中的上下文菜单
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflate = getMenuInflater();
        inflate.inflate(R.menu.menn_main4, menu);
    }

    // 响应上下文菜单的操作
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case R.id.delete_item:
                Toast.makeText(Main5Activity.this, "Edit", Toast.LENGTH_LONG).show();
                //mAdapter.clearSelection();
              //  mode.finish();
                break;
            default:
                break;
        }
        return super.onContextItemSelected(item);



       */
/* @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            // TODO Auto-generated method stub
            switch (item.getItemId()) {
                case R.id.delete_item:
                    nr = 0;
                    mAdapter.clearSelection();
                    mode.finish();
            }
            return false;
        }*//*


    }

    private void initComponent() {
        listView = (ListView) findViewById(R.id.ls);
    }

}*/
