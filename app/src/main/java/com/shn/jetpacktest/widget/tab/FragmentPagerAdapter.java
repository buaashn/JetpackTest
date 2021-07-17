package com.shn.jetpacktest.widget.tab;

import java.util.ArrayList;
import java.util.List;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class FragmentPagerAdapter extends FragmentStatePagerAdapter
//    implements PagerSlidingTabStrip.ITabProvider
{

  private final List<Fragment> mFragments = new ArrayList<>();
  private final List<String> mFragmentTitles = new ArrayList<>();

  public FragmentPagerAdapter(@NonNull FragmentManager fm, int behavior) {
    super(fm, behavior);
  }

//  public void addFragment(int index, Fragment fragment) {
//    mFragments.add(index, fragment);
//  }

  public void addFragment(Fragment fragment, String title) {
    mFragments.add(fragment);
    mFragmentTitles.add(title);
  }

  @Override
  public int getCount() {
    return mFragments.size();
  }


  @NonNull
  @Override
  public Fragment getItem(int position) {
    return mFragments.get(position);
  }

  @Override
  public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
    return ((Fragment) object).getView() == view;
  }

  @Nullable
  @Override
  public CharSequence getPageTitle(int position) {
    try {
      return mFragmentTitles.get(position);
    } catch (IndexOutOfBoundsException ignore) {
      return "";
    }
  }

  //  @Override
//  public TabView getTabView(int position) {
//    if (mFragments.get(position) instanceof TabView.ITabProvider) {
//      return ((TabView.ITabProvider) mFragments.get(position)).getTabView();
//    }
//    return null;
//  }
}
