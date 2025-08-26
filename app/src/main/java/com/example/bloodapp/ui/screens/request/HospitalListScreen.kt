//package com.example.bloodapp.ui.screens.request
//
//// app/src/main/java/com/example/vitalconnect/ui/screens/request/HospitalListScreen.kt
//
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material.icons.filled.ArrowDropDown
//import androidx.compose.material.icons.filled.Home
//import androidx.compose.material.icons.filled.LocationOn
//import androidx.compose.material.icons.filled.Search
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextFieldDefaults
//import androidx.compose.material3.TopAppBar
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import com.example.bloodapp.R
//import com.example.bloodapp.ui.theme.LightGrayBg
//import com.example.bloodapp.ui.theme.Red500
//import com.example.bloodapp.ui.theme.TextGray
//
//
//data class Hospital(
//    val id: Int,
//    val name: String,
//    val type: String, // "Hospital" or "Blood Bank"
//    val address: String,
//    val distance: String,
//    val phone:String,
//    val rating: Float,
//    val imageRes: Int
//)
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun HospitalListScreen(navController: NavController) {
//    val searchQuery = remember { mutableStateOf("") }
//    val hospitals = remember {
//        listOf(
//            Hospital(
//                id = 1,
//                name = "Indira Gandhi Memorial Hospital",
//                type = "Hospital",
//                address = "Shirpur",
//                distance = "2.5 km",
//                rating = 4.5f,
//                imageRes = R.drawable.ic_launcher_foreground,
//                phone = "1234567890"
//            ),
//            Hospital(
//                id = 2,
//                name = "Late Shri Mukeshbhai Patel Blood Bank",
//                type = "Blood Bank",
//                address = "456 Oak Avenue, Mumbai",
//                distance = "3.2 km",
//                rating = 4.8f,
//                imageRes = R.drawable.ic_launcher_foreground,
//                phone = "1234567890"
//
//            ),
//            Hospital(
//                id = 3,
//                name = "Community Health Clinic",
//                type = "Hospital",
//                address = "789 Pine Road, Mumbai",
//                distance = "1.8 km",
//                rating = 4.2f,
//                imageRes = R.drawable.ic_launcher_foreground,
//                phone = "1234567890"
//
//            ),
//            Hospital(
//                id = 4,
//                name = "St. Jude's Medical Center",
//                type = "Hospital",
//                address = "321 Elm Street, Mumbai",
//                distance = "4.1 km",
//                rating = 4.7f,
//                imageRes = R.drawable.ic_launcher_foreground,
//                phone = "1234567890"
//
//            ),
//            Hospital(
//                id = 5,
//                name = "Lifelood Transfusion",
//                type = "Blood Bank",
//                address = "654 Maple Lane, Mumbai",
//                distance = "2.9 km",
//                rating = 4.6f,
//                imageRes = R.drawable.ic_launcher_background,
//                phone = "1234567890"
//
//            )
//        )
//    }
//
//    Scaffold(
//        topBar = {
//            HospitalListTopAppBar(navController)
//        }
//    ) { innerPadding ->
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(innerPadding)
//                .background(Color.White)
//        ) {
//            // Header
//            Text(
//                text = "Choose Hospital or Blood Bank",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 24.dp, vertical = 16.dp),
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color.Black
//            )
//
//            // Search Bar
//            SearchBarSection(searchQuery)
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            // Hospital List
//            LazyColumn(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .weight(1f)
//                    .padding(horizontal = 16.dp),
//                verticalArrangement = Arrangement.spacedBy(12.dp)
//            ) {
//                items(hospitals) { hospital ->
//                    HospitalCard(
//                        hospital = hospital,
//                        onItemClick = {
//                            navController.navigate("hospital_detail/${hospital.id}")
//                        }
//                    )
//                }
//            }
//
//            Spacer(modifier = Modifier.height(16.dp))
//        }
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun HospitalListTopAppBar(navController: NavController) {
//    TopAppBar(
//        title = {
//            Text(
//                text = "Request Blood",
//                fontWeight = FontWeight.Bold,
//                fontSize = 18.sp
//            )
//        },
//        navigationIcon = {
//            IconButton(onClick = { navController.popBackStack() }) {
//                Icon(
//                    imageVector = Icons.Default.ArrowBack,
//                    contentDescription = "Back"
//                )
//            }
//        },
//        colors = TopAppBarDefaults.topAppBarColors(
//            containerColor = Color.White,
//            titleContentColor = Color.Black,
//            navigationIconContentColor = Color.Black
//        )
//    )
//}
//
//@Composable
//fun SearchBarSection(searchQuery: androidx.compose.runtime.MutableState<String>) {
//    Surface(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 16.dp),
//        shape = RoundedCornerShape(12.dp),
//        color = LightGrayBg
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 16.dp, vertical = 14.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Icon(
//                imageVector = Icons.Default.Search,
//                contentDescription = "Search",
//                tint = TextGray,
//                modifier = Modifier.size(20.dp)
//            )
//            Spacer(modifier = Modifier.width(12.dp))
//            Text(
//                text = "Search hospitals or blood banks",
//                color = TextGray,
//                fontSize = 14.sp
//            )
//        }
//    }
//}
//
//@Composable
//fun HospitalCard(hospital: Hospital, onItemClick: () -> Unit) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .clickable(onClick = onItemClick),
//        shape = RoundedCornerShape(16.dp),
//        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
//        colors = CardDefaults.cardColors(containerColor = Color.White)
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            // Hospital Image/Icon
//            Box(
//                modifier = Modifier
//                    .size(60.dp)
//                    .clip(RoundedCornerShape(12.dp))
//                    .background(if (hospital.type == "Hospital") Color(0xFFE3F2FD) else Color(0xFFFFEBEE)),
//                contentAlignment = Alignment.Center
//            ) {
//                Icon(
//                    imageVector = Icons.Default.Home,
//                    contentDescription = hospital.type,
//                    tint = if (hospital.type == "Hospital") Color(0xFF1976D2) else Red500,
//                    modifier = Modifier.size(30.dp)
//                )
//            }
//
//            Spacer(modifier = Modifier.width(16.dp))
//
//            // Hospital Details
//            Column(
//                modifier = Modifier.weight(1f)
//            ) {
//                Text(
//                    text = hospital.name,
//                    fontSize = 16.sp,
//                    fontWeight = FontWeight.Bold,
//                    color = Color.Black
//                )
//
//                Spacer(modifier = Modifier.height(4.dp))
//
//                Row(
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Icon(
//                        imageVector = Icons.Default.LocationOn,
//                        contentDescription = "Location",
//                        tint = TextGray,
//                        modifier = Modifier.size(14.dp)
//                    )
//                    Spacer(modifier = Modifier.width(4.dp))
//                    Text(
//                        text = hospital.address,
//                        fontSize = 12.sp,
//                        color = TextGray,
//                        maxLines = 1
//                    )
//                }
//
//                Spacer(modifier = Modifier.height(4.dp))
//
//                Text(
//                    text = "${hospital.distance} • ${hospital.type}",
//                    fontSize = 12.sp,
//                    color = TextGray
//                )
//            }
//
//            // Rating and Distance
//            Column(
//                horizontalAlignment = Alignment.End
//            ) {
//                // Rating
//                Row(
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.baseline_arrow_back_24),
//                        contentDescription = "Rating",
//                        tint = Color(0xFFFFC107),
//                        modifier = Modifier.size(14.dp)
//                    )
//                    Spacer(modifier = Modifier.width(2.dp))
//                    Text(
//                        text = hospital.rating.toString(),
//                        fontSize = 12.sp,
//                        fontWeight = FontWeight.Bold,
//                        color = Color.Black
//                    )
//                }
//
//                Spacer(modifier = Modifier.height(8.dp))
//
//                // Distance
//                Text(
//                    text = hospital.distance,
//                    fontSize = 12.sp,
//                    color = TextGray
//                )
//            }
//        }
//    }
//}
//
//package com.example.bloodapp.ui.screens.request
//
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.ArrowBack
//import androidx.compose.material.icons.filled.Home
//import androidx.compose.material.icons.filled.LocationOn
//import androidx.compose.material.icons.filled.Search
//import androidx.compose.material3.*
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import com.example.bloodapp.R
//import com.example.bloodapp.ui.screens.home.HospitalCard
//import com.example.bloodapp.ui.theme.LightGrayBg
//import com.example.bloodapp.ui.theme.Red500
//import com.example.bloodapp.ui.theme.TextGray
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun HospitalListScreen(navController: NavController) {
//    val searchQuery = remember { mutableStateOf("") }
//    val hospitals = remember {
//        listOf(
//            Hospital(
//                id = 1,
//                name = "Indira Gandhi Memorial Hospital",
//                type = "Hospital",
//                address = "Shirpur",
//                distance = "2.5 km",
//                rating = 4.5f,
//                imageRes = R.drawable.ic_launcher_foreground,
//                phone = "1234567890"
//            ),
//            Hospital(
//                id = 2,
//                name = "Late Shri Mukeshbhai Patel Blood Bank",
//                type = "Blood Bank",
//                address = "456 Oak Avenue, Mumbai",
//                distance = "3.2 km",
//                rating = 4.8f,
//                imageRes = R.drawable.ic_launcher_foreground,
//                phone = "1234567890"
//            ),
//            Hospital(
//                id = 3,
//                name = "Community Health Clinic",
//                type = "Hospital",
//                address = "789 Pine Road, Mumbai",
//                distance = "1.8 km",
//                rating = 4.2f,
//                imageRes = R.drawable.ic_launcher_foreground,
//                phone = "1234567890"
//            ),
//            Hospital(
//                id = 4,
//                name = "St. Jude's Medical Center",
//                type = "Hospital",
//                address = "321 Elm Street, Mumbai",
//                distance = "4.1 km",
//                rating = 4.7f,
//                imageRes = R.drawable.ic_launcher_foreground,
//                phone = "1234567890"
//            ),
//            Hospital(
//                id = 5,
//                name = "Lifelood Transfusion",
//                type = "Blood Bank",
//                address = "654 Maple Lane, Mumbai",
//                distance = "2.9 km",
//                rating = 4.6f,
//                imageRes = R.drawable.ic_launcher_background,
//                phone = "1234567890"
//            )
//        )
//    }
//
//    val filteredHospitals = remember(searchQuery.value) {
//        if (searchQuery.value.isEmpty()) {
//            hospitals
//        } else {
//            hospitals.filter { hospital ->
//                hospital.name.contains(searchQuery.value, ignoreCase = true) ||
//                        hospital.address.contains(searchQuery.value, ignoreCase = true) ||
//                        hospital.type.contains(searchQuery.value, ignoreCase = true)
//            }
//        }
//    }
//
//    Scaffold(
//        topBar = {
//            HospitalListTopAppBar(navController)
//        }
//    ) { innerPadding ->
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(innerPadding)
//                .background(Color.White)
//        ) {
//            // Header
//            Text(
//                text = "Choose Hospital or Blood Bank",
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 24.dp, vertical = 16.dp),
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold,
//                color = Color.Black
//            )
//
//            // Search Bar with functional search
//            Surface(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 16.dp),
//                shape = RoundedCornerShape(12.dp),
//                color = LightGrayBg
//            ) {
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(horizontal = 16.dp, vertical = 14.dp),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Icon(
//                        imageVector = Icons.Default.Search,
//                        contentDescription = "Search",
//                        tint = TextGray,
//                        modifier = Modifier.size(20.dp)
//                    )
//                    Spacer(modifier = Modifier.width(12.dp))
//                    OutlinedTextField(
//                        value = searchQuery.value,
//                        onValueChange = { searchQuery.value = it },
//                        modifier = Modifier.weight(1f),
//                        placeholder = {
//                            Text(
//                                "Search hospitals or blood banks",
//                                color = TextGray,
//                                fontSize = 14.sp
//                            )
//                        },
//                        singleLine = true,
//                        colors = TextFieldDefaults.outlinedTextFieldColors(
//                            focusedBorderColor = Color.Transparent,
//                            unfocusedBorderColor = Color.Transparent,
//                            containerColor = Color.Transparent
//                        )
//                    )
//                }
//            }
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            // Hospital List with search filtering
//            LazyColumn(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .weight(1f)
//                    .padding(horizontal = 16.dp),
//                verticalArrangement = Arrangement.spacedBy(12.dp)
//            ) {
//                if (filteredHospitals.isEmpty() && searchQuery.value.isNotEmpty()) {
//                    item {
//                        Box(
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(32.dp),
//                            contentAlignment = Alignment.Center
//                        ) {
//                            Text(
//                                text = "No results found for \"${searchQuery.value}\"",
//                                color = TextGray,
//                                fontSize = 16.sp
//                            )
//                        }
//                    }
//                } else {
//                    items(filteredHospitals) { hospital ->
//                        HospitalCard(
//                            hospital = hospital,
//                            onItemClick = {
//                                navController.navigate("hospital_detail/${hospital.id}")
//                            }
//                        )
//                    }
//                }
//            }
//
//            Spacer(modifier = Modifier.height(16.dp))
//        }
//    }
//}
//data class Hospital(
//    val id: Int,
//    val name: String,
//    val type: String, // "Hospital" or "Blood Bank"
//    val address: String,
//    val distance: String,
//    val phone:String,
//    val rating: Float,
//    val imageRes: Int
//)
//// The rest of your HospitalListScreen code remains unchanged...
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun HospitalListTopAppBar(navController: NavController) {
//    TopAppBar(
//        title = {
//            Text(
//                text = "Request Blood",
//                fontWeight = FontWeight.Bold,
//                fontSize = 18.sp
//            )
//        },
//        navigationIcon = {
//            IconButton(onClick = { navController.popBackStack() }) {
//                Icon(
//                    imageVector = Icons.Default.ArrowBack,
//                    contentDescription = "Back"
//                )
//            }
//        },
//        colors = TopAppBarDefaults.topAppBarColors(
//            containerColor = Color.White,
//            titleContentColor = Color.Black,
//            navigationIconContentColor = Color.Black
//        )
//    )
//}
//
//@Composable
//fun SearchBarSection(searchQuery: androidx.compose.runtime.MutableState<String>) {
//    Surface(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 16.dp),
//        shape = RoundedCornerShape(12.dp),
//        color = LightGrayBg
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 16.dp, vertical = 14.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            Icon(
//                imageVector = Icons.Default.Search,
//                contentDescription = "Search",
//                tint = TextGray,
//                modifier = Modifier.size(20.dp)
//            )
//            Spacer(modifier = Modifier.width(12.dp))
//            Text(
//                text = "Search hospitals or blood banks",
//                color = TextGray,
//                fontSize = 14.sp
//            )
//        }
//    }
//}
//
//@Composable
//fun HospitalCard(hospital: Hospital, onItemClick: () -> Unit) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .clickable(onClick = onItemClick),
//        shape = RoundedCornerShape(16.dp),
//        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
//        colors = CardDefaults.cardColors(containerColor = Color.White)
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            // Hospital Image/Icon
//            Box(
//                modifier = Modifier
//                    .size(60.dp)
//                    .clip(RoundedCornerShape(12.dp))
//                    .background(if (hospital.type == "Hospital") Color(0xFFE3F2FD) else Color(0xFFFFEBEE)),
//                contentAlignment = Alignment.Center
//            ) {
//                Icon(
//                    imageVector = Icons.Default.Home,
//                    contentDescription = hospital.type,
//                    tint = if (hospital.type == "Hospital") Color(0xFF1976D2) else Red500,
//                    modifier = Modifier.size(30.dp)
//                )
//            }
//
//            Spacer(modifier = Modifier.width(16.dp))
//
//            // Hospital Details
//            Column(
//                modifier = Modifier.weight(1f)
//            ) {
//                Text(
//                    text = hospital.name,
//                    fontSize = 16.sp,
//                    fontWeight = FontWeight.Bold,
//                    color = Color.Black
//                )
//
//                Spacer(modifier = Modifier.height(4.dp))
//
//                Row(
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Icon(
//                        imageVector = Icons.Default.LocationOn,
//                        contentDescription = "Location",
//                        tint = TextGray,
//                        modifier = Modifier.size(14.dp)
//                    )
//                    Spacer(modifier = Modifier.width(4.dp))
//                    Text(
//                        text = hospital.address,
//                        fontSize = 12.sp,
//                        color = TextGray,
//                        maxLines = 1
//                    )
//                }
//
//                Spacer(modifier = Modifier.height(4.dp))
//
//                Text(
//                    text = "${hospital.distance} • ${hospital.type}",
//                    fontSize = 12.sp,
//                    color = TextGray
//                )
//            }
//
//            // Rating and Distance
//            Column(
//                horizontalAlignment = Alignment.End
//            ) {
//                // Rating
//                Row(
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.baseline_arrow_back_24),
//                        contentDescription = "Rating",
//                        tint = Color(0xFFFFC107),
//                        modifier = Modifier.size(14.dp)
//                    )
//                    Spacer(modifier = Modifier.width(2.dp))
//                    Text(
//                        text = hospital.rating.toString(),
//                        fontSize = 12.sp,
//                        fontWeight = FontWeight.Bold,
//                        color = Color.Black
//                    )
//                }
//
//                Spacer(modifier = Modifier.height(8.dp))
//
//                // Distance
//                Text(
//                    text = hospital.distance,
//                    fontSize = 12.sp,
//                    color = TextGray
//                )
//            }
//        }
//    }
//}
//give me whole updated for the two files


package com.example.bloodapp.ui.screens.request

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.bloodapp.R
import com.example.bloodapp.ui.theme.LightGrayBg
import com.example.bloodapp.ui.theme.Red500
import com.example.bloodapp.ui.theme.TextGray

data class Hospital(
    val id: Int,
    val name: String,
    val type: String, // "Hospital" or "Blood Bank"
    val address: String,
    val distance: String,
    val phone: String,
    val rating: Float,
    val imageRes: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun HospitalListScreen(navController: NavController) {
    val searchQuery = remember { mutableStateOf("") }
    val hospitals = remember {
        listOf(
            Hospital(
                id = 1,
                name = "Indira Gandhi Memorial Hospital",
                type = "Hospital",
                address = "Shirpur",
                distance = "2.5 km",
                rating = 4.5f,
                imageRes = R.drawable.indira,
                phone = "1234567890"
            ),
            Hospital(
                id = 2,
                name = "Late Shri Mukeshbhai Patel Blood Bank",
                type = "Blood Bank",
                address = "456 Oak Avenue, Mumbai",
                distance = "3.2 km",
                rating = 4.8f,
                imageRes = R.drawable.mukesh,
                phone = "1234567890"
            ),
            Hospital(
                id = 3,
                name = "Indira Gandhi Memorial Hospital",
                type = "Hospital",
                address = "789 Pine Road, Mumbai",
                distance = "1.8 km",
                rating = 4.2f,
                imageRes = R.drawable.indira,
                phone = "1234567890"
            ),
            Hospital(
                id = 4,
                name = "St. Jude's Medical Center",
                type = "Hospital",
                address = "321 Elm Street, Mumbai",
                distance = "4.1 km",
                rating = 4.7f,
                imageRes = R.drawable.mukesh,
                phone = "1234567890"
            ),
            Hospital(
                id = 5,
                name = "Lifelood Transfusion",
                type = "Blood Bank",
                address = "654 Maple Lane, Mumbai",
                distance = "2.9 km",
                rating = 4.6f,
                imageRes = R.drawable.indira,
                phone = "1234567890"
            )
        )
    }

    val filteredHospitals = remember(searchQuery.value) {
        if (searchQuery.value.isEmpty()) {
            hospitals
        } else {
            hospitals.filter { hospital ->
                hospital.name.contains(searchQuery.value, ignoreCase = true) ||
                        hospital.address.contains(searchQuery.value, ignoreCase = true) ||
                        hospital.type.contains(searchQuery.value, ignoreCase = true)
            }
        }
    }

    Scaffold(
        topBar = {
            HospitalListTopAppBar(navController)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White)
        ) {
            // Search Bar - Only one search field
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                shape = RoundedCornerShape(12.dp),
                color = LightGrayBg
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = TextGray,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    OutlinedTextField(
                        value = searchQuery.value,
                        onValueChange = { searchQuery.value = it },
                        modifier = Modifier.weight(1f),
                        placeholder = {
                            Text(
                                "Search hospitals or blood banks",
                                color = TextGray,
                                fontSize = 14.sp
                            )
                        },
                        singleLine = true,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.Transparent,
                            unfocusedBorderColor = Color.Transparent,
                            containerColor = Color.Transparent
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Hospital List with search filtering
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                if (filteredHospitals.isEmpty() && searchQuery.value.isNotEmpty()) {
                    item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(32.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "No results found for \"${searchQuery.value}\"",
                                color = TextGray,
                                fontSize = 16.sp
                            )
                        }
                    }
                } else {
                    items(filteredHospitals) { hospital ->
                        HospitalCard(
                            hospital = hospital,
                            onItemClick = {
                                navController.navigate("hospital_detail/${hospital.id}")
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HospitalListTopAppBar(navController: NavController) {
    TopAppBar(
        title = {
            Text(
                text = "Request Blood",
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
fun HospitalCard(hospital: Hospital, onItemClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onItemClick),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Hospital Image - Using the actual drawable resource
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = hospital.imageRes),
                    contentDescription = hospital.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Hospital Details
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = hospital.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(4.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = "Location",
                        tint = TextGray,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = hospital.address,
                        fontSize = 12.sp,
                        color = TextGray,
                        maxLines = 1
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "${hospital.distance} • ${hospital.type}",
                    fontSize = 12.sp,
                    color = TextGray
                )
            }

            // Rating and Distance
            Column(
                horizontalAlignment = Alignment.End
            ) {
                // Rating
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_back_24), // Changed to star icon for rating
                        contentDescription = "Rating",
                        tint = Color(0xFFFFC107),
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                    Text(
                        text = hospital.rating.toString(),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Distance
                Text(
                    text = hospital.distance,
                    fontSize = 12.sp,
                    color = TextGray
                )
            }
        }
    }
}