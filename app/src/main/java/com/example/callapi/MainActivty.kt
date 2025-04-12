package com.example.callapi

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            fetchApiData()
        }
    }
//разобраться,доделать(кусок гпт)
    private fun fetchApiData() {
        RetrofitClient.apiService.getApiInfo().enqueue(object : Callback<stringsApi> {
            override fun onResponse(call: Call<stringsApi>, response: Response<stringsApi>) {
                if (response.isSuccessful) {
                    response.body()?.let { apiResponse ->
                        // Обработка успешного ответа
                        val message = "Item ID: ${apiResponse.item_id}, Item Name: ${apiResponse.item_name}"
                        Toast.makeText(this@MainActivity, message, Toast.LENGTH_LONG).show()
                    }
                }
            }

            override fun onFailure(call: Call<stringsApi>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Failure: ${t.message}", Toast.LENGTH_LONG).show()
            }
        })
    }
}