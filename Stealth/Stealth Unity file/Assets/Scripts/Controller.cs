using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class Controller : MonoBehaviour
{
    private int points;
    private float time;
    private int seen;
    private bool playerMoved=false;
    public bool gamePaused;
    public GameObject pause;
   

    public void AddPoint()
    {
        points++;
    }
    private void Update()
    {
        if (playerMoved == true)
        {
            time = time + 1 * Time.deltaTime;
        }
        if (Input.GetKeyDown(KeyCode.Escape))
        {
            if (gamePaused)
            {
                pause.SetActive(false);
                Time.timeScale = 1f;
            }
            else
            {
                pause.SetActive(true);
                Time.timeScale = 0f;
            }

        }
    }
    public void AddSeen()
    {
        seen++;
    }
    public void PlayerMove()
    {
        playerMoved = true;
    }
    public string GetPoints()
    {
        return points.ToString();
    }
    public string GetTime()
    {
        return time.ToString("F2");//only the first 2 decimals
    }
    public string GetSeen()
    {
        return seen.ToString();
    }




}
