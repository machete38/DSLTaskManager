package com.example.dsltaskmanager

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dsltaskmanager.data.Task
import com.example.dsltaskmanager.data.TaskAdapter
import com.example.dsltaskmanager.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val taskAdapter = TaskAdapter<String>()
    private val tasks = mutableListOf(
        Task("string task","description", "category", "data")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupDrawer()
        setupRecyclerView()

    }

    private fun setupRecyclerView() = with(binding) {
       taskRecyclerView.apply {
           layoutManager = LinearLayoutManager(this@MainActivity)
           adapter = taskAdapter
       }
        taskAdapter.submitList(tasks)

    }

    private fun setupToolbar() = with(binding){
        ib.setOnClickListener{
            showAddTaskDialog()
        }
        setSupportActionBar(toolbar)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_launcher_foreground)
        }
    }

    private fun setupDrawer() = with(binding)
    {
        navView.setNavigationItemSelectedListener {
            item ->
            Toast.makeText(this@MainActivity, "Item ${item.title} selected", Toast.LENGTH_SHORT).show()
            drawerLayout.closeDrawers()
            true
        }
    }

    private fun showAddTaskDialog()
    {
        taskDialog {
            newTask -> tasks.add(newTask as Task<String>)
        }
    }
}