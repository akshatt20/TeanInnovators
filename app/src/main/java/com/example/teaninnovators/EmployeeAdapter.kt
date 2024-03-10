package com.example.teaninnovators

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.TeanInnovators.R

class EmployeeAdapter(val context: Context, val userList: ArrayList<EmployeeData>):
    RecyclerView.Adapter<EmployeeAdapter.UserViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EmployeeAdapter.UserViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.user_post_layout, parent, false)
        return UserViewHolder(view)
    }

    class UserViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val textName = itemView.findViewById<TextView>(R.id.txt_name)
    }

    override fun onBindViewHolder(holder: EmployeeAdapter.UserViewHolder, position: Int) {
        val currentUser = userList[position]

        holder.textName.text = currentUser.name

        holder.itemView.setOnClickListener {
            val intent = Intent(context, Worker_Emp_Chat_Activity::class.java)

            intent.putExtra("name", currentUser.name)
            intent.putExtra("uid", currentUser.uid)


            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}