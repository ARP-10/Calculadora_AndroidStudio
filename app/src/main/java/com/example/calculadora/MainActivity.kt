package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import kotlin.math.sqrt
import kotlin.math.sin
import kotlin.math.cos
import kotlin.math.tan
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),  OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var op1: Double? = null
    private var op2: Double? = null
    private var resultado: Double? = 0.0
    private var operador: String? = null
    private var raiz: Double = 0.0
    private var seno: Double = 0.0
    private var coseno: Double = 0.0
    private var tangente: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // Recupero el estado
        resultado = savedInstanceState?.getDouble("resultado") ?: 0.0
        binding.txtResultado.text = resultado.toString()

        // Implementamos OnClickListener
        binding.btn0.setOnClickListener(this)
        binding.btn1.setOnClickListener(this)
        binding.btn2.setOnClickListener(this)
        binding.btn3.setOnClickListener(this)
        binding.btn4.setOnClickListener(this)
        binding.btn5.setOnClickListener(this)
        binding.btn6.setOnClickListener(this)
        binding.btn7.setOnClickListener(this)
        binding.btn8.setOnClickListener(this)
        binding.btn9.setOnClickListener(this)
        binding.btnSuma.setOnClickListener(this)
        binding.btnResta.setOnClickListener(this)
        binding.btnMultiplicacion.setOnClickListener(this)
        binding.btnDivision.setOnClickListener(this)
        binding.btnIgual.setOnClickListener(this)
        binding.btnClear.setOnClickListener(this)
        binding.btnRaiz?.setOnClickListener(this)
        binding.btnSin?.setOnClickListener(this)
        binding.btnCos?.setOnClickListener(this)
        binding.btnTan?.setOnClickListener(this)

    }

    // Funcion para guardar estado
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("resultado", resultado!!)
    }

    // Funcionalidad de los botones
    override fun onClick(v: View?) {
        val buttonText = (v as Button).text.toString() // Asumimos que v es un boton
        when (v?.id) {
            in arrayOf(binding.btn0.id, binding.btn1.id, binding.btn2.id, binding.btn3.id, binding.btn4.id,
            binding.btn5.id, binding.btn6.id, binding.btn7.id, binding.btn8.id, binding.btn9.id) -> {
                if (operador == null) {
                    // Si no hay operador, estamos ingresando el primer número
                    if (op1 == null) {
                        op1 = buttonText.toDouble()
                    } else {
                        op1 = op1!! * 10 + buttonText.toDouble()
                    }
                    binding.txtResultado.text = op1.toString()
                } else {
                    // Si hay un operador, estamos ingresando el segundo número
                    if (op2 == null) {
                        op2 = buttonText.toDouble()
                    } else {
                        op2 = op2!! * 10 + buttonText.toDouble()
                    }
                    binding.txtResultado.text = op2.toString()
                }
            }
            binding.btnSuma.id -> {
                operador = "suma"
            }
            binding.btnResta.id -> {
                operador = "resta"
            }
            binding.btnMultiplicacion.id -> {
                operador = "multiplicacion"
            }
            binding.btnDivision.id -> {
                operador = "division"
            }
            binding.btnIgual.id -> {
                when (operador) {
                    "suma" -> {
                        resultado = op1!! + op2!!
                        op1 = resultado
                        op2 = null
                    }
                    "resta" -> {
                        resultado = op1!! - op2!!
                        op1 = resultado
                        op2 = null
                    }
                    "multiplicacion" -> {
                        resultado = op1!! * op2!!
                        op1 = resultado
                        op2 = null
                    }
                    "division" -> {
                        resultado = op1!! / op2!!
                        op1 = resultado
                        op2 = null
                    }
                }
                binding.txtResultado.text = resultado.toString()
            }
            binding.btnClear.id -> {
                op1 = null
                op2 = null
                resultado = 0.0
                operador = null
                binding.txtResultado.text = "0.0"
            }
            binding.btnRaiz?.id -> {
                if (op1 != null && op2 == null) {
                    raiz = sqrt(op1!!)
                }
                binding.txtResultado.text = raiz.toString()
                op1 = raiz
            }
            binding.btnSin?.id -> {
                if (op1 != null && op2 == null) {
                    seno = sin(op1!!)
                }
                binding.txtResultado.text = seno.toString()
                op1 = seno
            }
            binding.btnCos?.id -> {
                if (op1 != null && op2 == null) {
                    coseno = cos(op1!!)
                }
                binding.txtResultado.text = coseno.toString()
                op1 = coseno
            }
            binding.btnTan?.id -> {
                if (op1 != null && op2 == null) {
                    tangente = tan(op1!!)
                }
                binding.txtResultado.text = tangente.toString()
                op1 = tangente
            }
        }


    }
}