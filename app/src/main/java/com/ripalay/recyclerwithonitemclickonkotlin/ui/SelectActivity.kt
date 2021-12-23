package com.ripalay.recyclerwithonitemclickonkotlin.ui

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ripalay.recyclerwithonitemclickonkotlin.R
import com.ripalay.recyclerwithonitemclickonkotlin.databinding.ActivityMainBinding
import com.ripalay.recyclerwithonitemclickonkotlin.databinding.ActivitySelectBinding
import com.ripalay.recyclerwithonitemclickonkotlin.ui.adapter.MainAdapter

class SelectActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySelectBinding
    private var list = ArrayList<Int>()
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list.clear()

        list = intent.getIntegerArrayListExtra("list") as ArrayList<Int>

        val adapter = MainAdapter(list)
        list.forEach {
            val drawable: Drawable? = getDrawable(it)
            drawable?.alpha = 255
        }
        binding.recycler.adapter = adapter



    }
}