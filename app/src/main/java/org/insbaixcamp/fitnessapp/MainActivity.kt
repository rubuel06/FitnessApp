package org.insbaixcamp.fitnessapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.insbaixcamp.fitnessapp.ui.screen.EditProfileScreen
import org.insbaixcamp.fitnessapp.ui.screen.ProfileScreen
import org.insbaixcamp.fitnessapp.ui.theme.FitnessAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FitnessAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        FitnessApp()
                    }
                }
            }
        }
    }
}

@Composable
fun FitnessApp(){

    var nom: String by remember { mutableStateOf("Laia") }
    var email: String by remember { mutableStateOf("laia.soler@exemple.com") }
    var dataNaixement: String by remember { mutableStateOf("14/05/1999") }
    var genere: String by remember { mutableStateOf("Dona") }
    var editant: Boolean by remember { mutableStateOf(false) }
    var pes: Double by remember { mutableStateOf(60.0) }
    var alçada: Double by remember { mutableStateOf(165.0) }
    var objectius: String by remember { mutableStateOf("Guanyar massa muscular") }

    if(editant){

        EditProfileScreen(
            nom,
            email,
            dataNaixement,
            genere,
            onGuardar = { editant = false },
            pes,
            alçada,
            objectius,
        )

    }else{

        ProfileScreen(nom, email, dataNaixement, genere, onEditar = { editant = true }, pes, alçada, objectius)

    }

}


@Preview(showBackground = true)
@Composable
fun FitnessAppPreview() {
    FitnessAppTheme {
        FitnessApp()
    }
}
