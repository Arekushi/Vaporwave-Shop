package br.com.arekushi.vaporwaveshop.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.com.arekushi.vaporwaveshop.R
import br.com.arekushi.vaporwaveshop.database.OpenHelper
import br.com.arekushi.vaporwaveshop.model.User
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    fun doRegister(view: View) {
        val database = OpenHelper(this)

        val email = edtEmailRegister.text.trim().toString()
        val password = edtPasswordRegister.text.trim().toString()

        if(email.isNullOrEmpty() || password.isNullOrEmpty()) {
            Toast.makeText(this, getString(R.string.toastRegister), Toast.LENGTH_SHORT).show()

        } else {
            database.registerUser(User(email, password))
            Toast.makeText(this, getString(R.string.sucessRegister), Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
