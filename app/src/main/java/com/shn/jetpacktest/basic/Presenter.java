package com.shn.jetpacktest.basic;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;

import io.reactivex.rxjava3.disposables.Disposable;

public class Presenter {
  private View mRootView;
  private Fragment mFragment;
  private final List<Presenter> mPresenters = new ArrayList<>();
  private final List<Disposable> mAutoDisposables = new ArrayList<>();

  public void onCreate(View rootView) {
    mRootView = rootView;
    for (Presenter presenter : mPresenters) {
      presenter.onCreate(mRootView);
    }
  }

  public void onBind() {
    for (Presenter presenter : mPresenters) {
      presenter.onBind();
    }
    doBindView(mRootView);
  }

  public void onUnBind() {
    for (Presenter presenter : mPresenters) {
      presenter.onUnBind();
    }
  }

  public void onDestroy() {
    for (Presenter presenter : mPresenters) {
      presenter.onDestroy();
    }
    for (Disposable disposable : mAutoDisposables) {
      disposable.dispose();
    }
  }

  protected void doBindView(View mRootView) {

  }

  public Fragment getFragment() {
    return mFragment;
  }

  public void setFragment(Fragment fragment) {
    mFragment = fragment;
    for (Presenter presenter : mPresenters) {
      presenter.setFragment(fragment);
    }
  }

  public final void addPresenter(Presenter presenter) {
    mPresenters.add(presenter);
  }

  protected final void addToAutoDispose(Disposable disposable) {
    mAutoDisposables.add(disposable);
  }

  protected final Context getContext() {
    return mRootView.getContext();
  }

}
