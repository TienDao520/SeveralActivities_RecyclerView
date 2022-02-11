package tdao.example.severalactivities_recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**Task1-1: Launch name activity */
    fun onClickEnterName(view: View) {
        // launch the second activity
        val intent: Intent = Intent(this,NameActivity::class.java)
        startActivity(intent)
    }
}