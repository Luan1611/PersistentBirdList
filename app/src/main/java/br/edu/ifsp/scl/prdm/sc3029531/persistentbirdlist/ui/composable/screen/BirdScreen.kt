package br.edu.ifsp.scl.prdm.sc3029531.persistentbirdlist.ui.composable.screen

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.edu.ifsp.scl.prdm.sc3029531.persistentbirdlist.model.Bird
import br.edu.ifsp.scl.prdm.sc3029531.persistentbirdlist.ui.theme.PersistentBirdListTheme

@Composable
fun BirdScreen(modifier: Modifier = Modifier, bird: Bird = Bird(), onSaveAndQuit: (Bird) -> Unit) {

    var aveAtual by rememberSaveable { mutableStateOf(bird) }

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = aveAtual.nome,
            label = { Text(text = "Nome") },
            onValueChange = { novoValorNome ->
                aveAtual = aveAtual.copy(nome = novoValorNome)
            }
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = aveAtual.especie,
            label = { Text(text = "Espécie") },
            onValueChange = { novoValorEspecie ->
                aveAtual = aveAtual.copy(especie = novoValorEspecie)

            }
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = aveAtual.idade,
            label = { Text(text = "Idade") },
            onValueChange = { novoValorIdade ->
                aveAtual = aveAtual.copy(idade = novoValorIdade)
            }
        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                onSaveAndQuit(aveAtual)
            }
        ) {
            Text(text = "Salvar e sair")
        }
    }

}


@Preview(uiMode = UI_MODE_NIGHT_NO, showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun BirdScreenPreview() {
    PersistentBirdListTheme {
        Surface() {
            BirdScreen(
                onSaveAndQuit = {}
            )
        }
    }
}