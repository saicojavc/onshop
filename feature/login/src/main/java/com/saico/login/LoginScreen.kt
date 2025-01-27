package com.saico.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.saico.onshop.ui.theme.AppDim
import com.saico.onshop.ui.theme.PaddingDim
import com.saico.onshop.ui.R

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    navController: NavHostController,
    viewModel: LogInViewModel = hiltViewModel()
) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    val context = LocalContext.current

    LaunchedEffect(key1 = uiState.value.signInError) {
        uiState.value.signInError?.let { error ->
            Toast.makeText(
                context,
                error,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    Content(
        navController = navController,
        onLoginClick = onLoginClick
    )
}

@Composable
fun Content(
    navController: NavHostController,
    onLoginClick: () -> Unit
) {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.systemBars.asPaddingValues())
    ) {
        val (background, topImage, bottomImage, bottomLogin) = createRefs()
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(background){
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
            contentScale = ContentScale.Crop
        )
        Image(
            painter = painterResource(id = R.drawable.fashion),
            contentDescription = null,
            modifier = Modifier
                .padding(PaddingDim.SMALL)
                .size(AppDim.IMAGE_DIMEN_HUGE)
                .constrainAs(topImage){
                    top.linkTo(background.top)
                    start.linkTo(background.start)
                    end.linkTo(background.end)
                }
        )
        Image(
            painter = painterResource(id = R.drawable.title),
            contentDescription = null,
            modifier = Modifier
                .padding(top = PaddingDim.HUGE)
                .size(AppDim.IMAGE_DIMEN_HUGE)
                .constrainAs(bottomImage){
                    top.linkTo(background.top)
                    start.linkTo(background.start)
                    end.linkTo(background.end)
                    bottom.linkTo(background.bottom)
                }
        )

        IconButton(
            onClick = onLoginClick
//                navController.navigate(
//                    HomeRoute.HomeScreenRoute.route
//                )


            ,
            modifier = Modifier
                .padding(PaddingDim.MEDIUM)
                .size(AppDim.BUTTON_WIDTH)
                .constrainAs(bottomLogin){
                    start.linkTo(background.start)
                    end.linkTo(background.end)
                    bottom.linkTo(background.bottom)
                },

            content = {
                Image(
                    painter = painterResource(id = R.drawable.go),
                    contentDescription = null,
                    modifier = Modifier
                        .size(AppDim.BUTTON_WIDTH)
                )
            }
        )

    }

}

