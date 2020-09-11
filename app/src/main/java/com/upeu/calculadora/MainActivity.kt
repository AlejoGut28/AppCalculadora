package com.upeu.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var operacion: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        unoBoton.setOnClickListener{ numeroPresionado("1") }
        dosBoton.setOnClickListener{ numeroPresionado( "2")}
        tresBoton.setOnClickListener{ numeroPresionado("3")}
        cuatroBoton.setOnClickListener{ numeroPresionado("4")}
        cincoBoton.setOnClickListener{ numeroPresionado("5")}
        seisBoton.setOnClickListener{ numeroPresionado("6")}
        sieteBoton.setOnClickListener{ numeroPresionado("7")}
        ochoBoton.setOnClickListener{ numeroPresionado("8")}
        nueveBoton.setOnClickListener{ numeroPresionado("9")}
        ceroBoton.setOnClickListener{ numeroPresionado("0")}

        sumaBoton.setOnClickListener { operacionPresionada(SUMA)}
        restaBoton.setOnClickListener{ operacionPresionada(RESTA)}
        multiBoton.setOnClickListener{ operacionPresionada(MULTIPLICACION)}
        divisionBoton.setOnClickListener{ operacionPresionada(DIVISION)}

        borrarBoton.setOnClickListener{
            num1 = 0.0
            num2 = 0.0
            resultadotextView.text = "0"
            operacion = NO_OPERACION
        }

        igualBoton.setOnClickListener{
            var resultado = when(operacion){
                SUMA -> num1 + num2
                RESTA -> num1 - num2
                MULTIPLICACION -> num1 * num2
                DIVISION -> num1 / num2
                else -> 0
            }
            resultadotextView.text = resultado.toString()
        }
    }

    private fun numeroPresionado(digito: String){
        resultadotextView.text = "${resultadotextView.text}$digito"
        if (operacion == NO_OPERACION){
             num1 = resultadotextView.text.toString().toDouble()
        } else{
            num2 = resultadotextView.text.toString().toDouble()
        }
    }

    private fun operacionPresionada(operacion: Int){
          this.operacion  = operacion

        resultadotextView.text = "0"
    }

    companion object{
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val NO_OPERACION = 0
    }
}