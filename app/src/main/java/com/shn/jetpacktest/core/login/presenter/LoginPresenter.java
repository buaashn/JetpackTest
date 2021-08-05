package com.shn.jetpacktest.core.login.presenter;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.material.textfield.TextInputEditText;
import com.shn.jetpacktest.R;
import com.shn.jetpacktest.basic.Presenter;
import com.shn.jetpacktest.core.login.api.LoginApi;
import com.shn.jetpacktest.core.network.ErrorEnum;
import com.shn.jetpacktest.core.network.HtmlUtil;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class LoginPresenter extends Presenter {
  private static final String TAG = "LoginPresenter";

  private TextInputEditText mUserNameInputView;
  private TextInputEditText mPasswordInputView;
  private TextInputEditText mCheckCodeInputView;
  private ImageView mCheckCodeImageView;
  private View mLoginView;

  private String[] fieldNames;

  @Override
  public void onBind() {
    super.onBind();
    bindCheckCodeImage();
    mLoginView.setOnClickListener(v -> login());
  }

  @Override
  public void onUnBind() {
    super.onUnBind();
  }

  @Override
  protected void doBindView(View mRootView) {
    super.doBindView(mRootView);
    mUserNameInputView = mRootView.findViewById(R.id.user_name);
    mPasswordInputView = mRootView.findViewById(R.id.password);
    mCheckCodeInputView = mRootView.findViewById(R.id.check_code);
    mCheckCodeImageView = mRootView.findViewById(R.id.check_code_image);
    mLoginView = mRootView.findViewById(R.id.login);
  }

  private void bindCheckCodeImage() {
    addToAutoDispose(LoginApi.get()
      .getLoginPage()
      .flatMap((Function<String, ObservableSource<Bitmap>>) s -> {
        ErrorEnum.ERROR_AUTH_IP_BE_BANED.check(s);
        fieldNames = HtmlUtil.getLoginFieldName(s);
        return LoginApi.get().getCaptcha(fieldNames[3]);
      })
      .observeOn(AndroidSchedulers.mainThread())
      .subscribeOn(Schedulers.io())
      .subscribe(
        bitmap -> mCheckCodeImageView.setImageBitmap(bitmap),
        throwable -> {
          //todo:没拉到数据
          LogUtils.eTag(TAG, throwable);
        }));
  }

  private void login() {
    if (mUserNameInputView.getText() == null) {
      ToastUtils.showShort("请输入用户名");
      return;
    }
    if (mPasswordInputView.getText() == null) {
      ToastUtils.showShort("请输入密码");
      return;
    }
    if (mCheckCodeInputView.getText() == null) {
      ToastUtils.showShort("请输入验证码");
      return;
    }

    Map<String, String> form = new HashMap<>();

    form.put(fieldNames[0], mUserNameInputView.getText().toString());
    form.put(fieldNames[1], mPasswordInputView.getText().toString());
    form.put(fieldNames[2], mCheckCodeInputView.getText().toString());
    form.put("once", fieldNames[3]);
    form.put("next", "/settings");

    addToAutoDispose(
      LoginApi.get()
        .postLogin(form)
//        .flatMap((Function<String, ObservableSource<Account>>) s -> {
////                    ErrorEnum.ERROR_AUTH_LOGIN_PROBLEM.check(s);
//          ErrorEnum.ERROR_AUTH_IP_BE_BANED.check(s);
//          ErrorEnum.ERROR_AUTH_LOGIN_UNKNOWN_PROBLEM.check(s);
//          return getAccount(s);
//        })
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(
          new Consumer<String>() {
            @Override
            public void accept(String s) {
              LogUtils.dTag(TAG, s);
            }
          },
          new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) {
              LogUtils.eTag(TAG, throwable);
            }
          }
        )
    );
  }
}
