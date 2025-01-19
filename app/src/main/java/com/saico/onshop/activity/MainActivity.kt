package com.saico.onshop.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.saico.login.navigation.loginGraph
import com.saico.onshop.ui.navigation.Navigator
import com.saico.onshop.ui.theme.OnshopTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigator: Navigator

    private val viewModel: MainActivityViewModel by viewModels()

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
//        enableEdgeToEdge()
        setContent {
            var showSplashScreen by remember { mutableStateOf(true) }
            val systemTheme = isSystemInDarkTheme()
            val context = LocalContext.current

            LaunchedEffect(Unit) {
                delay(3000) // Espera 3 segundos
                showSplashScreen = false
            }
            OnshopTheme(
                darkTheme = false,
            ) {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    MainContainer(
                        startDestination = viewModel.firstScreen,
                        navigator = navigator
                    )
                }
            }
        }
    }
}

@Composable
private fun MainContainer(
    startDestination: String,
    navigator: Navigator
){
    val navControllet = rememberNavController()

    Column {
        NavHost(
            navController = navControllet,
            startDestination = startDestination,
            modifier = Modifier.weight(1f)
        ){
            loginGraph(navControllet)
        }
    }

}
