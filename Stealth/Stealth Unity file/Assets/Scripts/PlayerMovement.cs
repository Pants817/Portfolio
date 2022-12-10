using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerMovement : MonoBehaviour
{
    public float turnSpeed = 20;
    public float speed = 10f;
    public Animator animator;
    public Rigidbody rigidbody;
    Vector3 movement;
    Quaternion rotation = Quaternion.identity;
    public Controller controller;

    void Start()
    {
        
    }

    void Update()
    {
        float horizontal = Input.GetAxis("Horizontal");//getting inputs
        float vertical = Input.GetAxis("Vertical");

        movement.Set(horizontal*speed, 0f, vertical*speed);

        bool hasHorizontalInput = !Mathf.Approximately(horizontal, 0f);//this checks if the input is approximately 0 
        bool hasVerticalInput = !Mathf.Approximately(vertical, 0f);
        bool isWalking = hasHorizontalInput || hasVerticalInput;//if either is not 0 then isWalking is true

        if (isWalking)
        {
            animator.SetBool("IsWalking", true);
            controller.PlayerMove();
        } else
        {
            animator.SetBool("IsWalking", false);
        }

        Vector3 direction = Vector3.RotateTowards(transform.forward, movement, turnSpeed * Time.deltaTime, 0f);
        rotation = Quaternion.LookRotation(direction);//the direction it is going to rotate to

        
    }
    private void OnAnimatorMove()
    {
        rigidbody.MovePosition(rigidbody.position + movement * animator.deltaPosition.magnitude);//moving the player
        rigidbody.MoveRotation(rotation);//rotating the player
    }
}
