package com.example.define.core.network.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.ConnectivityManager.NetworkCallback
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build
import android.util.Log
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow


class DeviceNetworkMonitor(private val context: Context) : NetworkMonitor {

    override fun checkNetwork(): Flow<NetworkStatus> = callbackFlow {

        val connectivityManager: ConnectivityManager? =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                context.getSystemService(ConnectivityManager::class.java)
            } else if (context.getSystemService(Context.CONNECTIVITY_SERVICE) is ConnectivityManager) {
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            } else {
                null
            }

        val callback = object : NetworkCallback() {
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                Log.i("DeviceNetworkMonitor", "Network available")
                channel.trySend(NetworkStatus.Online)
            }

            override fun onLost(network: Network) {
                super.onLost(network)
                Log.i("DeviceNetworkMonitor", "Network lost")
                channel.trySend(NetworkStatus.Offline)
            }

            override fun onUnavailable() {
                super.onUnavailable()
                Log.i("DeviceNetworkMonitor", "Network unavailable")
                channel.trySend(NetworkStatus.Offline)
            }
        }

        val networkRequest =
            NetworkRequest.Builder()
                .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                .build()

        connectivityManager?.registerNetworkCallback(networkRequest, callback)

        awaitClose {
            connectivityManager?.unregisterNetworkCallback(callback)
        }
    }
}