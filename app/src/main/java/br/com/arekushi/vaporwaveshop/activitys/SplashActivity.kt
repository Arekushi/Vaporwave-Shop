package br.com.arekushi.vaporwaveshop.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import br.com.arekushi.vaporwaveshop.R
import br.com.arekushi.vaporwaveshop.SharedPreferences

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val run = Runnable {
            showActivity()
        }

        val duration : Long = 2000
        Handler().postDelayed(run, duration)
    }

    private fun showActivity() {
        val preferences = SharedPreferences.getInstance(this)

        fun foo(isLogged : Boolean) : Intent {
            return when(isLogged) {
                true -> Intent(this, MainActivity::class.java)
                false -> Intent(this, LoginActivity::class.java)
            }
        }

        startActivity(foo(preferences.verificKey(getString(R.string.logged))))
        finish()
    }
}
