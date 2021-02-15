package mx.edu.itson.examen_calculadora189029

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.objecthunter.exp4j.ExpressionBuilder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



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


        tvPlus.setOnClickListener {
            evaluateExpression("+", clear = true)
        }

        tvMinus.setOnClickListener {
            evaluateExpression("-", clear = true)
        }

        tvMul.setOnClickListener {
            evaluateExpression("*", clear = true)
        }

        tvDivide.setOnClickListener {
            evaluateExpression("/", clear = true)
        }

        tvDot.setOnClickListener {
            evaluateExpression(".", clear = true)
        }

        tvClear.setOnClickListener {
            tvExpression.text = ""
            tvResult.text = ""
        }

        tvEquals.setOnClickListener {
            val text = tvExpression.text.toString()
            val expression = ExpressionBuilder(text).build()

            val result = expression.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble()) {
                tvResult.text = longResult.toString()
            } else {
                tvResult.text = result.toString()
            }
        }

        tvBack.setOnClickListener {
            val text = tvExpression.text.toString()
            if(text.isNotEmpty()) {
                tvExpression.text = text.drop(1)
            }

            tvResult.text = ""
        }
    }


    fun evaluateExpression(string: String, clear: Boolean) {
        if(clear) {
            Result.text = ""
            Expression.append(string)
        } else {
            Expression.append(Result.text)
            Expression.append(string)
            Result.text = ""
        }
    }

}