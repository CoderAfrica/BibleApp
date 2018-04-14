package com.ayodele.bible.ui.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import java.util.*

class MainPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private val mFragments = ArrayList<Fragment>()
    private val mFragmentTitles = ArrayList<String>()

    fun addFragment(fragment: Fragment, title: String) {
        mFragments.add(fragment)
        mFragmentTitles.add(title)
    }

    fun notifyDataChanged() {
        notifyDataSetChanged()
    }

    override fun getItem(position: Int): Fragment = mFragments[position]

    override fun getCount(): Int = mFragments.size

    override fun getPageTitle(position: Int): CharSequence? = mFragmentTitles[position]

    override fun getItemPosition(`object`: Any): Int = FragmentStatePagerAdapter.POSITION_NONE

}
