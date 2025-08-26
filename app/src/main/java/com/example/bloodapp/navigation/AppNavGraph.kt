package com.example.bloodapp.navigation

import com.example.bloodapp.ui.screens.Profile.ProfileScreen

// app/src/main/java/com/example/bloodapp/navigation/AppNavGraph.kt


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bloodapp.ui.screens.auth.LoginScreen
import com.example.bloodapp.ui.screens.auth.SignupScreen
import com.example.bloodapp.ui.screens.donation.CheckMyDonation
import com.example.bloodapp.ui.screens.donor.DonorFormScreen
import com.example.bloodapp.ui.screens.donor.DonorSuccessScreen
import com.example.bloodapp.ui.screens.history.HistoryScreen
import com.example.bloodapp.ui.screens.home.HomeScreen
import com.example.bloodapp.ui.screens.rare.RareBloodGroupScreen
import com.example.bloodapp.ui.screens.request.HospitalDetailScreen
import com.example.bloodapp.ui.screens.request.HospitalListScreen
import com.example.bloodapp.ui.screens.request.RequestBloodFormScreen
import com.example.bloodapp.ui.screens.request.RequestSuccessScreen
import com.example.bloodapp.ui.screens.splash.SplashScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Destinations.SPLASH_ROUTE
    ) {
        composable(Destinations.SPLASH_ROUTE) {
            SplashScreen(navController)
        }

        composable(Destinations.LOGIN_ROUTE) {
            LoginScreen(navController)
        }

        composable(Destinations.SIGNUP_ROUTE) {
            SignupScreen(navController)
        }

        composable(Destinations.HOME_ROUTE) {
            HomeScreen(navController)
        }

        composable(Destinations.DONOR_FORM_ROUTE) {
            DonorFormScreen(navController)
        }

        composable(Destinations.DONOR_SUCCESS_ROUTE) {
            DonorSuccessScreen(navController)
        }

        composable(Destinations.HOSPITAL_LIST_ROUTE) {
            HospitalListScreen(navController)
        }

        composable("${Destinations.HOSPITAL_DETAIL_ROUTE}/{hospitalId}") { backStackEntry ->
            val hospitalId = backStackEntry.arguments?.getString("hospitalId")?.toIntOrNull() ?: 0
            HospitalDetailScreen(navController, hospitalId)
        }

        composable("${Destinations.REQUEST_BLOOD_FORM_ROUTE}/{hospitalId}") { backStackEntry ->
            val hospitalId = backStackEntry.arguments?.getString("hospitalId")?.toIntOrNull() ?: 0
            RequestBloodFormScreen(navController, hospitalId)
        }

        composable(Destinations.REQUEST_SUCCESS_ROUTE) {
            RequestSuccessScreen(navController)
        }

        composable(Destinations.HISTORY_ROUTE) {
            HistoryScreen(navController)
        }

        composable(Destinations.RARE_GROUPS_ROUTE) {
            RareBloodGroupScreen(navController)
        }

        composable(Destinations.PROFILE_ROUTE) {
            ProfileScreen(navController)
        }
        composable(Destinations.CHECK_MY_DONATION_ROUTE) {
            CheckMyDonation(navController)
        }

    }
}