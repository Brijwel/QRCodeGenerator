package com.brijwel.qrcodegenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brijwel.qrcodegenerator.databinding.ActivityMainBinding
import com.google.zxing.WriterException

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btGenerate.setOnClickListener {
            val qrText = binding.editText.text.toString().trim()
            if (qrText.isNotEmpty()) {

                try {
                    val bitmap = QRUtils.generateQRCode(qrText)
                    binding.imageView.setImageBitmap(bitmap)
                } catch (e: WriterException) {

                }

            }
        }
    }
}