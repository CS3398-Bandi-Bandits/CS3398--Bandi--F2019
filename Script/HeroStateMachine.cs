using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

[System.Serializable]
public class HeroStateMachine : MonoBehaviour
{
    public BaseHero hero; 

    public enum TurnState
    {
        PROCESSING, 
        ADDTOLIST,
        WAITING,
        ACTION,
        DEAD
    }

    public TurnState currentState;
    //for the ProgressBar
    private float curCooldown = 0f;
    private float maxCooldown = 5f;
    public Image ProgressBar;

    void Start()
    {
        currentState = TurnState.PROCESSING;
    }

    void Update()
    {
        switch (currentState)
        {
            case (TurnState.PROCESSING):
                UpgradeProgressBar();
                break;
            case (TurnState.ADDTOLIST):
                break;
            case (TurnState.DEAD):
                break;
            case (TurnState.WAITING):
                break;
            case (TurnState.ACTION):
                break; 
        }
    }

    void UpgradeProgressBar()
    {
        curCooldown = curCooldown + Time.deltaTime;
        float calcCooldown = curCooldown / maxCooldown;
        ProgressBar.transform.localScale = new Vector3(Mathf.Clamp(calcCooldown, 0, 1), ProgressBar.transform.localScale.y, ProgressBar.transform.localScale.z);
        if(curCooldown >= maxCooldown)
        {
            currentState = TurnState.ADDTOLIST; 
        }
    }
}
