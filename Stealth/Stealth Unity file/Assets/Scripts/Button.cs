using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class Button : MonoBehaviour
{
    public string level;
    public void NextLevel()
    {
        if (level == "Quit")//only if its the quit button
        {
            Application.Quit();
        }
        else
        { 
            SceneManager.LoadScene(level);
            Time.timeScale = 1f;//unfereezes the game
        }
    }
}
