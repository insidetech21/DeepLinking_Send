package com.restart.send

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val REQUEST_CODE_RECEIVE_MESSAGE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        deep_a.setOnClickListener {
            startActivityForResult(
                Intent(Intent.ACTION_VIEW, Uri.parse("example://test/a")),
                REQUEST_CODE_RECEIVE_MESSAGE
            )
        }

        deep_b.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("example://test/b")))
        }

        deep_c.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("example://test/c")))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_RECEIVE_MESSAGE && resultCode == RESULT_OK) {
            val returnMessage = data?.getStringExtra("returnMessage")
            // Handle the return message as needed
            showToast("Received message from Receive app: $returnMessage")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
