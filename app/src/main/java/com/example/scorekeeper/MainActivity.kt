package com.example.scorekeeper

import  com.example.scorekeeper.R
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.scorekeeper.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


//    Set default values
    private var activeHomeScore = 0
    private var activeAwayScore = 0
    private var totalHomeScore = 0
    private var totalAwayScore = 0
    private var awayTeam = R.string.away_team
    private var homeTeam = R.string.home_team

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)


        val sharedPreferences = getPreferences(MODE_PRIVATE)
        val score = sharedPreferences!!.getBoolean("saveScore", false)
        val homeScore = sharedPreferences!!.getString("totalHomeScore", "0")
        val awayScore = sharedPreferences!!.getString("totalAwayScore", "0")
        setContentView(binding.root)
       if (score) {
           binding.homeScore.text = homeScore
           binding.awayScore.text = awayScore
       }

        binding.homeScore1.setOnClickListener {
            activeHomeScore = 1
            Toast.makeText(
                this,
                "Point 1 selected for ${getString(homeTeam)}, now increase or decrease total score",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.homeScore2.setOnClickListener {
            activeHomeScore = 2
            Toast.makeText(
                this,
                "Point 2 selected for ${getString(homeTeam)}, now increase or decrease total score",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.homeScore3.setOnClickListener {
            activeHomeScore = 3
            Toast.makeText(
                this,
                "Point 3 selected for ${getString(homeTeam)}, now increase or decrease total score",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.awayScore1.setOnClickListener {
            activeAwayScore = 1
            Toast.makeText(
                this,
                "Point 1 selected for ${getString(awayTeam)}, now increase or decrease total score",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.awayScore2.setOnClickListener {
            activeAwayScore = 2
            Toast.makeText(
                this,
                "Point 2 selected for ${getString(awayTeam)}, now increase or decrease total score",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.awayScore3.setOnClickListener {
            activeAwayScore = 3
            Toast.makeText(
                this,
                "Point 3 selected for ${getString(awayTeam)}, now increase or decrease total score",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.nextButtonHome.setOnClickListener {
            if (activeHomeScore != 0) {
                val sharedPreferences = getPreferences(MODE_PRIVATE)
                val editor = sharedPreferences.edit()
            if (totalHomeScore < activeHomeScore) {
                totalHomeScore = 0;
            } else {
                totalHomeScore -= activeHomeScore


            }
                editor.putString("totalHomeScore", totalHomeScore.toString())
                editor.commit()
                binding.homeScore.text = totalHomeScore.toString()
//            Reset Active score
            activeHomeScore = 0
            } else {
                Toast.makeText(
                    this,
                    "Select a score first",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }

        binding.prevButtonHome.setOnClickListener {
            if (activeHomeScore != 0) {
                val sharedPreferences = getPreferences(MODE_PRIVATE)

                totalHomeScore += activeHomeScore
                val editor = sharedPreferences.edit()
                editor.putString("totalHomeScore", totalHomeScore.toString())
                editor.commit()
                binding.homeScore.text = totalHomeScore.toString()
                //            Reset Active score
                activeHomeScore = 0
            } else {
                Toast.makeText(
                    this,
                    "Select a score first",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }


        binding.nextButtonAway.setOnClickListener {
            if (activeAwayScore != 0) {
                val sharedPreferences = getPreferences(MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                if (totalAwayScore < activeAwayScore) {
                    totalAwayScore = 0;


                } else {
                    totalAwayScore -= activeAwayScore
                }
                editor.putString("totalAwayScore", totalAwayScore.toString())
                editor.commit()
                binding.awayScore.text = totalAwayScore.toString()
//            Reset Active score
                activeAwayScore = 0
            } else {
                Toast.makeText(
                    this,
                    "Select a score first",
                    Toast.LENGTH_SHORT
                ).show()
            }


        }

        binding.prevButtonAway.setOnClickListener {
            if (activeAwayScore != 0) {
                val sharedPreferences = getPreferences(MODE_PRIVATE)
                totalAwayScore += activeAwayScore
                binding.awayScore.text = totalAwayScore.toString()
                val editor = sharedPreferences.edit()
                editor.putString("totalAwayScore", totalAwayScore.toString())
                editor.commit()
                //            Reset Active score
                activeAwayScore = 0

            } else {
                Toast.makeText(
                    this,
                    "Select a score first",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }

//        Refresh scores

        binding.refresh.setOnClickListener {
            activeHomeScore = 0
            activeAwayScore = 0
            totalHomeScore = 0
            totalAwayScore = 0
            binding.homeScore.text = totalHomeScore.toString()
            binding.awayScore.text = totalAwayScore.toString()
            val sharedPreferences = getPreferences(MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("totalAwayScore", totalAwayScore.toString())
            editor.putString("totalHomeScore", totalHomeScore.toString())
            editor.commit()
            Toast.makeText(
                this,
                "Scores refreshed",
                Toast.LENGTH_SHORT
            ).show()
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.mymenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.action_settings -> {
                val intent = Intent(this@MainActivity, SettingsActivity::class.java)
                startActivity(intent);
                true
            }
            R.id.action_about -> {
                Toast.makeText(
                    this,
                    "Chinedu Uche \n JAV-1001",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}