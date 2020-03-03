package com.recyclertreeview.sample

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.recyclertreeview.sample.bean.File
import com.recyclertreeview.lib.TreeNode
import com.recyclertreeview.lib.TreeViewBinder


class FileNodeBinder : TreeViewBinder<FileNodeBinder.ViewHolder>() {
    override fun provideViewHolder(itemView: View): ViewHolder {
        return ViewHolder(itemView)
    }

    override fun bindView(holder: RecyclerView.ViewHolder, position: Int, node: TreeNode<*>?) {
        val fileNode = node?.content as File
        with (holder as ViewHolder) {
            tvName.text = fileNode.fileName
        }
    }

    override val layoutId: Int
        get() = R.layout.item_file

     class ViewHolder(rootView: View) : TreeViewBinder.ViewHolder(rootView) {
        var tvName: TextView = rootView.findViewById<View>(R.id.tv_name) as TextView

    }
}