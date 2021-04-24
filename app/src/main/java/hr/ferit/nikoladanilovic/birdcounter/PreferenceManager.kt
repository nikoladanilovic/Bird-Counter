package hr.ferit.nikoladanilovic.birdcounter

import android.content.Context

class PreferenceManager {
    companion object{
        const val PREF_FILE = "MyPreferences"
        const val PREFS_KEY_BIRD_COLOR = "colorOfBirds"
        const val PREFS_KEY_NUM_OF_BIRDS = "numOfBirds"
    }

    fun saveNewBirdColor(color: String){
        val sharedPreferences = BirdCounterApp.ApplicationContext.getSharedPreferences(
            PREF_FILE, Context.MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()
        editor.putString(PREFS_KEY_BIRD_COLOR, color)
        editor.apply()
    }

    fun retrieveNewBirdColor(): String? {
        val defaultStr = "#FFFFFF"
        val sharedPreferences = BirdCounterApp.ApplicationContext.getSharedPreferences(
            PREF_FILE, Context.MODE_PRIVATE
        )
        return sharedPreferences.getString(PREFS_KEY_BIRD_COLOR, defaultStr)
    }

    fun updateTotalNumberOfBirds(numOfBirds: String){
        val sharedPreferences = BirdCounterApp.ApplicationContext.getSharedPreferences(
            PREF_FILE, Context.MODE_PRIVATE
        )
        val editor = sharedPreferences.edit()
        editor.putString(PREFS_KEY_NUM_OF_BIRDS, numOfBirds)
        editor.apply()
    }

    fun retrieveTotalNumberOfBirds(): String? {
        val defaultInt = "0"
        val sharedPreferences = BirdCounterApp.ApplicationContext.getSharedPreferences(
            PREF_FILE, Context.MODE_PRIVATE
        )
        return sharedPreferences.getString(PREFS_KEY_NUM_OF_BIRDS, defaultInt)
    }
}