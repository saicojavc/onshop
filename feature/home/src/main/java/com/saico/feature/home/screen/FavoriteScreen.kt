package com.saico.feature.home.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.saico.onshop.ui.R
import com.saico.onshop.ui.theme.AppDim
import com.saico.onshop.ui.theme.PaddingDim

@Composable
fun FavoriteScreen(
    modifier: Modifier
){
    Scaffold(
        modifier = Modifier
            .fillMaxWidth()
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.base_ic_search_empty_folder),
                contentDescription = null,
                modifier = Modifier
                    .padding(vertical = PaddingDim.EXTRA_HUGE, horizontal = PaddingDim.HUGE)
                    .size(AppDim.ROW_DATA_TIME_SIZE)
            )
        }
    }
}