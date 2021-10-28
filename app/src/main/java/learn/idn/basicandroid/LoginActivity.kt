package learn.idn.basicandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    lateinit var btnLogin: Button

    lateinit var dataName: List<String>
    lateinit var dataEmail: List<String>
    lateinit var dataPass: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val edtEmail: EditText = findViewById(R.id.edt_mail)
        val edtPass:EditText = findViewById(R.id.edt_pass)
        btnLogin =  findViewById(R.id.btn_login)

        dataName = listOf("Rizkia", "Harun")
        dataEmail = listOf("kia@gmail.com","harun123@gmail.com")
        dataPass = listOf("1234", "4321")

        btnLogin.setOnClickListener {
            if (login(edtEmail.text.toString(), edtPass.text.toString())){
                Toast.makeText(this, "Akun ditemukan", Toast.LENGTH_SHORT).show()
                finish()
            } else{
                Toast.makeText(this, "Akun tidak ditemukan", Toast.LENGTH_SHORT).show()
            }
        }

    }



    fun login(email: String, password: String): Boolean{
        for(i in dataEmail.indices){
            if (email == dataEmail[i] && password == dataPass[i]){
                startActivity(Intent(this, HomeActivity::class.java).apply {
                    putExtra("EMAIL", dataName[i])
                })
                return true
            }
        }
        return false
    }

}