package learn.idn.basicandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    var edtEmail: EditText? = null
    var edtPass: EditText? = null
    lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtEmail = findViewById(R.id.edt_mail)
        edtPass = findViewById(R.id.edt_pass)
        btnLogin =  findViewById(R.id.btn_login)

        btnLogin.setOnClickListener {
            Toast.makeText(this, "button dipencet", Toast.LENGTH_SHORT).show()
        }

    }
}