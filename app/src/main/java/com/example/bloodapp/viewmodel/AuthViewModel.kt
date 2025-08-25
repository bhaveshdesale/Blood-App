package com.example.bloodapp.viewmodel

// app/src/main/java/com/example/bloodapp/ui/viewmodels/AuthViewModel.kt


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bloodapp.data.model.User
import com.example.bloodapp.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel(private val userRepository: UserRepository) : ViewModel() {

    private val _registrationState = MutableStateFlow<RegistrationState>(RegistrationState.Idle)
    val registrationState: StateFlow<RegistrationState> = _registrationState

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState

    fun registerUser(user: User) {
        viewModelScope.launch {
            _registrationState.value = RegistrationState.Loading
            try {
                // Check if email already exists
                val existingUser = userRepository.getUserByEmail(user.email)
                if (existingUser != null) {
                    _registrationState.value = RegistrationState.Error("Email already registered")
                    return@launch
                }

                val userId = userRepository.registerUser(user)
                if (userId > 0) {
                    _registrationState.value = RegistrationState.Success(userId)
                } else {
                    _registrationState.value = RegistrationState.Error("Registration failed")
                }
            } catch (e: Exception) {
                _registrationState.value = RegistrationState.Error(e.message ?: "Registration failed")
            }
        }
    }

    fun loginUser(email: String, password: String) {
        viewModelScope.launch {
            _loginState.value = LoginState.Loading
            try {
                val user = userRepository.loginUser(email, password)
                if (user != null) {
                    _loginState.value = LoginState.Success(user)
                } else {
                    _loginState.value = LoginState.Error("Invalid email or password")
                }
            } catch (e: Exception) {
                _loginState.value = LoginState.Error(e.message ?: "Login failed")
            }
        }
    }

    sealed class RegistrationState {
        object Idle : RegistrationState()
        object Loading : RegistrationState()
        data class Success(val userId: Long) : RegistrationState()
        data class Error(val message: String) : RegistrationState()
    }

    sealed class LoginState {
        object Idle : LoginState()
        object Loading : LoginState()
        data class Success(val user: User) : LoginState()
        data class Error(val message: String) : LoginState()
    }
}