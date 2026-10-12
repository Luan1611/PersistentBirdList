package br.edu.ifsp.scl.prdm.sc3029531.persistentbirdlist.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import br.edu.ifsp.scl.prdm.sc3029531.persistentbirdlist.BirdViewModel

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
    birdViewModel: BirdViewModel
) {
    NavHost(
        modifier = modifier,
        navController = navHostController,
        startDestination = Screen.BirdListScreen.route
    ) {
        composable(
            route = Screen.BirdListScreen.route
        ) {
            BirdListRoute(birdViewModel = birdViewModel)
        }

        composable(
            route = Screen.Bird.route
        ) {
            BirdRoute(
                birdViewModel = birdViewModel,
                onDone = {
                    navHostController.popBackStack()
                }
            )
        }

    }

}