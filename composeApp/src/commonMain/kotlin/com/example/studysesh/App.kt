package com.example.studysesh

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import studysesh.composeapp.generated.resources.Res
import studysesh.composeapp.generated.resources.compose_multiplatform



@Preview
sealed class Screen(val route: String) {
    object FirstPage : Screen("first_page")
    object SecondPage : Screen("second_page")
    object ThirdPage : Screen("third_page")
    object Settings : Screen("settings")

    companion object {
        fun getNextRoute(currentRoute: String): String? = when(currentRoute) {
            FirstPage.route -> SecondPage.route
            SecondPage.route -> ThirdPage.route
            else -> null
        }

        fun getPreviousRoute(currentRoute: String): String? = when(currentRoute) {
            ThirdPage.route -> SecondPage.route
            SecondPage.route -> FirstPage.route
            else -> null
        }
    }
}

@Preview
@Composable
fun App() {
    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("My App") },
                navigationIcon = {
                    // Show back button if there's a previous page
                    if (currentRoute?.let { Screen.getPreviousRoute(it) } != null) {
                        IconButton(onClick = {
                            currentRoute?.let { route ->
                                Screen.getPreviousRoute(route)?.let { prevRoute ->
                                    navController.navigate(prevRoute)
                                }
                            }
                        }) {
                            Icon(Icons.Filled.ArrowBack, contentDescription = "Previous")
                        }
                    }
                },
                actions = {
                    // Show next button if there's a next page
                    if (currentRoute?.let { Screen.getNextRoute(it) } != null) {
                        IconButton(onClick = {
                            currentRoute?.let { route ->
                                Screen.getNextRoute(route)?.let { nextRoute ->
                                    navController.navigate(nextRoute)
                                }
                            }
                        }) {
                            Icon(Icons.Filled.ArrowForward, contentDescription = "Next")
                        }
                    }

                    // Settings button (always visible)
                    IconButton(onClick = { navController.navigate(Screen.Settings.route) }) {
                        Icon(Icons.Filled.Settings, contentDescription = "Settings")
                    }
                }
            )
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.FirstPage.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.FirstPage.route) { FirstPage() }
            composable(Screen.SecondPage.route) { SecondPage() }
            composable(Screen.ThirdPage.route) { ThirdPage() }
            composable(Screen.Settings.route) { SettingsPage() }
        }
    }
}
@Preview
@Composable
fun FirstPage() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("First Page", style = MaterialTheme.typography.headlineMedium)
    }
}

@Preview
@Composable
fun SecondPage() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Second Page", style = MaterialTheme.typography.headlineMedium)
    }
}

@Preview
@Composable
fun ThirdPage() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Third Page", style = MaterialTheme.typography.headlineMedium)
    }
}

@Preview
@Composable
fun SettingsPage() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Settings Page", style = MaterialTheme.typography.headlineMedium)
    }
}




/*
@Composable
@Preview
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }
    }
}

*/
