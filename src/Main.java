import java.util.Random;
class Hero {
    protected int strength; // показатель силы
    protected int agility; // показатель ловкости
    protected int intelligence; // показатель интеллекта
    protected int health; // показатель здоровья
    protected double moveSpeed; // показатель скорости бега
    protected double armor; // показатель брони
    protected int damage; // показатель урона
    protected Weapon hand; // слот в руке

    Hero(int s, int a, int i, int h, double ms, double arm, int dmg, Sword hd) {
        this.strength = s;
        this.agility = a;
        this.intelligence = i;
        this.health = h;
        this.moveSpeed = ms;
        this.armor = arm;
        this.damage = dmg;
        this.hand = hd;
    }
    void RuneHaste(double new_moveSpeed) {
        this.moveSpeed = new_moveSpeed;
        System.out.println("Hero " + moveSpeed);
    }

    void RuneHaste(String s) {
        this.moveSpeed = 0;
        System.out.println("Скорость не корректная");
    }
}

class StrengthHero extends Hero {
    protected String name;
    protected String attribute = "Strength";


    StrengthHero(int s, int a, int i, int h, double ms, double arm, int dmg, Sword hd, String n) {
        super(s, a, i, h, ms, arm, dmg, hd);
        this.name = n;
    }
    void UpLevel() {
        this.strength += 5;
        this.agility += 3;
        this.intelligence += 2;
    }

    void RuneHaste(double new_moveSpeed) {
        this.moveSpeed = 550;
        System.out.println("StrengthHero " + moveSpeed);
    }

    void BaseMoveSpeed() {
        this.moveSpeed = 300;
    }

}


class AgilityHero extends Hero {
    protected String name;
    protected String attribute = "Agility";

    AgilityHero( int s, int a, int i, int h, double ms, double arm, int dmg, Sword hd, String n) {
        super(s, a, i, h, ms, arm, dmg, hd);
        this.name = n;
    }
    void RuneHaste(double new_moveSpeed) {
        this.moveSpeed = 600;
        System.out.println("AgilityHero " + moveSpeed);
    }

}

class IntelligenceHero extends Hero {
    protected String name;
    protected String attribute = "Intelligence";

    IntelligenceHero(int s, int a, int i, int h, double ms, double arm, int dmg, Sword hd, String n) {
        super(s, a, i, h, ms, arm, dmg, hd);
        this.name = n;
    }
}

class Weapon {
    protected int damage; // урон оружия

    Weapon(int d) {
        this.damage = d;
    }

}

class Sword extends Weapon {
    protected String name; // название предмета разряда меч
    Sword(int d, String n) {
        super(d);
        this.name = n;
    }
}



class Creep {
    protected int health; // показатель здоровья
    protected int damage; // показатель урона
    protected int armor; // показатель брони
    protected int moveSpeed; // показатель скорости бега

    Creep(int h, int dmg, int arm, int ms) {
        this.health = h;
        this.damage = dmg;
        this.armor = arm;
        this.moveSpeed = ms;
    }
}

class UsuallyCreep extends Creep {
    protected String name; // имя монстра
    protected int bounties; // награда за монстра

    UsuallyCreep(int h, int dmg, int arm, int ms, String n, int b) {
        super(h, dmg, arm, ms);
        this.name = n;
        this.bounties = b;
    }
}

class MegaCreep extends Creep {
    protected String name; // имя монстра

    MegaCreep(int h, int dmg, int arm, int ms, String n) {
        super(h, dmg, arm, ms);
        this.name = n;
    }
}

class NeutralCreep {
    protected int tier; // класс нейтрального монстра
    protected int health; // показатель здоровья
    protected int damage; // показатель урона
    protected int armor; // показатель брони
    protected int moveSpeed; // показатель скорости бега
    protected int bounties; // награда за монстра
    protected Ring drop_item; // слот под нейтральную вещь, выпадающую с монстра
    NeutralCreep(int h, int dmg, int arm, int ms, int b, Ring di) {
        this.health = h;
        this.damage = dmg;
        this.armor = arm;
        this.moveSpeed = ms;
        this.bounties = b;
        this.drop_item = di;
    }
}

class Tier1NeutralCreep extends NeutralCreep {
    protected String name; // имя монстра
    protected int SpellDamage1; // урон с первого скилла монстра
    protected int tier = 1; // разряд монстра
    protected int SleepID; // находится в состоянии сна либо в боевой готовности

