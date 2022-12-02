package com.example.expense_share_app

class User(name:String, email:String, password:String){

    fun encodeData(data:String) : String {
        var encoded = data.replace(".", "~")
        encoded = data.replace("#", "~")
        encoded = data.replace("$", "~")
        encoded = data.replace("[", "~")
        encoded = data.replace("]", "~")
        return encoded
    }
}