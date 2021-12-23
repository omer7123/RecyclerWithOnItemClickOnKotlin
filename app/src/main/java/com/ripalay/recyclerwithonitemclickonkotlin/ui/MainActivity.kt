package com.ripalay.recyclerwithonitemclickonkotlin.ui

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ripalay.recyclerwithonitemclickonkotlin.R
import com.ripalay.recyclerwithonitemclickonkotlin.databinding.ActivityMainBinding
import com.ripalay.recyclerwithonitemclickonkotlin.ui.adapter.MainAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val users = arrayListOf<Int>(
            R.drawable.ic_baran_1,
            R.drawable.ic_baran_1,
            R.drawable.ic_baran_1,
            R.drawable.ic_baran_1,
            R.drawable.ic_baran_1,
            R.drawable.ic_baran_1,
            R.drawable.ic_baran_1,
            R.drawable.ic_baran_1,
            R.drawable.ic_baran_1,
            R.drawable.ic_baran_1,
            R.drawable.ic_baran_1,
            R.drawable.ic_baran_1,
            R.drawable.ic_baran_1,
            R.drawable.ic_baran_1,
        )

        val adapter = MainAdapter(users)
        adapter.onItemClick = { image ->
            val drawable: Drawable? = getDrawable(image)
            drawable?.alpha = 60
            Log.e("ololo", drawable?.alpha.toString())

        }
        binding.recycler.adapter = adapter
    }

}