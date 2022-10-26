package com.ksharshembie.pagination

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ksharshembie.pagination.databinding.ActivityMainBinding
import com.ksharshembie.pagination.model.PixaModel
import com.ksharshembie.pagination.photo.PhotoAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var page = 1
    var adapter = PhotoAdapter(listOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initclicker()
    }


    private fun initclicker() {
        with(binding) {
            getPhoto.setOnClickListener {
                page = 1
                requestImage(page)
            }
            morePhoto.setOnClickListener {
                requestImage(++page)
            }
        }
    }

    private fun ActivityMainBinding.requestImage(page: Int) {
        App.api.getImages(keyWord = keyWord.text.toString(), page = page)
            .enqueue(object : Callback<PixaModel> {
                override fun onResponse(
                    call: Call<PixaModel>,
                    response: Response<PixaModel>
                ) {
                    response.body()?.hits?.let { listImageModel ->
                        adapter = PhotoAdapter(listImageModel)
                        binding.recyclerView.adapter = adapter
                    }
                }

                override fun onFailure(call: Call<PixaModel>, t: Throwable) {
                    Log.e("ololo", "onFailure: ${t.message}")
                }
            })
    }

}