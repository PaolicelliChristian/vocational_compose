package com.example.vocational_compose.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign


class TextFieldComposable {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun FilledTextField(
        initText: String = "",
        initErrorValue: Boolean = false,
        textValState: MutableState<String>? = null,
        errorValState: MutableState<Boolean>? = null,
        labelText: String? = null,
        placeholderText: String? = null,
        supportingText: String? = null,
        singleLine: Boolean = true,
        enabled: Boolean = true,
        validateMaxLength: Boolean = false,
        charLimit: Int = 200,
        imeAction: ImeAction = ImeAction.Done,
        startIcon: ImageVector? = null,
        endIcon: ImageVector? = null,
        supportingTextAlign: TextAlign = TextAlign.End
    ){
        val text = textValState ?: rememberSaveable { mutableStateOf(initText) }
        val isError = errorValState ?: rememberSaveable { mutableStateOf(initErrorValue) }
        val keyboardController = LocalSoftwareKeyboardController.current

        fun validate(text: String) {
            isError.value = text.length > charLimit
        }

        TextField(
            value = text.value,
            onValueChange = {
                text.value = it
                if (validateMaxLength){
                    validate(text.value)
                }
            },
            label = {
                if(labelText != null){
                    Text(text = labelText)
                }
            },
            placeholder = {
                if(placeholderText != null){
                    Text(text = placeholderText)
                }
            },
            leadingIcon = if(startIcon!= null){
                {
                    Icon(
                        startIcon,
                        contentDescription = ""
                    )
                }
            }else{
                  null
            },
            trailingIcon =  if(endIcon!= null){
                {
                    Icon(
                        endIcon,
                        contentDescription = ""
                    )
                }
            }else{
                null
            },
            supportingText = if(supportingText.isNullOrEmpty()){
                null
            }else{
                {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = supportingText,
                        textAlign = supportingTextAlign,
                    )
                }
             },
            singleLine = singleLine,
            isError = isError.value,
            enabled = enabled,
            keyboardOptions = KeyboardOptions(imeAction = imeAction),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                    // do something here
                }
            )
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun OutlinedTextField(
        modifier: Modifier = Modifier,
        initText: String = "",
        initErrorValue: Boolean = false,
        errorValState: MutableState<Boolean>? = null,
        labelText: @Composable (() -> Unit)? = null,
        placeholderTextStyle: TextStyle? = null,
        textStyle: TextStyle = TextStyle.Default,
        placeholderText: String? = null,
        supportingText: String? = null,
        singleLine: Boolean = true,
        enabled: Boolean = true,
        validateMaxLength: Boolean = false,
        optional: Boolean = false,
        charLimit: Int = 200,
        imeAction: ImeAction = ImeAction.Next,
        startIcon: ImageVector? = null,
        endIcon: ImageVector? = null,
        supportingTextAlign: TextAlign = TextAlign.End,
        keyboardType: KeyboardType = KeyboardType.Text,
        shape: Shape = OutlinedTextFieldDefaults.shape,
        colors: TextFieldColors = OutlinedTextFieldDefaults.colors(),
        interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
        onValueChange: (text: String) -> Unit,
        onErrorListener: (text: Boolean) -> Unit,
    ){

        var text by rememberSaveable(stateSaver = TextFieldValue.Saver) {
            mutableStateOf(TextFieldValue(initText, TextRange(initText.length)))
        }

        val isError = errorValState ?: remember { mutableStateOf(initErrorValue) }

        val keyboardController = LocalSoftwareKeyboardController.current

        val focusRequester = remember { FocusRequester() }

        fun validate(text: String) {
            isError.value = text.length > charLimit
        }

        OutlinedTextField(
            modifier = modifier
                .clickable {
                    // Set focus to true when the TextField is clicked
                    focusRequester.requestFocus()
                    keyboardController?.show()

                }
                .focusModifier()
                .pointerInput(Unit){
                    detectTapGestures { focusRequester.requestFocus() }
                }
                .focusRequester(focusRequester),
            value = text,
            onValueChange = {
                onValueChange(it.text)
                if (validateMaxLength){
                    validate(it.text)
                }else{
                    if(!optional){
                        isError.value = it.text.isEmpty()
                        onErrorListener(isError.value)

                        text = it
                    }else{
                        text = it
                    }

                }
            },
            label = labelText,
            placeholder = {
                if(placeholderText != null) {
                    if (placeholderTextStyle != null){
                        Text(
                            text = placeholderText,
                            style = placeholderTextStyle
                        )
                    }else {
                        Text(
                            text = placeholderText,
                        )
                    }
                }
            },
            leadingIcon = if(startIcon!= null){
                {
                    Icon(
                        startIcon,
                        contentDescription = ""
                    )
                }
            }else{
                null
            },
            trailingIcon =  if(endIcon!= null){
                {
                    Icon(
                        endIcon,
                        contentDescription = "",
                        tint = Color.White
                    )
                }
            }else{
                null
            },
            supportingText = if(supportingText.isNullOrEmpty()){
                null
            }else{
                {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = supportingText,
                        textAlign = supportingTextAlign,
                    )
                }
            },
            colors = colors,
            textStyle = textStyle,
            singleLine = singleLine,
            isError = isError.value,
            enabled = enabled,
            shape = shape,
            keyboardOptions = KeyboardOptions(
                imeAction = imeAction,
                keyboardType = keyboardType
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                    // do something here
                }
            ),
            interactionSource = interactionSource
        )
    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun FilledPasswordTextField(
        initText: String = "",
        initErrorValue: Boolean = false,
        textValState: MutableState<String>? = null,
        errorValState: MutableState<Boolean>? = null,
        labelText: String? = null,
        placeholderText: String? = null,
        supportingText: String? = null,
        errorMessage: String = "La password non è valida",
        singleLine: Boolean = true,
        enabled: Boolean = true,
        validatePassword: Boolean = false,
        imeAction: ImeAction = ImeAction.Done,
        startIcon: ImageVector? = null,
        supportingTextAlign: TextAlign = TextAlign.Start
    ){
        val password = textValState ?: rememberSaveable { mutableStateOf(initText) }
        val isError = errorValState ?: rememberSaveable { mutableStateOf(initErrorValue) }
        val passwordHidden = rememberSaveable { mutableStateOf(true) }

        val keyboardController = LocalSoftwareKeyboardController.current

        //Questa regex valida una password che deve contenere almeno:
        //Una lettera minuscola
        //Una lettera maiuscola
        //Un numero
        //Un carattere speciale
        //La lunghezza della password deve essere almeno di 8 caratteri.
        val regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{10,}$"

        fun validate(text: String) {
            isError.value = !text.matches(Regex(regex))
        }

        TextField(
            value = password.value,
            onValueChange = {
                password.value = it
                if (validatePassword){
                    validate(it)
                }
            },
            label = {
                if(labelText != null){
                    Text(text = labelText)
                }
            },
            placeholder = {
                if(placeholderText != null){
                    Text(text = placeholderText)
                }
            },
            leadingIcon = if(startIcon!= null){
                {
                    Icon(
                        startIcon,
                        contentDescription = ""
                    )
                }
            }else{
                null
            },
            trailingIcon = {
                IconButton(
                    onClick = { passwordHidden.value = !passwordHidden.value }
                ) {
                    val visibilityIcon = if (passwordHidden.value) {
                        Icons.Filled.Email
                    } else {
                        Icons.Filled.Email
                    }
                    val description = if (passwordHidden.value) "Show password" else "Hide password"
                    Icon(imageVector = visibilityIcon, contentDescription = description)
                }
            },
            visualTransformation = if (passwordHidden.value){
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            supportingText = if(!isError.value){
                null
            }else{
                {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = errorMessage,
                        textAlign = supportingTextAlign,
                        color = if (isError.value) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary
                    )
                }
            },
            singleLine = singleLine,
            isError = isError.value,
            enabled = enabled,
            keyboardOptions = KeyboardOptions(
                imeAction = imeAction,
                keyboardType= KeyboardType.Password
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                    // do something here
                    if (validatePassword){
                        validate(password.value)
                    }
                }
            ),
            modifier = Modifier.semantics {
                // Provide localized description of the error
                if (isError.value) {
                    error(errorMessage)
                }
            }
        )
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun OutlinedPasswordTextField(
        modifier: Modifier = Modifier,
        initText: String = "",
        initErrorValue: Boolean = false,
        errorValState: MutableState<Boolean>? = null,
        labelText: @Composable (() -> Unit)? = null,
        placeholderText: String? = null,
        errorMessage: String = "La password non è valida",
        singleLine: Boolean = true,
        enabled: Boolean = true,
        validatePassword: Boolean = false,
        regexValidation: String = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{10,}$",
        imeAction: ImeAction = ImeAction.Done,
        startIcon: ImageVector? = null,
        supportingTextAlign: TextAlign = TextAlign.Start,
        placeholderTextStyle: TextStyle? = null,
        textStyle: TextStyle = TextStyle.Default,
        optional: Boolean = false,
        emptyErrorMessage: String = "Nessuna password inserita",
        shape: Shape = OutlinedTextFieldDefaults.shape,
        colors: TextFieldColors = OutlinedTextFieldDefaults.colors(),
        onValueChange: (text: String) -> Unit,
        onErrorListener: (text: Boolean) -> Unit,
    ){
        var password by rememberSaveable(stateSaver = TextFieldValue.Saver) {
            mutableStateOf(TextFieldValue(initText, TextRange(initText.length)))
        }
        val isError = errorValState ?: rememberSaveable { mutableStateOf(initErrorValue) }

//        val isEmptyError =  rememberSaveable { mutableStateOf(optional) }

        val passwordHidden = rememberSaveable { mutableStateOf(true) }

        val keyboardController = LocalSoftwareKeyboardController.current

        val focusRequester = remember { FocusRequester() }

        //Questa regex valida una password che deve contenere almeno:
        //Una lettera minuscola
        //Una lettera maiuscola
        //Un numero
        //Un carattere speciale
        //La lunghezza della password deve essere almeno di 10 caratteri.
//        val regex = regexValidation
//
//        fun validate(text: String) {
//            if(!text.matches(Regex(regex))){
//                onErrorListener(isEmptyError.value)
//                isError.value = true
//            }else{
//                isError.value = false
//            }
//        }

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                onValueChange(password.text)

//                if(!optional){
//                    if(password.text.isEmpty()) {
//                        isEmptyError.value = true
//                        onErrorListener(isEmptyError.value)
//                    }else{
//                        isEmptyError.value = false
//                        validate(password.text)
//                    }
//                }else{
//                    if (validatePassword){
//                        validate(password.text)
//                    }
//                }
            },
            label = labelText,
            placeholder = {
                if(placeholderText != null) {
                    if (placeholderTextStyle != null){
                        Text(
                            text = placeholderText,
                            style = placeholderTextStyle
                        )
                    }else {
                        Text(
                            text = placeholderText,
                        )
                    }
                }
            },
            leadingIcon = if(startIcon!= null){
                {
                    Icon(
                        startIcon,
                        contentDescription = ""
                    )
                }
            }else{
                null
            },
