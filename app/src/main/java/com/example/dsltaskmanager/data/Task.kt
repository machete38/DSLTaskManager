package com.example.dsltaskmanager.data

data class Task<T>(val title: String, val description: String, val category: String, val data: T)
