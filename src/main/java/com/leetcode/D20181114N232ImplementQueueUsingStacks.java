package com.leetcode;

import java.util.Stack;

/**
 * TODO description
 *
 * @author hewei
 * @date 2018/11/14
 */
public class D20181114N232ImplementQueueUsingStacks {
    Stack<Integer> inputStack = new Stack<>();
    Stack<Integer> outputStack = new Stack<>();

    /** Initialize your data structure here. */
    public D20181114N232ImplementQueueUsingStacks() {
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inputStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!outputStack.isEmpty()) {
            return outputStack.pop();
        } else {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (!outputStack.isEmpty()) {
            return outputStack.peek();
        } else {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
}
