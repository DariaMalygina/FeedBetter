package com.example.daria.feedreader

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*;
import com.example.daria.feedreader.SubscriptionError.*

class SubscriptionPresenterTest {
    lateinit var presenter: SubscriptionPresenter
    lateinit var view: MockSubscriptionView
    lateinit var service: SubscriptionService

    @Before
    fun init() {
        view = MockSubscriptionView()
        service = SubscriptionService()
        presenter = SubscriptionPresenter(view, service)
    }

    @Test
    fun requestSubscription_subscribed() {
        presenter.requestSubscription("https://news.yandex.ru/society.rss")
        assertTrue(view.isSubscribed)
    }

    @Test
    fun requestSubscription_nonExistentFeed_errorRaised() {
        presenter.requestSubscription("https://yandex.ru/society.rss")
        assertEquals(NON_EXISTENT_FEED, view.error)
    }

    @Test
    fun requestSubscription_invalidUrl_errorRaised() {
        presenter.requestSubscription("hps://news.yandex.ru/society.rss")
        assertEquals(INVALID_URL, view.error)
    }

    @Test
    fun requestSubscription_networkFailure_errorRaised() {
        presenter.requestSubscription("https://news.yandex.ru/society.rss")
        assertEquals(NETWORK_FAILURE, view.error)
    }

    @Test
    fun requestSubscription_dbFailure_errorRaised() {
        presenter.requestSubscription("https://news.yandex.ru/society.rss")
        assertEquals(DB_FAILURE, view.error)
    }
}