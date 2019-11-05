package com.example.demo.app.activity;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.ImageView;

import com.example.demo.app.R;
import com.xing.widget.OverrideEditText;
import com.zftlive.android.library.base.ui.BaseActivity;

public class LoginActivity extends BaseActivity {
    private OverrideEditText mPassWordEd;
    private OverrideEditText mAccountEd;
    private ImageView mPasswordImage;
    private boolean isHidden = true;

    @Override
    public int bindLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initParams(Bundle params) {
        getWindowTitle().setVisibility(View.GONE);
        setStatusBarBackground(getResources().getColor(R.color.anl_grally_817070));
    }

    @Override
    public void initView(View view) {
        mAccountEd = view.findViewById(R.id.ed_account);
        mPassWordEd = view.findViewById(R.id.ed_password);
        mPasswordImage = view.findViewById(R.id.pass_image);
    }

    @Override
    public void initListener() {
        mAccountEd.setDrawableClick(new OverrideEditText.IMyRightDrawableClick() {
            @Override
            public void rightDrawableClick() {
                mAccountEd.setText("");
            }
        });
        mPassWordEd.setDrawableClick(new OverrideEditText.IMyRightDrawableClick() {
            @Override
            public void rightDrawableClick() {
                mPassWordEd.setText("");
            }
        });
        mPasswordImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isHidden) {
                    mPassWordEd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    Drawable drawable = getResources().getDrawable(R.mipmap.wallet_home_ch_eye_open);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    mPasswordImage.setBackground(drawable);
                } else {
                    mPassWordEd.setTransformationMethod(PasswordTransformationMethod.getInstance());

                    Drawable drawable = getResources().getDrawable(R.mipmap.wallet_home_ch_eye_close);
                    drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                    mPasswordImage.setBackground(drawable);
                }
                //切换后将EditText光标置于末尾
                CharSequence charSequence = mPassWordEd.getText();
                if (charSequence instanceof Spannable) {
                    Spannable spanText = (Spannable) charSequence;
                    Selection.setSelection(spanText, charSequence.length());
                }
                isHidden = !isHidden;
            }
        });
    }

    @Override
    public void doBusiness(Context mContext) {

    }
}
