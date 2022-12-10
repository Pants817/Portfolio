using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class EnemyCollision : MonoBehaviour
{
    public float fadeTime = 1f;
    public float showTime = 1f;
    public GameObject player;
    public CanvasGroup loseCanvas;

    private float timer;
    private bool playerCollision;

    private void OnCollisionEnter(Collision other)
    {
        if (other.gameObject == player)
        {
            playerCollision = true;//checks if the object that is colliding is the player
        }
    }

    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        if (playerCollision)
        {
            timer += Time.deltaTime;
            loseCanvas.alpha = timer / fadeTime;//makes the image less opaque 

            if (timer > showTime)
            {
                Application.LoadLevel(Application.loadedLevel);//restarts after the given time
            }
        }
    }
}
