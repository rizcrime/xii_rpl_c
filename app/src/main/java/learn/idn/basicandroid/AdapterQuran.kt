package learn.idn.basicandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterQuran(private val dataAyat: ArrayList<String>,
                   private val dataText: ArrayList<String>) :
    RecyclerView.Adapter<AdapterQuran.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ayatQuran: TextView = view.findViewById(R.id.ayat)
        val textQuran: TextView = view.findViewById(R.id.text_quran)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.rv_quran_model, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.ayatQuran.text = dataAyat[position]
        viewHolder.textQuran.text = dataText[position]
    }

    override fun getItemCount() = dataAyat.size

}