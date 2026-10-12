package br.edu.ifsp.scl.prdm.sc3029531.persistentbirdlist.ui.composable.screen

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import br.edu.ifsp.scl.prdm.sc3029531.persistentbirdlist.model.Bird
import br.edu.ifsp.scl.prdm.sc3029531.persistentbirdlist.ui.theme.PersistentBirdListTheme

@Composable
fun BirdListScreen(modifier: Modifier = Modifier, birdList: List<Bird>) {

    LazyColumn(modifier = modifier.fillMaxWidth()) {

        items(items = birdList, key = {currentIterationBird -> currentIterationBird.id}) { currentBird ->

            var caixaExpandida by remember { mutableStateOf(value = false) }

            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .combinedClickable(
                            onClick = {

                            },
                            onLongClick = {
                                caixaExpandida = true
                            }
                        )
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = currentBird.nome)
                        Text(text = currentBird.especie)
                    }
                }

                DropdownMenu(
                    expanded = caixaExpandida,
                    onDismissRequest = {caixaExpandida = false}
                ) {
                    DropdownMenuItem(
                        text = { Text(text = "Editar") },
                        onClick = {

                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Remover") },
                        onClick = {

                        }
                    )
                }

            }

        }

    }

}

@Preview(uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun BirdListScreenPreview() {
    PersistentBirdListTheme {
        Surface() {
            BirdListScreen(
                birdList = listOf()
            )
        }
    }
}