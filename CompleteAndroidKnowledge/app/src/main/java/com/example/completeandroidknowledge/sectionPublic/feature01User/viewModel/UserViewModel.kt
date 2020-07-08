package com.example.completeandroidknowledge.sectionPublic.feature01User.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.completeandroidknowledge.commons.dialogs.DialogEventBus
import com.example.completeandroidknowledge.commons.dialogs.DialogManager
import com.example.completeandroidknowledge.commons.dialogs.optionsDialog.OptionDialogEvent
import com.example.completeandroidknowledge.sectionPublic.model.*
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

    enum class STATES{
        IDLE, LOADING, LOGIN_SUCCEED, LOGIN_FAIL
    }

    private var _navigationToMainFlag = MutableLiveData<Boolean>()

    val navigationToMainFlag: LiveData<Boolean>
        get() = _navigationToMainFlag

    private var _clearPasswordFlag = MutableLiveData<Boolean>()

    private var _actualState = MutableLiveData<STATES>()

    val actualState: LiveData<STATES>
        get() = _actualState

    val clearPasswordFlag: LiveData<Boolean>
        get() = _clearPasswordFlag

    private var _user = MutableLiveData<User>()

    val user: LiveData<User>
        get() = _user

    init{
        _user.value = user
        _actualState.value =
            STATES.IDLE
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
        _actualState.postValue(STATES.LOGIN_SUCCEED)
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
        _actualState.postValue(STATES.LOGIN_FAIL)
        dialogManager.showErrorOnlyTwoAction(null, "ERROR LOGIN","Fallo el login","Intentar","Cerrar")
    }

    fun executeLoginService() {
        _actualState.value =
            STATES.LOADING
        sessionServicesUseCase.executeLogin()
    }

    override fun onDialogEvent(event: Any) {
        if(event is OptionDialogEvent){
            when(event.getClickedButton()){
                OptionDialogEvent.Button.POSITIVE -> executeLoginService()
                OptionDialogEvent.Button.NEGATIVE -> {
                    _user.value?.userPassword = ""
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