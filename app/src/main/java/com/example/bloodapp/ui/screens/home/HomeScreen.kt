//package com.example.bloodapp.ui.screens.home
//
//import androidx.compose.foundation.clickable
//import androidx.compose.ui.text.style.TextAlign
//
//import com.example.bloodapp.ui.theme.LightGrayBg
//import com.example.bloodapp.ui.theme.Red500
//import com.example.bloodapp.ui.theme.TextGray
//
//
//// app/src/main/java/com/example/vitalconnect/ui/screens/home/HomeScreen.kt
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
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.LocationOn
//import androidx.compose.material.icons.filled.Person
//import androidx.compose.material.icons.filled.Search
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextFieldDefaults
//import androidx.compose.material3.TopAppBar
//import androidx.compose.material3.TopAppBarDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//
//
//
//
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//
//import androidx.compose.material.icons.filled.LocationOn
//import androidx.compose.material.icons.filled.Person
//import androidx.compose.material.icons.filled.Search
//import androidx.compose.material3.*
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
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
//import com.example.bloodapp.navigation.Destinations
//import com.example.bloodapp.ui.theme.LightGrayBg
//import com.example.bloodapp.ui.theme.Red500
//import com.example.bloodapp.ui.theme.TextGray
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun HomeScreen(navController: NavController) {
//    val searchQuery = remember { mutableStateOf("") }
//
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = {
//                    Row(
//                        verticalAlignment = Alignment.CenterVertically,
//                        modifier = Modifier.fillMaxWidth()
//                    ) {
//                        Icon(
//                            imageVector = Icons.Default.LocationOn,
//                            contentDescription = "Location",
//                            tint = Red500,
//                            modifier = Modifier.size(24.dp)
//                        )
//                        Spacer(modifier = Modifier.width(8.dp))
//                        Text(
//                            text = "Mumbai, India",
//                            fontWeight = FontWeight.Bold,
//                            fontSize = 18.sp
//                        )
//                    }
//                },
//                actions = {
//                    IconButton(onClick = { navController.navigate(Destinations.PROFILE_ROUTE) }) {
//                        Icon(
//                            imageVector = Icons.Default.Person,
//                            contentDescription = "Profile",
//                            tint = Color.Black
//                        )
//                    }
//                },
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = Color.White,
//                    titleContentColor = Color.Black
//                )
//            )
//        },
//        bottomBar = {
//            BottomNavigationBar(navController)
//        }
//    ) { innerPadding ->
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(innerPadding)
//                .background(Color.White)
//        ) {
//            // Search Bar
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 16.dp, vertical = 8.dp)
//                    .clip(RoundedCornerShape(12.dp))
//                    .background(LightGrayBg)
//                    .padding(horizontal = 12.dp, vertical = 8.dp),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Icon(
//                    imageVector = Icons.Default.Search,
//                    contentDescription = "Search",
//                    tint = TextGray,
//                    modifier = Modifier.size(20.dp)
//                )
//                Spacer(modifier = Modifier.width(8.dp))
//                Text(
//                    text = "Search blood, hospitals, or blood banks",
//                    color = TextGray,
//                    fontSize = 14.sp
//                )
//            }
//
//            // Hero Image
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(450.dp)
//                    .padding(16.dp)
//                    .clip(RoundedCornerShape(12.dp))
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.home),
//                    contentDescription = "Blood Donation",
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier.fillMaxSize()
//                )
//            }
//
//            // Action Buttons
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 16.dp),
//                horizontalArrangement = Arrangement.SpaceEvenly
//            ) {
//                Button(
//                    onClick = { navController.navigate(Destinations.DONOR_FORM_ROUTE) },
//                    modifier = Modifier
//                        .weight(1f)
//                        .padding(end = 8.dp)
//                        .height(48.dp),
//                    shape = RoundedCornerShape(12.dp),
//                    colors = ButtonDefaults.buttonColors(
//                        containerColor = Red500,
//                        contentColor = Color.White
//                    )
//                ) {
//                    Text(
//                        text = "Become a Donor",
//                        fontSize = 14.sp,
//                        fontWeight = FontWeight.Bold
//                    )
//                }
//
//                Button(
//                    onClick = { navController.navigate(Destinations.HOSPITAL_LIST_ROUTE) },
//                    modifier = Modifier
//                        .weight(1f)
//                        .height(48.dp),
//                    shape = RoundedCornerShape(12.dp),
//                    colors = ButtonDefaults.buttonColors(
//                        containerColor = Red500,
//                        contentColor = Color.White
//                    )
//                ) {
//                    Text(
//                        text = "Request Blood",
//                        fontSize = 14.sp,
//                        fontWeight = FontWeight.Bold
//                    )
//                }
//            }
//
//            Spacer(modifier = Modifier.height(24.dp))
//        }
//    }
//}
//
//@Composable
//fun BottomNavigationBar(navController: NavController) {
//    val currentDestination = navController.currentBackStackEntry?.destination?.route
//
//    NavigationBar(
//        containerColor = Color.White
//    ) {
//        NavigationBarItem(
//            selected = currentDestination == Destinations.HOME_ROUTE,
//            onClick = { navController.navigate(Destinations.HOME_ROUTE) },
//            icon = {
//                Icon(
//                    painter = painterResource(id = R.drawable.baseline_home_24),
//                    contentDescription = "Check Donation"
//                )
//            },
//            label = { Text("Check Donation") },
//            colors = NavigationBarItemDefaults.colors(
//                selectedIconColor = Red500,
//                selectedTextColor = Red500,
//                unselectedIconColor = TextGray,
//                unselectedTextColor = TextGray
//            )
//        )
//
//        NavigationBarItem(
//            selected = currentDestination == Destinations.RARE_GROUPS_ROUTE,
//            onClick = { navController.navigate(Destinations.RARE_GROUPS_ROUTE) },
//            icon = {
//                Icon(
//                    painter = painterResource(id = R.drawable.baseline_chat_24),
//                    contentDescription = "Groups"
//                )
//            },
//            label = { Text("Groups") },
//            colors = NavigationBarItemDefaults.colors(
//                selectedIconColor = Red500,
//                selectedTextColor = Red500,
//                unselectedIconColor = TextGray,
//                unselectedTextColor = TextGray
//            )
//        )
//
//        NavigationBarItem(
//            selected = currentDestination == Destinations.HISTORY_ROUTE,
//            onClick = { navController.navigate(Destinations.HISTORY_ROUTE) },
//            icon = {
//                Icon(
//                    painter = painterResource(id = R.drawable.baseline_history_24),
//                    contentDescription = "History"
//                )
//            },
//            label = { Text("History") },
//            colors = NavigationBarItemDefaults.colors(
//                selectedIconColor = Red500,
//                selectedTextColor = Red500,
//                unselectedIconColor = TextGray,
//                unselectedTextColor = TextGray
//            )
//        )
//    }
//}
//
//
//@Composable
//fun BottomNavItem(icon: Int, label: String, isSelected: Boolean, onClick: () -> Unit) {
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier
//            .clickable { onClick() }
//            .padding(4.dp)
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
//            fontSize = 12.sp
//        )
//    }
//}
//
//
//
//
//
//
//
//
//package com.example.bloodapp.ui.screens.home
//
//import androidx.compose.foundation.Image
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
//import androidx.compose.material.icons.filled.Person
//import androidx.compose.material.icons.filled.Search
//import androidx.compose.material3.*
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
//import com.example.bloodapp.navigation.Destinations
//import com.example.bloodapp.ui.screens.request.Hospital
//import com.example.bloodapp.ui.theme.LightGrayBg
//import com.example.bloodapp.ui.theme.Red500
//import com.example.bloodapp.ui.theme.TextGray
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun HomeScreen(navController: NavController) {
//    val searchQuery = remember { mutableStateOf("") }
//    val showSearchResults = remember { mutableStateOf(false) }
//
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = {
//                    Row(
//                        verticalAlignment = Alignment.CenterVertically,
//                        modifier = Modifier.fillMaxWidth()
//                    ) {
//                        Icon(
//                            imageVector = Icons.Default.LocationOn,
//                            contentDescription = "Location",
//                            tint = Red500,
//                            modifier = Modifier.size(24.dp)
//                        )
//                        Spacer(modifier = Modifier.width(8.dp))
//                        Text(
//                            text = "Mumbai, India",
//                            fontWeight = FontWeight.Bold,
//                            fontSize = 18.sp
//                        )
//                    }
//                },
//                actions = {
//                    IconButton(onClick = { navController.navigate(Destinations.PROFILE_ROUTE) }) {
//                        Icon(
//                            imageVector = Icons.Default.Person,
//                            contentDescription = "Profile",
//                            tint = Color.Black
//                        )
//                    }
//                },
//                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = Color.White,
//                    titleContentColor = Color.Black
//                )
//            )
//        },
//        bottomBar = {
//            BottomNavigationBar(navController)
//        }
//    ) { innerPadding ->
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(innerPadding)
//                .background(Color.White)
//        ) {
//            // Search Bar
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 16.dp, vertical = 8.dp)
//                    .clip(RoundedCornerShape(12.dp))
//                    .background(LightGrayBg)
//                    .clickable { showSearchResults.value = true }
//                    .padding(horizontal = 12.dp, vertical = 8.dp),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Icon(
//                    imageVector = Icons.Default.Search,
//                    contentDescription = "Search",
//                    tint = TextGray,
//                    modifier = Modifier.size(20.dp)
//                )
//                Spacer(modifier = Modifier.width(8.dp))
//                Text(
//                    text = "Search blood, hospitals, or blood banks",
//                    color = TextGray,
//                    fontSize = 14.sp
//                )
//            }
//
//            if (showSearchResults.value) {
//                // Show search overlay
//                SearchOverlay(
//                    searchQuery = searchQuery,
//                    onClose = { showSearchResults.value = false },
//                    navController = navController
//                )
//            } else {
//                // Original content remains unchanged
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .height(450.dp)
//                        .padding(16.dp)
//                        .clip(RoundedCornerShape(12.dp))
//                ) {
//                    Image(
//                        painter = painterResource(id = R.drawable.home),
//                        contentDescription = "Blood Donation",
//                        contentScale = ContentScale.Crop,
//                        modifier = Modifier.fillMaxSize()
//                    )
//                }
//
//                // Action Buttons
//                Row(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(horizontal = 16.dp),
//                    horizontalArrangement = Arrangement.SpaceEvenly
//                ) {
//                    Button(
//                        onClick = { navController.navigate(Destinations.DONOR_FORM_ROUTE) },
//                        modifier = Modifier
//                            .weight(1f)
//                            .padding(end = 8.dp)
//                            .height(48.dp),
//                        shape = RoundedCornerShape(12.dp),
//                        colors = ButtonDefaults.buttonColors(
//                            containerColor = Red500,
//                            contentColor = Color.White
//                        )
//                    ) {
//                        Text(
//                            text = "Become a Donor",
//                            fontSize = 14.sp,
//                            fontWeight = FontWeight.Bold
//                        )
//                    }
//
//                    Button(
//                        onClick = { navController.navigate(Destinations.HOSPITAL_LIST_ROUTE) },
//                        modifier = Modifier
//                            .weight(1f)
//                            .height(48.dp),
//                        shape = RoundedCornerShape(12.dp),
//                        colors = ButtonDefaults.buttonColors(
//                            containerColor = Red500,
//                            contentColor = Color.White
//                        )
//                    ) {
//                        Text(
//                            text = "Request Blood",
//                            fontSize = 14.sp,
//                            fontWeight = FontWeight.Bold
//                        )
//                    }
//                }
//
//                Spacer(modifier = Modifier.height(24.dp))
//            }
//        }
//    }
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun SearchOverlay(
//    searchQuery: androidx.compose.runtime.MutableState<String>,
//    onClose: () -> Unit,
//    navController: NavController
//) {
//    // Static hospital data (same as in HospitalListScreen)
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
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White)
//    ) {
//        // Search Header
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            IconButton(onClick = onClose) {
//                Icon(
//                    imageVector = Icons.Default.ArrowBack,
//                    contentDescription = "Back",
//                    tint = Color.Black
//                )
//            }
//            Spacer(modifier = Modifier.width(8.dp))
//            OutlinedTextField(
//                value = searchQuery.value,
//                onValueChange = { searchQuery.value = it },
//                modifier = Modifier.weight(1f),
//                placeholder = {
//                    Text("Search hospitals or blood banks")
//                },
//                leadingIcon = {
//                    Icon(
//                        imageVector = Icons.Default.Search,
//                        contentDescription = "Search"
//                    )
//                },
//                singleLine = true,
//                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    focusedBorderColor = Red500,
//                    unfocusedBorderColor = LightGrayBg
//                )
//            )
//        }
//
//        // Search Results
//        LazyColumn(
//            modifier = Modifier
//                .fillMaxWidth()
//                .weight(1f)
//                .padding(horizontal = 16.dp),
//            verticalArrangement = Arrangement.spacedBy(12.dp)
//        ) {
//            if (filteredHospitals.isEmpty() && searchQuery.value.isNotEmpty()) {
//                item {
//                    Box(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(32.dp),
//                        contentAlignment = Alignment.Center
//                    ) {
//                        Text(
//                            text = "No results found for \"${searchQuery.value}\"",
//                            color = TextGray,
//                            fontSize = 16.sp
//                        )
//                    }
//                }
//            } else {
//                items(filteredHospitals) { hospital ->
//                    HospitalCard(
//                        hospital = hospital,
//                        onItemClick = {
//                            navController.navigate("hospital_detail/${hospital.id}")
//                            onClose()
//                        }
//                    )
//                }
//            }
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
//// Rest of the HomeScreen code remains unchanged...
//@Composable
//fun BottomNavigationBar(navController: NavController) {
//    val currentDestination = navController.currentBackStackEntry?.destination?.route
//
//    NavigationBar(
//        containerColor = Color.White
//    ) {
//        NavigationBarItem(
//            selected = currentDestination == Destinations.HOME_ROUTE,
//            onClick = { navController.navigate(Destinations.HOME_ROUTE) },
//            icon = {
//                Icon(
//                    painter = painterResource(id = R.drawable.baseline_home_24),
//                    contentDescription = "Check Donation"
//                )
//            },
//            label = { Text("Check Donation") },
//            colors = NavigationBarItemDefaults.colors(
//                selectedIconColor = Red500,
//                selectedTextColor = Red500,
//                unselectedIconColor = TextGray,
//                unselectedTextColor = TextGray
//            )
//        )
//
//        NavigationBarItem(
//            selected = currentDestination == Destinations.RARE_GROUPS_ROUTE,
//            onClick = { navController.navigate(Destinations.RARE_GROUPS_ROUTE) },
//            icon = {
//                Icon(
//                    painter = painterResource(id = R.drawable.baseline_chat_24),
//                    contentDescription = "Groups"
//                )
//            },
//            label = { Text("Groups") },
//            colors = NavigationBarItemDefaults.colors(
//                selectedIconColor = Red500,
//                selectedTextColor = Red500,
//                unselectedIconColor = TextGray,
//                unselectedTextColor = TextGray
//            )
//        )
//
//        NavigationBarItem(
//            selected = currentDestination == Destinations.HISTORY_ROUTE,
//            onClick = { navController.navigate(Destinations.HISTORY_ROUTE) },
//            icon = {
//                Icon(
//                    painter = painterResource(id = R.drawable.baseline_history_24),
//                    contentDescription = "History"
//                )
//            },
//            label = { Text("History") },
//            colors = NavigationBarItemDefaults.colors(
//                selectedIconColor = Red500,
//                selectedTextColor = Red500,
//                unselectedIconColor = TextGray,
//                unselectedTextColor = TextGray
//            )
//        )
//    }
//}
//
//
//@Composable
//fun BottomNavItem(icon: Int, label: String, isSelected: Boolean, onClick: () -> Unit) {
//    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
//        modifier = Modifier
//            .clickable { onClick() }
//            .padding(4.dp)
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
//            fontSize = 12.sp
//        )
//    }
//}
package com.example.bloodapp.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
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
import com.example.bloodapp.navigation.Destinations

import com.example.bloodapp.ui.theme.LightGrayBg
import com.example.bloodapp.ui.theme.Red500
import com.example.bloodapp.ui.theme.TextGray

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    val searchQuery = remember { mutableStateOf("") }
    val showSearchResults = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "Location",
                            tint = Red500,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Mumbai, India",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { navController.navigate(Destinations.PROFILE_ROUTE) }) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Profile",
                            tint = Color.Black
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black
                )
            )
        },
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(Color.White)
        ) {
            // Search Bar - Now with functional search
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                shape = RoundedCornerShape(12.dp),
                color = LightGrayBg
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = TextGray,
                        modifier = Modifier.size(10.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    OutlinedTextField(
                        value = searchQuery.value,
                        onValueChange = {
                            searchQuery.value = it
                            showSearchResults.value = it.isNotEmpty()
                        },
                        modifier = Modifier.weight(1f),
                        placeholder = {
                            Text(
                                "Search blood, hospitals, or blood banks",
                                color = TextGray,
                                fontSize = 12.sp
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

            if (showSearchResults.value) {
                // Show search results
                SearchResultsSection(
                    searchQuery = searchQuery,
                    onClose = {
                        searchQuery.value = ""
                        showSearchResults.value = false
                    },
                    navController = navController
                )
            } else {
                // Original content
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(450.dp)
                        .padding(16.dp)
                        .clip(RoundedCornerShape(12.dp))
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.home),
                        contentDescription = "Blood Donation",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }

                // Action Buttons
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = { navController.navigate(Destinations.DONOR_FORM_ROUTE) },
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp)
                            .height(48.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Red500,
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            text = "Become a Donor",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Button(
                        onClick = { navController.navigate(Destinations.HOSPITAL_LIST_ROUTE) },
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Red500,
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            text = "Request Blood",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Composable
fun SearchResultsSection(
    searchQuery: androidx.compose.runtime.MutableState<String>,
    onClose: () -> Unit,
    navController: NavController
) {
    // Static hospital data
    val hospitals = remember {
        listOf(
            Hospital(
                id = 1,
                name = "Indira Gandhi Memorial Hospital",
                type = "Hospital",
                address = "Shirpur",
                distance = "2.5 km",
                rating = 4.5f,
                imageRes = R.drawable.ic_launcher_foreground,
                phone = "1234567890"
            ),
            Hospital(
                id = 2,
                name = "Late Shri Mukeshbhai Patel Blood Bank",
                type = "Blood Bank",
                address = "456 Oak Avenue, Mumbai",
                distance = "3.2 km",
                rating = 4.8f,
                imageRes = R.drawable.ic_launcher_foreground,
                phone = "1234567890"
            ),
            Hospital(
                id = 3,
                name = "Community Health Clinic",
                type = "Hospital",
                address = "789 Pine Road, Mumbai",
                distance = "1.8 km",
                rating = 4.2f,
                imageRes = R.drawable.ic_launcher_foreground,
                phone = "1234567890"
            ),
            Hospital(
                id = 4,
                name = "St. Jude's Medical Center",
                type = "Hospital",
                address = "321 Elm Street, Mumbai",
                distance = "4.1 km",
                rating = 4.7f,
                imageRes = R.drawable.ic_launcher_foreground,
                phone = "1234567890"
            ),
            Hospital(
                id = 5,
                name = "Lifelood Transfusion",
                type = "Blood Bank",
                address = "654 Maple Lane, Mumbai",
                distance = "2.9 km",
                rating = 4.6f,
                imageRes = R.drawable.ic_launcher_background,
                phone = "1234567890"
            )
        )
    }

    val filteredHospitals = remember(searchQuery.value) {
        if (searchQuery.value.isEmpty()) {
            emptyList()
        } else {
            hospitals.filter { hospital ->
                hospital.name.contains(searchQuery.value, ignoreCase = true) ||
                        hospital.address.contains(searchQuery.value, ignoreCase = true) ||
                        hospital.type.contains(searchQuery.value, ignoreCase = true)
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        // Search results header
        Text(
            text = "Search Results",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        // Search results list
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            if (filteredHospitals.isEmpty()) {
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
                            onClose()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun HospitalCard(hospital: Hospital, onItemClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onItemClick),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Hospital name and rating
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = hospital.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.weight(1f)
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                        contentDescription = "Rating",
                        tint = Color(0xFFFFC107),
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = hospital.rating.toString(),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Address
            Text(
                text = hospital.address,
                fontSize = 14.sp,
                color = TextGray
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Distance and type
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = hospital.distance,
                    fontSize = 12.sp,
                    color = TextGray
                )
                Text(
                    text = " • ",
                    fontSize = 12.sp,
                    color = TextGray
                )
                Text(
                    text = hospital.type,
                    fontSize = 12.sp,
                    color = TextGray
                )
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val currentDestination = navController.currentBackStackEntry?.destination?.route

    NavigationBar(
        containerColor = Color.White
    ) {
        NavigationBarItem(
            selected = currentDestination == Destinations.HOME_ROUTE,
            onClick = { navController.navigate(Destinations.HOME_ROUTE) },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_home_24),
                    contentDescription = "Check Donation"
                )
            },
            label = { Text("Check Donation") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Red500,
                selectedTextColor = Red500,
                unselectedIconColor = TextGray,
                unselectedTextColor = TextGray
            )
        )

        NavigationBarItem(
            selected = currentDestination == Destinations.RARE_GROUPS_ROUTE,
            onClick = { navController.navigate(Destinations.RARE_GROUPS_ROUTE) },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_chat_24),
                    contentDescription = "Groups"
                )
            },
            label = { Text("Groups") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Red500,
                selectedTextColor = Red500,
                unselectedIconColor = TextGray,
                unselectedTextColor = TextGray
            )
        )

        NavigationBarItem(
            selected = currentDestination == Destinations.HISTORY_ROUTE,
            onClick = { navController.navigate(Destinations.HISTORY_ROUTE) },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_history_24),
                    contentDescription = "History"
                )
            },
            label = { Text("History") },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Red500,
                selectedTextColor = Red500,
                unselectedIconColor = TextGray,
                unselectedTextColor = TextGray
            )
        )
    }
}

@Composable
fun BottomNavItem(icon: Int, label: String, isSelected: Boolean, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable { onClick() }
            .padding(4.dp)
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = label,
            tint = if (isSelected) Red500 else TextGray,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            color = if (isSelected) Red500 else TextGray,
            fontSize = 12.sp
        )
    }
}


data class Hospital(
    val id: Int,
    val name: String,
    val type: String, // "Hospital" or "Blood Bank"
    val address: String,
    val distance: String,
    val phone:String,
    val rating: Float,
    val imageRes: Int
)