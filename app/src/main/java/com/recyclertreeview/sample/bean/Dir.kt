package com.recyclertreeview.sample.bean

import com.recyclertreeview.lib.LayoutItemType
import com.recyclertreeview.sample.R


class Dir(var dirName: String) : LayoutItemType {

    override val layoutId: Int
        get() = R.layout.item_dir

}