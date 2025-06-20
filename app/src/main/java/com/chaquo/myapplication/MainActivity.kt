package com.chaquo.myapplication

//import android.content.Context
//import android.graphics.BitmapFactory
import android.os.Bundle
//import android.view.inputmethod.InputMethodManager
//import android.widget.Button
//import android.widget.EditText
//import android.widget.ImageView
//import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
//import com.chaquo.python.PyException
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (! Python.isStarted()) { // Start Python if not already
            Python.start(AndroidPlatform(this))
        }
        // ===== For debugging only =====
        val py = Python.getInstance()
        val module = py.getModule("test_hello")
        val result = module.callAttr("say_hello", "admin")
        Log.d("PythonTest", result.toString())
        // ===== For debugging only =====

        // ===== DEPRECATED, ORIGINALLY FROM EXAMPLE CODE =====
        //findViewById<Button>(R.id.button).setOnClickListener {
        //    try {
        //        val bytes = module.callAttr("plot",
        //                                    findViewById<EditText>(R.id.etX).text.toString(),
        //                                    findViewById<EditText>(R.id.etY).text.toString())
        //            .toJava(ByteArray::class.java)
        //        val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
        //        findViewById<ImageView>(R.id.imageView).setImageBitmap(bitmap)

        //        currentFocus?.let {
        //            (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
        //                .hideSoftInputFromWindow(it.windowToken, 0)
        //        }
        //    } catch (e: PyException) {
        //        Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        //    }
        //}
        // ===== DEPRECATED, ORIGINALLY FROM EXAMPLE CODE =====



    }
}