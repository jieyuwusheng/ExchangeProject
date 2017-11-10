package com.quanshu.exchange.ui.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;

import com.quanshu.exchange.R;
import com.quanshu.exchange.support.net.loading.ILoading;

public class LoadingDialog extends Dialog implements ILoading {

    public LoadingDialog(Context context) {
        super(context, R.style.Dialog_Anim_Style_Bottom_In);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog_loading_layout);
        Window window = getWindow();
        window.setLayout(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        window.setWindowAnimations(R.style.Dialog_Anim_Style_Bottom_In);
        setCancelable(false);
    }

    @Override
    public void show() {
        super.show();
    }
}
