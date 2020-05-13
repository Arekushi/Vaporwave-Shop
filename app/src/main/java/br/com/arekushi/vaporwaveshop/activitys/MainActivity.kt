package br.com.arekushi.vaporwaveshop.activitys

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.com.arekushi.vaporwaveshop.R
import br.com.arekushi.vaporwaveshop.SharedPreferences
import br.com.arekushi.vaporwaveshop.database.OpenHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = OpenHelper(this)
        val preferences = SharedPreferences(this)

        txvShow.text = getString(R.string.textShow, database.returnUser(preferences.getString(getString(R.string.email)))[0].email)
    }

    fun logout(view: View) {
        val preferences = SharedPreferences(this)
        preferences.removeKey(getString(R.string.email))
        preferences.removeKey(getString(R.string.logged))

        Toast.makeText(this, getString(R.string.logout), Toast.LENGTH_SHORT).show()

        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
