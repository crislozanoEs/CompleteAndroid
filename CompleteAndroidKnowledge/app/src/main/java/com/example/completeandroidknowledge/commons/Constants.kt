package com.example.completeandroidknowledge.commons

class Constants{
    companion object{
        var BASE_URL: String = "http://demo4322636.mockable.io/"
        var documentType1: HashMap<String, String> = hashMapOf("dt1" to "User", "dt2" to "Identification", "dt3" to "Passport", "dt4" to "Other")
        enum class FOOTER{
            HOME, PRODUCTS_INFO, NEWS, MORE
        }


    }
}