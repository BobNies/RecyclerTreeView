package tellh.com.recyclertreeview.viewbinder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tellh.com.recyclertreeview.R
import tellh.com.recyclertreeview.bean.Dir
import tellh.com.recyclertreeview_lib.TreeNode
import tellh.com.recyclertreeview_lib.TreeViewBinder

class DirectoryNodeBinder : TreeViewBinder<DirectoryNodeBinder.ViewHolder>() {
    override fun provideViewHolder(itemView: View): ViewHolder {
        return ViewHolder(itemView)
    }

    override fun bindView(holder: RecyclerView.ViewHolder, position: Int, node: TreeNode<*>?) {
        with(holder as ViewHolder) {
            ivArrow.rotation = 0f
            ivArrow.setImageResource(R.drawable.ic_keyboard_arrow_right_black_18dp)
            val rotateDegree = if (node?.isExpand!!) 90 else 0
            ivArrow.rotation = rotateDegree.toFloat()
            val dirNode = node.content as Dir
            tvName.text = dirNode.dirName
            if (node.isLeaf) ivArrow.visibility = View.INVISIBLE else {
                ivArrow.visibility = View.VISIBLE
            }
        }

    }


    override val layoutId: Int
        get() = R.layout.item_dir

    class ViewHolder(rootView: View) : TreeViewBinder.ViewHolder(rootView) {
        val ivArrow: ImageView = rootView.findViewById<View>(R.id.iv_arrow) as ImageView
        val tvName: TextView = rootView.findViewById<View>(R.id.tv_name) as TextView

    }
}