package br.edu.ifsp.scl.prdm.sc3029531.persistentbirdlist.navigation

sealed class Screen(val route: String) {

    data object BirdListScreen: Screen(route = "bird_list_screen")
    data object Bird: Screen(route = "bird_screen")

}