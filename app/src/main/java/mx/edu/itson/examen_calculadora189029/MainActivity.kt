package mx.edu.itson.examen_calculadora189029

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.objecthunter.exp4j.ExpressionBuilder
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.Expression

class MainActivity : AppCompatActivity() {
    private var num1:Double=0.0
    private var num2:Double=0.0
    private var operacionCurso:Int= NO_OPERACION
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*Number Buttons*/

        tvOne.setOnClickListener {
            evaluateExpression("1", clear = true)
        }

        tvTwo.setOnClickListener {
            evaluateExpression("2", clear = true)
        }

        tvThree.setOnClickListener {
            evaluateExpression("3", clear = true)
        }
        tvFour.setOnClickListener {
            evaluateExpression("4", clear = true)
        }

        tvFive.setOnClickListener {
            evaluateExpression("5", clear = true)
        }

        tvSix.setOnClickListener {
            evaluateExpression("6", clear = true)
        }

        tvSeven.setOnClickListener {
            evaluateExpression("7", clear = true)
        }

        tvEight.setOnClickListener {
            evaluateExpression("8", clear = true)
        }

        tvNine.setOnClickListener {
            evaluateExpression("9", clear = true)
        }

        tvZero.setOnClickListener {
            evaluateExpression("0", clear = true)
        }

        /*Operators*/

        tvPlus.setOnClickListener {
            opTipo(SUMA)
        }

        tvMinus.setOnClickListener {
            opTipo(RESTA)
        }

        tvMul.setOnClickListener {
            opTipo(MULTIPLICACION)
        }

        tvDivide.setOnClickListener {
            opTipo(DIVICION)
        }

        tvDot.setOnClickListener {
            evaluateExpression(".", clear = true)
        }

        tvClear.setOnClickListener {
            num1=0.0
            num2=0.0
            operacionCurso= NO_OPERACION
            tvExpression.text = " "
            tvResult.text = ""
        }

        tvEquals.setOnClickListener {
            var r=0.0
            if (operacionCurso== SUMA){
                r=num1+num2
            }else if(operacionCurso==RESTA){
                r=num1-num2
            }else if(operacionCurso== MULTIPLICACION){
                r=num1*num2
            }else if(operacionCurso== DIVICION){
                r=num1/num2
            } else{
                r=0.0
            }
            tvResult.text=r.toString()
        }

        tvBack.setOnClickListener {
            val text = tvExpression.text.toString()
            if(text.isNotEmpty()) {
                tvExpression.text = text.drop(1)
            }

            tvResult.text = ""
        }
    }


    private fun evaluateExpression(numero: String, clear: Boolean) {
        tvResult.text="${tvResult.text}$numero"
        if (operacionCurso== NO_OPERACION){
            num1=tvResult.text.toString().toDouble()
        } else{
            num2=tvResult.text.toString().toDouble()
        }
    }

    private fun opTipo(op:Int){
        this.operacionCurso=op
        tvResult.text=""
    }

    companion object{
        const val SUMA=1
        const val RESTA=2
        const val MULTIPLICACION=3
        const val DIVICION=4
        const val NO_OPERACION=5
    }
}


