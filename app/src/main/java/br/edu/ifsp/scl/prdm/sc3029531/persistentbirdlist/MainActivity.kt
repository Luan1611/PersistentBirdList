package br.edu.ifsp.scl.prdm.sc3029531.persistentbirdlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.edu.ifsp.scl.prdm.sc3029531.persistentbirdlist.model.Bird
import br.edu.ifsp.scl.prdm.sc3029531.persistentbirdlist.navigation.MainNavHost
import br.edu.ifsp.scl.prdm.sc3029531.persistentbirdlist.navigation.Screen
import br.edu.ifsp.scl.prdm.sc3029531.persistentbirdlist.ui.composable.component.MainTopAppBar
import br.edu.ifsp.scl.prdm.sc3029531.persistentbirdlist.ui.theme.PersistentBirdListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navHostController = rememberNavController()
            val birdViewModel: BirdViewModel = viewModel()
            val navStackBackEntry by navHostController.currentBackStackEntryAsState()
            val showActions = navStackBackEntry?.destination?.route == Screen.BirdListScreen.route

            PersistentBirdListTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        MainTopAppBar(showActions = showActions) {
                            navHostController.navigate(
                                route = Screen.Bird.route
                            )
                        }
                    }
                ) { innerPadding ->
                    MainNavHost(
                        navHostController = navHostController,
                        birdViewModel = birdViewModel,
                        modifier = Modifier.padding(innerPadding)

                    )
                }
            }

        }
    }
}