package com.shn.jetpacktest.core.home.presenter;

import android.view.View;

import com.shn.jetpacktest.R;
import com.shn.jetpacktest.basic.Presenter;
import com.shn.jetpacktest.core.topic.TopicFragment;
import com.shn.jetpacktest.widget.BaseViewPager;
import com.shn.jetpacktest.widget.tab.FragmentPagerAdapter;
import com.shn.jetpacktest.widget.tab.PagerSlidingTabStrip;

public class HomePresenter extends Presenter {
  private PagerSlidingTabStrip mTabsView;
  private View mTabsAddView;
  private BaseViewPager mViewPager;
  private FragmentPagerAdapter mPagerAdapter;


  @Override
  public void onBind() {
    super.onBind();
    bindViewPager();
  }

  @Override
  public void onUnBind() {
    super.onUnBind();
  }

  @Override
  protected void doBindView(View mRootView) {
    super.doBindView(mRootView);
    mTabsView = mRootView.findViewById(R.id.tabs);
    mTabsAddView = mRootView.findViewById(R.id.tabs_add);
    mViewPager = mRootView.findViewById(R.id.view_pager);
  }

  private void bindViewPager() {
    mPagerAdapter = new FragmentPagerAdapter(getFragment().getChildFragmentManager(), 0);
    mPagerAdapter.addFragment(new TopicFragment(), "热门");
    mPagerAdapter.addFragment(new TopicFragment(), "交易");
    mPagerAdapter.addFragment(new TopicFragment(), "全部");
    mPagerAdapter.addFragment(new TopicFragment(), "城市");
    mPagerAdapter.addFragment(new TopicFragment(), "问与答");
    mPagerAdapter.addFragment(new TopicFragment(), "技术");
    mPagerAdapter.addFragment(new TopicFragment(), "节点");
    mPagerAdapter.addFragment(new TopicFragment(), "关注");
    mPagerAdapter.addFragment(new TopicFragment(), "酷工作");

    mViewPager.setAdapter(mPagerAdapter);
    mTabsView.setViewPager(mViewPager);
  }
}
