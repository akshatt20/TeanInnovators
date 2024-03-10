package com.example.teaninnovators

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.TeanInnovators.R
import com.google.firebase.database.DatabaseReference

class Worker_Emp_Chat_Activity : AppCompatActivity() {

    private lateinit var chatRecyclerView: RecyclerView
    private lateinit var messageBox: EditText
    private lateinit var sendButton: ImageView
    private lateinit var messageAdapter: EmployeeMessageAdapter
    private lateinit var messageList: ArrayList<EmployeeMessage>
    private lateinit var mDbRef : DatabaseReference

    var receiverRoom: String? = null
    var senderRoom: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_worker_emp_chat)
    }
}