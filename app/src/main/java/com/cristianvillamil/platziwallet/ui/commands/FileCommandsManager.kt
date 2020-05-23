package com.cristianvillamil.platziwallet.ui.commands

class FileCommandsManager {

    private val commands : HashMap<String,FileCommand> = HashMap()

    fun putCommand(nameCommand:String,fileCommand: FileCommand){
        commands[nameCommand] = fileCommand
    }

    fun getCommand(nameCommand:String):FileCommand{
        if(commands.containsKey(nameCommand)){
            return commands[nameCommand]!!
        }else{
            throw RuntimeException("command: $nameCommand doesn't exists")
        }
    }

}