package com.example.samplecomposeapp

import android.content.Context
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import android.net.ConnectivityManager
import android.net.ConnectivityManager.NetworkCallback
import android.net.Network
import android.net.NetworkCapabilities
import android.util.Log
import kotlinx.coroutines.channels.awaitClose
import kotlin.math.log

class AndroidConnectivityObserver(context: Context):ConnectivityObserver {

    private val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)!! as ConnectivityManager
    override val isConnected: Flow<Boolean>
        get() = callbackFlow {
            val callback = object :NetworkCallback(){
                override fun onAvailable(network: Network) {
                    super.onAvailable(network)
                    Log.d(AndroidConnectivityObserver::class.simpleName, ": onAvailable")
                    trySend(true)
                }

                override fun onLosing(network: Network, maxMsToLive: Int) {
                    super.onLosing(network, maxMsToLive)
                    Log.d(AndroidConnectivityObserver::class.simpleName, ": onLosing")
                }

                override fun onLost(network: Network) {
                    super.onLost(network)
                    Log.d(AndroidConnectivityObserver::class.simpleName, ": onLost")
                    trySend(false)
                }

                override fun onUnavailable() {
                    super.onUnavailable()
                    Log.d(AndroidConnectivityObserver::class.simpleName, ": onUnavailable")
                    trySend(false)
                }

                override fun onCapabilitiesChanged(
                    network: Network,
                    networkCapabilities: NetworkCapabilities
                ) {
                    super.onCapabilitiesChanged(network, networkCapabilities)
                    Log.d(AndroidConnectivityObserver::class.simpleName, ": onCapability Change")
                    val connected = networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
                    trySend(connected)
                }
            }
            connectivityManager.registerDefaultNetworkCallback(callback)
            awaitClose {
                connectivityManager.unregisterNetworkCallback(callback)
            }
        }
}