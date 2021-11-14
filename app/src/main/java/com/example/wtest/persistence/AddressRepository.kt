package com.example.wtest.persistence

import com.example.wtest.persistence.db.DbManager
import com.example.wtest.persistence.entities.Address
import com.example.wtest.utils.Decoder
import com.example.wtest.utils.PreferencesManager
import com.example.wtest.utils.RegexUtil
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

    fun getAddress(newText: String): List<Address> {
        val collator = Collator.getInstance()
        val resultList = mutableListOf<Address>()
        val digits = RegexUtil.getDigits(newText)
        val location = RegexUtil.getLocation(newText)

        collator.strength = Collator.NO_DECOMPOSITION

        addressList.value?.forEach { address ->
            if (digits.contains(address.fourDigits) && digits.contains(address.threeDigits)) {
                resultList.add(address)
            } else if (digits.size == 1 && (digits.contains(address.fourDigits) || digits.contains(address.threeDigits))) {
                resultList.add(address)
            }

            if (location?.isNotEmpty() == true) {
                if (collator.compare(location, address.location) == 0) {
                    resultList.add(address)
                }
            }
        }

        return resultList
    }
}