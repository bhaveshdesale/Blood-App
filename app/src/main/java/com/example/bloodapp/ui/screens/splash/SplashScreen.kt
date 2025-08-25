package com.example.bloodapp.ui.screens.splash

// app/src/main/java/com/example/vitalconnect/ui/screens/splash/SplashScreen.kt

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.bloodapp.navigation.Destinations

import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    // Navigation effect after delay
    LaunchedEffect(Unit) {
        delay(2000) // 2 seconds delay
        navController.navigate(Destinations.LOGIN_ROUTE) // Or your desired route
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF44336)), // Red-500
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
//            Icon(
////                painter= painterResource(id=Int), // You'll need to add this icon
//                contentDescription = "Blood Type Icon",
//                tint = Color.White,
//                modifier = Modifier.size(72.dp)
//            )

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Vital Connect",
                color = Color.White,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Connecting Every drop Right on Time",
                color = Color.White,
                fontSize = 18.sp
            )
        }
    }
}