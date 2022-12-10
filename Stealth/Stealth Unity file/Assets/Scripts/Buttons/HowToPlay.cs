using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class HowToPlay : MonoBehaviour
{
    private void OnMouseUp()
    {
        SceneManager.LoadScene("HowToPlay");
    }
}

