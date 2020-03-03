package com.recyclertreeview.sample.bean

import com.recyclertreeview.lib.LayoutItemType
import com.recyclertreeview.sample.R


class File(var fileName: String) : LayoutItemType {

    override val layoutId: Int
        get() = R.layout.item_file

}