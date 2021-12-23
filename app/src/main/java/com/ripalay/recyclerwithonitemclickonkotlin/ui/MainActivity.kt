package com.ripalay.recyclerwithonitemclickonkotlin.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ripalay.recyclerwithonitemclickonkotlin.R
import com.ripalay.recyclerwithonitemclickonkotlin.databinding.ActivityMainBinding
import com.ripalay.recyclerwithonitemclickonkotlin.ui.adapter.MainAdapter

class MainActivity : AppCompatActivity() {
    private var sendList = ArrayList<Int>()
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("UseCompatLoadingForDrawables", "Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sendList.clear()
        val users = arrayListOf<Int>(
            R.drawable.ic_baran_1,
            R.drawable.ic_bart,
            R.drawable.ic_baran,
            R.drawable.ic_post,
            R.drawable.ic_free,
            R.drawable.ic_counter,

            )

        val adapter = MainAdapter(users)
        adapter.onItemClick = { image ->
            val drawable: Drawable? = getDrawable(image)
            if (drawable?.alpha != 170) {
                drawable?.alpha = 170
                sendList.add(image)

            } else {
                drawable.alpha = 255
                sendList.remove(image)
            }

            adapter.notifyDataSetChanged()
            Log.e("ololo", drawable?.alpha.toString())
        }
        binding.recycler.adapter = adapter
        binding.selectBtn.setOnClickListener {
            val intent = Intent(this, SelectActivity::class.java)
            intent.putExtra("list", sendList)
            startActivity(intent)

        }
    }

}