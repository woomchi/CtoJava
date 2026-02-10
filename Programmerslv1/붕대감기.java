package Programmerslv1;

public class 붕대감기 {
    /* 핵심 로직 : 반복되는 규칙을 이벤트 중심으로 진행 + 조기종료 */

    // 나의 풀이
    // 1초 단위의 타임라인으로 불필요한 연산 발생
    // 조기 종료하지 않아 불필요한 연산 발생
    public int solution(int[] bandage, int health, int[][] attacks) {
        int startTime = 1;
        int endTime = attacks[attacks.length-1][0];

        boolean isDead = false;
        int currentHealth = health;
        int continueTime = 0;
        int attackTime = 0;
        for(int i = startTime ; i <= endTime ; i++){
            continueTime++;
            if(isDead)  continue;
            if(attacks[attackTime][0] == i){
                currentHealth -= attacks[attackTime++][1];
                continueTime = 0;
                if(currentHealth <= 0)  isDead = true;
            }else{
                if(continueTime == bandage[0]){
                    currentHealth += bandage[2];
                    continueTime = 0;
                }
                currentHealth += bandage[1];
                if(health < currentHealth)  currentHealth = health;
            }
        }

        if(currentHealth > 0){
            return currentHealth;
        }
        return -1;
    }

    // 다른 사람의 풀이 - 최적화된 풀이
    public int solutionOther(int[] bandage, int health, int[][] attacks) {
        int cnt = bandage[0]; // 추가 체력 기준
        int now = health; // 현재 체력
        int std = 0; // 마지막으로 공격당한 시간

        int v1, v2; // 추가 체력 받을 수 있나?
        for (int[] atk: attacks) {
            if (now <= 0) {
                return -1;
            }

            v1 = atk[0] - std - 1; // 시간 차이
            v2 = v1 / cnt; // 추가 체력 회수

            // 맞기 직전까지의 체력 정산
            std = atk[0];
            now = Math.min(health, now + (v1 * bandage[1]));
            now = Math.min(health, now + (v2 * bandage[2]));

            now -= atk[1];
        }        

        return now <= 0 ? -1 : now;
    }

    // Gemini 개선 풀이 - 공격 시간을 기준으로 마지막 공격 사이의 시간을 토대로 회복 반영
    public int solutionGemini(int[] bandage, int health, int[][] attacks) {
        int castingTime = bandage[0];
        int healPerSec = bandage[1];
        int bonusHeal = bandage[2];
        
        int currentHealth = health;
        int lastAttackTime = 0; // 마지막으로 공격당한(혹은 시작) 시간

        for (int[] attack : attacks) {
            int attackTime = attack[0];
            int damage = attack[1];

            // 1. 공격과 공격 사이의 시간 차이 계산 (회복 가능한 시간)
            int timeDiff = attackTime - lastAttackTime - 1; 

            // 2. 회복 로직 (시간 차이가 0보다 클 때만 수행)
            if (timeDiff > 0) {
                // 기본 회복량: 시간 차이 * 초당 회복량
                int healAmount = timeDiff * healPerSec;
                
                // 추가 회복량: (시간 차이 / 시전 시간) * 추가 회복량
                // 정수 나눗셈을 이용해 시전 성공 횟수를 구함
                healAmount += (timeDiff / castingTime) * bonusHeal;
                
                currentHealth += healAmount;
                
                // 최대 체력 초과 방지
                if (currentHealth > health) {
                    currentHealth = health;
                }
            }

            // 3. 공격 적용
            currentHealth -= damage;
            
            // 4. 사망 체크 (즉시 종료)
            if (currentHealth <= 0) {
                return -1;
            }

            // 다음 계산을 위해 마지막 공격 시간 갱신
            lastAttackTime = attackTime;
        }

        return currentHealth;
    }
}
