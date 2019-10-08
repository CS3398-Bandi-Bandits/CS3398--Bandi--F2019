using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BattleStateMachine : MonoBehaviour {

    public enum PerformAction
    {
        WAIT,
        TAKEACTION,
        PERFORMACTION
    }

    public PerformAction performStates;
    public List<TurnHandler> PerformList = new List<TurnHandler>();    //list of turnhandler classes
    public List<GameObject> HeroesInBattle = new List<GameObject>();   //List for expansion to multiple heroes/enemies
    public List<GameObject> EnemysInBattle = new List<GameObject>();   // ^^

    //maybe public GameObject HeroInGame = new GameObject;
    //      pulbic GameObject EnemyInGame = new GameObject;

    // Use this for initialization
    void Start ()
    {
        performStates = PerformAction.WAIT;
        EnemysInBattle.AddRange(GameObject.FindGameObjectsWithTag("Enemy"));
        HeroesInBattle.AddRange(GameObject.FindGameObjectsWithTag("Hero"));

    }
	
	// Update is called once per frame
	void Update () {
		switch (performStates)
        {
            case (PerformAction.WAIT):
                break;
            case (PerformAction.TAKEACTION):
                break;
            case (PerformAction.PERFORMACTION):
                break;
        }
	}

    public void CollectActions(TurnHandler input)
    {
        PerformList.Add(input); 
    }
}
