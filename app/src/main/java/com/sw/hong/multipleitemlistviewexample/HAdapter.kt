package com.sw.hong.multipleitemlistviewexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

/**
* Created by hong on 18. 1. 25.
*/

class HAdapter(context: Context) : BaseAdapter() {

    //아이템의 타입을 정의 할 상
    companion object {
        const val VIEWTYPE_IMAGE = 0
        const val VIEWTYPE_TEXT = 1
        const val VIEWTYPE_EDITTEXT = 2
        const val VIEWTYPE_BOOLEAN = 3
        const val VIEWTYPE_COUNT = 4
    }

    private val mInflater = LayoutInflater.from(context)
    //아이템을 담을 리스트
    private val mItem = ArrayList<Items>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        //뷰의 타입을 받아옴.
        val type = getItemViewType(position)
        lateinit var viewHolder : ViewHolder
        if(view == null) {
            //뷰 타입에 따라 다른 뷰를 Inflate, 뷰홀더에 등록
            when(type){
                VIEWTYPE_IMAGE    -> {
                    viewHolder = ViewHolder()
                    view = mInflater.inflate(R.layout.listview_item1, parent, false)
                    viewHolder.imageView = view.findViewById(R.id.imageView)
                    view.tag = viewHolder
                }
                VIEWTYPE_TEXT     -> {
                    viewHolder = ViewHolder()
                    view = mInflater.inflate(R.layout.listview_item2, parent, false)
                    viewHolder.textView = view.findViewById(R.id.textView)
                    view.tag = viewHolder
                }
                VIEWTYPE_EDITTEXT -> {
                    viewHolder = ViewHolder()
                    view = mInflater.inflate(R.layout.listview_item3, parent, false)
                    viewHolder.editText = view.findViewById(R.id.editText)
                    view.tag = viewHolder
                }
                VIEWTYPE_BOOLEAN -> {
                    viewHolder = ViewHolder()
                    view = mInflater.inflate(R.layout.listview_item4, parent, false)
                    viewHolder.checkBox = view.findViewById(R.id.checkbox)
                    view.tag = viewHolder
                }
            }
        }else{
            viewHolder = view.tag as ViewHolder
        }
        when(type){
            VIEWTYPE_IMAGE    -> {viewHolder.imageView!!.setImageResource(mItem[position].itemData as Int)}
            VIEWTYPE_TEXT     -> {viewHolder.textView!!.text = mItem[position].itemData as String}
            VIEWTYPE_EDITTEXT -> {viewHolder.editText!!.setText(mItem[position].itemData as String)}
            VIEWTYPE_BOOLEAN -> {viewHolder.checkBox!!.isChecked = mItem[position].itemData as Boolean}
        }
        return view!!
    }

    override fun getItem(position: Int) = mItem[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getCount() = mItem.size

    override fun getViewTypeCount() = VIEWTYPE_COUNT

    override fun getItemViewType(position: Int) = mItem[position].type

    fun addItem(item: Items){
        mItem.add(item)
    }
    //뷰홀더를 사용하는 이유는 findViewById를 계속해서 호출하지 않음으로써 부드러운 스크롤을 가능하게 하는게 목적
    //때문에  하나의 클래스에 몰빵했습니다.
    inner class ViewHolder {
        var textView : TextView? = null
        var imageView : ImageView? = null
        var checkBox : CheckBox? = null
        var editText : EditText? = null
    }
    //아이템을 담을 클래스
    data class Items(var itemData: Any, var type: Int)
}