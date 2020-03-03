package com.recyclertreeview.sample

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.recyclertreeview.sample.bean.Dir
import com.recyclertreeview.sample.bean.File
import com.recyclertreeview.lib.TreeNode
import com.recyclertreeview.lib.TreeViewAdapter
import com.recyclertreeview.lib.TreeViewAdapter.OnTreeNodeListener
import java.util.*

class MainActivity : AppCompatActivity() {
    private var rv: RecyclerView? = null
    private var adapter: TreeViewAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initData()
    }

    private fun initData() {
        val nodes: MutableList<TreeNode<*>> = ArrayList()
        val app = TreeNode(Dir("app"))
        nodes.add(app)
        app.addChild(
                TreeNode(Dir("manifests"))
                        .addChild(TreeNode(File("AndroidManifest.xml")))
        )
        app.addChild(
                TreeNode(Dir("java")).addChild(
                        TreeNode(Dir("tellh")).addChild(
                                TreeNode(Dir("com")).addChild(
                                        TreeNode(Dir("recyclertreeview"))
                                                .addChild(TreeNode(File("Dir")))
                                                .addChild(TreeNode(File("DirectoryNodeBinder")))
                                                .addChild(TreeNode(File("File")))
                                                .addChild(TreeNode(File("FileNodeBinder")))
                                                .addChild(TreeNode(File("TreeViewBinder")))
                                )
                        )
                )
        )
        val res = TreeNode(Dir("res"))
        nodes.add(res)
        res.addChild(
                TreeNode(Dir("layout")).lock() // lock this TreeNode
                        .addChild(TreeNode(File("activity_main.xml")))
                        .addChild(TreeNode(File("item_dir.xml")))
                        .addChild(TreeNode(File("item_file.xml")))
        )
        res.addChild(
                TreeNode(Dir("mipmap"))
                        .addChild(TreeNode(File("ic_launcher.png")))
        )
        rv?.layoutManager = LinearLayoutManager(this)
        adapter = TreeViewAdapter(nodes, listOf(FileNodeBinder(), DirectoryNodeBinder()))
        // whether collapse child nodes when their parent node was close.
//        adapter.ifCollapseChildWhileCollapseParent(true);
        adapter?.setOnTreeNodeListener(object : OnTreeNodeListener {
            override fun onClick(node: TreeNode<*>?, holder: RecyclerView.ViewHolder?): Boolean {
                node?.let {
                    if (it.isLeaf) {
                        onToggle(it.isExpand, holder)
                    }
                }

                return false
            }

            override fun onToggle(isExpand: Boolean, holder: RecyclerView.ViewHolder?) {
                val dirViewHolder = holder as DirectoryNodeBinder.ViewHolder
                val ivArrow = dirViewHolder.ivArrow
                val rotateDegree = if (isExpand) 90 else -90
                ivArrow.animate().rotationBy(rotateDegree.toFloat())
                        .start()
            }
        })
        rv?.adapter = adapter
    }

    private fun initView() {
        rv = findViewById<View>(R.id.rv) as RecyclerView
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.id_action_close_all -> adapter?.collapseAll()
            else -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }
}