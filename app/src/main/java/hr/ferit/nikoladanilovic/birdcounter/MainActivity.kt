package hr.ferit.nikoladanilovic.birdcounter

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import hr.ferit.nikoladanilovic.birdcounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainActivityBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        setUI()
        mainActivityBinding.btnOrangeSeen.setOnClickListener { updatePreferences("orange") }
        mainActivityBinding.btnGraySeen.setOnClickListener { updatePreferences("gray") }
        mainActivityBinding.btnRedSeen.setOnClickListener { updatePreferences("red") }
        mainActivityBinding.btnBlueSeen.setOnClickListener { updatePreferences("blue") }
        mainActivityBinding.btnResetCounter.setOnClickListener { resetCounter() }
        setContentView(mainActivityBinding.root)
    }

    private fun resetCounter() {
        val preferenceManager = PreferenceManager()
        preferenceManager.updateTotalNumberOfBirds("0")
        mainActivityBinding.tvNumberOfBirdSeen.text = preferenceManager.retrieveTotalNumberOfBirds()
        preferenceManager.saveNewBirdColor("#FFFFFF")
        mainActivityBinding.tvNumberOfBirdSeen.setBackgroundColor(Color.parseColor(preferenceManager.retrieveNewBirdColor()))
    }

    private fun setUI() {
        val preferenceManager = PreferenceManager()
        mainActivityBinding.tvNumberOfBirdSeen.text = preferenceManager.retrieveTotalNumberOfBirds()
        mainActivityBinding.tvNumberOfBirdSeen.setBackgroundColor(Color.parseColor(preferenceManager.retrieveNewBirdColor()))
    }

    private fun updatePreferences(birdColor: String) {
        var CounterColorString: String
        val preferenceManager = PreferenceManager()
        var currentNumOfBirds = preferenceManager.retrieveTotalNumberOfBirds()!!.toInt()
        currentNumOfBirds += 1
        val currentNumOfBirdsString = currentNumOfBirds.toString()
        mainActivityBinding.tvNumberOfBirdSeen.text = currentNumOfBirdsString
        preferenceManager.updateTotalNumberOfBirds(currentNumOfBirdsString)
        when(birdColor){
            "orange" -> CounterColorString = "#FF960D"
            "gray" -> CounterColorString = "#969696"
            "red" -> CounterColorString = "#E32C10"
            "blue" -> CounterColorString = "#0963EB"
            else -> CounterColorString = "#FFFFFF"
        }
        mainActivityBinding.tvNumberOfBirdSeen.setBackgroundColor(Color.parseColor(CounterColorString))
        preferenceManager.saveNewBirdColor(CounterColorString)
    }
}