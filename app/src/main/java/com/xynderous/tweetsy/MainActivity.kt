package com.xynderous.tweetsy

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.xynderous.tweetsy.api.TweetsyAPI
import com.xynderous.tweetsy.screens.CategoryScreen
import com.xynderous.tweetsy.screens.DetailScreen
import com.xynderous.tweetsy.ui.theme.TweetsyTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var tweetsyAPI: TweetsyAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            TweetsyTheme {
                DetailScreen()
            }

        }
    }
}