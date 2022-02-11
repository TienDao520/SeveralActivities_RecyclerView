package tdao.example.severalactivities_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class NameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)
    }


    /**Task1-3: Save name to companion object from NameActivity*/
    fun onButtonNameActivity(view: View) {
        // save the name in the editText to the companion object
        // Thats how we will get the data there
        MainActivity.userName = findViewById<EditText>(R.id.editTextNameActivity).text.toString()
        finish()
    }
}