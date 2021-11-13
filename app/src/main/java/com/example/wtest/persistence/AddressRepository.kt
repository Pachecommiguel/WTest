package com.example.wtest.persistence

import com.example.wtest.persistence.db.DbManager
import com.example.wtest.utils.Decoder
import com.example.wtest.utils.Preferences
import com.example.wtest.web.WebManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AddressRepository @Inject constructor(
    private val dbManager: DbManager,
    private val preferences: Preferences,
    webManager: WebManager
) : ContentReceiver {
    val addressList = dbManager.dao.getAll()

    init {
        webManager.setReceiver(this)

        if (preferences.isFirstTimeLaunch()) {
            webManager.getAddress()
        }
    }

    override fun onNewContent(content: String?) {
        preferences.setFirstTimeLaunch(false)
        GlobalScope.launch { dbManager.insertAll(Decoder.decode(content)) }
    }
}