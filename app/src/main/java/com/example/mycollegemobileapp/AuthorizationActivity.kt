package com.example.mycollegemobileapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.gson.Gson
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class AuthorizationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_MyCollegeMobileApp)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)
        title = "Авторизация"
    }

    fun btnApplicantInfClick(view: View) {
        var intent : Intent = Intent(this@AuthorizationActivity, ApplicantInfActivity::class.java)
        startActivity(intent)
    }
    fun btnSignInClick(view: View) {
        var intent : Intent = Intent(this@AuthorizationActivity, MainMenuActivity::class.java);
        startActivity(intent);
       // getLoginAndPassword()
    }
    fun getLoginAndPassword() : Thread{
        return Thread{
            val url = URL("")
            val connection = url.openConnection() as HttpURLConnection

            if(connection.responseCode == 200){
                val inputSystem = connection.inputStream
                val inputStreamReader = InputStreamReader(inputSystem, "UTF-8")
                val request = Gson().fromJson(inputStreamReader, Request::class.java)
                updateUI(request)
                inputStreamReader.close()
                inputSystem.close()
            }
            else{
                Toast.makeText(this, "Failed Connection", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun updateUI(request: Any) {
        runOnUiThread {
            kotlin.run{
                //проверка логина пароля и парсинг
            }
        }

    }
}