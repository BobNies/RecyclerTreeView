package tellh.com.recyclertreeview.bean

import tellh.com.recyclertreeview.R
import tellh.com.recyclertreeview_lib.LayoutItemType


class Dir(var dirName: String) : LayoutItemType {

    override val layoutId: Int
        get() = R.layout.item_dir

}