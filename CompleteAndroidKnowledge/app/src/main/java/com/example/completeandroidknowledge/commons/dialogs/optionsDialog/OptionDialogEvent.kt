package com.example.completeandroidknowledge.commons.dialogs.optionsDialog

class OptionDialogEvent(private var clickedButton: Button) {

    enum class Button{
        NEGATIVE, POSITIVE
    }
    fun getClickedButton(): Button = clickedButton
}