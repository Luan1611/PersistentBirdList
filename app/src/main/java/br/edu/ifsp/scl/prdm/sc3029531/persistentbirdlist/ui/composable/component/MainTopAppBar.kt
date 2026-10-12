package br.edu.ifsp.scl.prdm.sc3029531.persistentbirdlist.ui.composable.component

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.edu.ifsp.scl.prdm.sc3029531.persistentbirdlist.R
import br.edu.ifsp.scl.prdm.sc3029531.persistentbirdlist.ui.theme.PersistentBirdListTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopAppBar(
    showActions: Boolean = true,
    onNavigate: () -> Unit
) {
    TopAppBar(
        title = { Text(stringResource(R.string.app_name)) },
        modifier = Modifier.fillMaxWidth(),
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        actions = {
            if (showActions) {
                MainDropdownMenu(onNavigate = onNavigate)
            }
        }
    )
}

@Preview(uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun BirdListScreenPreview() {
    PersistentBirdListTheme {
        Surface() {
            MainTopAppBar(onNavigate = {})
        }
    }
}