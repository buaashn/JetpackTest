package com.shn.jetpacktest.basic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment {
  private final Presenter mRootPresenter = new Presenter();

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View rootView = inflater.inflate(getLayoutId(), container, false);
    mRootPresenter.onCreate(rootView);
    return rootView;
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    mRootPresenter.onBind();
  }

  @Override
  public void onStop() {
    super.onStop();
    mRootPresenter.onUnBind();
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    mRootPresenter.onDestroy();
  }

  protected void addPresenter(Presenter presenter) {
    mRootPresenter.addPresenter(presenter);
  }

  @LayoutRes
  protected abstract int getLayoutId();
}
