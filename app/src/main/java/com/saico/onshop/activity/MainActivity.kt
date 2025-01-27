package com.saico.onshop.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.auth.api.identity.Identity
import com.saico.feature.home.navigation.homeGraph
import com.saico.login.navigation.loginGraph
import com.saico.onshop.GoogleAuthUiClient
import com.saico.onshop.ui.navigation.Navigator
import com.saico.onshop.ui.navigation.routes.home.HomeRoute
import com.saico.onshop.ui.theme.OnshopTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigator: Navigator

    private val viewModel: MainActivityViewModel by viewModels()

    private val googleAuthUiClient by lazy {
        GoogleAuthUiClient(
            context = applicationContext,
            oneTapClient = Identity.getSignInClient(applicationContext)
        )
    }
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "StateFlowValueCalledInComposition")
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
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    LaunchedEffect(key1 = Unit) {
                        if (googleAuthUiClient.getSignedInUser() != null){
                            navController.navigate(
                                HomeRoute.HomeScreenRoute.route
                            )
                        }
                    }
                    val launcher = rememberLauncherForActivityResult(
                        contract = ActivityResultContracts.StartIntentSenderForResult(),
                        onResult = { result ->
                            if(result.resultCode == RESULT_OK) {
                                lifecycleScope.launch {
                                    val signInResult = googleAuthUiClient.signInWithIntent(
                                        intent = result.data ?: return@launch
                                    )
                                    viewModel.onSignInResult(signInResult)
                                }
                            }
                        }
                    )

                    LaunchedEffect(key1 = viewModel.uiState.value.isSignInSuccessful) {
                        if(viewModel.uiState.value.isSignInSuccessful) {
                            Toast.makeText(
                                applicationContext,
                                "Sign in successful",
                                Toast.LENGTH_LONG
                            ).show()

                            navController.navigate( HomeRoute.HomeScreenRoute.route)
                            viewModel.resetState()
                        }
                    }
                    MainContainer(
                        navController = navController,
                        startDestination = viewModel.firstScreen,
                        navigator = navigator,
                        onLoginClick = {
                            lifecycleScope.launch {
                                val signInIntentSender = googleAuthUiClient.signIn()
                                launcher.launch(
                                    IntentSenderRequest.Builder(
                                        signInIntentSender ?: return@launch
                                    ).build()
                                )
                            }

                        }
                    )

                    LaunchedEffect(Unit) {
                        while (true) {
                            println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")
                            if (viewModel.uiState.value.isSignInSuccessful) {
                                navController.navigate(HomeRoute.HomeScreenRoute.route) {
                                    popUpTo(0) // Elimina el historial de navegación para evitar volver al login
                                }

                                viewModel.resetState()
                            }
                            delay(3000) // Espera 3 segundos antes de repetir
                        }
                    }


                }
            }
        }
    }
}

@Composable
private fun MainContainer(
    navController: NavHostController,
    startDestination: String,
    navigator: Navigator,
    onLoginClick: () -> Unit
){
//    val navController = rememberNavController()

    Column {
        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = Modifier.weight(1f)
        ){
            loginGraph(
                navHostController = navController,
                onLoginClick = onLoginClick
                )
            homeGraph(navController)
        }
    }

}
