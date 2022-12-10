using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.UI;

public class Door : MonoBehaviour
{
    public GameObject player;
    public GameObject nextLevel;
    public Text ScoreText;
    public Controller controller;

    private void OnTriggerEnter(Collider other)
    {
        if (other.gameObject == player)//checking if the player is the one causing the collision
        {
            Time.timeScale = 0f;//freezes the gaem
            nextLevel.SetActive(true);//Makes the end screen come up
            ScoreText.text = "SCORE:" + controller.GetPoints() + "\tTIME:" + controller.GetTime() + "\tSEEN:" + controller.GetSeen();//This sets the score on the win screen
        }
    }
}
