package com.nickboy.cc150.chapter3;


public class Question1 {

	//we have three stacks, each stack has 100 spaces.
	int stackSize = 100;
	int[] buf = new int[stackSize * 3];
	int[] stackPointer = {0, 0, 0};

	void push(int stackNum, int value) throws Exception {

		//check if there is enough space
		if (stackPointer[stackNum] >= stackSize) {
			throw new Exception("Out of space.");
		}

		//calculate the insert point.
		int index = stackNum * stackSize + stackPointer[stackNum] + 1;
		buf[index] = value;
		stackPointer[stackNum] += 1;
	}

	int pop(int stackNum) throws Exception {
		if (stackPointer[stackNum] == 0) {
			throw new Exception("Trying to pop an empty stack.");
		}
		int index = stackNum * stackSize + stackPointer[stackNum];
		stackPointer[stackNum]--;
		int value = buf[index];
		buf[index] = 0;
		return value;

	}

	int peek(int stackNum) throws Exception {
		if (stackPointer[stackNum] == 0) {
			throw new Exception("try to peek an empty stack.");
		}
		int index = stackNum * stackSize + stackPointer[stackNum];
		int value = buf[index];
		return value;
	}

}

