package tdao.example.severalactivities_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class NameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)
    }

    fun onButtonNameActivity(view: View) {}
}