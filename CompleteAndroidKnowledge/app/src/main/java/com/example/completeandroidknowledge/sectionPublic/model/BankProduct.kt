package com.example.completeandroidknowledge.sectionPublic.model

data class BankProduct (
    var id: Int,
    var imageId: Int,
    var textProduct: String,
    var urlProduct: String,
    var isOpen: Boolean = false
)