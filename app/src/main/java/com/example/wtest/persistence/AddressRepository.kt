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
        val resultList = mutableListOf<Address>()
        val digits = RegexUtil.getDigits(newText)
        val location = RegexUtil.getLocation(newText)
        val collator = Collator.getInstance()
        collator.strength = Collator.NO_DECOMPOSITION

        addressList.value?.forEach {
            if (containsDigits(it, digits) && (location.isNullOrBlank() || containsLocation(location, it.location, collator))) {
                resultList.add(it)
            } else if (digits.isNullOrEmpty() && containsLocation(location, it.location, collator)) {
                resultList.add(it)
            }
        }

        return resultList
    }

    private fun containsLocation(locationReg: String?, location: String?, collator: Collator): Boolean {
        return locationReg?.isNotEmpty() == true && collator.compare(locationReg, location) == 0
    }

    private fun containsDigits(address: Address, digits: List<String>): Boolean {
        return (digits.contains(address.fourDigits) && digits.contains(address.threeDigits)) ||
                digits.size == 1 && (digits.contains(address.fourDigits) || digits.contains(address.threeDigits))
    }
}