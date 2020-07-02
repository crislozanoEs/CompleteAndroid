package com.example.completeandroidknowledge.section1.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.completeandroidknowledge.commons.dialogs.DialogEventBus
import com.example.completeandroidknowledge.commons.dialogs.DialogManager
import com.example.completeandroidknowledge.commons.dialogs.optionsDialog.OptionDialogEvent
import com.example.completeandroidknowledge.section1.model.*
import com.example.completeandroidknowledge.network.sessionServices.SessionServicesUseCase
import com.example.completeandroidknowledge.repository.userDatabase.UserDatabaseUseCaseImpl

class UserViewModel(user: User,
                    private val userDatabaseUseCaseImpl: UserDatabaseUseCaseImpl,
                    private val sessionServicesUseCase: SessionServicesUseCase,
                    private val dialogManager: DialogManager,
                    private val dialogEventBus: DialogEventBus):
    ViewModel(),
    SessionServicesUseCase.Listener,
    DialogEventBus.Listener,
    UserDatabaseUseCaseImpl.Listener{

    private var actualState: STATES = STATES.IDLE
    enum class STATES{
        IDLE, LOADING, LOGIN_SUCCEED, LOGIN_FAIL
    }

    private var _navigationToMainFlag = MutableLiveData<Boolean>()

    val navigationToMainFlag: LiveData<Boolean>
        get() = _navigationToMainFlag

    private var _clearPasswordFlag = MutableLiveData<Boolean>()

    val clearPasswordFlag: LiveData<Boolean>
        get() = _clearPasswordFlag

    private var _user = MutableLiveData<User>()

    val user: LiveData<User>
        get() = _user

    init{
        _user.value = user
        userDatabaseUseCaseImpl.registerListener(this)
        sessionServicesUseCase.registerListener(this)
        dialogEventBus.registerListener(this)
    }


    override fun onCleared() {
        super.onCleared()
        sessionServicesUseCase.unregisterListener(this)
        sessionServicesUseCase.getJobObject().cancel()
        dialogEventBus.unregisterListener(this)
    }

    fun doneClearingPassword(){
        _clearPasswordFlag.value = false
    }
    fun doneNavigation(){
        _navigationToMainFlag.value = false
    }
    override fun loginSucceed(user: User) {
        actualState = STATES.LOGIN_SUCCEED
        _user.value?.apply {
            this.userCompleteName = user.userCompleteName
            this.userDocument = user.userDocument
            this.userImageSecure = user.userImageSecure
            this.userLastSessionDateString = user.userLastSessionDateString
            this.userSessionInactivity = user.userSessionInactivity
            this.userSessionRefresh = user.userSessionRefresh
            this.userSessionInactivity = user.userSessionInactivity
            this.userType = user.userType
            this.userTypeBank = user.userTypeBank
        }
        userDatabaseUseCaseImpl.initUpdateUser(_user.value)
    }

    override fun loginFailed() {
        actualState = STATES.LOGIN_FAIL
        dialogManager.showErrorOnlyTwoAction(null, "ERROR LOGIN","Fallo el login","Intentar","Cerrar")
    }

    fun executeLoginService() {
        actualState = STATES.LOADING
        sessionServicesUseCase.executeLogin()
    }

    override fun onDialogEvent(event: Any) {
        if(event is OptionDialogEvent){
            val eventDialog = event as OptionDialogEvent
            when(eventDialog.getClickedButton()){
                OptionDialogEvent.Button.POSITIVE -> executeLoginService()
                OptionDialogEvent.Button.NEGATIVE -> {
                    _user.value?.apply {
                        this.userPassword = ""
                    }
                    _clearPasswordFlag.value = true
                }
            }
        }
    }

    override fun onUserRetrieved(user: User?) {
        //This method is not used in this fragment
    }

    override fun onUserUpdated() {
        _navigationToMainFlag.value = true
    }
}