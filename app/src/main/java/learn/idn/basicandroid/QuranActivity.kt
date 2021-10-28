package learn.idn.basicandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import learn.idn.basicandroid.network.AlquranModel
import learn.idn.basicandroid.network.Config
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuranActivity : AppCompatActivity() {

    val dataText = arrayListOf<String>()
    val dataAyat = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quran)

        val rvQuran : RecyclerView = findViewById(R.id.rv_quran)

        Config().service().listRepos().enqueue(object : Callback<AlquranModel>{
            override fun onResponse(call: Call<AlquranModel>, response: Response<AlquranModel>) {
                val respon = response.body()!!
                respon.data?.ayahs?.forEach { data ->
                    dataAyat.add(data?.numberInSurah.toString())
                    dataText.add(data?.text.toString())
                    rvQuran.adapter = AdapterQuran(dataAyat, dataText)
                    rvQuran.layoutManager = LinearLayoutManager(this@QuranActivity)
                    rvQuran.setHasFixedSize(true)
                }

            }

            override fun onFailure(call: Call<AlquranModel>, t: Throwable) {
                Toast.makeText(this@QuranActivity, "$t", Toast.LENGTH_LONG).show()
                Log.d("Pengetesan", "$t")
            }

        })

    }
}