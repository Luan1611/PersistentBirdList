package br.edu.ifsp.scl.prdm.sc3029531.persistentbirdlist.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.edu.ifsp.scl.prdm.sc3029531.persistentbirdlist.BirdViewModel
import br.edu.ifsp.scl.prdm.sc3029531.persistentbirdlist.model.Bird
import br.edu.ifsp.scl.prdm.sc3029531.persistentbirdlist.ui.composable.screen.BirdScreen

@Composable
fun BirdRoute(modifier: Modifier = Modifier, onDone: () -> Unit, birdViewModel: BirdViewModel) {

    val bird by birdViewModel.aveAtual.collectAsStateWithLifecycle()

    val operation by birdViewModel.operation.collectAsStateWithLifecycle()


    BirdScreen(
        modifier = modifier,
        bird = bird,
        onSaveAndQuit = { newOrEditedBird ->
            birdViewModel.saveBird(newOrEditedBird)
            onDone()
        },
        operation = operation
    )

}