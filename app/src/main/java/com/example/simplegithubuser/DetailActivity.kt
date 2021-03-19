package com.example.simplegithubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val dataDetail = intent.getParcelableExtra<Data>(MainActivity.INTENT_PARCELABLLE)

        val imgDetail = findViewById<ImageView>(R.id.img_circle_detail)

        val detailName = findViewById<TextView>(R.id.tv_name_detail)
        val detailUsername = findViewById<TextView>(R.id.tv_username_detail)
        val detailLocation = findViewById<TextView>(R.id.tv_location_detail)
        val detailRepository = findViewById<TextView>(R.id.tv_repository_detail)
        val detailCompany = findViewById<TextView>(R.id.tv_company_detail)
        val followers = findViewById<TextView>(R.id.tv_followers_detail)
        val following = findViewById<TextView>(R.id.tv_following_detail)


        imgDetail.setImageResource(dataDetail?.avatar!!)
        detailName.text = dataDetail.nama
        detailUsername.text = dataDetail.userName
        detailLocation.text = dataDetail.location
        detailRepository.text = dataDetail.repository
        detailCompany.text = dataDetail.company
        followers.text = dataDetail.followers
        following.text = dataDetail.following

    }
}