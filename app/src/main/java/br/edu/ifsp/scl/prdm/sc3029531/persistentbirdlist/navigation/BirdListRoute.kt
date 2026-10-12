package br.edu.ifsp.scl.prdm.sc3029531.persistentbirdlist.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.edu.ifsp.scl.prdm.sc3029531.persistentbirdlist.BirdViewModel
import br.edu.ifsp.scl.prdm.sc3029531.persistentbirdlist.model.Bird
import br.edu.ifsp.scl.prdm.sc3029531.persistentbirdlist.ui.composable.screen.BirdListScreen

@Composable
fun BirdListRoute(modifier: Modifier = Modifier, birdViewModel: BirdViewModel) {

    val birdList by birdViewModel.birdList.collectAsStateWithLifecycle()

    BirdListScreen(
        modifier = modifier,
        birdList = birdList
    )

}