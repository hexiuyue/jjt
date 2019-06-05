package com.guoshi.module_news;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.guoshi.baselib.route.ModuleNewsUtlis;

@Route(path = ModuleNewsUtlis.test)
public class NewsTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_test);
    }
}
