package com.example.daria.feedreader

import com.example.daria.feedreader.SubscriptionError.*
import java.net.MalformedURLException
import java.net.URL


class SubscriptionPresenter(val view: SubscriptionView, val service: SubscriptionService) {

    fun requestSubscription(url: String) {
        if (!isValidUrl(url)) {
            view.onError(INVALID_URL)
        }
        

        

    }

    private fun isValidUrl(url: String): Boolean {
        try {
            URL(url)
            return true
        } catch (e: MalformedURLException) {
            return false
        }
    }
}