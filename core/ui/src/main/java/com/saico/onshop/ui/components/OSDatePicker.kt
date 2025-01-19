package com.saico.onshop.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.saico.onshop.common.util.dateFormat
import com.saico.onshop.ui.R
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OSDatePickerDialog(
    isVisible: Boolean,
    onDismissRequest: () -> Unit = {},
    onDateSelected: (String) -> Unit,
) {
    if (isVisible) {
        val todayCalendar = Calendar.getInstance()
        val todayInMillis = todayCalendar.timeInMillis

        val datePickerState = rememberDatePickerState(
            initialSelectedDateMillis = todayInMillis,
            initialDisplayedMonthMillis = todayInMillis,

            )

        DatePickerDialog(
            tonalElevation = 0.dp,
            onDismissRequest = onDismissRequest,
            confirmButton = {
                OSTextButton(
                    onClick = {
                        val date = datePickerState.selectedDateMillis
                        date?.let {
                            onDateSelected(it.dateFormat())
                        }
                        onDismissRequest()
                    },
                    label = stringResource(id = R.string.accept)
                )
            },
            dismissButton = {
                OSTextButton(
                    label = stringResource(id = R.string.cancel)
                ) {
                    onDismissRequest()
                }
            }
        ) {
            DatePicker(
                state = datePickerState,
                showModeToggle = true,
            )
        }
    }
}
