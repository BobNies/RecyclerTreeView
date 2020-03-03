package tellh.com.recyclertreeview.bean

import tellh.com.recyclertreeview.R
import tellh.com.recyclertreeview_lib.LayoutItemType


class File(var fileName: String) : LayoutItemType {

    override val layoutId: Int
        get() = R.layout.item_file

}