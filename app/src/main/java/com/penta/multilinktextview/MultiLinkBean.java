package com.penta.multilinktextview;

import android.text.style.ForegroundColorSpan;
import android.view.View;

/**
 * Created by Penta on 2018/9/27.
 *
 *
 *
 */

public class MultiLinkBean {

    private String text;
    private View.OnClickListener listener;
    private ForegroundColorSpan foregroundColorSpan;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public View.OnClickListener getListener() {
        return listener;
    }

    public void setListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    public ForegroundColorSpan getForegroundColorSpan() {
        return foregroundColorSpan;
    }

    public void setForegroundColorSpan(ForegroundColorSpan foregroundColorSpan) {
        this.foregroundColorSpan = foregroundColorSpan;
    }

    public MultiLinkBean(String text, View.OnClickListener listener) {
        this.text = text;
        this.listener = listener;
    }

    public MultiLinkBean(String text, View.OnClickListener listener, ForegroundColorSpan foregroundColorSpan) {
        this.text = text;
        this.listener = listener;
        this.foregroundColorSpan = foregroundColorSpan;
    }
}
