package com.saico.onshop.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.saico.onshop.ui.R
import com.saico.onshop.ui.components.icon.OSIcons
import com.saico.onshop.ui.theme.PaddingDim

@Composable
fun OSTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String = "",
    placeholder: @Composable (() -> Unit)? = {},
    enabled: Boolean = true,
    singleLine: Boolean = true,
    errorMessage: String? = null,
    maxLines: Int = if (singleLine) 1 else 5,
    maxLength: Int? = null,
    shape: Shape = ShapeDefaults.Medium,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    colors: TextFieldColors = TextFieldDefaults.colors(),
    trailingIcon: @Composable (() -> Unit)? = {},
    leadingIcon: @Composable (() -> Unit)? = {},
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
) {
    Column(modifier = modifier) {
        OutlinedTextField(
            value = value,
            onValueChange = {
                if (maxLength != null) {
                    if (it.length <= maxLength) {
                        onValueChange(it)
                    }
                } else {
                    onValueChange(it)
                }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = singleLine,
            maxLines = maxLines,
            label = {
                ProvideTextStyle(value = MaterialTheme.typography.bodyMedium) {
                    Text(text = label)
                }
            },
            textStyle = textStyle,
            placeholder = placeholder,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            colors = colors,
            isError = errorMessage != null,
            shape = shape,
            visualTransformation = visualTransformation,
            trailingIcon = if (errorMessage == null) {
                trailingIcon
            } else {
                {
                    Icon(
                        imageVector = OSIcons.ErrorIcon, contentDescription = errorMessage
                    )
                }
            },
            leadingIcon = if (errorMessage == null) {
                leadingIcon
            } else {
                {
                    Icon(
                        imageVector = OSIcons.ErrorIcon, contentDescription = errorMessage
                    )
                }
            },
        )
        errorMessage?.let {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = PaddingDim.LARGE, top = PaddingDim.VERY_SMALL),
                text = it,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
fun TextFieldEmail(
    modifier: Modifier = Modifier,
    label: String = stringResource(id = R.string.email),
    value: String,
    onValueChange: (String) -> Unit,
    maxLength: Int = 40,
    errorMessage: String? = null,
    imeAction: ImeAction = ImeAction.Next,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Email, imeAction = imeAction
    ),
    keyboardActions: KeyboardActions,
    trailingIcon: @Composable (() -> Unit)? = {},
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    OSTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        maxLength = maxLength,
        label = label,
        errorMessage = errorMessage,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        trailingIcon = trailingIcon,
        leadingIcon = leadingIcon
    )
}

@Composable
fun TextFieldPassword(
    modifier: Modifier = Modifier,
    label: String = stringResource(id = R.string.password),
    value: String,
    onValueChange: (String) -> Unit,
    maxLength: Int = 40,
    errorMessage: String? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Password, imeAction = ImeAction.Done
    ),
    keyboardActions: KeyboardActions,
    hidden: Boolean,
    onHiddenChange: () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
    colors: TextFieldColors = TextFieldDefaults.colors(),
) {
    OSTextField(
        modifier = modifier,
        value = value,
        colors = colors,
        onValueChange = onValueChange,
        maxLength = maxLength,
        label = label,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        errorMessage = errorMessage,
        visualTransformation = if (hidden) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = onHiddenChange) {
                val vector = if (hidden) OSIcons.VisibilityOffIcon else OSIcons.VisibilityIcon
                val description = if (hidden) R.string.hide_password else R.string.show_password
                Icon(
                    imageVector = vector,
                    contentDescription = stringResource(id = description),
                    tint = Color.White
                )
            }
        },
        leadingIcon = leadingIcon,
    )
}

@Composable
fun OSOutlinedTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String = "",
    enabled: Boolean = true,
    readOnly: Boolean = false,
    singleLine: Boolean = true,
    errorMessage: String? = null,
    maxLines: Int = if (singleLine) 1 else 5,
    maxLength: Int? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    colors: TextFieldColors = TextFieldDefaults.colors(),
    shape: Shape = OutlinedTextFieldDefaults.shape,
    trailingIcon: @Composable (() -> Unit)? = {},
    leadingIcon: @Composable (() -> Unit)? = null,
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
) {
    Column(modifier = modifier) {
        OutlinedTextField(
            value = value,
            onValueChange = {
                if (maxLength != null) {
                    if (it.length <= maxLength) {
                        onValueChange(it)
                    }
                } else {
                    onValueChange(it)
                }
            },
            modifier = Modifier.fillMaxWidth(),
            label = {
                ProvideTextStyle(value = MaterialTheme.typography.bodyMedium) {
                    Text(text = label)
                }
            },
            enabled = enabled,
            readOnly = readOnly,
            singleLine = singleLine,
            maxLines = maxLines,
            isError = errorMessage != null,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            visualTransformation = visualTransformation,
            colors = colors,
            shape = shape,
            leadingIcon = if (errorMessage == null) {
                leadingIcon
            } else {
                {
                    Icon(
                        imageVector = OSIcons.ErrorIcon, contentDescription = errorMessage
                    )
                }
            },
            trailingIcon = if (errorMessage == null) {
                trailingIcon
            } else {
                {
                    Icon(
                        imageVector = OSIcons.ErrorIcon, contentDescription = errorMessage
                    )
                }
            },
            textStyle = textStyle,
        )

        errorMessage?.let {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = PaddingDim.LARGE, top = PaddingDim.VERY_SMALL),
                text = it,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }

    }
}
