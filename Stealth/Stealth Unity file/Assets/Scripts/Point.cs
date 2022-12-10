using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Point : MonoBehaviour
{
    public GameObject player;
    public Controller controller;

    // Update is called once per frame
    void Update()
    {
        transform.Rotate(new Vector3(15, 30, 45) * Time.deltaTime); // rotates the cube
    }
    private void OnTriggerEnter(Collider other)
    {
        if (other.gameObject == player)
        {
            controller.AddPoint();
            gameObject.SetActive(false);
        }
    }
}
