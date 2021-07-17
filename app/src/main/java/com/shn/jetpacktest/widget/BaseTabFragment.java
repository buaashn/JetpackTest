package com.shn.jetpacktest.widget;

import androidx.fragment.app.Fragment;

import com.shn.jetpacktest.widget.tab.TabView;

public class BaseTabFragment extends Fragment
    implements TabView.ITabProvider {

  @Override
  public TabView getTabView() {
    return new TabView(getContext());
  }
}
