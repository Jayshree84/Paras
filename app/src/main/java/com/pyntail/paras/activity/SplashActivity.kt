package com.pyntail.paras.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.content.ContextCompat
import android.widget.Toast
import com.pyntail.paras.R
import com.pyntail.paras.utils.Constants
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity() {

    private var handler: Handler? = null
    private var runnable: Runnable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        handler = Handler()
        initComponents()
    }


    override fun onDestroy() {
        super.onDestroy()

        if (handler != null && runnable != null) {
            (handler as Handler).removeCallbacks(runnable);
        }
    }

    /**
     * Called when activity is created. It initializes the views
     */
    override fun initComponents() {
        this.imageView1.setImageDrawable(ContextCompat.getDrawable(this, R.mipmap.ic_launcher));

        handler = Handler()
        runnable = Runnable {
            run {
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                finish()
            }
        }

        handler!!.postDelayed(runnable, Constants.SPALSH_TIME_OUT);
    }
}


