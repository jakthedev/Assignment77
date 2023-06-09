package com.coderscampus.myapp.customlistapp; 

import java.util.Arrays;

public class CustomArrayList<T> implements CustomList<T> {
	// When I add more than 1-
	Object[] items = new Object[10];
	private int currentSize = 0;

	@Override
	public boolean add(T item) {
		while (currentSize <= items.length) {
			for(int j = 0; j < items.length; j++)
			{
			    if(items[j] == null)
			    {
			    	items[j] = item;
			    	currentSize++;
			        return true;
			    }
			}

			if (currentSize == items.length) {
				Object[] newItemsArray = Arrays.copyOf(items, items.length*2); 
				for(int i = 0; i < newItemsArray.length; i++) 
				{	
				    if(newItemsArray[i] == null) {
				    	newItemsArray[i] = item;
				    	currentSize++;
				    	items = newItemsArray;
				        return true;
				    }
				}
			}	
		}
		return true;
	}

	@Override
	public int getSize() {

		return currentSize;
	}

	@Override
	public T get(int index) {
		
		return (T) items[index];
	}

	@Override
	public boolean add(int index, T item) throws IndexOutOfBoundsException {
		
		Object newArray[] = new Object[items.length + 1];
		
		for(int i = 0, e = 0 ; i < items.length; i++, currentSize++, e++) {

			newArray[i] = items[e];			
			if (i == index) {
				newArray[i] = item;
				e--;	
			}	
		}
		
		for(int j = 0; j < newArray.length; j++) {
			items[j] = newArray[j];
			
			if (items[j] == null) {
				currentSize = items.length;
						;
				return false;
			}
		}
		
		return true;
		
	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		
		for (int i = index; i < items.length-1; i++) {
			
				items[i]= items[i + 1];
				items[items.length-1] = null;
				
		}	
		currentSize--;
		return null;
	}
}

