package com.cristianvillamil.platziwallet.ui.commands

import android.content.Context
import java.io.IOException
import java.io.OutputStreamWriter

class SaveCommand : FileCommand {

    override fun execute(
        context: Context,
        fileName: String,
        vararg arguments: String
    ) {
        try{
            var argumentAsString = ""
            arguments.forEach {
                argumentAsString += "\n $it"
            }
            val outPutStringWriter = OutputStreamWriter(
                context.openFileOutput(fileName,Context.MODE_PRIVATE)
            )
            outPutStringWriter.write(argumentAsString)
            outPutStringWriter.close()
        }catch (e:IOException){

        }
    }

}