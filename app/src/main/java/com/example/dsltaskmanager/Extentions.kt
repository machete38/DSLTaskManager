package com.example.dsltaskmanager

import android.app.AlertDialog
import android.content.Context
import android.widget.EditText
import com.example.dsltaskmanager.data.Task

fun Context.taskDialog(onTaskCreated: (Task<*>) -> Unit) {
    AlertDialog.Builder(this).apply {
        setTitle("New Task")
        val input = EditText(this@taskDialog)
        setView(input)
        setPositiveButton("Add") { _, _ ->
            val taskTitle: String = input.text.toString()
            onTaskCreated(Task(taskTitle, "", "Work", "null"))
        }
        setNegativeButton("Cancel") { dialog, _ -> dialog.cancel() }
    }.create().show()
}