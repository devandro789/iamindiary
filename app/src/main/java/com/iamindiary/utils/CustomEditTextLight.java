package com.iamindiary.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

import com.iamindiary.R;

/**
 * Created by varun on 27/2/17.
 */

public class CustomEditTextLight extends EditText {
    public CustomEditTextLight(Context context) {
        super(context);
        applyCustomFont(context);
    }

    public CustomEditTextLight(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);
    }

    public CustomEditTextLight(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context);
    }

    public CustomEditTextLight(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = FontCache.getTypeface("Montserrat-Light.otf", context);
        setTypeface(customFont);
        setTextColor(getResources().getColor(R.color.edittext_text_color));
    }
}
