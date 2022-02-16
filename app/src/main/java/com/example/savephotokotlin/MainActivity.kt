package com.example.savephotokotlin

import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        button.setOnClickListener {

            // Save the image to gallery and get saved image Uri
            val uri = saveImage(R.drawable.omnemix1, "Cat Android")
            infoTextView.text = uri.toString()

            // Show the saved image in an image view
            savedImageView.setImageURI(uri)
        }
    }

    // Method to save an image to gallery and return uri
    private fun saveImage(drawable: Int, title: String): Uri {
        // Get the image from drawable resource
        val drawable = ContextCompat.getDrawable(applicationContext, drawable)

        // Get the bitmap from drawable
        val bitmap = (drawable as BitmapDrawable).bitmap

        // Save image to gallery
        val savedImageURL = MediaStore.Images.Media.insertImage(
                contentResolver,
                bitmap,
                title,
                "Image of $title"
        )
        return Uri.parse(savedImageURL)
    }
}