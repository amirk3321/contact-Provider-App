package com.provider.contactprovider.providerUtil

import android.content.Context
import android.provider.ContactsContract

object provider {
    fun getContact(context: Context) : MutableList<Any>{
        val mListContact = mutableListOf<Any>()
        val uri= ContactsContract.Contacts.CONTENT_URI
        val name= ContactsContract.Contacts.DISPLAY_NAME
        val cursor=context.contentResolver.query(uri,null,null,null,null)
        if (cursor!=null && cursor.moveToFirst()){
            do {
                val name=cursor.getString(cursor.getColumnIndex(name))
                mListContact.add(name)
            }while (cursor.moveToNext())
            cursor.close()
        }
        return mListContact
    }
}