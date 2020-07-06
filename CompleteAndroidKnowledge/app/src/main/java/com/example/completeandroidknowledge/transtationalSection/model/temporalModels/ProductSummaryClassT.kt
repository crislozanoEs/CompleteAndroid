package com.example.completeandroidknowledge.transtationalSection.model.temporalModels

import com.example.completeandroidknowledge.transtationalSection.model.Product

class ProductSummaryClassT() {
    val products : List<Product>
    init{
        val product1 = Product(0, "111233441", "Mi producto",
            "00_32_01_111233441", 1, 1,12000000.00)
        val product2 = Product(0, "1133456", "Mi producto funcional",
            "00_35_01_1133456", 2, 2,-5500000.20)
        val product3 = Product(0, "0005233441", "Mi cuenta",
            "00_32_01_0005233441", 1, 2,0.00)
        val product4 = Product(0, "123444455500265", "Mi Tarjeta premium",
            "00_30_05_123444455500265", 5, 3,7000.00)
        products = listOf(product1,product2,product3,product4)

    }
}