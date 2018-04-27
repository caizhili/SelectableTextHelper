package com.jaeger.selectabletexthelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jaeger.library.OnSelectListener;
import com.jaeger.library.OnSelectedItemClickListener;
import com.jaeger.library.SelectableTextHelper;

public class MainActivity extends AppCompatActivity implements OnSelectedItemClickListener {

    private TextView mTvTest;

    private SelectableTextHelper mSelectableTextHelper;
    private LinearLayout llRoot;
    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvTest = (TextView) findViewById(R.id.tv_test);
        //mTvTest.setTextIsSelectable(true);

        mSelectableTextHelper = new SelectableTextHelper.Builder(mTvTest, R.layout.layout_operate_windows)
                .setSelectedColor(getResources().getColor(R.color.selected_blue))
                .setCursorHandleSizeInDp(20)
                .setOnSelectedItemClickListener(this)
                .setCursorHandleColor(getResources().getColor(R.color.cursor_handle_color))
                .build();

        mSelectableTextHelper.setSelectListener(new OnSelectListener() {
            @Override
            public void onTextSelected(CharSequence content) {

            }
        });
        initView();
    }

    private void initView() {
        llRoot = (LinearLayout) findViewById(R.id.ll_root);
        tvTest = (TextView) findViewById(R.id.tv_test);
    }

    @Override
    public void onItemClick(View v, String mSelectionText) {
        switch (v.getId()) {
            case R.id.tv_copy:
                Toast.makeText(this, "tv_copy---" + mSelectionText, Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_select_all:
                Toast.makeText(this, "tv_select_all---" + mSelectionText, Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
