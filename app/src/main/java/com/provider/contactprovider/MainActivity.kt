package com.provider.contactprovider

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.provider.contactprovider.providerUtil.provider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mListContact :MutableList<Any>
    lateinit var mAdapter : ArrayAdapter<Any>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mListContact= mutableListOf()
        show.setOnClickListener {
           mListContact= provider.getContact(this)
            mAdapter=ArrayAdapter(this,android.R.layout.simple_expandable_list_item_1,mListContact)
            listcontact.adapter=mAdapter
            mAdapter.notifyDataSetChanged()
        }
        listcontact.setOnItemClickListener(object :AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(applicationContext," "+p3,Toast.LENGTH_SHORT).show()
            }
        })



    }
}
