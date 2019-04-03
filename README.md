# android_UI

1


    private ListView mListView;
    private String[] names = {"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};
    private int[] icons = {R.drawable.lion, R.drawable.tiger, R.drawable.monkey, R.drawable.dog, R.drawable.cat, R.drawable.elephant};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化ListView控件
        mListView = findViewById(R.id.ls);//////
        List<Map<String, Object>> listItems = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> listItem = new HashMap<>();
            listItem.put("face", icons[i]);
            listItem.put("name", names[i]);
            listItems.add(listItem);
        }
        SimpleAdapter simleAdapter = new SimpleAdapter(MainActivity.this, listItems,
                R.layout.list_item, new String[]{"face", "name"}, new int[]{R.id.face, R.id.name});
        mListView.setAdapter(simleAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //我们需要的内容，跳转页面或显示详细信息
                Toast.makeText(getApplicationContext(), names[position], Toast.LENGTH_LONG).show();
                if (((ListView)parent).getTag() != null){
                    ((View)((ListView)parent).getTag()).setBackgroundDrawable(null);
                }
                ((ListView)parent).setTag(view);
                view.setBackgroundColor(Color.RED);
            } });
            }


   截图：
   
   2
   
    //设置按钮事件
    private void initEvent() {
        findViewById(R.id.two_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }
    private void showDialog(){
        Button mButton1;
        Button mButton2;
        LayoutInflater inflater = LayoutInflater.from(this);
        View layout=inflater.inflate(R.layout.order,null);  //布局
        AlertDialog.Builder builder = new AlertDialog.Builder(Main4Activity.this)
                .setView(layout);
        final AlertDialog dialog=builder.create();
        dialog.show();
        mButton1 = (Button) layout.findViewById(R.id.startOrder_btn);
        mButton2 = (Button)layout.findViewById(R.id.managerOrder_btn);
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText()
                dialog.dismiss();
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

    }

   截图：
   
   3
   
    private TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        txt = (TextView)findViewById(R.id.txt);

    }
    
    //开发选项菜单重写的方法
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);//菜单动态加载类
        inflater.inflate(R.menu.menu_main3,menu);//调用inflate方法解析菜单文件
        super.onCreateOptionsMenu(menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem mi){
        switch (mi.getItemId()){
            case R.id.font_10:
                txt.setTextSize(20);
                break;
            case R.id.font_16:
                txt.setTextSize(32);
                break;
            case R.id.font_20:
                txt.setTextSize(40);
                break;
            case R.id.red_font:
                txt.setTextColor(Color.RED);
                break;
            case R.id.black_font:
                txt.setTextColor(Color.BLACK);
                break;
            case R.id.plain_item:
                Toast toast =Toast.makeText(Main3Activity.this,"这是普通菜单项",Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
        return true;
    }
    
  截图：

  4
    
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
    
  截图：