    Tier1NeutralCreep(int h, int dmg, int arm, int ms, int b, Ring di, String n, int s1) {
        super(h, dmg, arm, ms, b, di);
        this.name = n;
        this.SpellDamage1 = s1;
    }

    void SleepID(int slp) {
        if (slp < 0) SleepID = 0; else
        if (slp > 1) SleepID = 1; else
            SleepID = slp; // 0 - монстр бодрствует
        // 1 - монстр спит
    }

}

class Tier2NeutralCreep extends  NeutralCreep {
    protected String name; // имя монстра
    protected int SpellDamage1;
    protected int SpellDamage2;
    protected int tier = 2; // разряд монстра

    Tier2NeutralCreep(int h, int dmg, int arm, int ms, int b, Ring di, String n, int s1, int s2) {
        super(h, dmg, arm, ms, b, di);
        this.name = n;
        this.SpellDamage1 = s1;
        this.SpellDamage2 = s2;
    }


    void upgrade() {
        this.health += 100;
        this.damage += 50;
    }
}

class Neutral_item {
    protected double armor;
    protected int damage;
    protected int health;
    Neutral_item(double arm, int dmg, int h) {
        this.armor = arm; // количество брони, которое дает нейтральная вещь
        this.damage = dmg; // количество урона, которое дает нейтральная вещь
        this.health = h; // количество здоровья, которое дает нейтральная вещь
    }
}

class Ring extends Neutral_item {
    protected String name; // название предмета разряда кольцо
    Ring (double arm, int dmg, int h, String n) {
        super(arm, dmg, h);
        this.name = n;
    }
}
public class Main {
    public static void main(String[] args) {
        Sword frostmourne = new Sword(15, "frostmourne");
        StrengthHero Axe = new StrengthHero(20, 15, 13, 500, 300, 2, 50, frostmourne, "Axe");

        Ring ArcaneRing = new Ring(2, 10, 50, "Arcane Ring");
        Tier1NeutralCreep Harpy = new Tier1NeutralCreep(200, 30, 2, 300, 50, ArcaneRing, "Harpy", 15); // Задание 4.1. Два примера композиции, при котором объект класса StrengthHero имеет
                                                                                                                                 // значение аттрибута объекта класса Sword
                                                                                                                                // и аналогично объект класса ier1NeutralCreep имеет аттрибут объекта класса Ring

        AgilityHero PhantomAssassin = new AgilityHero(16, 23, 14, 400, 310, 4, 60, frostmourne, "Phantom Assassin");
        IntelligenceHero Tinker = new IntelligenceHero(14, 18, 25, 410, 305, 2, 49, frostmourne, "Tinker");
        StrengthHero Alchemist = new StrengthHero(21,16,16,550,310,3,44,frostmourne, "Alchemist");
        StrengthHero Phoenix = new StrengthHero(22,22,22,600,200,1,40, frostmourne, "Phoenix");
        AgilityHero Mirana = new AgilityHero(20,26,11,400,295,1,48, frostmourne, "Mirana");
        AgilityHero Riki = new AgilityHero(15,30,15,300,320,6,60, frostmourne, "Riki");

        Axe.RuneHaste(1000); // Задание 4.2. Переопределенный метод для дочернего класса StrengthHero
        PhantomAssassin.RuneHaste(1000); // Переопределенный метод для дочернего класса AgilityHero
        Tinker.RuneHaste(1000); // Метод родительского класса Hero, аналогичный StrengthHero и AgilityHero


        Hero[] Heroes = new Hero[500];
        Random rand = new Random();
        for (int i = 0; i < 500; i++) {
            int x = rand.nextInt(6);
            if (x == 0) {
                Heroes[i] = Axe;
            } else  if (x == 1) {
                Heroes[i] = PhantomAssassin;
            } else if (x == 2) {
                Heroes[i] = Alchemist;
            } else if (x == 3) {
                Heroes[i] = Phoenix;
            } else if (x == 4) {
                Heroes[i] = Mirana;
            } else if (x == 5) {
                Heroes[i] = Riki;
            }
            Heroes[i].RuneHaste(1000); // Посредством полиморфизма для дочерних классов определяется переопределенный метод, принадлежащий конкретному классу, и выводится расчет, согласно переопределенному методу
        }

        Axe.RuneHaste("sss"); // Задание 4.3. Используются два разных метода с названием RuneHaste, но при параметрах типа String выдается сообщение о некорректной скорости

    }
}

