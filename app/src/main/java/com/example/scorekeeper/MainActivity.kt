package com.example.scorekeeper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.scorekeeper.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    private var activeHomeScore = 0
    private var activeAwayScore = 0
    private var totalHomeScore = 0
    private var totalAwayScore = 0

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.homeScore1.setOnClickListener {
            activeHomeScore = 1
            Toast.makeText(
                this,
                "Point 1 selected for ${R.string.home_team}, now increase or decrease",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.homeScore2.setOnClickListener {
            activeHomeScore = 2
            Toast.makeText(
                this,
                "Point 2 selected for ${R.string.home_team}, now increase or decrease",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.homeScore3.setOnClickListener {
            activeHomeScore = 3
            Toast.makeText(
                this,
                "Point 3 selected for ${R.string.home_team}, now increase or decrease",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.awayScore1.setOnClickListener {
            activeAwayScore = 1
            Toast.makeText(
                this,
                "Point 1 selected for ${R.string.away_team}, now increase or decrease",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.awayScore1.setOnClickListener {
            activeAwayScore = 2
            Toast.makeText(
                this,
                "Point 2 selected for ${R.string.away_team}, now increase or decrease",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.awayScore1.setOnClickListener {
            activeAwayScore = 3
            Toast.makeText(
                this,
                "Point 3 selected for ${R.string.away_team}, now increase or decrease",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.prevButtonHome.setOnClickListener {
            if (activeHomeScore != 0) {
            if (totalHomeScore < activeHomeScore) {
                totalHomeScore = 0;
            } else {
                totalHomeScore -= activeHomeScore
            }
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

        binding.nextButtonHome.setOnClickListener {
            if (activeHomeScore != 0) {

                totalHomeScore += activeHomeScore
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


        binding.prevButtonAway.setOnClickListener {
            if (activeAwayScore != 0) {
                if (totalAwayScore < activeAwayScore) {
                    totalAwayScore = 0;
                } else {
                    totalAwayScore -= activeAwayScore
                }
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

        binding.nextButtonAway.setOnClickListener {
            if (activeAwayScore != 0) {

                totalAwayScore += activeAwayScore
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
    }
}