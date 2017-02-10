package com.jx3.yanqijs.jx3equipment.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import com.jx3.yanqijs.jx3equipment.R;

/**
 * Created by yanqijs on 2017/2/7.
 */

public class EquipmentView extends TextView {
    private Context mContext;
    public String hideName;

    public EquipmentView(Context context) {
        this(context, null);
    }

    public EquipmentView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public EquipmentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        TypedArray typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.eq);
        hideName = typedArray.getString(R.styleable.eq_hide_name);
        typedArray.recycle();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
}
