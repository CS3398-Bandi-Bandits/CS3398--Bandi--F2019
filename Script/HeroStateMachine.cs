/*
 * FitWarriorsBattleProject
 * @Author: Dakota Ruhl
 */

using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

[System.Serializable]
public class HeroStateMachine : MonoBehaviour
{
    private BattleStateMachine BSM;
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
    public GameObject Selector;
    //Ienumerator 
    public GameObject EnemyToAttack;
    private bool actionStarted = false;
    private Vector3 startPosition;
    private float animSpeed = 10f;
    //when hero dies
   
    

    void Start()
    {
        GameObject performer = GameObject.Find("Hero");
        performer.SetActive(true);
        startPosition = transform.position;
        curCooldown = UnityEngine.Random.Range(0, 2.5f); //SPEED STAT GOES HERE
        Selector.SetActive(false);
        BSM = GameObject.Find("BattleManager").GetComponent<BattleStateMachine>();
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
                BSM.HerosToManage.Add(this.gameObject);
                currentState = TurnState.WAITING;
                break;
            case (TurnState.WAITING):
                break;
            case (TurnState.ACTION):
                StartCoroutine(TimeForAction());
                break;
            case (TurnState.DEAD):
                GameObject performer = GameObject.Find("Hero");
                performer.SetActive(false);
                Time.timeScale = 0;
                break;
        }
    }

    void UpgradeProgressBar()
    {
        curCooldown = curCooldown + Time.deltaTime;
        float calcCooldown = curCooldown / maxCooldown;
        //ProgressBar.transform.localScale = new Vector3(Mathf.Clamp(calcCooldown, 0, 1), ProgressBar.transform.localScale.y, ProgressBar.transform.localScale.z);
        
        if (curCooldown >= maxCooldown)
        {
            currentState = TurnState.ADDTOLIST;
        }
    }

    private IEnumerator TimeForAction()
    {
        if (actionStarted)
            yield break;


        actionStarted = true;
        //animate the enemy near the hero to attack
        Vector3 heroPosition = new Vector3(EnemyToAttack.transform.position.x-1.5f, EnemyToAttack.transform.position.y, EnemyToAttack.transform.position.z);
        while (MoveTowardsEnemy(heroPosition)) { yield return null; }

        //wait a bit
        yield return new WaitForSeconds(0.5f);

        //do damage
        doDamage();

        //animate back to start position
        Vector3 firstPosition = startPosition;
        while (MoveTowardsStart(firstPosition)) { yield return null; }

        //remove this perfromer from the list in BSM
        BSM.PerformList.RemoveAt(0);

        //reset the BSM -> wait
        BSM.performStates = BattleStateMachine.PerformAction.WAIT;
        //end coroutine
        actionStarted = false;
        //reset the enemy state
        curCooldown = 0f;
        currentState = TurnState.PROCESSING;
    }

    private bool MoveTowardsEnemy(Vector3 target)
    {
        return target != (transform.position = Vector3.MoveTowards(transform.position, target, animSpeed * Time.deltaTime));
    }

    private bool MoveTowardsStart(Vector3 target)
    {
        return target != (transform.position = Vector3.MoveTowards(transform.position, target, animSpeed * Time.deltaTime));
    }

    void doDamage()
    {
        float rand = (float)GetRandomNumberInRange(0, 2);
        float calc_damage = hero.curATK * rand;   // + the chosen attack by the hero  //Random number float 0-2  x curATK
        this.EnemyToAttack.GetComponent<EnemyStateMachine>().TakeDamage(calc_damage);
        Debug.Log("Hero has done " + calc_damage + " damage, " + "with random double " + rand);
    }

    public void TakeDamage(float getDamageAmount)
    {
        float rand = (float)GetRandomNumberInRange(0, 2);
        float damageTaken = getDamageAmount - (hero.baseDEF * rand); //Damage incoming - Defense*random(0,2)
        hero.curHP -= damageTaken; 
        Debug.Log("Hero has taken " + damageTaken + " damage, " + "with defence * random double " + rand);
        if (hero.curHP <= 0)
        {
            currentState = TurnState.DEAD;
        }
        
        if (hero.curHP < hero.baseHP)
        {
            ProgressBar.transform.localScale = new Vector3(Mathf.Clamp(hero.curHP / hero.baseHP, 0, 1), ProgressBar.transform.localScale.y, ProgressBar.transform.localScale.z);
            if (this.hero.curHP <= 0)
            {
                ProgressBar.transform.localScale =
                    new Vector3(Mathf.Clamp(0, 0, 1), ProgressBar.transform.localScale.y, ProgressBar.transform.localScale.z);
            }
        } 
    }

    public double GetRandomNumberInRange(double min, double max)
    {
        return new System.Random().NextDouble() * (max - min) + min; 
    }

    public void reduceHealth()
    {

    }
    
}
