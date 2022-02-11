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
        /**Task4-2: Create people MultableList from dataClass person */
        var people:MutableList<Person> = mutableListOf<Person>()
        var order:Int = 1;
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
        /**Task4-3: Pass people MultableList to recyclerAdapter */
        recyclerAdapter = RecyclerAdapter(people)  // pass in data to be displayed
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
        /**Task3-2: getSharedPreferences when onResume()*/
        val prefsEditor = getSharedPreferences("SharedPref",Context.MODE_PRIVATE)
        var et:EditText = findViewById(R.id.editTextJsonName)
        //If no written SharedPreferences default value is empty
        et.setText(prefsEditor.getString("json_name", ""))

    }

    /**Task2-5: Add value and recyclerAdapter.notifyDataSetChanged() */
    fun onClickAddName(view: View) {
        names.add(textViewName.text.toString())
        /**Task4-5: Add value with MutableList<Person> dataSet  */
        people.add(Person(order++, textViewName.text.toString()))
        println(people)
        println(names)
        // tell the recyclerAdapter that you changed the dataset
        recyclerAdapter.notifyDataSetChanged()
    }

    /**Task3-1:
     * write data to shared pref onPause()
     * when application goes into background and delete the data if the system kills the app.*/
    override fun onPause() {
        // Save current state to the shared pref
        val prefsEditor = getSharedPreferences("SharedPref", Context.MODE_PRIVATE).edit()
        var et:EditText = findViewById(R.id.editTextJsonName)
        prefsEditor.putString("json_name", et.text.toString())
        prefsEditor.apply()
        super.onPause()
    }

    /**Task3-3: reset the shared prefs to default onDestroy()*/
    override fun onDestroy() {
        val prefsEditor = getSharedPreferences("SharedPref", Context.MODE_PRIVATE).edit()
        var et:EditText = findViewById(R.id.editTextJsonName)
        prefsEditor.putString("json_name", "")
        prefsEditor.apply()
        super.onDestroy()
        // reset the shared prefs to default
    }

    fun onClickSaveJson(view: View) {}


}