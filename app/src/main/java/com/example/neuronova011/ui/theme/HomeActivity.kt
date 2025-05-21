package com.example.neuronova011.ui.theme

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import android.widget.TextView
import android.widget.ImageView
import androidx.cardview.widget.CardView
import com.example.neuronova011.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // 1) Показываем случайный факт
        val facts = resources.getStringArray(R.array.memory_facts)
        findViewById<TextView>(R.id.tvFact).text = facts.random()

        // 2) Счетчики (пока статично)
        findViewById<TextView>(R.id.tvFactCount).text = "365"
        findViewById<TextView>(R.id.tvStarCount).text = "985"

        // 3) Запуск игры (Unity)
        findViewById<View>(R.id.cardGame1).setOnClickListener {
            startActivity(Intent(this, GameActivity::class.java))
        }

        // 4) Нижняя навигация
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNav.selectedItemId = R.id.nav_home
        bottomNav.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.nav_home -> true
                R.id.nav_leaderboard -> {
                    startActivity(Intent(this, RatingActivity::class.java)); finish(); true
                }
                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java)); finish(); true
                }
                else -> false
            }
        }
    }
}