package com.defey.testcourse.login.ui

import android.content.Intent
import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import com.defey.testcourse.navigation.FlowRouter
import com.defey.testcourse.navigation.RootScreen
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel @Inject constructor(
    private val router: FlowRouter,
) : ViewModel() {

    private val _state = MutableStateFlow(LoginUiContract.State())
    val state get() = _state.asStateFlow()

    fun handleEvent(event: LoginUiContract.Event) {
        when (event) {
            LoginUiContract.Event.OnCourses -> router.navigateNewRootScreen(RootScreen.COURSES_SCREEN)
            is LoginUiContract.Event.UpdateEmail -> {
                _state.update { it.copy(email = event.email) }
                updateFormByEvent()
            }

            is LoginUiContract.Event.UpdatePassword -> {
                _state.update { it.copy(password = event.password) }
                updateFormByEvent()
            }

            LoginUiContract.Event.NavigateToOk -> navigateTo(OK)
            LoginUiContract.Event.NavigateToVk -> navigateTo(VK)
        }
    }

    private fun updateFormByEvent() {
        val currentEmail = state.value.email
        val currentPassword = state.value.password
        val validEmail = isValidEmail(currentEmail)
        val validPassword = currentPassword.isNullOrBlank().not()
        val loginAvailable = validEmail && validPassword
        _state.update { it.copy(isLoginAvailable = loginAvailable) }
    }

    private fun isValidEmail(email: String?): Boolean {
        val emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$".toRegex()
        return email?.matches(emailRegex) ?: false
    }

    private fun navigateTo(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, url.toUri())
        router.navigateToActivityByIntent(intent)
    }

    companion object {
        private const val VK = "https://vk.com/"
        private const val OK = "https://ok.ru/"
    }
}