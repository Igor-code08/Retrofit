package com.example.retrofit

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Установите Toolbar
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Найдите элементы интерфейса
        imageView = findViewById(R.id.imageView)
        val buttonLoad = findViewById<Button>(R.id.buttonLoad)

        // Обработчик кнопки "Загрузить"
        buttonLoad.setOnClickListener {
            loadRandomDogImage()
        }
    }

    // Функция загрузки картинки
    private fun loadRandomDogImage() {
        lifecycleScope.launch {
            try {
                // Выполните запрос к API
                val response = RetrofitClient.apiService.getRandomDog()

                // Загрузите изображение с помощью Glide
                Glide.with(this@MainActivity)
                    .load(response.url)
                    .into(imageView)

            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, "Ошибка загрузки", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Создание меню
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    // Обработчик выбора пункта меню
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_exit -> {
                finish() // Закрыть приложение
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
