package pe.edu.upc.friendfindr.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(navigateToContact: () -> Unit, navigateToFavorite : () -> Unit) {
    Scaffold() { paddingValues->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Button(
                onClick = { navigateToContact() },
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Personas")
            }

            Button(
                onClick = { navigateToFavorite() },
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Favoritos")
            }
        }
    }

}
