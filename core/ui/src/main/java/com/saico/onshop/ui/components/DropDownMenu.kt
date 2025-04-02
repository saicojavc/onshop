package com.saico.onshop.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material.icons.rounded.ArrowDropUp
import androidx.compose.material.icons.rounded.Error
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.saico.onshop.ui.theme.PaddingDim


@Composable
fun OSDropDownMenu(
    selectedItem: String?,
    items: List<String>,
    modifier: Modifier = Modifier,
    onSelect: (String) -> Unit
) {
    var isDropDownExpanded by remember {
        mutableStateOf(false)
    }

    Box(modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(TextFieldDefaults.MinHeight)
                .clickable { isDropDownExpanded = !isDropDownExpanded },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = selectedItem.orEmpty(),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .weight(1f)
            )

            Icon(
                imageVector = Icons.Rounded.ArrowDropDown,
                contentDescription = "drop down icon",
                modifier = Modifier.padding(end = PaddingDim.MEDIUM)
            )
        }

        DropdownMenu(
            expanded = isDropDownExpanded,
            onDismissRequest = { isDropDownExpanded = false },
            modifier = Modifier
                .clip(MaterialTheme.shapes.medium),
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = item,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.fillMaxWidth()
                        )
                    },
                    onClick = {
                        onSelect(item)
                        isDropDownExpanded = false
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(TextFieldDefaults.MinHeight)
                        .fillMaxWidth(.8f),
                    colors = MenuDefaults.itemColors()
                )
            }
        }
    }
}

/**
 *@param visibleItems for a fixed height
 * */
@Composable
fun OSEditableDropDownMenu(
    text: String,
    onTextChange: (String) -> Unit,
    hint: String,
    items: List<String>,
    modifier: Modifier = Modifier,
    visibleItems: Int = 3,
    onSelect: (String) -> Unit
) {
    var isDropDownExpanded by remember {
        mutableStateOf(true)
    }

    Column(modifier) {
        OSTextField(
            value = text,
            onValueChange = onTextChange,
            trailingIcon = {
                IconButton(
                    onClick = { isDropDownExpanded = !isDropDownExpanded }) {
                    Icon(
                        imageVector = if (isDropDownExpanded) Icons.Rounded.ArrowDropUp else Icons.Rounded.ArrowDropDown,
                        contentDescription = "drop down icon"
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        )

        SlideInFromTopAnimation(isDropDownExpanded && items.isNotEmpty()) {
            Surface(
                tonalElevation = 8.dp,
                shadowElevation = 4.dp,
                shape = MaterialTheme.shapes.small
            ) {
                LazyColumn(
                    modifier = Modifier
                        .height(TextFieldDefaults.MinHeight * visibleItems)
                        .fillMaxWidth()
                        .animateContentSize(),
                ) {
                    items(items) { item ->
                        Row(
                            modifier
                                .fillMaxWidth()
                                .height(TextFieldDefaults.MinHeight)
                                .clickable {
                                    onSelect(item)
                                },
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = item,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.padding(start = PaddingDim.MEDIUM)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SlideInFromTopAnimation(
    visible: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    AnimatedVisibility(
        visible = visible,
        content = { content() },
        enter = slideInVertically { -it } + fadeIn(),
        exit = slideOutVertically { -it } + fadeOut(),
        modifier = modifier,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedDropDownMenu(
    label: String,
    options: List<String>,
    selectedOption: String = "",
    onOptionSelected: (Int) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    error: String? = null,
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded && enabled,
        onExpandedChange = { expanded = it },
        modifier = modifier,
    ) {
        OutlinedTextField(
            value = selectedOption,
            onValueChange = { },
            enabled = enabled,
            readOnly = true,
            label = {
                Text(
                    text = label,
                    maxLines = 2
                )
            },
            trailingIcon = {
                if (error != null)
                    Icon(
                        imageVector = Icons.Rounded.Error,
                        contentDescription = "error icon",
                        tint = MaterialTheme.colorScheme.error
                    )
                else
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            supportingText = {
                error?.let {
                    Text(it)
                }
            },
            isError = error != null,
            maxLines = 2,
            colors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(),
            modifier = Modifier
                .menuAnchor(MenuAnchorType.PrimaryEditable, enabled)
                .fillMaxWidth(1f)
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEachIndexed { index, option ->
                DropdownMenuItem(
                    text = { Text(text = option) },
                    onClick = {
                        onOptionSelected(index)
                        expanded = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                )
            }
        }
    }
}