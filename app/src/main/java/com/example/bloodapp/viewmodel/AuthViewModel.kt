package com.example.bloodapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bloodapp.data.model.User
import com.example.bloodapp.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val userRepository: UserRepository // Remove the val keyword
) : ViewModel() {

    private val _registrationState = MutableStateFlow<RegistrationState>(RegistrationState.Idle)
    val registrationState: StateFlow<RegistrationState> = _registrationState

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState

    fun registerUser(user: User) {
        viewModelScope.launch {
            _registrationState.value = RegistrationState.Loading
            try {
                // Use IO dispatcher for database operations
                val result = withContext(Dispatchers.IO) {
                    // Check if email already exists
                    val existingUser = userRepository.getUserByEmail(user.email)
                    if (existingUser != null) {
                        return@withContext RegistrationState.Error("Email already registered")
                    }

                    val userId = userRepository.registerUser(user)
                    if (userId > 0) {
                        RegistrationState.Success(userId)
                    } else {
                        RegistrationState.Error("Registration failed")
                    }
                }
                _registrationState.value = result
            } catch (e: Exception) {
                _registrationState.value = RegistrationState.Error(e.message ?: "Registration failed")
            }
        }
    }

    fun loginUser(email: String, password: String) {
        viewModelScope.launch {
            _loginState.value = LoginState.Loading
            try {
                // Use IO dispatcher for database operations
                val result = withContext(Dispatchers.IO) {
                    val user = userRepository.loginUser(email, password)
                    if (user != null) {
                        LoginState.Success(user)
                    } else {
                        LoginState.Error("Invalid email or password")
                    }
                }
                _loginState.value = result
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