package za.ac.cput.Factory.User;

/* AccountFactoryTest.java
Entity for the Account
Author: Tauriq-Allie Wilkinson  (219071330)
Date: 10 June 2021
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.User.Account;
import za.ac.cput.Factory.User.AccountFactory;

import static org.junit.jupiter.api.Assertions.*;



class AccountFactoryTest {
private  Account accA;
         Account accB;
         Account compare = accA;
    @BeforeEach
    void SetUp(){
        accA = null;
        accB = null;
        compare = accA;
    }
    @Test
    void validAccount(){
        accA = AccountFactory.createAccount("26D Parkwood Avenue",
                "26/02/2021","29/05/2021");
        assertNotNull(accA);
        System.out.println(accA);

        accB = AccountFactory.createAccount("11B Kings Palace",
                "9/03/2021","9/07/2021");
        assertNotNull(accB);
        System.out.println(accB);

    }

    @Test
    void testIdentity(){assertSame(accA,accB);}

    @Test
    void testEquality(){assertEquals(accA,compare);}

   @Disabled
    @Test
    public void testDisabling(){assertNotNull(accA);}



}