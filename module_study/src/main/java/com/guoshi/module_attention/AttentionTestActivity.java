package com.guoshi.module_attention;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.guoshi.baselib.route.ModuleAttentionUtlis;
import com.guoshi.baselib.route.ModuleHomeUtlis;

@Route(path = ModuleAttentionUtlis.test)
public class AttentionTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attention_test);

    }
}
