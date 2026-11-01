package org.insbaixcamp.fitnessapp.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.insbaixcamp.fitnessapp.R
import org.insbaixcamp.fitnessapp.ui.theme.FitnessAppTheme

@Composable
fun ProfileScreen(
    nom: String,
    email: String,
    dataNaixement: String,
    genere: String,
    onEditar: () -> Unit,
    pes: Double,
    alçada: Double,
    objectius: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imatge de perfil
        Image(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(Color.Black)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Nom i Email
        Text(
            text = nom,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            text = email,
            fontSize = 16.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text("Data Naixement", fontWeight = FontWeight.Bold, fontSize = 12.sp)
                        Text(dataNaixement, fontSize = 14.sp)
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        Text("Gènere", fontWeight = FontWeight.Bold, fontSize = 12.sp)
                        Text(genere.ifEmpty { "No especificat" }, fontSize = 14.sp)
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        Text("Alçada", fontWeight = FontWeight.Bold, fontSize = 12.sp)
                        Text("$alçada m", fontSize = 14.sp)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Secció "Objectiu" alineada a la part esquerra
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Objectiu",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Card(
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = objectius,
                    fontSize = 16.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    FitnessAppTheme {
        ProfileScreen(
            nom = "Laia",
            email = "laia@example.com",
            dataNaixement = "15/10/1999",
            genere = "Femení",
            onEditar = {},
            pes = 60.0,
            alçada = 1.70,
            objectius = "Perdre pes"
        )
    }
}