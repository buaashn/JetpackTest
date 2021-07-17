package com.shn.jetpacktest.widget;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.shn.jetpacktest.R;
import com.shn.jetpacktest.basic.Presenter;

public class BaseRefreshFragment extends Fragment {
  protected final Presenter mRootPresenter = new Presenter();

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.base_refresh_list_fragment, container, false);
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
}
