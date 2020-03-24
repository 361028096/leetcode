package com.lintcode;

/**
 * 单例模式
 * Administrator
 *
 */
public class D20170801N204Single {
	private D20170801N204Single() {}
	
	// 饿汉式
    private static D20170801N204Single single = new D20170801N204Single();
    public static D20170801N204Single getInstance() {
        // write your code here
        return single;
    }
    
    // 懒汉式
    private static D20170801N204Single singleton = null;
    public static D20170801N204Single getInstance2() {
    	if (singleton == null) {
    		singleton = new D20170801N204Single();
    	}
    	return singleton;
    }
}
