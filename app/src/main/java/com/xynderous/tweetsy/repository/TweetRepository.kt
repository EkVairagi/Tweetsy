package com.xynderous.tweetsy.repository

import com.xynderous.tweetsy.api.TweetsyAPI
import com.xynderous.tweetsy.models.TweetListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(private val tweetsyAPI: TweetsyAPI) {

    private val _categories = MutableStateFlow<List<String>>(emptyList())

    val categories: StateFlow<List<String>>
        get() = _categories


    private val _tweetList = MutableStateFlow<List<TweetListItem>>(emptyList())
    val tweetList:StateFlow<List<TweetListItem>>
        get() = _tweetList

    suspend fun getCategories() {
        val response = tweetsyAPI.getCategories()
        if (response.isSuccessful && response.body() != null) {
            _categories.emit(response.body() ?: emptyList())
        }
    }

    suspend fun getTweets(category: String) {
        val response = tweetsyAPI.getTweets("tweets[?(@.category==\"$category\")]")
        if (response.isSuccessful && response.body() != null) {
            _tweetList.emit(response.body() ?: emptyList())
        }
    }

}