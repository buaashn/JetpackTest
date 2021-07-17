package com.shn.jetpacktest.widget.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TabView extends FrameLayout {

  public TabView(@NonNull Context context) {
    super(context);
  }

  public TabView(@NonNull Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }

  public TabView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  public TabView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
  }

  public static interface ITabProvider {
    TabView getTabView();
  }
}
