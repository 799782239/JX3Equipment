package com.dang.yanqijs.base.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by yanqijs on 2017/2/22.
 */

public class BaseToast {
    private static BaseToast mBaseToast;
    private Context mContext;

    public BaseToast(Context mContext) {
        this.mContext = mContext;
    }

    public static BaseToast getInstance(Context context) {
        if (mBaseToast == null) {
            mBaseToast = new BaseToast(context);
        }
        return mBaseToast;
    }

    public void showToast(CharSequence text) {
        show(Toast.makeText(mContext, text, Toast.LENGTH_SHORT));
    }

    private void show(Toast toast) {
        toast.show();
    }
}
