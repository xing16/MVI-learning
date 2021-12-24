package com.xing.mvilearning

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.xing.mvilearning.ui.home.HomeIntent
import com.xing.mvilearning.ui.home.HomeState
import com.xing.mvilearning.ui.home.HomeViewModel
import kotlinx.coroutines.flow.collect
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private val viewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.tv_text)
        lifecycleScope.launchWhenCreated {
            viewModel.apply {
                intents.send(HomeIntent.Fetch(0))
                state.collect {
                    when (it) {
                        is HomeState.Loading -> {
                        }
                        is HomeState.HomeResult -> {
                            textView.text = it.article.data.toString()
                        }
                        is HomeState.Error -> {
                        }
                    }
                }
            }
        }
    }
}