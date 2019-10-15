package com.implude.dreamplude.activities

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.Context
import android.content.IntentFilter

class BluetoothRequest(private val context: Context) {
    private val bluetoothStateReceiver = BluetoothStateReceiver()

    fun registerReceiver() = IntentFilter().run {
        addAction(BluetoothAdapter.ACTION_STATE_CHANGED)
        addAction(BluetoothAdapter.ACTION_CONNECTION_STATE_CHANGED)
        addAction(BluetoothDevice.ACTION_ACL_CONNECTED)
        addAction(BluetoothDevice.ACTION_ACL_DISCONNECTED)
        addAction(BluetoothDevice.ACTION_BOND_STATE_CHANGED)
        addAction(BluetoothDevice.ACTION_FOUND)
        addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED)
        addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED)
        addAction(BluetoothDevice.ACTION_PAIRING_REQUEST)
        context.registerReceiver(bluetoothStateReceiver, this)
    }

    fun unregisterReceiver() = context.unregisterReceiver(bluetoothStateReceiver)
}