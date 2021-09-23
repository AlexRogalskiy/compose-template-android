package ru.surf.other.ui.screens.signUp

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import com.keygenqt.forms.base.FormFieldsState
import com.keygenqt.forms.fields.FormField
import com.keygenqt.forms.fields.FormFieldNumber
import com.keygenqt.forms.fields.FormFieldPhone
import com.keygenqt.modifier.paddingLarge
import com.keygenqt.modifier.paddingMedium
import com.keygenqt.modifier.paddingSmall
import com.keygenqt.modifier.sizeLarge
import ru.surf.core.compose.BoxTextFieldError
import ru.surf.core.theme.MainAppTheme
import ru.surf.other.R
import ru.surf.other.ui.actions.SignUpActions
import ru.surf.other.ui.forms.SignUpProfileFieldsForm.*

@OptIn(ExperimentalPagerApi::class)
@Composable
fun SignUpFormProfile(
    state: PagerState = rememberPagerState(pageCount = 0),
    loading: Boolean = false,
    commonError: String? = null,
    onActions: (SignUpActions) -> Unit = {},
    dataEmail: String = "",
    dataPass: String = "",
) {
    val listState = rememberScrollState()

    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .background(MaterialTheme.colors.background)
            .navigationBarsWithImePadding()
            .fillMaxSize()
            .verticalScroll(listState)
    ) {

        Spacer(modifier = Modifier.sizeLarge())

        // common error
        commonError?.let {
            BoxTextFieldError(textError = it)
            Spacer(Modifier.sizeLarge())
            LaunchedEffect(commonError) { listState.animateScrollTo(0) }
        }

        // to top list
        LaunchedEffect(state.currentPage) {
            listState.animateScrollTo(0)
        }

        SignUpForm(
            state = state,
            dataEmail = dataEmail,
            dataPass = dataPass,
            loading = loading,
            onActions = onActions
        )

        Spacer(modifier = Modifier.sizeLarge())
    }
}

