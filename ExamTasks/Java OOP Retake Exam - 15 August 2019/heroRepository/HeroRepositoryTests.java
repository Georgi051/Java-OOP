package heroRepository;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

public class HeroRepositoryTests {
    private HeroRepository heroRepository;

    @Before
    public void repository(){
        heroRepository = new HeroRepository();
    }

    @Test
    public void checkHeroCollectionSize() {
        Hero hero = new Hero("Dragan", 1);
        heroRepository.create(hero);
        Assert.assertEquals( 1,heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void createHeroThrowExceptionIfIsNull() {
        Hero hero = null;
        heroRepository.create(hero);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createHeroWithSameNameShouldThrowException() {
        Hero hero = new Hero("Dragan", 1);
        Hero hero1 = new Hero("Dragan", 1);
        this.heroRepository.create(hero);
        this.heroRepository.create(hero1);
    }

    @Test
    public void createHero() {
        Hero hero = new Hero("Dragan", 1);
        String result = heroRepository.create(hero);
        String expected = "Successfully added hero Dragan with level 1";
        Assert.assertEquals(expected, result);
    }

    @Test(expected = NullPointerException.class)
    public void heroThrowExceptionWhenRemoveHeroWithNull() {
        heroRepository.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void heroThrowExceptionWhenRemoveHeroWithEmpty() {
        this.heroRepository.remove("       ");
    }

    @Test
    public void heroRemoveWithCurrentName() {
        Hero hero = new Hero("Dragan", 1);
        Assert.assertEquals("Dragan", hero.getName());
        this.heroRepository.remove(hero.getName());
    }

    @Test
    public void checkHeroWithHighestLevel() {
        Hero hero = new Hero("Dragan", 1);
        Hero hero1 = new Hero("Gosho", 2);
        this.heroRepository.create(hero);
        this.heroRepository.create(hero1);
        this.heroRepository.getHeroWithHighestLevel();
        Assert.assertEquals(hero1,this.heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void getHeroWithCurrentName() {
        Hero hero = new Hero("Dragan", 1);
        Hero hero2 = new Hero("asd", 2);
        Hero hero3 = new Hero("Stoqn", 3);
        this.heroRepository.create(hero);
        this.heroRepository.create(hero2);
        this.heroRepository.create(hero3);

        String currName = "asd";
        this.heroRepository.getHero(currName);
        Assert.assertEquals(hero2,this.heroRepository.getHero(currName));

    }

    @Test(expected = UnsupportedOperationException.class)
    public void heroCollectionShouldBeNotModified() {
        Collection<Hero> heroes = this.heroRepository.getHeroes();
        heroes.clear();
    }
}
