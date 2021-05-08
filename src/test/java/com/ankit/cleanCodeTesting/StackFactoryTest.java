package com.ankit.cleanCodeTesting;

import com.ankit.stack.Stack;
import com.ankit.stack.StackFactory;
import org.junit.Assert;
import org.junit.Test;

public class StackFactoryTest {

    private Stack stackFactory;

    @Test
    public void createStack() {
        stackFactory = StackFactory.Make(0);
        Assert.assertTrue(stackFactory.isEmpty());
    }

    @Test(expected = Stack.InvalidSize.class)
    public void negativeSize() {
        stackFactory = StackFactory.Make(-1);
    }

    @Test
    public void checkSizeOne() {
        stackFactory = StackFactory.Make(1);
        Assert.assertEquals(1, stackFactory.getSize());
    }

    @Test(expected = Stack.Overflow.class)
    public void pushMoreThanSizeOverflowSize() {
        stackFactory = StackFactory.Make(1);
        stackFactory.push(1);
        stackFactory.push(1);
    }

    @Test
    public void pushOneCheckTop() {
        stackFactory = StackFactory.Make(1);
        stackFactory.push(1);

        Assert.assertEquals(1, stackFactory.top().intValue());
    }

    @Test
    public void topOnEmptyStack() {
        stackFactory = StackFactory.Make(1);

        Assert.assertNull(stackFactory.top());
    }

}
