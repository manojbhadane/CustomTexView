package com.manojbhadane.customtextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by manoj.bhadane on 11/07/18.
 */

public class CustomTextView extends AppCompatTextView {

    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context, attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setFont(context, attrs);
    }

    private void setFont(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView);
        int customFont = a.getInt(R.styleable.CustomTextView_fontname, 0);
        String fontname = "";
        switch (customFont) {
            case 1:
                fontname = "Ubuntu-R.ttf";
                break;
            case 2:
                fontname = "Ubuntu-B.ttf";
                break;
            case 3:
                fontname = "Ubuntu-LI.ttf";
                break;
        }
        setFont(fontname);
    }

    public boolean setFont(String asset) {
        Typeface typeface = null;
        try {
            typeface = Typeface.createFromAsset(getContext().getResources().getAssets(), asset);
        } catch (Exception e) {
            return false;
        }
        setTypeface(typeface);
        return true;
    }
}