package tdao.example.severalactivities_recyclerview

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    // companion object
    companion object MainActivityData {
        /**Task1-2: Create userName inside companion object */
        var userName:String = ""
        /**Task2-4: Create MutableList of Name */
        var names:MutableList<String> = mutableListOf<String>()
    }

    lateinit var textViewName: TextView
    /**Task2-2: Add RecyclerAdapter */
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecyclerAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewName = findViewById(R.id.textViewRecyclerItemName)

        /**Task2-3: Setting the recyclerView up */
        // setting the recyclerView up
        // setting up the recyclerView
        viewManager = LinearLayoutManager(this)
        recyclerAdapter = RecyclerAdapter(names)  // pass in data to be displayed
        //       recyclerAdapter = RecyclerAdapter(names)  // pass in data to be displayed
        recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply{
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = recyclerAdapter  }
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