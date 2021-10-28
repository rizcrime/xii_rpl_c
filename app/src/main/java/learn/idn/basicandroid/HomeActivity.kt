package learn.idn.basicandroid

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class HomeActivity : AppCompatActivity() {

    lateinit var takeEmail: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        takeEmail = intent.getStringExtra("EMAIL").toString()

    }

    override fun onStart() {
        super.onStart()
        menyapa()
    }

    fun menyapa(){
        Snackbar.make(findViewById(android.R.id.content), "Hai $takeEmail", Snackbar.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.logout -> {
                alertDialog()
            }
            R.id.profile -> {
                startActivity(Intent(this, ProfileActivity::class.java))
            }
            else -> return super.onOptionsItemSelected(item)
        }
        return true
    }

    fun logout(){
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    fun alertDialog(){
        val alertDialog: AlertDialog = this.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Perhatian")
            builder.apply {
                setPositiveButton("Ok") { _, _ -> logout() }
                setNegativeButton("Cancel") { _, _ ->  }
                setNeutralButton("YNTKYS") { _, _ ->  }
            }
            builder.create()
        }
        alertDialog.show()
    }

}