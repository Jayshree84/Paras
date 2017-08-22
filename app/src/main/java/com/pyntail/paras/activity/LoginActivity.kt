package com.pyntail.paras.activity

import android.net.Uri
import android.os.Bundle
import com.pyntail.paras.R
import com.pyntail.paras.fragment.LoginMobileFragment

class LoginActivity : BaseActivity(), LoginMobileFragment.OnFragmentInteractionListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initComponents();
    }

    override fun initComponents() {
        addFragment(R.id.layout_fragment_container, LoginMobileFragment())
    }


    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
