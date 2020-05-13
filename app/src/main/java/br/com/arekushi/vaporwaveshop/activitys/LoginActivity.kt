package br.com.arekushi.vaporwaveshop.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.com.arekushi.vaporwaveshop.R
import br.com.arekushi.vaporwaveshop.SharedPreferences
import br.com.arekushi.vaporwaveshop.database.OpenHelper
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun login(view: View) {
        val preferences = SharedPreferences.getInstance(this)
        val database = OpenHelper(this)

        val email = edtEmailLogin.text.trim().toString()
        val password = edtPasswordLogin.text.trim().toString()

        if(email.isNullOrEmpty() || password.isNullOrEmpty()) {
            Toast.makeText(this, getString(R.string.toastRegister), Toast.LENGTH_SHORT).show()

        } else {
            var result = database.verificLogin(email, password)

            if(result) {
                preferences.addString(getString(R.string.email), email)
                preferences.addBoolean(getString(R.string.logged), true)
                Toast.makeText(this, getString(R.string.sucessLogin), Toast.LENGTH_SHORT).show()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()

            } else {
                Toast.makeText(this, getString(R.string.failedLogin), Toast.LENGTH_SHORT).show()
            }
        }

    }

    fun register(view: View) {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
        finish()
    }
}
