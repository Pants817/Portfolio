using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.AI;

public class FieldofViewMoving : MonoBehaviour
{
    public Transform player;
    public Transform[] waypoints;
    public NavMeshAgent navMesh;
    public Animator animator;
    bool isPlayerThere;
    int currentWaypoint=0;
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
            if (waypoints[currentWaypoint].position == transform.position)
            {
                if (currentWaypoint == waypoints.Length-1)//if at final waypoint change the index to 0
                {
                    currentWaypoint = 0;
                } else
                {
                    currentWaypoint++;
                }
            }
            else
            {
                navMesh.SetDestination(waypoints[currentWaypoint].position); //moves back towards the way point they were at
                animator.SetBool("IsWalking", true);
            }
        }
    }
}