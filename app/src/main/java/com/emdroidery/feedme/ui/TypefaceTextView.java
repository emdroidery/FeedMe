package com.emdroidery.feedme.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.support.v7.widget.AppCompatTextView;

import com.emdroidery.feedme.R;
import com.emdroidery.feedme.utils.TypefaceLoader;

/**
 * This is an extension of a text view that
 * allows us to load the typeface from the xml
 * configuration
 *
 * @author farhan
 * @version 1.0
 * @since 31/5/17
 */
public class TypefaceTextView extends AppCompatTextView {

    public TypefaceTextView(Context context) {
        this(context, null);
    }

    public TypefaceTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TypefaceTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (isInEditMode())
            return;
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.Typeface);
        if (ta != null) {
            String fontAsset = ta.getString(R.styleable.Typeface_typeface);
            if (!TextUtils.isEmpty(fontAsset)) {
                Typeface tf = TypefaceLoader.getInstance(context).getFont(fontAsset);
                int style = Typeface.NORMAL;
                if (getTypeface() != null)
                    style = getTypeface().getStyle();
                if (tf != null)
                    setTypeface(tf, style);
            }
        }
    }
}