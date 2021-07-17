package com.shn.jetpacktest.core.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.shn.jetpacktest.R
import com.shn.jetpacktest.basic.Presenter
import com.shn.jetpacktest.core.home.presenter.HomePresenter

class HomeFragment : Fragment() {

  private val mRootPresenter: Presenter = Presenter()

  override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?): View? {
    val root = inflater.inflate(R.layout.fragment_home, container, false)
    return root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    mRootPresenter.addPresenter(HomePresenter())
    mRootPresenter.fragment = this
    mRootPresenter.onCreate(view)
    mRootPresenter.onBind()
  }

  override fun onStop() {
    super.onStop()
    mRootPresenter.onUnBind()
  }

  override fun onDestroyView() {
    super.onDestroyView()
    mRootPresenter.onDestroy()
  }
}