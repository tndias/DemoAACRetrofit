package br.com.psoa.demoaacretrofit.ui.mainscreen

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import br.com.psoa.demoaacretrofit.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        btSearch.setOnClickListener {
            mainViewModel.search(edCep.text.toString())
        }

        mainViewModel.apiResponse.observe(this,
                Observer { a ->
                    if (a?.error == null) {

                        Log.i("TIAGO", "SUCESSO")
                        var end = a?.address
                        txResult.text = "Logradouro: ${end?.logradouro}"
                    } else {
                        Log.i("TIAGO", "ERRO: ${a.error}")
                    }
                })
        mainViewModel.isLoading.observe(this, Observer { isLoading ->
            if (isLoading!!) {
                loading.visibility = View.VISIBLE
            } else {
                loading.visibility = View.GONE
            }
        })
    }
}
