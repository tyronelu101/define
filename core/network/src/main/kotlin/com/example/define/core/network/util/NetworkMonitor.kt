package com.example.define.core.network.util

import kotlinx.coroutines.flow.Flow


enum class NetworkStatus {
    Online, Offline
}

interface NetworkMonitor {
    fun checkNetwork(): Flow<NetworkStatus>
}