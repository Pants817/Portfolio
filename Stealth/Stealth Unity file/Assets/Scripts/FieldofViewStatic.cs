using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.AI;

public class FieldofViewStatic : MonoBehaviour
{
    public Transform player;
    public Transform waypoint;
    public NavMeshAgent navMesh;
    public GameObject self;
    public Animator animator;
    bool isPlayerThere;
    private float rotation;
    public Controller controller;


    private void OnTriggerEnter(Collider other)
    {
        if (other.transform == player)//checking if the player is the one causing the collision
        {
            isPlayerThere = true;
            controller.AddSeen();
        }
    }
    private void OnTriggerExit(Collider other)
    {
        if (other.transform == player)//checking if the player is the one causing the collision
        {
            isPlayerThere = false;
        }
    }
    void Start()
    {
        rotation = transform.rotation.eulerAngles.y;
    }

    void FixedUpdate()
    {
        if (isPlayerThere)
        {
            RaycastHit hit;
            Vector3 rayDirection= player.position - transform.position + Vector3.up;
            if (Physics.Raycast(transform.position, rayDirection, out hit, Mathf.Infinity))
            {
                if (hit.collider.transform == player)
                {
                    navMesh.SetDestination(player.position); //moves towards the player
                    animator.SetBool("IsWalking", true);
                }
            }
        }
        else
        {
            if (waypoint.position!=transform.position)
            {
                navMesh.SetDestination(waypoint.position);//moves back towards the way point they were at
                animator.SetBool("IsWalking", true);
            }
            if (waypoint.position == transform.position)
            {
                transform.rotation = Quaternion.Euler(0f, rotation, 0f);//sets the rotation of the field of view
                self.transform.rotation = Quaternion.Euler(0f, rotation, 0f);//sets the rotation of the actual enemy 
                animator.SetBool("IsWalking", false);
            }
        }
    }
}
