package com.ariawaludin.mobile_programming

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi elemen UI
        val editTextLink = findViewById<EditText>(R.id.editTextLink)
        val btnOpenWebsite = findViewById<Button>(R.id.btnOpenWebsite)

        val editTextLocation = findViewById<EditText>(R.id.editTextLocation)
        val btnOpenLocation = findViewById<Button>(R.id.btnOpenLocation)

        val editTextShare = findViewById<EditText>(R.id.editTextShare)
        val btnShareText = findViewById<Button>(R.id.btnShareText)

        val buttonAlert = findViewById<Button>(R.id.btnAlert)
        val builder = AlertDialog.Builder(this)
        val btnToast = findViewById<Button>(R.id.btnToast)

        // Aksi tombol buka website
        btnOpenWebsite.setOnClickListener {
            val url = editTextLink.text.toString()
            if (url.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            } else {
                Toast.makeText(this, "Masukkan link terlebih dahulu!", Toast.LENGTH_SHORT).show()
            }
        }

        // Aksi tombol buka lokasi
        btnOpenLocation.setOnClickListener {
            val location = editTextLocation.text.toString()
            if (location.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=$location"))
                startActivity(intent)
            } else {
                Toast.makeText(this, "Masukkan lokasi terlebih dahulu!", Toast.LENGTH_SHORT).show()
            }
        }

        // Aksi tombol share teks
        btnShareText.setOnClickListener {
            val textToShare = editTextShare.text.toString()
            if (textToShare.isNotEmpty()) {
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, textToShare)
                startActivity(Intent.createChooser(intent, "Bagikan dengan"))
            } else {
                Toast.makeText(this, "Masukkan teks untuk dibagikan!", Toast.LENGTH_SHORT).show()
            }
        }

        // Aksi tombol alert
        buttonAlert.setOnClickListener {
            builder.setTitle("Konfirmasi")
            builder.setMessage("Apakah kamu yakin ingin keluar?")
            builder.setPositiveButton("Ya") { _, _ ->
                finish() // Menutup aplikasi
            }
            builder.setNegativeButton("Tidak") { dialog, _ ->
                dialog.dismiss() // Menutup dialog
            }
            builder.show()
        }

        // Aksi tombol toast
        btnToast.setOnClickListener {
            Toast.makeText(this, "Ini adalah Toast!", Toast.LENGTH_SHORT).show()
        }
    }
}
