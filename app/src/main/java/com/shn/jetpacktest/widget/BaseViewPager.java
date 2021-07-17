package com.shn.jetpacktest.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

public class BaseViewPager extends ViewPager {
  public BaseViewPager(@NonNull Context context) {
    super(context);
  }

  public BaseViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
  }
}
