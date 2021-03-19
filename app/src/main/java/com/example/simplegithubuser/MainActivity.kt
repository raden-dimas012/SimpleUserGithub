package com.example.simplegithubuser

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(),View.OnClickListener {
    private val list = ArrayList<Data>()

    companion object {
        const val INTENT_PARCELABLLE = "OBJECT INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val moveProfile : ImageView = findViewById(R.id.img_profile)
        moveProfile.setOnClickListener(this)


        list.addAll(getListUsers())
        val recyclerView = findViewById<RecyclerView>(R.id.rv_data)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = DataAdapter(this,list) {
            val intent = Intent(this,DetailActivity::class.java)
            intent.putExtra(INTENT_PARCELABLLE,it)
            startActivity(intent)
        }

    }

    @SuppressLint("Recycle")
    private fun getListUsers(): ArrayList<Data> {
        val dataPhoto = resources.obtainTypedArray(R.array.avatar)
        val dataName = resources.getStringArray(R.array.name)
        val dataUserName = resources.getStringArray(R.array.username)
        val dataLocation = resources.getStringArray(R.array.location)
        val dataRepository = resources.getStringArray(R.array.repository)
        val dataCompany = resources.getStringArray(R.array.company)
        val dataFollowers = resources.getStringArray(R.array.followers)
        val dataFollowing = resources.getStringArray(R.array.following)

        val listUser = ArrayList<Data>()
        for (position in dataName.indices) {
            val dataUser = Data(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataUserName[position],
                dataLocation[position],
                dataRepository[position],
                dataCompany[position],
                dataFollowers[position],
                dataFollowing[position]
            )
            listUser.add(dataUser)
        }
        return listUser
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.img_profile -> {
                val moveIntent = Intent(this@MainActivity,ProfileActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }

}