@OptIn(ExperimentalComposeUiApi::class, ExperimentalPagerApi::class)
@Composable
private fun SignUpForm(
    state: PagerState,
    dataEmail: String = "",
    dataPass: String = "",
    loading: Boolean = false,
    onActions: (SignUpActions) -> Unit = {},
) {
    Column(
        modifier = Modifier
    ) {

        val softwareKeyboardController = LocalSoftwareKeyboardController.current
        val localFocusManager = LocalFocusManager.current

        // create from state
        val formFields = FormFieldsState().apply {
            add(SignUpFname, remember { SignUpFname.state.default("") })
            add(SignUpLname, remember { SignUpLname.state.default("") })
            add(SignUpPhoneWork, remember { SignUpPhoneWork.state.default("") })
            add(SignUpPhoneHome, remember { SignUpPhoneHome.state.default("") })
            add(SignUpCard, remember { SignUpCard.state.default("") })
            add(SignUpCvc, remember { SignUpCvc.state.default("") })
            add(SignUpBio, remember { SignUpBio.state.default("") })
        }

        // clear error
        LaunchedEffect(state.currentPage) {
            formFields.clearError()
        }

        // click submit
        val submitClick = {
            // clear focuses
            localFocusManager.clearFocus()
            // validate before send
            formFields.validate()
            // check has errors
            if (!formFields.hasErrors()) {
                // submit query
                onActions(
                    SignUpActions.SignUp(
                        email = dataEmail,
                        pass = dataPass,
                        fname = formFields.get(SignUpFname).getValue(),
                        lname = formFields.get(SignUpLname).getValue(),
                        phoneWork = formFields.get(SignUpPhoneWork).getValue(),
                        phoneHome = formFields.get(SignUpPhoneHome).getValue(),
                        card = formFields.get(SignUpCard).getValue(),
                        cvc = formFields.get(SignUpCvc).getValue(),
                        bio = formFields.get(SignUpBio).getValue(),
                    )
                )
                // hide keyboard
                softwareKeyboardController?.hide()
            }
        }

        Spacer(modifier = Modifier.paddingSmall())

        Text(
            text = stringResource(id = R.string.sign_up_subtitle_info),
            style = MaterialTheme.typography.subtitle2,
        )

        Spacer(modifier = Modifier.paddingSmall())

        FormField(
            label = stringResource(id = R.string.sign_up_required_fname),
            enabled = !loading,
            state = formFields.get(SignUpFname),
            imeAction = ImeAction.Next,
            keyboardActions = KeyboardActions(onNext = { formFields.get(SignUpLname).requestFocus() }),
            filterEmoji = true
        )

        Spacer(modifier = Modifier.paddingLarge())

        FormField(
            label = stringResource(id = R.string.sign_up_required_lname),
            enabled = !loading,
            state = formFields.get(SignUpLname),
            imeAction = ImeAction.Next,
            keyboardActions = KeyboardActions(onNext = { formFields.get(SignUpPhoneWork).requestFocus() }),
            filterEmoji = true
        )

        Spacer(modifier = Modifier.paddingLarge())

        Text(
            text = stringResource(id = R.string.sign_up_subtitle_connection),
            style = MaterialTheme.typography.subtitle2,
        )

        Spacer(modifier = Modifier.paddingSmall())

        FormFieldPhone(
            label = stringResource(id = R.string.sign_up_required_phone_work),
            enabled = !loading,
            state = formFields.get(SignUpPhoneWork),
            imeAction = ImeAction.Next,
            keyboardActions = KeyboardActions(onNext = { formFields.get(SignUpPhoneHome).requestFocus() }),
            mask = "+7 (###) ###-##-##",
            placeholder = "+7 (000) 000-000-000",
        )

        Spacer(modifier = Modifier.paddingLarge())

        FormFieldPhone(
            label = stringResource(id = R.string.sign_up_phone_home),
            enabled = !loading,
            state = formFields.get(SignUpPhoneHome),
            imeAction = ImeAction.Next,
            keyboardActions = KeyboardActions(onNext = { formFields.get(SignUpCard).requestFocus() }),
            mask = "+380 (###) ###-##-##",
            placeholder = "+380 (000) 000-000-000",
        )

        Spacer(modifier = Modifier.paddingLarge())

        Text(
            text = stringResource(id = R.string.sign_up_subtitle_payment),
            style = MaterialTheme.typography.subtitle2,
        )

        Spacer(modifier = Modifier.paddingSmall())

        FormFieldNumber(
            label = stringResource(id = R.string.sign_up_number_card),
            enabled = !loading,
            state = formFields.get(SignUpCard),
            imeAction = ImeAction.Next,
            keyboardActions = KeyboardActions(onNext = { formFields.get(SignUpCvc).requestFocus() }),
            mask = "####-####-####-####",
            placeholder = "0000-0000-0000-0000",
        )

        Spacer(modifier = Modifier.paddingLarge())

        FormFieldNumber(
            label = stringResource(id = R.string.sign_up_cvc),
            enabled = !loading,
            state = formFields.get(SignUpCvc),
            imeAction = ImeAction.Next,
            keyboardActions = KeyboardActions(onNext = { formFields.get(SignUpBio).requestFocus() }),
            mask = "###",
            placeholder = "000",
        )

        Spacer(modifier = Modifier.paddingLarge())

        Text(
            text = stringResource(id = R.string.sign_up_bio),
            style = MaterialTheme.typography.subtitle2,
        )

        Spacer(modifier = Modifier.paddingSmall())

        FormField(
            lines = 3,
            maxLines = 5,
            singleLine = false,
            enabled = !loading,
            state = formFields.get(SignUpBio),
            imeAction = ImeAction.Default,
        )

        Spacer(modifier = Modifier.paddingLarge())

        // Submit button
        Button(
            enabled = !loading,
            onClick = { submitClick.invoke() },
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.large,
            colors = ButtonDefaults.textButtonColors(backgroundColor = MaterialTheme.colors.secondary),
        ) {
            Text(
                text = stringResource(id = R.string.sign_in_form_button_submit).uppercase(),
            )
        }

        Spacer(modifier = Modifier.paddingMedium())
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO, device = Devices.PIXEL_4)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, device = Devices.NEXUS_6)
@Composable
private fun Preview() {
    MainAppTheme {
        Scaffold {
            SignUpFormProfile()
        }
    }
}