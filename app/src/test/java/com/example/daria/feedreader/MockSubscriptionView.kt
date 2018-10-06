package com.example.daria.feedreader

import com.example.daria.feedreader.SubscriptionError.*

class MockSubscriptionView: SubscriptionView {
    var isSubscribed: Boolean = false
        private set

    var error: SubscriptionError = NO_ERROR
        private set

    override fun onError(error: SubscriptionError) {
        this.error = error
    }

    override fun onCompletion() {
        isSubscribed = true
    }
}