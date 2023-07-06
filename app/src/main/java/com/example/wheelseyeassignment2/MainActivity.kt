package com.example.wheelseyeassignment2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var adapters:MyAdapter
    lateinit var newRecyclerView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getNews();

    }

    private fun getNews() {
        val news:Call<News>  =NewsApi.newsInstance.getHeadlines("in",500)
        Log.d("getnews", "getNews: is running")
         news.enqueue(object : Callback<News>{
             override fun onResponse(call: Call<News>, response: Response<News>) {

               val news:News? = response.body()

                 if(news!= null){
                     Log.d("response1",news.toString())
                    adapters=MyAdapter(this@MainActivity,news.article)
                     newRecyclerView = findViewById(R.id.newsList)
                     newRecyclerView.adapter = adapters;

                     newRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

                 }
             }

             override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("response2",t.message.toString())
             }
         })
    }

}