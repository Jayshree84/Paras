package com.pyntail.paras.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

/**
 * Created by Jayshree.Rathod on 21-08-2017.
 */
abstract class BaseActivity: AppCompatActivity() {

    abstract protected fun initComponents()

    /**
     * Called when any activity is created
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    /**
     * Add fragment into desire fragment container layout
     * @param fragmentContainerResourceId fragment container resource  id
     * *
     * @param nextFragment                the fragment which now we want to add above current fragment in same container
     * *
     * @return true if fragment added successfully, false otherwise
     * *
     * @throws IllegalStateException throws in case of transaction after activity saved its state
     */
    @Throws(IllegalStateException::class)
    protected fun addFragment(fragmentContainerResourceId: Int, nextFragment: Fragment): Boolean {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.add(fragmentContainerResourceId, nextFragment, nextFragment.javaClass.simpleName)
        fragmentTransaction.commit()
        return true
    }


    /**
     * Add fragment into desire fragment container layout
     * @param fragmentContainerResourceId fragment container resource  id
     * *
     * @param currentFragment             current added fragment into same container
     * *
     * @param nextFragment                the fragment which now we want to add above current fragment in same container
     * *
     * @return true if fragment added successfully, false otherwise
     * *
     * @throws IllegalStateException throws in case of transaction after activity saved its state
     */
    @Throws(IllegalStateException::class)
    protected fun addFragment(fragmentContainerResourceId: Int, currentFragment: Fragment?, nextFragment: Fragment): Boolean {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.add(fragmentContainerResourceId, nextFragment, nextFragment.javaClass.simpleName)
        fragmentTransaction.addToBackStack(nextFragment.javaClass.simpleName)
        if(currentFragment != null) {
            fragmentTransaction.hide(currentFragment)
        }
        fragmentTransaction.commit()
        return true
    }


    /**
     * Replace fragment into desire fragment container layout

     * @param fragmentContainerResourceId fragment container resource  id
     * *
     * @param nextFragment                the fragment which now we want to add above current fragment in same container
     * *
     * @return true if fragment added successfully, false otherwise
     * *
     * @throws IllegalStateException throws in case of transaction after activity saved its state
     */
    @Throws(IllegalStateException::class)
    protected fun replaceFragment(fragmentContainerResourceId: Int, nextFragment: Fragment?): Boolean {
        if (nextFragment == null) {
            return false
        }
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(fragmentContainerResourceId, nextFragment, nextFragment!!.javaClass.simpleName)
        fragmentTransaction.commit()
        return true
    }
}