package tdao.example.severalactivities_recyclerview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // companion object
    companion object MainActivityData {
        /**Task1-2: Create userName inside companion object */
        var userName:String = ""
    }

    lateinit var textViewName: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewName = findViewById(R.id.textViewRecyclerItemName)
    }

    /**Task1-1: Launch name activity */
    fun onClickEnterName(view: View) {
        // launch the second activity
        val intent: Intent = Intent(this,NameActivity::class.java)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        /**Task1-4: Launch userName to textViewName */
        textViewName.text = userName
    }

    fun onClickSaveJson(view: View) {}
    fun onClickAddName(view: View) {}

}