package com.disfinder.forest.test;

import com.disfinder.forest.cache.ForestCache;

public class test {

    public static void main(String[] args) {
	ForestCache a = ForestCache.getInstance();
	//System.out.println(a.a.toString());
	System.out.println(a.a);
	a.a=90;
	    
    
	ForestCache b = ForestCache.getInstance();
	System.out.println(b.a);
    
    }

}
