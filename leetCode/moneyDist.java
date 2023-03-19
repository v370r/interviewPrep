package leetCode;

public class moneyDist {
    public static int distMoney(int money, int children) {
        int changedMoney = money - children;
        if (changedMoney < children) {
            if (changedMoney < 7) {
                return 0;
            }
        }

        int count = 0;
        while (changedMoney > 0 && children > 0) {
            if (changedMoney >= 7) {
                children--;
                count++;
                changedMoney -= 7;
                if (changedMoney < 0) {
                    count--;
                    break;
                }
            } else {
                if (changedMoney == 3 && count >= 1 && children == 1) {
                    count--;
                    break;
                } else {
                    break;
                }
            }

        }
        if (changedMoney > 0 && children == 0) {
            count--;
        }
        return count;
    }

    public static void main(String[] args) {
        int money = 13, children = 3;
        System.out.println("distrinbuted money : " + distMoney(money, children));
    }
}
