package com.example.wtest.persistence

import com.example.wtest.persistence.db.DbManager
import com.example.wtest.persistence.entities.Address
import com.example.wtest.utils.Decoder
import com.example.wtest.utils.PreferencesManager
import com.example.wtest.web.WebManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.Collator
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AddressRepository @Inject constructor(
    private val dbManager: DbManager,
    private val preferencesManager: PreferencesManager,
    webManager: WebManager
) : ContentReceiver {

    val addressList = dbManager.dao.getAll()

    init {
        webManager.setReceiver(this)

        if (preferencesManager.isFirstTimeLaunch()) {
            webManager.getAddress()
        }
    }

    override fun onNewContent(content: String?) {
        preferencesManager.setFirstRun(false)
        GlobalScope.launch { dbManager.insertAll(Decoder.decodeFromBase64(content)) }
    }

    // TODO: 11/14/2021 change this
    fun getAddress(newText: String): List<Address> {
        val collator = Collator.getInstance()
        val text = newText.uppercase().trim()
        val digits = text.replace("-", " ").split("\\s".toRegex())
        val locationRegex = "[a-zA-Z[:blank:]]+".toRegex()
        val location = locationRegex.find(text)?.value ?: ""
        val resultList = mutableListOf<Address>()

        collator.strength = Collator.NO_DECOMPOSITION

        addressList.value?.forEach { address ->
            digits.forEach {
                if (address.threeDigits == it || address.fourDigits == it || collator.compare(address.location, location) == 0) {
                    resultList.add(address)
                }
            }
        }

        return resultList
    }
}