package com.cristianvillamil.platziwallet.ui.home.data

import android.app.AlertDialog
import android.content.Context

class MessageFactory {

    companion object{

        val ANOTHER_TYPE = "typeError"

    }

    fun getDialog(type:TypeResponse,context: Context):AlertDialog.Builder{
        when(type){
            TypeResponse.TYPE_ERROR ->{
                return AlertDialog
                    .Builder(context)
                    .setMessage("No podemos contactar con el servidor")
            }
            TypeResponse.TYPE_SUCCESS ->{
                return AlertDialog
                    .Builder(context)
                    .setMessage("Conexión exitosa")
            }
        }
    }

    enum class TypeResponse(val nameType:String){
        TYPE_ERROR("typeError"),
        TYPE_SUCCESS("typeSuccess")
    }

}