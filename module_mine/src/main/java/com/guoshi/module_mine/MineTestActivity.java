package com.guoshi.module_mine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.guoshi.baselib.route.ModuleMineUtlis;

@Route(path = ModuleMineUtlis.test)
public class MineTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_test);

    }
}