//            trailingIcon = {
//                IconButton(
//                    onClick = { passwordHidden.value = !passwordHidden.value }
//                ) {
//                    val visibilityIcon = if (passwordHidden.value) {
//                        Icons.Filled.Email
//                    } else {
//                        Icons.Filled.Email
//                    }
//                    val description = if (passwordHidden.value) "Show password" else "Hide password"
//                    Icon(imageVector = visibilityIcon, contentDescription = description, tint = Color.White)
//                }
//            },
            visualTransformation = if (passwordHidden.value){
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
//            supportingText = if(!isError.value && !isEmptyError.value){
//                null
//            }else{
//                val message = if(isEmptyError.value){
//                    emptyErrorMessage
//                }else{
//                    errorMessage
//                }
//                {
//                    Text(
//                        modifier = Modifier.fillMaxWidth(),
//                        text = message,
//                        textAlign = supportingTextAlign,
//                        color = if (isError.value) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary
//                    )
//                }
//            },
            colors = colors,
            textStyle = textStyle,
            singleLine = singleLine,
            isError = isError.value,
            enabled = enabled,
            shape = shape,
            keyboardOptions = KeyboardOptions(
                imeAction = imeAction,
                keyboardType= KeyboardType.Password
            ),
//            keyboardActions = KeyboardActions(
//                onDone = {
//                    keyboardController?.hide()
//                    focusRequester.freeFocus()
//                    // do something here
//                    if (validatePassword){
//                        validate(password.text)
//                    }else{
//                        if(!optional){
//                            isError.value = password.text.isEmpty()
//                            onErrorListener(isError.value)
//                        }
//                    }
//                }
//            ),
            modifier = modifier
                .semantics {
                // Provide localized description of the error
                    if (isError.value) {
                        error(errorMessage)
                    }
                }
                .focusModifier()
                .pointerInput(Unit){
                    detectTapGestures { focusRequester.requestFocus() }
                }
                .focusRequester(focusRequester)
        )
    }
}