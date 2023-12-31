package com.xynderous.tweetsy.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xynderous.tweetsy.models.TweetListItem
import com.xynderous.tweetsy.repository.TweetRepository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(val repository: TweetRepository,
    private val savedStateHandle: SavedStateHandle
):ViewModel() {

    val tweets:StateFlow<List<TweetListItem>>
        get() = repository.tweetList

    init {
        viewModelScope.launch {
            //[Technology, Food, Travel, Sports, Movies, Books]
            val category = savedStateHandle.get<String>("category") ?: ""
            repository.getTweets(category)
        }
    }

}