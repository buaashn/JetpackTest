package com.shn.jetpacktest.widget;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.shn.jetpacktest.R;
import com.shn.jetpacktest.basic.BaseFragment;
import com.shn.jetpacktest.basic.Presenter;

public class BaseRefreshFragment extends BaseFragment {
  @Override
  protected int getLayoutId() {
    return R.layout.base_refresh_list_fragment;
  }
}
