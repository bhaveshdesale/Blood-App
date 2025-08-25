package com.example.bloodapp.ui.screens.request

// app/src/main/java/com/example/vitalconnect/ui/screens/request/HospitalDetailScreen.kt


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bloodapp.R
import com.example.bloodapp.ui.theme.LightGrayBg
import com.example.bloodapp.ui.theme.Red500
import com.example.bloodapp.ui.theme.TextGray


data class BloodUnit(
    val bloodType: String,
    val unitsAvailable: Int,
    val status: String = "Available" // Available, Low, Critical
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HospitalDetailScreen(navController: NavController, hospitalId: Int) {
    val hospital = remember(hospitalId) {
        // In real app, fetch from database based on hospitalId
        Hospital(
            id = hospitalId,
            name = "Vital Connect Hospital",
            type = "Hospital",
            address = "123 Health St, Cityville",
            phone = "+1 (555) 123-4567",
            distance = "2.5 km",
            rating = 4.8f,
            imageRes = R.drawable.ic_launcher_foreground
        )
    }

    val bloodUnits = remember {
        listOf(
            BloodUnit("A+", 15),
            BloodUnit("A-", 8),
            BloodUnit("B+", 12),
            BloodUnit("B-", 5),
            BloodUnit("AB+", 3),
            BloodUnit("AB-", 2),
            BloodUnit("O+", 20),
            BloodUnit("O-", 6)
        )
    }

    Scaffold(
        topBar = {
            HospitalDetailTopAppBar(navController, hospital.name)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White)
                .padding(16.dp)
        ) {
            // Hospital Info Card
            HospitalInfoCard(hospital)

            Spacer(modifier = Modifier.height(24.dp))

            // Blood Availability Section
            BloodAvailabilitySection(bloodUnits)

            Spacer(modifier = Modifier.height(32.dp))

            // Action Buttons
            ActionButtonsSection(navController, hospital)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HospitalDetailTopAppBar(navController: NavController, hospitalName: String) {
    TopAppBar(
        title = {
            Text(
                text = "Hospital Details",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White,
            titleContentColor = Color.Black,
            navigationIconContentColor = Color.Black
        )
    )
}

@Composable
fun HospitalInfoCard(hospital: Hospital) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            // Hospital Name
            Text(
                text = hospital.name,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Address
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Address",
                    tint = TextGray,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = hospital.address,
                    fontSize = 14.sp,
                    color = TextGray
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Phone
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = "Phone",
                    tint = TextGray,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = hospital.phone,
                    fontSize = 14.sp,
                    color = TextGray
                )
            }
        }
    }
}

@Composable
fun BloodAvailabilitySection(bloodUnits: List<BloodUnit>) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        // Section Title
        Text(
            text = "Blood Units Availability",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Divider
        Divider(
            color = LightGrayBg,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Blood Units Grid
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(bloodUnits.chunked(4)) { row ->
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    row.forEach { bloodUnit ->
                        BloodUnitCard(bloodUnit)
                    }
                }
            }
        }
    }
}

@Composable
fun BloodUnitCard(bloodUnit: BloodUnit) {
    val backgroundColor = when (bloodUnit.status) {
        "Low" -> Color(0xFFFFF3E0) // Orange tint
        "Critical" -> Color(0xFFFFEBEE) // Red tint
        else -> Color(0xFFE8F5E8) // Green tint
    }

    val textColor = when (bloodUnit.status) {
        "Low" -> Color(0xFFF57C00) // Orange
        "Critical" -> Color(0xFFD32F2F) // Red
        else -> Color(0xFF388E3C) // Green
    }

    Box(
        modifier = Modifier
            .width(80.dp)
            .height(80.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(backgroundColor)
            .border(
                width = 1.dp,
                color = textColor.copy(alpha = 0.3f),
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = bloodUnit.bloodType,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = textColor
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "${bloodUnit.unitsAvailable} units",
                fontSize = 12.sp,
                color = textColor
            )
        }
    }
}

@Composable
fun ActionButtonsSection(navController: NavController, hospital: Hospital) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Request Blood Button
        Button(
            onClick = {
                navController.navigate("request_blood_form/${hospital.id}")
            },
            modifier = Modifier
                .weight(1f)
                .height(56.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Red500,
                contentColor = Color.White
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 4.dp,
                pressedElevation = 2.dp
            )
        ) {
            Icon(
                imageVector = Icons.Default.Call,
                contentDescription = "Request Blood",
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Request Blood",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        // Call Button
        Button(
            onClick = {
                // Handle call action
            },
            modifier = Modifier
                .weight(1f)
                .height(56.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4CAF50),
                contentColor = Color.White
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 4.dp,
                pressedElevation = 2.dp
            )
        ) {
            Icon(
                imageVector = Icons.Default.Call,
                contentDescription = "Call",
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Call",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

// Update Hospital data class to include phone
