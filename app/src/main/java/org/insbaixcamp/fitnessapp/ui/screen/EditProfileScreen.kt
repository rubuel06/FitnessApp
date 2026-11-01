package org.insbaixcamp.fitnessapp.ui.screen

import org.insbaixcamp.fitnessapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.insbaixcamp.fitnessapp.ui.component.CalendariPicker
import org.insbaixcamp.fitnessapp.ui.component.MenuDespegable
import org.insbaixcamp.fitnessapp.ui.theme.FitnessAppTheme


@Composable
fun EditProfileScreen(
    nom: String,
    email: String,
    dataNaixement: String,
    genere: String,
    onGuardar: () -> Unit,
    pes: Double,
    alçada: Double,
    objectius: String
) {

    var nomNou by remember { mutableStateOf(nom) }
    var emailNou by remember { mutableStateOf(email) }
    var dataNaixementNou by remember { mutableStateOf(dataNaixement) }
    var genereNou by remember { mutableStateOf(genere) }
    var pesNou by remember { mutableStateOf(pes.toInt().toString()) }
    var alçadaNou by remember { mutableStateOf(alçada.toInt().toString()) }
    var pesObjectiuNou by remember { mutableStateOf("55") }

    Column(modifier = Modifier.padding(16.dp)) {

        Row(modifier = Modifier.padding(bottom = 16.dp)) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.Black)
            )

            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End) {
                Button(onClick = {}) { Text("Canviar foto") }
                Button(onClick = {}) { Text("Eliminar foto") }
            }
        }

        //Dades personals
        Text(
            text = "Dades personals",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        //nom
        OutlinedTextField(
            value = nomNou,
            onValueChange = { nomNou = it },
            label = { Text("Nom complet") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )

        //email
        OutlinedTextField(
            value = emailNou,
            onValueChange = { emailNou = it },
            label = { Text("Correu electrònic") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )

        //Data de naixement amb CalendariPicker
        CalendariPicker(
            label = "Data de naixement",
            selectedDateMillis = dataNaixementNou,
            onDateSelected = { dataNaixementNou = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )

        //genere
        MenuDespegable(
            label = "Gènere",
            opcions = listOf("Home", "Dona", "Prefereixo no dir-ho"),
            valorSeleccionat = genereNou,
            onValorSeleccionat = { genereNou = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Dades físiques
        Text(
            text = "Dades físiques",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            MenuDespegable(
                label = "Alçada (cm)",
                opcions = listOf("150", "155", "160", "165", "170", "175", "180", "185", "190"),
                valorSeleccionat = alçadaNou,
                onValorSeleccionat = { alçadaNou = it },
                modifier = Modifier.weight(1f)
            )

            MenuDespegable(
                label = "Pes (kg)",
                opcions = listOf("45", "50", "55", "60", "65", "70", "75", "80", "85", "90"),
                valorSeleccionat = pesNou,
                onValorSeleccionat = { pesNou = it },
                modifier = Modifier.weight(1f)
            )

            MenuDespegable(
                label = "Objectiu de pes (kg)",
                opcions = listOf("45", "50", "55", "60", "65", "70", "75", "80", "85", "90"),
                valorSeleccionat = pesObjectiuNou,
                onValorSeleccionat = { pesObjectiuNou = it },
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onGuardar,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun EditProfileScreenPreview() {
    FitnessAppTheme {
        EditProfileScreen(
            nom = "Laia Soler",
            email = "laia.soler@exemple.com",
            dataNaixement = "14/05/1999",
            genere = "Dona",
            onGuardar = {},
            pes = 60.0,
            alçada = 165.0,
            objectius = "Perdre pes"
        )
    }
}
