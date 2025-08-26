package com.example.bloodapp.ui.screens.history
// app/src/main/java/com/example/vitalconnect/ui/screens/history/HistoryScreen.kt

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bloodapp.R
import com.example.bloodapp.ui.screens.home.BottomNavigationBar
import com.example.bloodapp.ui.theme.LightGrayBg
import com.example.bloodapp.ui.theme.Red500
import com.example.bloodapp.ui.theme.TextGray


data class HistoryItem(
    val id: Int,
    val type: String, // "Donation" or "Request"
    val bloodType: String,
    val date: String,
    val units: Int,
    val hospital: String,
    val status: String? = null // For donation status if needed
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
//@Preview(showSystemUi = true)
fun HistoryScreen(navigatonController: NavController) {
    val historyItems = remember {
        listOf(
            HistoryItem(
                id = 1,
                type = "Donation",
                bloodType = "O+",
                date = "2023-11-15",
                units = 2,
                hospital = "City General"
            ),
            HistoryItem(
                id = 2,
                type = "Request",
                bloodType = "AB-",
                date = "2023-10-20",
                units = 1,
                hospital = "County Medical"
            ),
            HistoryItem(
                id = 3,
                type = "Donation",
                bloodType = "A-",
                date = "2023-09-05",
                units = 3,
                hospital = "State Clinic"
            ),
            HistoryItem(
                id = 4,
                type = "Request",
                bloodType = "B+",
                date = "2023-08-12",
                units = 2,
                hospital = "Regional Center"
            ),
            HistoryItem(
                id = 5,
                type = "Donation",
                bloodType = "O-",
                date = "2023-07-28",
                units = 1,
                hospital = "Community Hospital"
            ),
            HistoryItem(
                id = 5,
                type = "Donation",
                bloodType = "O-",
                date = "2023-07-28",
                units = 1,
                hospital = "Community Hospital"
            )
        )
    }

    Scaffold(
        topBar = {
            HistoryTopAppBar(navigatonController)
        },
        bottomBar = {
//            HistoryBottomNavigation(navigatonController)
            BottomNavigationBar(navigatonController)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White)
        ) {
            // Header
//            Text(
//                text = "History",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 24.dp, vertical = 20.dp),
//                fontSize = 24.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color.Black
//            )

            // History List
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(historyItems) { item ->
                    HistoryCard(historyItem = item)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryTopAppBar(navigationController: NavController) {
    TopAppBar(
        title = {
            Text(
                text = "History",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        },
        navigationIcon = {
            IconButton(onClick = {
                navigationController.popBackStack()
            }) {
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
fun HistoryCard(historyItem: HistoryItem) {
    val backgroundColor = when (historyItem.type) {
        "Donation" -> Color(0xFFE8F5E8) // Light green for donations
        "Request" -> Color(0xFFFFF3E0) // Light orange for requests
        else -> LightGrayBg
    }

    val borderColor = when (historyItem.type) {
        "Donation" -> Color(0xFF4CAF50) // Green border
        "Request" -> Color(0xFFFF9800) // Orange border
        else -> TextGray
    }

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Type Icon
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(borderColor.copy(alpha = 0.2f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id=R.drawable.mukesh),
                    contentDescription = historyItem.type,
                    tint = borderColor,
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            // History Details
            Column(
                modifier = Modifier.weight(1f)
            ) {
                // Type and Blood Type
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = historyItem.type,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = borderColor
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "•",
                        color = TextGray,
                        fontSize = 16.sp
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Blood Type: ${historyItem.bloodType}",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Date and Units
                Text(
                    text = "Date: ${historyItem.date} | Units: ${historyItem.units}",
                    fontSize = 12.sp,
                    color = TextGray
                )

                Spacer(modifier = Modifier.height(4.dp))

                // Hospital
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Hospital",
                        tint = TextGray,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Hospital: ${historyItem.hospital}",
                        fontSize = 12.sp,
                        color = TextGray
                    )
                }
            }
        }
    }
}
//
//@Composable
//fun HistoryBottomNavigation(navigationController: NavController) {
//    Surface(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(Color.White),
//        color = Color.White
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(vertical = 12.dp),
//            horizontalArrangement = Arrangement.SpaceAround,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            BottomNavItem(
//                icon = R.drawable.baseline_home_24,
//                label = "Check my donation",
//                isSelected = false,
//                onClick = {
//                    navigationController.navigate("check_donation")
//                }
//            )
//            BottomNavItem(
//                icon = R.drawable.baseline_chat_24,
//                label = "Rare blood type",
//                isSelected = false,
//                onClick = {
//                    navigationController.navigate("rare_groups")
//                }
//            )
//            BottomNavItem(
//                icon = R.drawable.baseline_history_24,
//                label = "History",
//                isSelected = true, // Current screen is active
//                onClick = { /* Already on history screen */ }
//            )
//        }
//    }
//}
//
//@Composable
//fun BottomNavItem(icon: Int, label: String, isSelected: Boolean, onClick: () -> Unit) {
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier
//            .clickable { onClick() }
//            .padding(8.dp)
//            .width(80.dp)
//    ) {
//        Icon(
//            painter = painterResource(id = icon),
//            contentDescription = label,
//            tint = if (isSelected) Red500 else TextGray,
//            modifier = Modifier.size(24.dp)
//        )
//        Spacer(modifier = Modifier.height(4.dp))
//        Text(
//            text = label,
//            color = if (isSelected) Red500 else TextGray,
//            fontSize = 10.sp,
//            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
//            textAlign = TextAlign.Center,
//            maxLines = 2
//        )
//    }
//}

