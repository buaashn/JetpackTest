package com.shn.jetpacktest.core.login;

import com.shn.jetpacktest.R;
import com.shn.jetpacktest.basic.BaseFragment;
import com.shn.jetpacktest.core.login.presenter.LoginPresenter;

public class LoginFragment extends BaseFragment {

  public LoginFragment() {
    addPresenter(new LoginPresenter());
  }

  @Override
  protected int getLayoutId() {
    return R.layout.login_fragment;
  }
}
