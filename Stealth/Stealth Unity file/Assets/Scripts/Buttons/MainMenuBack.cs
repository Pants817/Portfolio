using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class MainMenuBack : MonoBehaviour
{
    private void OnMouseUp()
    {
        SceneManager.LoadScene("MainMenu");
    }
}
