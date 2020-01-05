package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroRepositoryTest {
    private HeroRepository heroRepository;
    private Hero hero;


    @Before
    public void createHero() {
        this.heroRepository = new HeroRepository();
        Item item = new Item(5, 4, 3);
        this.hero = new Hero("Stancho", 3, item);
    }


    @Test(expected = IllegalArgumentException.class)
    public void checkIfHeroAlreadyExistThrowException() {
        this.heroRepository.add(this.hero);
        this.heroRepository.add(this.hero);
    }

    @Test
    public void checkForAddingInCollection() {
        this.heroRepository.add(this.hero);
        Assert.assertEquals(1, this.heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void checkWhenRemoveHeroItsNull() {
        this.heroRepository.remove(null);
    }

    @Test
    public void removeHeroFromCollection() {
        Hero hero2 = new Hero("Pesho", 3, new Item(6, 3, 3));
        this.heroRepository.add(this.hero);
        this.heroRepository.add(hero2);
        this.heroRepository.remove("Stancho");
        Assert.assertEquals(1, this.heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void ifHeroIsNullValueThrowException() {
        this.heroRepository.getHeroWithHighestStrength();
    }

    @Test
    public void checkForHeroWhitHighStrength() {
        this.heroRepository.add(this.hero);
        Hero hero2 = new Hero("Pesho", 3, new Item(6, 3, 3));
        this.heroRepository.add(hero2);
        Assert.assertEquals(hero2, this.heroRepository.getHeroWithHighestStrength());
    }

    @Test(expected = NullPointerException.class)
    public void ifHeroIsNullWhenCheckForHighestAgilityValueThrowException() {
        this.heroRepository.getHeroWithHighestAgility();
    }

    @Test
    public void checkForHeroWhitHighAgility() {
        this.heroRepository.add(this.hero);
        Hero hero2 = new Hero("Pesho", 3, new Item(6, 3, 3));
        this.heroRepository.add(hero2);
        Assert.assertEquals(this.hero, this.heroRepository.getHeroWithHighestAgility());
    }

    @Test(expected = NullPointerException.class)
    public void ifHeroIsNullWhenCheckForHighestIntelligenceValueThrowException() {
        this.heroRepository.getHeroWithHighestIntelligence();
    }

    @Test
    public void checkForHeroWhitHighIntelligence() {
        this.heroRepository.add(this.hero);
        Hero hero2 = new Hero("Pesho", 3, new Item(6, 3, 5));
        this.heroRepository.add(hero2);
        Assert.assertEquals(hero2, this.heroRepository.getHeroWithHighestIntelligence());
    }

    @Test
    public void checkForCurrentCollectionSize() {
        this.heroRepository.add(this.hero);
        Assert.assertEquals(1, this.heroRepository.getCount());
    }
}