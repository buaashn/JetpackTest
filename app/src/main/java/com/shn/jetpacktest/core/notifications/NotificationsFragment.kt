package com.shn.jetpacktest.core.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.shn.jetpacktest.R
import com.shn.jetpacktest.core.home.HomeFragment

class NotificationsFragment : Fragment() {

  private lateinit var notificationsViewModel: NotificationsViewModel

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    notificationsViewModel =
      ViewModelProviders.of(this).get(NotificationsViewModel::class.java)
    val root = inflater.inflate(R.layout.fragment_notifications, container, false)
//        val textView: TextView = root.findViewById(R.id.text_notifications)
//        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
    return root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val tabLayout: TabLayout = view.findViewById(R.id.tab_container)
    val viewPager: ViewPager = view.findViewById(R.id.viewpager)
    val fragments = arrayListOf<Fragment>(HomeFragment(), HomeFragment(), HomeFragment())
    val tabTitles = arrayListOf("第一个", "第二个", "第三个")
    val fragmentPagerAdapter = MyFragmentStatePagerAdapter(childFragmentManager)
    fragmentPagerAdapter.datas = fragments
    fragmentPagerAdapter.titles = tabTitles
    viewPager.adapter = fragmentPagerAdapter
    tabLayout.setupWithViewPager(viewPager)
  }

  inner class MyFragmentStatePagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    lateinit var datas: List<Fragment>
    lateinit var titles: List<String>

    override fun getItem(position: Int): Fragment {
      return datas[position]
    }

    override fun getCount(): Int {
      return datas.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
      return titles[position]
    }
  }
}