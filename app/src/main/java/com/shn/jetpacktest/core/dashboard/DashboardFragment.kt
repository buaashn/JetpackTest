package com.shn.jetpacktest.core.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.shn.jetpacktest.R
import com.shn.jetpacktest.basic.network.RetrofitManager
import com.shn.jetpacktest.core.dashboard.api.TestV2exApi
import com.shn.jetpacktest.core.topic.api.TopicApi
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.Consumer
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

@AndroidEntryPoint
class DashboardFragment : Fragment() {

  @Inject
  lateinit var dashboardViewModel: DashboardViewModel

  private val mTestApi: TestV2exApi = RetrofitManager.create(TestV2exApi::class.java)
  private val mTopicApi: TopicApi = RetrofitManager.create(TopicApi::class.java)
  override fun onCreateView(
      inflater: LayoutInflater,
      container: ViewGroup?,
      savedInstanceState: Bundle?
  ): View? {
//    dashboardViewModel =
//        ViewModelProviders.of(this).get(DashboardViewModel::class.java)
    val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
    val textView: TextView = root.findViewById(R.id.text_dashboard)
    dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
      textView.text = it
      textView.setOnClickListener {
//        mTestApi.getMember("buaashn")
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(Schedulers.io())
//            .subscribe({ jsonObject ->
//              Log.d("NetworkTest", jsonObject.toString())
//            }, { t: Throwable? ->
//              Log.d("NetworkTest", "Error")
//            })
        mTopicApi.hotTopics
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ topics->
              Log.d("NetworkTest", topics.size.toString())
            }, { t: Throwable? ->
              Log.d("NetworkTest", "Error")
            })
      }
    })
    return root
  }
}