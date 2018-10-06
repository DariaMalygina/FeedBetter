package com.example.daria.feedreader

enum class SubscriptionError {
    NO_ERROR,
    NON_EXISTENT_FEED,
    INVALID_URL,
    NETWORK_FAILURE,
    DB_FAILURE
}