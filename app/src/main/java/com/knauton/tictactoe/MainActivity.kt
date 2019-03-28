package com.knauton.tictactoe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TableLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var activePlayer: Int = 1
    var Player1_list: ArrayList<Int> = arrayListOf(0)
    var Player2_list: ArrayList<Int> = arrayListOf(0)
    var count: Int = 0
    var winner: Int = 0
    
    fun resetGame(view: View){
        activePlayer = 1
        Player1_list = arrayListOf(0)
        Player2_list = arrayListOf(0)
        count = 0
        winner = 0

        cell11.isEnabled = true
        cell12.isEnabled = true
        cell13.isEnabled = true
        cell21.isEnabled = true
        cell22.isEnabled = true
        cell23.isEnabled = true
        cell31.isEnabled = true
        cell32.isEnabled = true
        cell33.isEnabled = true

        cell11.setBackgroundResource(R.drawable.rounded_button)
        cell12.setBackgroundResource(R.drawable.rounded_button)
        cell13.setBackgroundResource(R.drawable.rounded_button)
        cell21.setBackgroundResource(R.drawable.rounded_button)
        cell22.setBackgroundResource(R.drawable.rounded_button)
        cell23.setBackgroundResource(R.drawable.rounded_button)
        cell31.setBackgroundResource(R.drawable.rounded_button)
        cell32.setBackgroundResource(R.drawable.rounded_button)
        cell33.setBackgroundResource(R.drawable.rounded_button)

        result_disp.text = ""

    }

    fun buttonClicked(view: View) {
        val activeButton: Button = view as Button
        count++

        when (activePlayer) {
            1 -> {
                activeButton.setBackgroundResource(R.drawable.rounded_clicked_p1)
                winner = playGame(activeButton, activePlayer, Player1_list)
                if(winner != 0)
                    endGame(winner)
                activePlayer = 2
            }

            2 -> {
                activeButton.setBackgroundResource(R.drawable.rounded_clicked_p2)
                winner = playGame(activeButton, activePlayer, Player2_list)
                if(winner != 0)
                    endGame(winner)
                activePlayer = 1
            }
        }

        activeButton.isEnabled = false

        if (winner == 0 && count == 9)
            endGame(0)
    }

    fun playGame(activeButton: Button, activePlayer: Int, Player_list: ArrayList<Int>): Int {

        var activeCell: Int = 0

        when (activeButton.id) {
            R.id.cell11 -> activeCell = 1
            R.id.cell12 -> activeCell = 2
            R.id.cell13 -> activeCell = 3
            R.id.cell21 -> activeCell = 4
            R.id.cell22 -> activeCell = 5
            R.id.cell23 -> activeCell = 6
            R.id.cell31 -> activeCell = 7
            R.id.cell32 -> activeCell = 8
            R.id.cell33 -> activeCell = 9
        }

        Player_list.add(activeCell)

        if ((Player_list.contains(1) && Player_list.contains(2) && Player_list.contains(3))
            || (Player_list.contains(4) && Player_list.contains(5) && Player_list.contains(6))
            || (Player_list.contains(7) && Player_list.contains(8) && Player_list.contains(9))
            || (Player_list.contains(1) && Player_list.contains(4) && Player_list.contains(7))
            || (Player_list.contains(2) && Player_list.contains(5) && Player_list.contains(8))
            || (Player_list.contains(3) && Player_list.contains(6) && Player_list.contains(9))
            || (Player_list.contains(1) && Player_list.contains(5) && Player_list.contains(9))
            || (Player_list.contains(3) && Player_list.contains(5) && Player_list.contains(7)))

            return activePlayer

        return 0
    }

    fun endGame(winner: Int) {
        when(winner){
            0 -> {
                result_disp.setTextColor(Color.parseColor("#00000E"))
                result_disp.text = "DRAW"
            }
            1-> {
                result_disp.setTextColor(Color.parseColor("#B03C36"))
                result_disp.text = "WINNER"
            }
            2-> {
                result_disp.setTextColor(Color.parseColor("#007DBB"))
                result_disp.text = "WINNER"
            }
        }

        cell11.isEnabled = false
        cell12.isEnabled = false
        cell13.isEnabled = false
        cell21.isEnabled = false
        cell22.isEnabled = false
        cell23.isEnabled = false
        cell31.isEnabled = false
        cell32.isEnabled = false
        cell33.isEnabled = false
    }

}