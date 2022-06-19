package com.example.convertingnumbersintowords

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvTitle: TextView = findViewById(R.id.tvTitle)
        val etNumber: EditText = findViewById(R.id.etNumber)
        val btnModify: Button = findViewById(R.id.btnModify)
        val tvResult: TextView = findViewById(R.id.tvResult)

        btnModify.setOnClickListener {
            if (etNumber.text.toString().isEmpty())
            {
                val toast = Toast.makeText(this,"შეიყვანეთ რიცხვი 1დან 1000მდე", Toast.LENGTH_LONG)
                toast.show()
            }
            else
            {
                val item = etNumber.text.toString().toInt()
                val finalItem = ConvertNumberIntoWord(item)
                tvResult.text = finalItem

            }

        }
    }
}


fun ConvertNumberIntoWord(number: Int): String {
    var digit = number
    var text = ""
    val componentArray = arrayOf(
        "ნული", "ერთი", "ორი", "სამი", "ოთხი", "ხუთი", "ექვსი", "შვიდი",
        "რვა", "ცხრა", "ათი", "თერთმეტი", "თორმეტი", "ცამეტი", "თოთხმეტი",
        "თხუმეტი", "თექვსმეტი", "ჩვიდმეტი", "ცხრამეტი"
    )
    val tensArray = arrayOf(
        "ნული", "ათი", "ოცი", "ოცდაათი", "ორმოცი", "ორმოცდაათი", "სამოცი",
        "სამოცდაათი", "ოთხმოცი", "ოთხმოცდაათი"
    )
    val hundredsArray = arrayOf(
        "ნული", "ასი", "ორასი", "სამასი", "ოთხასი", "ხუთასი", "ექვსასი",
        "შვიდასი", "რვაასი", "ცხრაასი", "ათასი"
    )

    if (number == 0)
    {
        return "ნული"
    }

    if (number > 0)
    {
        if (number < 20)
        {
            text += componentArray[number]
        } else if (number in 21..99)
        {
            text += tensArray[number / 10]
            if (number % 10 > 0)
            {
                text += componentArray[number % 10]
            }
        } else
        {
            text += hundredsArray[number / 100]
            if (number % 100 > 99)
            {
                text = text + componentArray[number] + tensArray[number / 10]
            }
        }
    }
    return text
}