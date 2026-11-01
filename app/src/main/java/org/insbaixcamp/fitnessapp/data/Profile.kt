package org.insbaixcamp.fitnessapp.data

import android.content.Context

class Profile {
    private var nom: String = ""
    var email: String = ""
    var dataNaixement: Long = 0
    var genere: String = ""
    var pes: Double = 0.0
    var pesObjectiu: Double = 0.0
    var alçada: Int = 0
    var objectiu: String = ""

    fun getNom(context: Context): String {
        val prefs = context.getSharedPreferences("fitness_app", Context.MODE_PRIVATE)
        nom = prefs.getString("nom", "") ?: ""
        return nom
    }

    fun setNom(context: Context, nomNou: String) {
        nom = nomNou
        val prefs = context.getSharedPreferences("fitness_app", Context.MODE_PRIVATE)
        prefs.edit().putString("nom", nomNou).apply()
    }
}
