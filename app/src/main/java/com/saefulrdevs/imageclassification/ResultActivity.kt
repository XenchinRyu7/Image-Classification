package com.saefulrdevs.imageclassification

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.saefulrdevs.imageclassification.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imageUri = Uri.parse(intent.getStringExtra(EXTRA_IMAGE_URI))
        imageUri?.let {
            Log.d("Image URI", "showImage: $it")
            binding.resultImage.setImageURI(it)
        }
    }

    companion object {
        const val EXTRA_IMAGE_URI = "extra_image_uri"
        const val EXTRA_RESULT = "extra_result"
    }
}