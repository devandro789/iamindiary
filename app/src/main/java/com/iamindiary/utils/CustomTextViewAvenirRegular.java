package com.iamindiary.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by varun on 27/2/17.
 */
public class CustomTextViewAvenirRegular extends TextView
{

    public CustomTextViewAvenirRegular(Context context) {

        super(context);
        applyCustomFont(context);
    }

    public CustomTextViewAvenirRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);
    }

    public CustomTextViewAvenirRegular(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context);
    }

    public CustomTextViewAvenirRegular(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        applyCustomFont(context);
    }
    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("AvenirNextLTPro-Regular.ttf", context);
        setTypeface(customFont, Typeface.BOLD);
    }
}
