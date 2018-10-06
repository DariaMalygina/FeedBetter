package com.example.daria.feedreader

interface SubscriptionView {

    fun onError(error: SubscriptionError)

    fun onCompletion()
}