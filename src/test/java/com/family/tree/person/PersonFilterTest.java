package com.family.tree.person;

import com.family.tree.person.fixture.PersonFixture;
import org.junit.Before;
import org.junit.Test;

public class PersonFilterTest {

    private Person gen0Child1;
    private Person gen0Child2;
    private Female gen1Mother;
    private Male gen1Father;
    private Female gen2MM;
    private Male gen2MF;
    private Female gen2FM;
    private Male gen2FF;

    @Before
    public void setUp() {
        PersonFixture personFixture = new PersonFixture();
        gen2FF = personFixture.male(null, null);
        gen2FM = personFixture.female(null, null);
        gen2MF = personFixture.male(null, null);
        gen2MM = personFixture.female(null, null);
        gen1Father = personFixture.male(gen2FM, gen2FF);
        gen1Mother = personFixture.female(gen2MM, gen2MF);
        gen0Child1 = personFixture.male(gen1Mother, gen1Father);
        gen0Child2 = personFixture.female(gen1Mother, gen1Father);
    }

    @Test
    public void descendants() {
    }

    @Test
    public void ancestors() {
    }
}