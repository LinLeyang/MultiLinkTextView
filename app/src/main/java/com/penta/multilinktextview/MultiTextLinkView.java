package com.penta.multilinktextview;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;

import java.util.List;

/**
 * Created by Penta on 2018/9/27.
 */

public class MultiTextLinkView extends AppCompatTextView {

    public MultiTextLinkView(Context context) {
        super(context);
    }

    public MultiTextLinkView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MultiTextLinkView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setLinkPair(String text, List<MultiLinkBean> multiLinkBeans) {
        if (null == text) {
            return;
        }
        SpannableString spannableString = new SpannableString(text);

        for (MultiLinkBean multiLinkBean : multiLinkBeans) {

            int start = text.indexOf(multiLinkBean.getText());

            if (start >= 0) {
                int end = start + multiLinkBean.getText().length();
                if (null != multiLinkBean.getListener())
                    spannableString.setSpan(new Clickable(multiLinkBean.getListener()), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                if (null != multiLinkBean.getForegroundColorSpan())
                    spannableString.setSpan(multiLinkBean.getForegroundColorSpan(), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
        }
        this.setText(spannableString);
        this.setMovementMethod(LinkMovementMethod.getInstance());//链接点击必有代码
        this.setHighlightColor(getResources().getColor(android.R.color.transparent));//去除Clickable导致的点击时的文字背景高亮
    }

    public static class Clickable extends ClickableSpan implements View.OnClickListener {
        private final View.OnClickListener mListener;

        public Clickable(View.OnClickListener listener) {
            mListener = listener;
        }

        @Override
        public void onClick(View view) {
            mListener.onClick(view);
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setUnderlineText(false);//去掉下划线
        }
    }


}
