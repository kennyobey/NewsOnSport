package com.example.kennyobey.newsonsports

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        refresh_btn.visibility= View.VISIBLE
        show_movies.layoutManager = GridLayoutManager(this,2)
        val apiinterface = Client.getRetrofit().create(Apiinterface::class.java)
          val apiConnect = apiinterface.getLatestnews("0adf070657ca4ef4b089c47f2e218e31","us","sports")
        fetchNews(apiConnect)
        refresh_btn.setOnClickListener{
            refresh_btn.visibility = View.VISIBLE
            progress_bar.visibility = View.VISIBLE
            fetchNews(apiConnect)

        }
    }
    private  fun fetchNews(latestNews: Call<NewsFetch>){
        latestNews.clone().enqueue(object : Callback<NewsFetch> {
            override fun onResponse(call: Call<NewsFetch>, response: Response<NewsFetch>) {
                show_movies.adapter = NewsAdapter(this@MainActivity, response.body()!!)
                hideProgressBar()
            }

            override fun onFailure(call: Call<NewsFetch>, t: Throwable) {
                Toast.makeText(
                    this@MainActivity, "Unable to connect "
                            + t.message, Toast.LENGTH_SHORT
                ).show()
                hideProgressBar()
                refresh_btn.visibility = View.VISIBLE
            }


            private fun hideProgressBar() {
                progress_bar.visibility =View.INVISIBLE
            }
        })
    }
}
