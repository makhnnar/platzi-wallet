package com.cristianvillamil.platziwallet.ui.home.data

class User private constructor(
    private val name:String,
    private val pass:String
) {
    class Builder{
        private var name:String = ""
        private var pass:String = ""

        fun setNewName(newName:String):Builder{
            this.name = newName
            return this
        }

        fun setNewPass(newPass:String):Builder{
            this.pass = newPass
            return this
        }

        fun build():User{
            return User(name,pass)
        }
    }
}