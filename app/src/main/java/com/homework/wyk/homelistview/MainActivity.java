package com.homework.wyk.homelistview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.homework.wyk.homelistview.bean.Fruit;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    private ListView mListView;
    private List<Fruit> mFruitList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.activity_main_listview);
        initFruit();
       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas);
        FruitAdapter fruitAdapter = new FruitAdapter(this, R.layout.activity_list_item, mFruitList);
        mListView.setAdapter(fruitAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "请点击"+ mFruitList.get(position).getmFruitName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruit() {
        String[] datas = {"apple", "banana", "pear", "cherry", "watermelon", "starwberry",
                "apple", "banana", "pear", "cherry", "watermelon", "starwberry","apple",
                "banana", "pear", "cherry", "watermelon", "starwberry"};
        int[] images = {R.drawable.apple_pic, R.drawable.banana_pic, R.drawable.pear_pic, R.drawable.cherry_pic,
                R.drawable.watermelon_pic, R.drawable.strawberry_pic,
                R.drawable.apple_pic, R.drawable.banana_pic, R.drawable.pear_pic, R.drawable.cherry_pic,
                R.drawable.watermelon_pic, R.drawable.strawberry_pic,
                R.drawable.apple_pic, R.drawable.banana_pic, R.drawable.pear_pic, R.drawable.cherry_pic,
                R.drawable.watermelon_pic, R.drawable.strawberry_pic};
        mFruitList = new ArrayList<>();
        for (int i = 0; i < datas.length; i++) {
            Fruit fruit = new Fruit(datas[i],images[i]);
            System.out.print(123);
            mFruitList.add(fruit);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }


    public class FruitAdapter extends ArrayAdapter<Fruit> {

        private int mCountOfInflate = 0;

        public FruitAdapter(Context context, int resource, List<Fruit> objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // return super.getView(position, convertView, parent);
            //View view;

            ViewHolder viewHolder;

            if (convertView == null) {

                convertView = LayoutInflater.from(getContext()).inflate(
                        R.layout.activity_list_item, parent, false);
                viewHolder = new ViewHolder();
                viewHolder.imageView = (ImageView) convertView.findViewById(R.id.activity_list_item_img);
                viewHolder.textView = (TextView) convertView.findViewById(R.id.activity_list_item_text);
                Log.d(TAG, "新造箱子" + (++mCountOfInflate));
                convertView.setTag(viewHolder);
            }
            else
            {
                viewHolder = (ViewHolder) convertView.getTag();
            }

                //ImageView imageView = (ImageView) convertView.findViewById(R.id.activity_list_item_img);
                //TextView textView = (TextView) convertView.findViewById(R.id.activity_list_item_text);

                Fruit fruit = getItem(position);
                Log.d("name", fruit.getmFruitName());



            //int aa = fruit.getmImageId();
            //System.out.print(aa);
            viewHolder.imageView.setImageResource(fruit.getmImageId());
            viewHolder.textView.setText(fruit.getmFruitName());
            return convertView;
        }

        @Override
        public int getCount() {
            Log.d(TAG, "getCount: " + super.getCount());
            return super.getCount();
        }

        class ViewHolder {
            ImageView imageView;
            TextView textView;
        }
    }
}
