using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Resume : MonoBehaviour
{
    public GameObject pause;
    public void GameResume()
    {
        pause.SetActive(false);
        Time.timeScale = 1f;
    }
}
