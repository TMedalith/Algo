package pe.edu.upc.friendfindr.ui.home

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.friendfindr.feature_contacts.ui.ContactScreen
import pe.edu.upc.friendfindr.feature_contacts.ui.FavoriteScreen

@Composable
fun HomeNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home") {

        composable("Home") {
            HomeScreen(
                navigateToContact = {navController.navigate("Contact")  },
                navigateToFavorite = {navController.navigate("Favorite")  }

            )
        }

        composable("Contact") {
            ContactScreen()
        }

        composable("Favorite") {
            FavoriteScreen()
        }
    }
}

