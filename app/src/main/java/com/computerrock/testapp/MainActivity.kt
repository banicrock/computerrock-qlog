package com.computerrock.testapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.computerrock.qlog.dLog
import com.computerrock.qlog.dStackTrace
import com.computerrock.qlog.eLog
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.module

class MainActivity : AppCompatActivity() {

    var parm = arrayOf("android.permission.READ_PHONE_STATE")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        dLog("Hello World!")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


}
