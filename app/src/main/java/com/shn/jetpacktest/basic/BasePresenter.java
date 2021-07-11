package com.shn.jetpacktest.basic;

import android.content.Context;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.disposables.Disposable;

public class BasePresenter {
  private View mRootView;
  private final List<BasePresenter> mPresenters = new ArrayList<>();
  private final List<Disposable> mAutoDisposables = new ArrayList<>();

  public void onCreate(View rootView) {
    mRootView = rootView;
    for (BasePresenter presenter : mPresenters) {
      presenter.onCreate(mRootView);
    }
  }

  public void onBind() {
    for (BasePresenter presenter : mPresenters) {
      presenter.onBind();
    }
    doBindView(mRootView);
  }

  public void onUnBind() {
    for (BasePresenter presenter : mPresenters) {
      presenter.onUnBind();
    }
  }

  public void onDestroy() {
    for (BasePresenter presenter : mPresenters) {
      presenter.onDestroy();
    }
    for (Disposable disposable : mAutoDisposables) {
      disposable.dispose();
    }
  }

  protected void doBindView(View mRootView) {

  }

  public final void addPresenter(BasePresenter presenter) {
    mPresenters.add(presenter);
  }

  protected final void addToAutoDispose(Disposable disposable) {
    mAutoDisposables.add(disposable);
  }

  protected final Context getContext() {
    return mRootView.getContext();
  }

}
