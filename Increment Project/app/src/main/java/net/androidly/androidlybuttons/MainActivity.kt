package net.androidly.androidlybuttons

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var androidlyButton = Button(this)
        androidlyButton.apply {
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            text = "Decrement"
            setAllCaps(false)
            textSize = 20f
            id = R.id.btnDouble
        }

        androidlyButton.setOnClickListener(this)
        linearLayout.addView(androidlyButton)

        //create another button
        androidlyButton = Button(this)
        androidlyButton.apply {
            layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            text = "RESET"
            textSize = 20f
            setTextColor(ContextCompat.getColor(this@MainActivity, R.color.colorPrimaryDark))
            id = R.id.btnReset
            setOnLongClickListener {
                txtCounter.text = 0.toString()
                true
            }
        }
        androidlyButton.setOnClickListener(this)
        linearLayout.addView(androidlyButton)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnDouble -> {
                txtCounter.text = (txtCounter.text.toString().toInt() - 1).toString()
            }
            R.id.btnReset -> {
                txtCounter.text = (0).toString()
            }
            else -> {
            }
        }
    }

    //gets executed when btnIncrementByOne is clicked.
    fun addOne(view: View) {
        txtCounter.text = (txtCounter.text.toString().toInt() + 1).toString()
    }
}
