package com.tesji.appkotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.tesji.appkotlin.model.TerrenoModel

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("HEEEEEEEEY MUY BUENAS A TODOS GUAPISIMOS AQUI VEGETTA777 EN UN NUEVO GAMEPLAY DE ANDROID STUDIO")
        println("CREADO POR WOLFKNIGHT")
        println("YA CASI UN INGENIERO")

        /*VARIABLES EN KOTLIN
        * KOTLIN PUEDE SER TIPADO O NO
        * VAR: DECLARA UNA VARIABLE
        * permite redeclar en un mismo scope
        * VAL: SE USA PARA DEFINIR CONSTANTES*/

        /*var nombre:String
        if (true){
            var nombre = "linces"
        }
        var salario:Double = 25000.00
        val PI = 3.1416*/

        //--CONTROLADOR PARA LA GUI Y EL MODEL--//
        //declarar los views y referenciarlos por id

        val txtNombre = findViewById<EditText>(R.id.txNombre)
        val txtAncho = findViewById<EditText>(R.id.txMedidaAncho)
        val txtLargo = findViewById<EditText>(R.id.txMedidaLargo)
        val txtPrecioMetro = findViewById<EditText>(R.id.txPrecioMetro)
        val btnCalculo = findViewById<Button>(R.id.btCalcular)

        //crear el evento clic del boton
        btnCalculo.setOnClickListener{

            if(txtNombre.text.toString().trim().isEmpty()){
                txtNombre.setError("INGRESE NOMBRE")
            }else if(txtAncho.text.toString().trim().isEmpty()){
                txtAncho.setError("INGRESE ANCHO")
            }else if(txtLargo.text.toString().trim().isEmpty()){
                txtLargo.setError("INGRESE LARGO")
            }else if(txtPrecioMetro.text.toString().trim().isEmpty()){
                txtPrecioMetro.setError("INGRESE PRECIO POR METRO")
            }else{
                //Conectar con el modelo
                val terreno = TerrenoModel()
                terreno.nombre = txtNombre.text.toString()
                terreno.medidaLargo = txtLargo.text.toString().toDouble()
                terreno.medidaAncho = txtAncho.text.toString().toDouble()
                terreno.precioMetro = txtPrecioMetro.text.toString().toDouble()

                Toast.makeText(applicationContext,
                    terreno.calcularVenta(),
                    Toast.LENGTH_LONG).show()
            }


/*
            //Conectar con el modelo
            val terreno = TerrenoModel()
            terreno.nombre = txtNombre.text.toString()
            terreno.medidaLargo = txtLargo.text.toString().toDouble()
            terreno.medidaAncho = txtAncho.text.toString().toDouble()
            terreno.precioMetro = txtPrecioMetro.text.toString().toDouble()

            Toast.makeText(applicationContext,
                terreno.calcularVenta(),
                Toast.LENGTH_LONG).show()*/

        }
    }
}