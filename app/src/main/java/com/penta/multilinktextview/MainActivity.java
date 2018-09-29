package com.penta.multilinktextview;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private MultiTextLinkView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.main_textview);
        List list = new ArrayList<MultiLinkBean>();
        list.add(new MultiLinkBean("[呼赛测试球队3]", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击1", Toast.LENGTH_SHORT).show();
            }
        }, new ForegroundColorSpan(Color.BLUE)));

        list.add(new MultiLinkBean("[球员2]", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击2", Toast.LENGTH_SHORT).show();
            }
        }, new ForegroundColorSpan(Color.RED)));
        textView.setLinkPair("球队[呼赛测试球队3]邀请[球员2]加入球队", list);

    }

}
