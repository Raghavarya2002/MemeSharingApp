package com.example.memesharingapp

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        loadmeme()
    }

    private fun loadmeme(){
        val imageView: ImageView = findViewById(R.id.memeImageView)
        val textView = findViewById<TextView>(R.id.text)

// ...

// Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://meme-api.herokuapp.com/gimme"

// Request a string response from the provided URL.
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->

                val url = response.getString("url")
                Glide.with(this).load(url).into(imageView)


            },
            Response.ErrorListener {

            })

// Add the request to the RequestQueue.
        queue.add(jsonObjectRequest)
    }

    fun showNextMeme(view: View) {
        loadmeme()
    }

    fun shareMeme(view: View) {

    }

}